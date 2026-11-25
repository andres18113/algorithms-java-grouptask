package ec.edu.uce.algorithms.sorting;

/** Defines the shared contract for sorting integer arrays. */
public interface SortingAlgorithm {
    /**
     * Sorts an array in ascending order in place and records its operations.
     *
     * @param values the array to sort
     * @param metrics the counters for comparisons and writes to the array
     * @throws IllegalArgumentException if either argument is null
     */
    void sort(int[] values, SortMetrics metrics);
}
