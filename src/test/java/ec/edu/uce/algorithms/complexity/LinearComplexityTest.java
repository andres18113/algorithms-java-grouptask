package ec.edu.uce.algorithms.complexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinearComplexityTest {

    private final LinearComplexity linearComplexity =
            new LinearComplexity();

    @Test
    void shouldCalculateSumOfMultipleElements() {
        int[] numbers = {2, 4, 6};

        long result = linearComplexity.calculateSum(numbers);

        assertEquals(12, result);
    }

    @Test
    void shouldCalculateSumOfPositiveNumbers() {
        int[] numbers = {5, 10, 15};

        long result = linearComplexity.calculateSum(numbers);

        assertEquals(30, result);
    }

    @Test
    void shouldReturnZeroForEmptyArray() {
        int[] numbers = {};

        long result = linearComplexity.calculateSum(numbers);

        assertEquals(0, result);
    }

    @Test
    void shouldReturnElementForSingleElementArray() {
        int[] numbers = {8};

        long result = linearComplexity.calculateSum(numbers);

        assertEquals(8, result);
    }

    @Test
    void shouldThrowExceptionForNullArray() {

        assertThrows(
                IllegalArgumentException.class,
                () -> linearComplexity.calculateSum(null)
        );
    }
}
