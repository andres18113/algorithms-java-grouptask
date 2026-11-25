package ec.edu.uce.algorithms.sorting;

/**
 * Implements the Insertion Sort algorithm.
 * Time complexity: O(n^2) in the worst case, O(n) in the best case.
 * Auxiliary space: O(1).
 */
public class InsertionSort implements SortingAlgorithm {

    /**
     * Sorts an array in ascending order in place and records its operations.
     *
     * @param values  the array to sort
     * @param metrics the counters for comparisons and writes to the array
     * @throws IllegalArgumentException if either argument is null
     */
    @Override
    public void sort(int[] values, SortMetrics metrics) {
        if (values == null || metrics == null) {
            throw new IllegalArgumentException("Array and metrics must not be null");
        }

        int n = values.length;
        for (int i = 1; i < n; i++) {
            int key = values[i];
            int j = i - 1;

            // Move elements of values[0..i-1], that are greater than key,
            // to one position ahead of their current position
            while (j >= 0) {
                metrics.recordComparison(); // Count the comparison
                if (values[j] > key) {
                    values[j + 1] = values[j];
                    metrics.recordMovement(); // Count the write
                    j = j - 1;
                } else {
                    break;
                }
            }
            values[j + 1] = key;
            metrics.recordMovement(); // Count the final write of the key
        }
    }
}
