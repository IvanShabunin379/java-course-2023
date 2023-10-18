package edu.hw1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import org.junit.jupiter.api.Test;

public class Task3Test {
    @Test
    public void nestableArraysShouldReturnTrue() {
        assertTrue(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 6}));
        assertTrue(Task3.isNestable(new int[] {3, 1}, new int[] {4, 0}));
    }

    @Test
    public void nonNestableArraysShouldReturnTrue() {
        assertFalse(Task3.isNestable(new int[] {9, 9, 8}, new int[] {8, 9}));
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {2, 3}));
    }

    @Test
    public void emptyArraysShouldReturnFalse() {
        assertFalse(Task3.isNestable(new int[] {}, new int[] {0, 6}));
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {}));
        assertFalse(Task3.isNestable(new int[] {}, new int[] {}));
    }

    @Test
    public void sameArraysShouldReturnFalse() {
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {1, 2, 3, 4}));
        assertFalse(Task3.isNestable(new int[] {0, 6}, new int[] {0, 6}));
    }

    @Test
    public void equalMinMaxArraysShouldReturnFalse() {
        assertFalse(Task3.isNestable(new int[] {1, 2, 3, 4}, new int[] {0, 4}));
        assertFalse(Task3.isNestable(new int[] {3, 1}, new int[] {4, 1}));
        assertFalse(Task3.isNestable(new int[] {3, 1}, new int[] {1, 2, 3}));
    }
}
