package ec.edu.uce.algorithms.complexity;

/**
 * Demonstrates a linear time complexity algorithm.
 */
public class LinearComplexity {

    /**
     * Calculates the sum of all elements in an array.
     *
     * @param numbers the array of integer values
     * @return the sum of all elements
     * @throws IllegalArgumentException if the array is null
     */
    public long calculateSum(int[] numbers) {

        if (numbers == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }

        long sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum;
    }
}

