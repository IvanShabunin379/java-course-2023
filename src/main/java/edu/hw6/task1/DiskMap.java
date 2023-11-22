package edu.hw6.task1;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DiskMap implements Map<String, String> {
    private final Map<String, String> cache;
    private final Path storageDirectory;

    public DiskMap(@NotNull Path storageDirectory) throws IOException {
        cache = new HashMap<>();
        this.storageDirectory = storageDirectory.toAbsolutePath();
        if (Files.exists(storageDirectory)) {
            loadCache();
        } else {
            Files.createDirectory(this.storageDirectory);
        }
    }

    private void loadCache() throws IOException {
        try (Stream<Path> paths = Files.list(storageDirectory)) {
            paths.forEach(path -> {
                try {
                    String key = path.getFileName().toString();
                    String value = new String(Files.readAllBytes(path));
                    cache.put(key, value);
                } catch (IOException e) {
                    throw new RuntimeException(e.getMessage(), e);
                }
            });
        }
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean isEmpty() {
        return cache.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return cache.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return cache.containsValue(value);
    }

    @Override
    public String get(Object key) {
        return cache.get(key);
    }

    @Nullable
    @Override
    public String put(String key, String value) {
        Path filePathOfNewEntry = storageDirectory.resolve(key);

        try {
            if (!Files.exists(filePathOfNewEntry)) {
                Files.createFile(filePathOfNewEntry);
            }

            try (var bufferedWriter = Files.newBufferedWriter(filePathOfNewEntry);
                 var printWriter = new PrintWriter(bufferedWriter)) {
                printWriter.println(value);
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }

        return cache.put(key, value);
    }

    @Override
    public String remove(Object key) {
        String result = cache.remove(key);

        if (result != null) {
            Path filePathOfEntryBeingRemoved = storageDirectory.resolve((String) key);
            try {
                Files.delete(filePathOfEntryBeingRemoved);
            } catch (IOException e) {
                throw new RuntimeException(e.getMessage(), e);
            }
        }

        return result;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        m.forEach(this::put);
    }

    @Override
    public void clear() {
        cache.keySet().forEach(this::remove);
    }

    @NotNull
    @Override
    public Set<String> keySet() {
        return cache.keySet();
    }

    @NotNull
    @Override
    public Collection<String> values() {
        return cache.values();
    }

    @NotNull
    @Override
    public Set<Entry<String, String>> entrySet() {
        return cache.entrySet();
    }
}
