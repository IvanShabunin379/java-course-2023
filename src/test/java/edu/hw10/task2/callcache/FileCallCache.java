package edu.hw10.task2.callcache;

import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FileCallCache implements CallCache {
    private final ObjectOutputStream objectOutputStream;
    private final InMemoryCallCache inMemoryCallCache = new InMemoryCallCache();

    public FileCallCache(Path cacheFile) throws IOException, ClassNotFoundException {
        if (Files.exists(cacheFile)) {
            try (
                var is = Files.newInputStream(cacheFile);
                var objectInputStream = new ObjectInputStream(is)
            ) {
                boolean hasNext = true;
                while (hasNext) {
                    try {
                        var cached = (SerializedCache) objectInputStream.readObject();
                        inMemoryCallCache.put(cached.arguments(), cached.result);
                    } catch (EOFException eof) {
                        hasNext = false;
                    }
                }
            }
            var os = Files.newOutputStream(cacheFile, StandardOpenOption.APPEND);

            objectOutputStream = new ObjectOutputStream(os) {
                @Override
                protected void writeStreamHeader() throws IOException {
                    reset();
                }
            };
        } else {
            objectOutputStream = new ObjectOutputStream(Files.newOutputStream(
                cacheFile,
                StandardOpenOption.CREATE_NEW
            ));
        }
    }

    @Override
    public boolean put(Object[] args, Object result) throws IOException {
        if (inMemoryCallCache.put(args, result)) {
            objectOutputStream.writeObject(new SerializedCache(args, result));
            return true;
        }
        return false;
    }

    @Override
    public Object get(Object[] args) {
        return inMemoryCallCache.get(args);
    }

    public record SerializedCache(Object[] arguments, Object result) implements Serializable {
    }
}
