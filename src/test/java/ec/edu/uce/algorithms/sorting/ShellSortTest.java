package ec.edu.uce.algorithms.sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShellSortTest {
    private final SortingAlgorithm algorithm = new ShellSort();
    private final SortMetrics metrics = new SortMetrics();

    @Test
    void sortsAssignmentExampleInPlace() {
        int[] values = {45, 12, 90, 12, 3, 70, 45, 18};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{3, 12, 12, 18, 45, 45, 70, 90}, values);
    }

    @Test
    void leavesEmptyArrayUnchangedWithZeroOperations() {
        int[] values = {};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{}, values);
        assertEquals(0L, metrics.getComparisons());
        assertEquals(0L, metrics.getMovements());
    }

    @Test
    void leavesSingleElementUnchangedWithZeroOperations() {
        int[] values = {7};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{7}, values);
        assertEquals(0L, metrics.getComparisons());
        assertEquals(0L, metrics.getMovements());
    }

    @Test
    void preservesRepeatedValues() {
        int[] values = {5, 2, 5, 2};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{2, 2, 5, 5}, values);
    }

    @Test
    void sortsNegativeValues() {
        int[] values = {-2, 4, -2, 0};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{-2, -2, 0, 4}, values);
    }

    @Test
    void preservesAscendingOrderWithoutWritingToTheArray() {
        int[] values = {1, 2, 3, 4};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{1, 2, 3, 4}, values);
        assertEquals(5L, metrics.getComparisons());
        assertEquals(0L, metrics.getMovements());
    }

    @Test
    void sortsDescendingInput() {
        int[] values = {4, 3, 2, 1};

        algorithm.sort(values, metrics);

        assertArrayEquals(new int[]{1, 2, 3, 4}, values);
    }

    @Test
    void rejectsNullArrayBeforeRecordingOperations() {
        assertThrows(IllegalArgumentException.class, () -> algorithm.sort(null, metrics));
        assertEquals(0L, metrics.getComparisons());
        assertEquals(0L, metrics.getMovements());
    }

    @Test
    void rejectsNullMetricsBeforeChangingArray() {
        int[] values = {2, 1};

        assertThrows(IllegalArgumentException.class, () -> algorithm.sort(values, null));
        assertArrayEquals(new int[]{2, 1}, values);
    }

    @Test
    void countsComparisonsAndWritesAcrossGapPasses() {
        int[] values = {4, 3, 2, 1};

        algorithm.sort(values, metrics);

        // Gap 2: two comparisons and four writes. Gap 1: four comparisons and four writes.
        assertEquals(6L, metrics.getComparisons());
        assertEquals(8L, metrics.getMovements());
    }
}
