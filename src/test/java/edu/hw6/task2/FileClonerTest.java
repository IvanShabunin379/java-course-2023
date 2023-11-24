package edu.hw6.task2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import edu.hw6.TestWithTemporaryDirectory;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileClonerTest extends TestWithTemporaryDirectory {
    private static final String ORIGIN_TEST_FILE_NAME = "Tinkoff Bank Biggest Secret";

    @Test
    public void shouldCreateCopiesOfFileWithCorrectNames() throws IOException {
        Path originTestFilePath = TEMP_DIR_PATH.resolve(ORIGIN_TEST_FILE_NAME);
        Files.createFile(originTestFilePath);
        try (var writer = new PrintWriter(Files.newOutputStream(originTestFilePath))) {
            writer.print("some text");
        }

        FileCloner.cloneFile(originTestFilePath);
        Path expectedCopyPath = TEMP_DIR_PATH.resolve(ORIGIN_TEST_FILE_NAME + " - копия");
        assertThat(Files.exists(expectedCopyPath)).isTrue();
        assertThat(Files.mismatch(expectedCopyPath, originTestFilePath)).isEqualTo(-1);

        for (int i = 2; i <= 110; ++i) {
            FileCloner.cloneFile(originTestFilePath);
            expectedCopyPath = TEMP_DIR_PATH.resolve(ORIGIN_TEST_FILE_NAME + " - копия (" + i + ")");
            assertThat(Files.exists(expectedCopyPath)).isTrue();
            assertThat(Files.mismatch(expectedCopyPath, originTestFilePath)).isEqualTo(-1);
        }
    }

    @Test
    public void whenThereIsNoFileOnInputPathShouldThrowException() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Path originTestFilePath = TEMP_DIR_PATH.resolve("nofile.txt");
            FileCloner.cloneFile(originTestFilePath);
        });
    }
}
