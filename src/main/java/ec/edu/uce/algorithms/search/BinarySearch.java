package ec.edu.uce.algorithms.search;

/**
 * Implements a binary search algorithm to find a target value in a sorted array.
 * Time complexity: O(log n). Auxiliary space: O(1).
 */
public class BinarySearch {

    /**
     * Searches a value in a sorted array using binary search.
     *
     * @param sortedValues array sorted in ascending order
     * @param target       value to find
     * @return the index of the target, or -1 if it is not present
     * @throws IllegalArgumentException if sortedValues is null
     */
    public static int binarySearch(int[] sortedValues, int target) {
        if (sortedValues == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        int low = 0;
        int high = sortedValues.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // avoids integer overflow

            if (sortedValues[mid] == target) {
                return mid;
            }
            if (sortedValues[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}