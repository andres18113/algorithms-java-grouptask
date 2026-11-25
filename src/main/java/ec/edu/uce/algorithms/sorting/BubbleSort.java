package ec.edu.uce.algorithms.sorting;

/**
 * Implements the Bubble Sort algorithm to sort integer arrays in-place
 * in ascending order while recording comparison and movement metrics.
 */
public class BubbleSort implements SortingAlgorithm {

    /**
     * Sorts the given array in ascending order using Bubble Sort and updates
     * the provided {@link SortMetrics} instance.
     *
     * @param values  array to sort in-place
     * @param metrics metrics tracker for comparisons and array movements
     * @throws IllegalArgumentException if {@code values} or {@code metrics} is {@code null}
     */
    @Override
    public void sort(int[] values, SortMetrics metrics) {
        if (values == null || metrics == null) {
            throw new IllegalArgumentException("Values array and metrics must not be null.");
        }

        int n = values.length;
        if (n <= 1) {
            return;
        }

        for (int pass = 0; pass < n - 1; pass++) {
            boolean swapped = false;

            for (int i = 0; i < n - 1 - pass; i++) {
                metrics.recordComparison();
                if (values[i] > values[i + 1]) {
                    int temp = values[i];
                    values[i] = values[i + 1];
                    metrics.recordMovement();
                    values[i + 1] = temp;
                    metrics.recordMovement();
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}