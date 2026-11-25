package ec.edu.uce.algorithms.factorial;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactorialAlgorithmsTest {

    private final FactorialAlgorithms factorial =
            new FactorialAlgorithms();

    // Iterative factorial tests

    @Test
    void shouldCalculateFactorialIteratively() {
        assertEquals(120, factorial.calculateFactorialIterative(5));
    }

    @Test
    void shouldReturnOneForZeroIteratively() {
        assertEquals(1, factorial.calculateFactorialIterative(0));
    }

    @Test
    void shouldReturnOneForOneIteratively() {
        assertEquals(1, factorial.calculateFactorialIterative(1));
    }

    @Test
    void shouldCalculateMaximumFactorialIteratively() {
        assertEquals(2432902008176640000L,
                factorial.calculateFactorialIterative(20));
    }

    @Test
    void shouldRejectNegativeNumberIteratively() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculateFactorialIterative(-1));
    }

    @Test
    void shouldRejectNumberGreaterThanTwentyIteratively() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculateFactorialIterative(21));
    }

    // Recursive factorial tests

    @Test
    void shouldCalculateFactorialRecursively() {
        assertEquals(120, factorial.calculateFactorialRecursive(5));
    }

    @Test
    void shouldReturnOneForZeroRecursively() {
        assertEquals(1, factorial.calculateFactorialRecursive(0));
    }

    @Test
    void shouldReturnOneForOneRecursively() {
        assertEquals(1, factorial.calculateFactorialRecursive(1));
    }

    @Test
    void shouldCalculateMaximumFactorialRecursively() {
        assertEquals(2432902008176640000L,
                factorial.calculateFactorialRecursive(20));
    }

    @Test
    void shouldRejectNegativeNumberRecursively() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculateFactorialRecursive(-1));
    }

    @Test
    void shouldRejectNumberGreaterThanTwentyRecursively() {
        assertThrows(IllegalArgumentException.class,
                () -> factorial.calculateFactorialRecursive(21));
    }
}
