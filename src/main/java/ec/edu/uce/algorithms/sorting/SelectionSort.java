package ec.edu.uce.algorithms.sorting;

/**
 * Implements Selection Sort through the SortingAlgorithm interface.
 *
 * @author Ivana Arce
 * @version 1.0
 */
public class SelectionSort implements SortingAlgorithm {

    @Override
    public void sort(int[] values, SortMetrics metrics) {
        if (values == null || metrics == null) {
            throw new IllegalArgumentException("Arguments must not be null");
        }

        int n = values.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                metrics.recordComparison();
                if (values[j] < values[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = values[i];
                values[i] = values[minIndex];
                values[minIndex] = temp;
                metrics.recordMovement();
                metrics.recordMovement();
            }
        }
    }
}