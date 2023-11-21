package edu.hw6.task3;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.regex.Pattern;

public final class Filters {
    private Filters() {
    }

    public static final Filter REGULAR_FILE = Files::isRegularFile;
    public static final Filter READABLE = Files::isReadable;
    public static final Filter WRITABLE = Files::isWritable;

    public static Filter hasSize(long size) {
        return path -> Files.size(path) == size;
    }

    public static Filter largerThan(long size) {
        return path -> Files.size(path) > size;
    }

    public static Filter smallerThan(long size) {
        return path -> Files.size(path) < size;
    }

    public static Filter hasExtension(String extension) {
        return path -> path.getFileName().toString().endsWith("." + extension);
    }

    public static Filter regexContains(String regex) {
        return path -> Pattern.compile(regex).matcher(path.getFileName().toString()).find();
    }

    public static Filter globMatches(String glob) {
        return path -> FileSystems.getDefault().getPathMatcher("glob:" + glob).matches(path.getFileName());
    }

    public static Filter hasMagicNumber(byte... magicNumber) {
        return path -> {
            try (var input = Files.newInputStream(path)) {
                byte[] bytes = new byte[magicNumber.length];
                if (input.read(bytes) != magicNumber.length) {
                    return false;
                }
                return Arrays.equals(bytes, magicNumber);
            } catch (IOException e) {
                return false;
            }
        };
    }
}
