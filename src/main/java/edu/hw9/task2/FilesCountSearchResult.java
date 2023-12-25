package edu.hw9.task2;

import java.nio.file.Path;
import java.util.List;

public record FilesCountSearchResult(List<Path> directories, int numberOfFiles) {
}
