package ec.edu.uce.algorithms.sorting;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class InsertionSortTest {

    @Test
    void sortsEmptyArray() {
        int[] values = {};
        SortMetrics metrics = new SortMetrics();
        InsertionSort sorter = new InsertionSort();

        sorter.sort(values, metrics);
        assertArrayEquals(new int[]{}, values);
    }

    @Test
    void sortsSingleElementArray() {
        int[] values = {5};
        SortMetrics metrics = new SortMetrics();
        InsertionSort sorter = new InsertionSort();

        sorter.sort(values, metrics);
        assertArrayEquals(new int[]{5}, values);
    }

    @Test
    void sortsRandomArrayAndRecordsMetrics() {
        int[] values = {5, 2, 9, 1, 5, 6};
        SortMetrics metrics = new SortMetrics();
        InsertionSort sorter = new InsertionSort();

        sorter.sort(values, metrics);

        assertArrayEquals(new int[]{1, 2, 5, 5, 6, 9}, values);
        assertTrue(metrics.getComparisons() > 0, "Should record comparisons");
        assertTrue(metrics.getMovements() > 0, "Should record movements");
    }

    @Test
    void rejectsNullArguments() {
        InsertionSort sorter = new InsertionSort();
        assertThrows(IllegalArgumentException.class, () -> sorter.sort(null, new SortMetrics()));
        assertThrows(IllegalArgumentException.class, () -> sorter.sort(new int[]{1}, null));
    }
}