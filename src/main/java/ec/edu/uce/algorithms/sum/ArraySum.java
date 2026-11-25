package ec.edu.uce.algorithms.sum;

/**
 * Provides iterative and recursive implementations to sum the elements of an array.
 *
 * <p>Both methods follow the project input-validation rules:
 * an empty array returns 0, and a {@code null} array is rejected explicitly.</p>
 *
 * @author Kevin Ramirez
 * @version 1.0
 */
public final class ArraySum {

    private ArraySum() {
        // Utility class: prevent instantiation.
    }

    /**
     * Computes the sum of all elements in the array using an iterative loop.
     *
     * @param array the array to sum; must not be {@code null}
     * @return the sum of all elements, or 0 if the array is empty
     * @throws IllegalArgumentException if {@code array} is {@code null}
     */
    public static long sumIterative(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        long sum = 0L;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    /**
     * Computes the sum of all elements in the array using recursion.
     *
     * @param array the array to sum; must not be {@code null}
     * @param index the current index; callers should pass 0
     * @return the sum of elements from {@code index} to the end of the array
     * @throws IllegalArgumentException if {@code array} is {@code null}
     *                                  or {@code index} is out of range
     */
    public static long sumRecursive(int[] array, int index) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }
        if (index < 0 || index > array.length) {
            throw new IllegalArgumentException("Index out of range: " + index);
        }
        if (index == array.length) {
            return 0L;
        }
        return array[index] + sumRecursive(array, index + 1);
    }
}