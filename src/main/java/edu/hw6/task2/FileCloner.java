package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public final class FileCloner {
    private FileCloner() {
    }

    public static void cloneFile(Path filePath) {
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            return;
        }

        String[] nameAndExtension = filePath.getFileName().toString().split("\\.");
        String InfoAboutCopyPart = "( - копия( \\([2-9]|[1-9][0-9]+\\))?)";
        String name = nameAndExtension[0].split(InfoAboutCopyPart)[0];
        String extension = (nameAndExtension.length == 2) ? nameAndExtension[1] : "";
        String fileCopyPattern = String.format("^%s%s?%s$", name, InfoAboutCopyPart, extension);

        Path parentDirectory = filePath.getParent();
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(parentDirectory, fileCopyPattern)) {
            int copiesCount = 0;
            for (Path path : directoryStream) {
                if (path.getFileName().toString().matches(fileCopyPattern)) {
                    ++copiesCount;
                }
            }

            StringBuilder nameOfNewCopy = new StringBuilder();
            nameOfNewCopy.append(name).append(" - копия");
            if (copiesCount > 1) {
                nameOfNewCopy.append("(").append(copiesCount).append(")");
            }
            nameOfNewCopy.append(".").append(extension);

            Files.copy(filePath, Paths.get(nameOfNewCopy.toString()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
