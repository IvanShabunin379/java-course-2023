package edu.hw6.task3;

import java.nio.file.DirectoryStream;
import java.nio.file.Path;

public interface Filter extends DirectoryStream.Filter<Path> {
    default Filter and(Filter other) {
        return path -> accept(path) && other.accept(path);
    }
}
