package ec.edu.uce.algorithms.recursion;

public class ArrayMaximumRecursive {

    /**
     * Finds the maximum value of an array using recursion.
     * Time complexity: O(n). Auxiliary space: O(n) because of the call stack,
     * so very large arrays risk a StackOverflowError.
     *
     * @param values array to inspect
     * @return the largest value in the array
     * @throws IllegalArgumentException if values is null or empty
     */
    public static int maxRecursive(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        return maxRecursive(values, values.length - 1);
    }

    /**
     * Returns the maximum of the elements from index 0 up to the given index.
     *
     * @param values array to inspect
     * @param index  last position to consider
     * @return the largest value between positions 0 and index
     */
    private static int maxRecursive(int[] values, int index) {
        if (index == 0) {
            return values[0]; // base case: a single element is the maximum
        }
        return Math.max(values[index], maxRecursive(values, index - 1));
    }
}