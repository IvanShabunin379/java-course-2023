package edu.hw6;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;

public class TestWithTemporaryDirectory {
    public static final Path TEMP_DIR_PATH = Paths.get("tmp-dir");

    @BeforeAll
    public static void createTemporaryDirectory() throws IOException {
        Files.createDirectory(TEMP_DIR_PATH);
    }

    @AfterAll
    public static void deleteTemporaryDirectory() throws IOException {
        try (var paths = Files.walk(TEMP_DIR_PATH)) {
            paths.sorted(Comparator.reverseOrder())
                .forEach(path -> {
                    try {
                        Files.delete(path);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
        }
    }
}
