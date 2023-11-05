package edu.hw3.task7;

import java.util.TreeMap;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AdmittingNullComparatorTest {
    @Test
    public void whenTreeMapWithStringKeyAfterAddingNullKeyTreeMapShouldContainsThisItem() {
        TreeMap<String, String> tree = new TreeMap<>(new AdmittingNullComparator<String>());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }

    @Test
    public void whenTreeMapWithIntegerKeyAfterAddingNullKeyTreeMapShouldContainsThisItem() {
        TreeMap<Integer, String> tree = new TreeMap<>(new AdmittingNullComparator<Integer>());
        tree.put(null, "test");
        assertThat(tree.containsKey(null)).isTrue();
    }
}
