package ec.edu.uce.algorithms.sorting;

/** Records the number of ordering comparisons and writes made during sorting. */
public final class SortMetrics {
    private long comparisons;
    private long movements;

    /** Creates metrics with both counters set to zero. */
    public SortMetrics() {
    }

    /** Records one ordering comparison between array values. */
    public void recordComparison() {
        comparisons++;
    }

    /** Records one write to an array position. */
    public void recordMovement() {
        movements++;
    }

    /**
     * Returns the number of ordering comparisons.
     *
     * @return the comparison count
     */
    public long getComparisons() {
        return comparisons;
    }

    /**
     * Returns the number of array writes.
     *
     * @return the movement count
     */
    public long getMovements() {
        return movements;
    }
}
