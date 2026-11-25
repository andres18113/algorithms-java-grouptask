package ec.edu.uce.algorithms.search;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void findsElementAtStart() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(0, BinarySearch.binarySearch(arr, 1));
    }

    @Test
    void findsElementInMiddle() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(2, BinarySearch.binarySearch(arr, 5));
    }

    @Test
    void findsElementAtEnd() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(4, BinarySearch.binarySearch(arr, 9));
    }

    @Test
    void returnsMinusOneWhenNotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        assertEquals(-1, BinarySearch.binarySearch(arr, 4));
    }

    @Test
    void handlesEmptyArray() {
        int[] arr = {};
        assertEquals(-1, BinarySearch.binarySearch(arr, 5));
    }

    @Test
    void handlesSingleElement() {
        int[] arr = {10};
        assertEquals(0, BinarySearch.binarySearch(arr, 10));
        assertEquals(-1, BinarySearch.binarySearch(arr, 5));
    }
}