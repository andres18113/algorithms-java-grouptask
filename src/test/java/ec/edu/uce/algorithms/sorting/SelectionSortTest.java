package ec.edu.uce.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link SelectionSort}.
 */
class SelectionSortTest {

    @Test
    void sortsTheAssignmentExampleCorrectly() {
        SelectionSort sorter = new SelectionSort();
        int[] values = {45, 12, 90, 12, 3, 70, 45, 18};
        SortMetrics metrics = new SortMetrics();

        sorter.sort(values, metrics);

        assertArrayEquals(new int[]{3, 12, 12, 18, 45, 45, 70, 90}, values);
        assertEquals(28, metrics.getComparisons());
        assertEquals(8, metrics.getMovements());
    }

    @Test
    void sortsTwoElements() {
        SelectionSort sorter = new SelectionSort();
        int[] values = {2, 1};
        SortMetrics metrics = new SortMetrics();

        sorter.sort(values, metrics);

        assertArrayEquals(new int[]{1, 2}, values);
        assertEquals(1, metrics.getComparisons());
        assertEquals(2, metrics.getMovements());
    }

    @Test
    void sortsAlreadySortedArray() {
        SelectionSort sorter = new SelectionSort();
        int[] values = {1, 2, 3, 4};
        SortMetrics metrics = new SortMetrics();

        sorter.sort(values, metrics);

        assertArrayEquals(new int[]{1, 2, 3, 4}, values);
        assertEquals(6, metrics.getComparisons());
        assertEquals(0, metrics.getMovements());
    }

    @Test
    void handlesEmptyAndSingleElementArrays() {
        SelectionSort sorter = new SelectionSort();

        int[] empty = {};
        SortMetrics metrics1 = new SortMetrics();
        sorter.sort(empty, metrics1);
        assertArrayEquals(new int[]{}, empty);
        assertEquals(0, metrics1.getComparisons());
        assertEquals(0, metrics1.getMovements());

        int[] single = {7};
        SortMetrics metrics2 = new SortMetrics();
        sorter.sort(single, metrics2);
        assertArrayEquals(new int[]{7}, single);
        assertEquals(0, metrics2.getComparisons());
        assertEquals(0, metrics2.getMovements());
    }

    @Test
    void throwsOnNullArguments() {
        SelectionSort sorter = new SelectionSort();
        assertThrows(IllegalArgumentException.class, () -> sorter.sort(null, new SortMetrics()));
        assertThrows(IllegalArgumentException.class, () -> sorter.sort(new int[]{1, 2}, null));
    }
}