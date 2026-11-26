package ec.edu.uce.algorithms.complexity;

/** Demonstrates quadratic growth by comparing every pair of distinct positions. */
public final class QuadraticComplexity {
    private QuadraticComplexity() {
    }

    /**
     * Compares the values at every ordered pair of distinct indices.
     * An array of length n produces n(n - 1) comparisons and uses constant auxiliary space.
     *
     * @param values the array to compare
     * @return the number of comparisons and the number of equal pairs
     * @throws IllegalArgumentException if values is null
     */
    public static ComparisonResult analyze(int[] values) {
        if (values == null) {
            throw new IllegalArgumentException("Values must not be null.");
        }

        long comparisons = 0;
        long equalPairs = 0;
        for (int first = 0; first < values.length; first++) {
            for (int second = 0; second < values.length; second++) {
                if (first == second) {
                    continue;
                }

                comparisons++;
                if (values[first] == values[second]) {
                    equalPairs++;
                }
            }
        }
        return new ComparisonResult(comparisons, equalPairs);
    }

    /**
     * Holds the operation counts from the pairwise comparison.
     *
     * @param comparisons the number of comparisons between values
     * @param equalPairs the number of ordered pairs whose values are equal
     */
    public record ComparisonResult(long comparisons, long equalPairs) {
    }
}
