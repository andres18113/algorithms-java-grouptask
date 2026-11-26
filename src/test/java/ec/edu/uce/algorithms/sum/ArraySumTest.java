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
    @Test
    void sumIterativeCalculatesExampleValues() {
        assertEquals(30L, ArraySum.sumIterative(new int[]{8, 3, 10, 2, 7}));
        assertEquals(7L, ArraySum.sumIterative(new int[]{7}));
        assertEquals(-7L, ArraySum.sumIterative(new int[]{-8, 3, -2}));
    }

    @Test
    void sumRecursiveCalculatesExampleValues() {
        assertEquals(30L, ArraySum.sumRecursive(new int[]{8, 3, 10, 2, 7}, 0));
        assertEquals(7L, ArraySum.sumRecursive(new int[]{7}, 0));
        assertEquals(-7L, ArraySum.sumRecursive(new int[]{-8, 3, -2}, 0));
    }

    @Test
    void sumRecursiveThrowsOnInvalidIndex() {
        assertThrows(IllegalArgumentException.class, () -> ArraySum.sumRecursive(new int[]{1, 2, 3}, -1));
        assertThrows(IllegalArgumentException.class, () -> ArraySum.sumRecursive(new int[]{1, 2, 3}, 4));
    }
}