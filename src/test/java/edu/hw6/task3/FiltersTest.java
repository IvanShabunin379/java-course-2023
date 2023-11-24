package edu.hw6.task3;

import edu.hw6.TestWithTemporaryDirectory;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class FiltersTest extends TestWithTemporaryDirectory {
    @BeforeAll
    public static void createFilesInDirectory() throws IOException {
        Files.createFile(TEMP_DIR_PATH.resolve("aaa.txt"));
        Files.createFile(TEMP_DIR_PATH.resolve("text1.txt"));
        Files.createFile(TEMP_DIR_PATH.resolve("text2.txt"));
        Files.createFile(TEMP_DIR_PATH.resolve("dont_readme.md"));
        Files.write(TEMP_DIR_PATH.resolve("pseudo.png"), new byte[] {89, 'P', 'N', 'G'});
        Files.write(TEMP_DIR_PATH.resolve("10bytes.dat"), new byte[10]);
        Files.write(TEMP_DIR_PATH.resolve("500bytes.dat"), new byte[500]);
        Files.write(TEMP_DIR_PATH.resolve("777bytes.dat"), new byte[777]);
        Files.write(TEMP_DIR_PATH.resolve("1024bytes.dat"), new byte[1024]);
        Files.createDirectory(TEMP_DIR_PATH.resolve("not-file"));
    }

    private List<String> getPathsNames(DirectoryStream<Path> paths) {
        List<String> pathsNames = new ArrayList<>();
        for (Path path : paths) {
            pathsNames.add(path.getFileName().toString());
        }
        return pathsNames;
    }

    @Test
    public void testAttributeFilters() throws IOException {
        var filter = Filters.REGULAR_FILE
            .and(Filters.READABLE)
            .and(Filters.WRITABLE);

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, filter)) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder(
                "1024bytes.dat",
                "10bytes.dat",
                "500bytes.dat",
                "777bytes.dat",
                "aaa.txt",
                "dont_readme.md",
                "pseudo.png",
                "text1.txt",
                "text2.txt"
            );
        }
    }

    @Test
    public void testHasSizeFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.hasSize(777))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("777bytes.dat");
        }
    }

    @Test
    public void testLargerThanFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.largerThan(10))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("500bytes.dat", "777bytes.dat", "1024bytes.dat");
        }
    }

    @Test
    public void testSmallerThanFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.smallerThan(1024))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder(
                "10bytes.dat",
                "500bytes.dat",
                "777bytes.dat",
                "aaa.txt",
                "text1.txt",
                "text2.txt",
                "dont_readme.md",
                "pseudo.png",
                "not-file"
            );
        }
    }

    @Test
    public void testHasExtensionFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.hasExtension("txt"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("aaa.txt", "text1.txt", "text2.txt");
        }

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.hasExtension("md"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("dont_readme.md");
        }

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.hasExtension("png"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("pseudo.png");
        }

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.hasExtension("dat"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder(
                "10bytes.dat",
                "500bytes.dat",
                "777bytes.dat",
                "1024bytes.dat"
            );
        }
    }

    @Test
    public void testRegexContainsFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.regexContains("\\d+"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder(
                "text1.txt",
                "text2.txt",
                "10bytes.dat",
                "500bytes.dat",
                "777bytes.dat",
                "1024bytes.dat"
            );
        }
    }

    @Test
    public void testGlobMatchesFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, Filters.globMatches("*.dat"))) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder(
                "10bytes.dat",
                "500bytes.dat",
                "777bytes.dat",
                "1024bytes.dat"
            );
        }
    }

    @Test
    public void testHasMagicNumberFilter() throws IOException {
        try (DirectoryStream<Path> paths = Files.newDirectoryStream(
            TEMP_DIR_PATH,
            Filters.hasMagicNumber(new byte[] {89, 'P', 'N', 'G'})
        )) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsOnly("pseudo.png");
        }
    }

    @Test
    public void testFilterChainability() throws IOException {
        var filter = Filters.REGULAR_FILE
            .and(Filters.READABLE)
            .and(Filters.smallerThan(1024))
            .and(Filters.hasExtension("txt"))
            .and(Filters.regexContains("\\d+"));

        try (DirectoryStream<Path> paths = Files.newDirectoryStream(TEMP_DIR_PATH, filter)) {
            List<String> pathsNames = getPathsNames(paths);
            assertThat(pathsNames).containsExactlyInAnyOrder("text1.txt", "text2.txt");
        }
    }
}
