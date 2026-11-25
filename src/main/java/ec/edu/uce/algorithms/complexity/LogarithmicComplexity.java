package ec.edu.uce.algorithms.complexity;

/**
 * Demonstrates logarithmic complexity O(log n) by counting how many times a
 * positive integer can be divided by two, using integer division, before it
 * reaches 1.
 *
 * <p>Dominant operation: the integer division {@code current / 2}, executed
 * once per loop iteration. The loop runs floor(log2(n)) times, so
 * T(n) = floor(log2(n)) divisions, which is O(log n).
 * Auxiliary space: O(1), because only a few local variables are used.</p>
 */
public class LogarithmicComplexity {

    /**
     * Divides a positive integer by two, using integer division, until it
     * reaches 1, and returns the number of divisions performed.
     * Example: 16 -> 8 -> 4 -> 2 -> 1 returns 4.
     *
     * @param number a positive integer
     * @return the number of divisions needed to reach 1 (0 when number is 1)
     * @throws IllegalArgumentException if number is less than or equal to zero
     */
    public static int countDivisions(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Number must be positive");
        }

        int current = number;
        int divisions = 0;

        while (current > 1) {
            current = current / 2;
            divisions++;
        }

        return divisions;
    }
}