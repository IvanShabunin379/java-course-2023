package edu.hw6.task2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;

public final class FileCloner {
    private FileCloner() {
    }

    public static void cloneFile(Path filePath) {
        if (!Files.exists(filePath) || !Files.isRegularFile(filePath)) {
            throw new IllegalArgumentException("There is no file on this path.");
        }

        String infoAboutCopyPart = " - копия( \\([2-9]\\)| \\([1-9][0-9]+\\))?";
        String[] nameAndExtension = filePath.getFileName().toString().split(infoAboutCopyPart);
        String name = nameAndExtension[0];
        String extension = (nameAndExtension.length == 2) ? (nameAndExtension[1]) : "";
        Pattern fileCopyPattern = Pattern.compile("^" + name + infoAboutCopyPart + extension + "$");

        Path parentDirectory = filePath.toAbsolutePath().getParent();
        try (var copies = Files.find(
            parentDirectory,
            1,
            (path, atr) -> fileCopyPattern.matcher(path.getFileName().toString()).matches()
        )) {
            long copiesCount = copies.count();

            StringBuilder nameOfNewCopy = new StringBuilder();
            nameOfNewCopy.append(name).append(" - копия");
            if (copiesCount > 0) {
                nameOfNewCopy.append(" (").append(copiesCount + 1).append(")");
            }
            nameOfNewCopy.append(extension);

            Path pathOfNewCopy = parentDirectory.resolve(nameOfNewCopy.toString());
            Files.copy(filePath, pathOfNewCopy);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
