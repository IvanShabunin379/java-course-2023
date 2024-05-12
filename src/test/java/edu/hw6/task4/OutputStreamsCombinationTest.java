package edu.hw6.task4;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatRuntimeException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class OutputStreamsCombinationTest {
    private static final Path TEMP_FILE_PATH = Paths.get("tmp.txt");

    @AfterEach
    public void deleteTemporaryFile() throws IOException {
        Files.deleteIfExists(TEMP_FILE_PATH);
    }

    @Test
    public void shouldCreateFileWithQuote() throws IOException {
        OutputStreamsCombination.saveQuoteToFile(TEMP_FILE_PATH);
        assertThat(Files.exists(TEMP_FILE_PATH)).isTrue();

        String expected = OutputStreamsCombination.QUOTE;
        try (InputStream is = Files.newInputStream(TEMP_FILE_PATH);
             Scanner scanner = new Scanner(is)) {
            String result = scanner.nextLine();
            assertThat(result).isEqualTo(expected);
            assertThat(scanner.hasNext()).isFalse();
        }
    }

    @Test
    public void whenFileByInputPathAlreadyExistsShouldThrowException() throws IOException {
        Files.createFile(TEMP_FILE_PATH);
        assertThatRuntimeException()
            .isThrownBy(() -> OutputStreamsCombination.saveQuoteToFile(TEMP_FILE_PATH));
    }
}
