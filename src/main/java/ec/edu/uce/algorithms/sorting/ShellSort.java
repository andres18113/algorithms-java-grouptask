package ec.edu.uce.algorithms.sorting;

/** Sorts integer arrays by performing insertion passes with decreasing gaps. */
public final class ShellSort implements SortingAlgorithm {
    /**
     * Sorts an integer array in ascending order using Shell Sort.
     * Uses insertion passes with progressively smaller gaps.
     * Records element comparisons and array movements.
     *
     * @param values the array to sort in place
     * @param metrics the collector for comparisons and movements
     * @throws IllegalArgumentException if any argument is null
     */
    @Override
    public void sort(int[] values, SortMetrics metrics) {
        if (values == null || metrics == null) {
            throw new IllegalArgumentException("Values and metrics must be non-null.");
        }

        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            for (int index = gap; index < values.length; index++) {
                int valueToInsert = values[index];
                int insertionIndex = index;

                while (insertionIndex >= gap) {
                    int previousIndex = insertionIndex - gap;
                    metrics.recordComparison();
                    if (values[previousIndex] <= valueToInsert) {
                        break;
                    }

                    values[insertionIndex] = values[previousIndex];
                    metrics.recordMovement();
                    insertionIndex = previousIndex;
                }

                if (insertionIndex != index) {
                    values[insertionIndex] = valueToInsert;
                    metrics.recordMovement();
                }
            }
        }
    }
}
