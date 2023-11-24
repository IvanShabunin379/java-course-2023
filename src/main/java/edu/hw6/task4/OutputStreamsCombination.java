package edu.hw6.task4;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import static java.nio.file.StandardOpenOption.CREATE_NEW;

public final class OutputStreamsCombination {
    public static final String QUOTE = "Programming is learned by writing programs. ― Brian Kernighan";

    private OutputStreamsCombination() {
    }

    public static void saveQuoteToFile(Path filePath) {
        try (var fileOutputStream = Files.newOutputStream(filePath, CREATE_NEW);
             var checkedOutputStream = new CheckedOutputStream(fileOutputStream, new Adler32());
             var bufferedOutputStream = new BufferedOutputStream(checkedOutputStream);
             var outputStreamWriter = new OutputStreamWriter(bufferedOutputStream);
             var printWriter = new PrintWriter(outputStreamWriter)
        ) {
            printWriter.println(QUOTE);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
