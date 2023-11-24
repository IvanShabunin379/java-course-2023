package edu.hw6.task1;

import edu.hw6.TestWithTemporaryDirectory;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

public class DiskMapTest extends TestWithTemporaryDirectory {
    private DiskMap diskMap;

    @BeforeEach
    public void setUp() throws IOException {
        diskMap = new DiskMap(TEMP_DIR_PATH);
    }

    private boolean diskAndCacheAreSynced() throws IOException {
        Set<String> diskEntries = new HashSet<>();
        try (Stream<Path> paths = Files.list(TEMP_DIR_PATH)) {
            paths.map(Path::getFileName)
                .map(Path::toString)
                .forEach(diskEntries::add);
        }

        Set<String> cacheKeys = new HashSet<>(diskMap.keySet());

        return diskEntries.equals(cacheKeys);
    }

    @Test
    public void testPut() throws IOException {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.put("key3", "value3");

        assertThat(diskAndCacheAreSynced()).isTrue();
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(diskMap.get("key1")).isEqualTo("value1");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
    }

    @Test
    public void testRemove() throws IOException {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.put("key3", "value3");

        diskMap.remove("key1");
        assertThat(diskAndCacheAreSynced()).isTrue();
        assertThat(diskMap.size()).isEqualTo(2);
        assertThat(diskMap.get("key2")).isEqualTo("value2");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
    }

    @Test
    public void testPutAll() throws IOException {
        Map<String, String> map = new HashMap<>() {{
            put("key1", "value1");
            put("key2", "value2");
            put("key3", "value3");
        }};

        diskMap.putAll(map);

        assertThat(diskAndCacheAreSynced()).isTrue();
        assertThat(diskMap.size()).isEqualTo(3);
        assertThat(diskMap.get("key1")).isEqualTo("value1");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
        assertThat(diskMap.get("key2")).isEqualTo("value2");
    }

    @Test
    public void testClear() throws IOException {
        diskMap.put("key1", "value1");
        diskMap.put("key2", "value2");
        diskMap.put("key3", "value3");

        diskMap.clear();

        assertThat(diskAndCacheAreSynced()).isTrue();
        assertThat(diskMap).isEmpty();
    }
}
