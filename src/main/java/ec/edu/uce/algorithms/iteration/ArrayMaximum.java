package ec.edu.uce.algorithms.iteration;

public class ArrayMaximum {

    /**
     * Finds the maximum value of an array using a loop.
     *
     * @param values array to inspect
     * @return the largest value in the array
     * @throws IllegalArgumentException if values is null or empty
     */
    public static int maxIterative(int[] values) {
        if (values == null || values.length == 0) {
            throw new IllegalArgumentException("Array must not be null or empty");
        }
        int max = values[0];
        for (int i = 1; i < values.length; i++) {
            if (values[i] > max) {
                max = values[i];
            }
        }
        return max;
    }
}