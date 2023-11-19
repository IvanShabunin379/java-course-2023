package edu.hw6.task1;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DiskMap implements Map<String, String> {
    private final Map<String, String> cache;
    private final Path dataStorePath;

    public DiskMap(String filePath) {
        this.dataStorePath = Paths.get(filePath);
        this.cache = new HashMap<>();
        loadFromFile();
    }

    private void loadFromFile() {
        if (!Files.exists(dataStorePath)) {
            try {
                Files.createFile(dataStorePath);
            } catch (IOException e) {
                throw new RuntimeException("", e);
            }
        }

        try (BufferedReader reader = Files.newBufferedReader(dataStorePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(":", 2);
                if (parts.length == 2) {
                    cache.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("", e);
        }
    }

    private void saveToFile() {
        try (BufferedWriter writer = Files.newBufferedWriter(dataStorePath)) {
            for (Map.Entry<String, String> entry : cache.entrySet()) {
                writer.write(entry.getKey() + ":" + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("", e);
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
        String previousValue = cache.put(key, value);
        saveToFile();
        return previousValue;
    }

    @Override
    public String remove(Object key) {
        String removedValue = cache.remove(key);
        saveToFile();
        return removedValue;
    }

    @Override
    public void putAll(@NotNull Map<? extends String, ? extends String> m) {
        cache.putAll(m);
        saveToFile();
    }

    @Override
    public void clear() {
        cache.clear();
        saveToFile();
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
