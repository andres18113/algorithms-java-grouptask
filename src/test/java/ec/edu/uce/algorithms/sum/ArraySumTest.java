package ec.edu.uce.algorithms.sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ArraySumTest {

    @Test
    void sumIterativeReturnsZeroForEmptyArray() {
        assertEquals(0L, ArraySum.sumIterative(new int[]{}));
    }

    @Test
    void sumIterativeThrowsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> ArraySum.sumIterative(null));
    }

    @Test
    void sumIterativeSumsValues() {
        assertEquals(10L, ArraySum.sumIterative(new int[]{1, 2, 3, 4}));
    }

    @Test
    void sumRecursiveReturnsZeroForEmptyArray() {
        assertEquals(0L, ArraySum.sumRecursive(new int[]{}, 0));
    }

    @Test
    void sumRecursiveThrowsOnNull() {
        assertThrows(IllegalArgumentException.class, () -> ArraySum.sumRecursive(null, 0));
    }

    @Test
    void sumRecursiveSumsValues() {
        assertEquals(10L, ArraySum.sumRecursive(new int[]{1, 2, 3, 4}, 0));
    }
}