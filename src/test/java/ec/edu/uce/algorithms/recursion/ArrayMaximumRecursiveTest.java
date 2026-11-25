package ec.edu.uce.algorithms.recursion;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArrayMaximumRecursiveTest {

    @Test
    void findsMaximumInMiddle() {
        assertEquals(7, ArrayMaximumRecursive.maxRecursive(new int[]{3, 7, 2}));
    }

    @Test
    void handlesSingleElement() {
        assertEquals(5, ArrayMaximumRecursive.maxRecursive(new int[]{5}));
    }

    @Test
    void handlesNegativeValues() {
        assertEquals(-1, ArrayMaximumRecursive.maxRecursive(new int[]{-8, -1, -5}));
    }

    @Test
    void rejectsEmptyArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ArrayMaximumRecursive.maxRecursive(new int[]{}));
    }

    @Test
    void rejectsNullArray() {
        assertThrows(IllegalArgumentException.class,
                () -> ArrayMaximumRecursive.maxRecursive(null));
    }
}