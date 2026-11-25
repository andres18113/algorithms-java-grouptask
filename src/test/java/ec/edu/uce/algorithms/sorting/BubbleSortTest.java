package ec.edu.uce.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void shouldSortAssignmentExampleArray() {
        SortingAlgorithm algorithm = new BubbleSort();
        SortMetrics metrics = new SortMetrics();
        int[] values = {45, 12, 90, 12, 3, 70, 45, 18};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{3, 12, 12, 18, 45, 45, 70, 90}, values);
        assertTrue(metrics.getComparisons() > 0);
        assertTrue(metrics.getMovements() > 0);
        assertEquals(0, metrics.getMovements() % 2);
    }

    @Test
    void shouldHandleEmptyAndSingleElementArraysWithZeroMetrics() {
        SortingAlgorithm algorithm = new BubbleSort();

        int[] empty = {};
        SortMetrics emptyMetrics = new SortMetrics();
        algorithm.sort(empty, emptyMetrics);
        assertArrayEquals(new int[]{}, empty);
        assertEquals(0L, emptyMetrics.getComparisons());
        assertEquals(0L, emptyMetrics.getMovements());

        int[] single = {7};
        SortMetrics singleMetrics = new SortMetrics();
        algorithm.sort(single, singleMetrics);
        assertArrayEquals(new int[]{7}, single);
        assertEquals(0L, singleMetrics.getComparisons());
        assertEquals(0L, singleMetrics.getMovements());
    }

    @Test
    void shouldSortDuplicatesAndNegativeNumbers() {
        SortingAlgorithm algorithm = new BubbleSort();
        SortMetrics metrics = new SortMetrics();
        int[] values = {-2, 4, -2, 0};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{-2, -2, 0, 4}, values);
        assertTrue(metrics.getComparisons() >= 0);
        assertTrue(metrics.getMovements() >= 0);
    }

    @Test
    void shouldSortAlreadySortedAndReverseSortedArrays() {
        SortingAlgorithm algorithm = new BubbleSort();

        int[] sorted = {1, 2, 3, 4, 5};
        SortMetrics sortedMetrics = new SortMetrics();
        algorithm.sort(sorted, sortedMetrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, sorted);
        assertEquals(0L, sortedMetrics.getMovements());

        int[] reversed = {5, 4, 3, 2, 1};
        SortMetrics reversedMetrics = new SortMetrics();
        algorithm.sort(reversed, reversedMetrics);
        assertArrayEquals(new int[]{1, 2, 3, 4, 5}, reversed);
        assertEquals(20L, reversedMetrics.getMovements());
    }

    @Test
    void shouldThrowExceptionWhenValuesOrMetricsIsNull() {
        SortingAlgorithm algorithm = new BubbleSort();
        SortMetrics metrics = new SortMetrics();
        int[] values = {3, 1, 2};

        assertThrows(IllegalArgumentException.class, () -> algorithm.sort(null, metrics));
        assertThrows(IllegalArgumentException.class, () -> algorithm.sort(values, null));
    }
}