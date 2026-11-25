
package ec.edu.uce.algorithms.factorial;

/**
 * Provides iterative and recursive factorial implementations.
 */
public class FactorialAlgorithms {

    /**
     * Calculates the factorial using iteration.
     *
     * @param number integer between 0 and 20
     * @return the factorial of the given number
     * @throws IllegalArgumentException if the number is outside the supported range
     */
    public long calculateFactorialIterative(int number) {

        if (number < 0 || number > 20) {
            throw new IllegalArgumentException(
                    "Number must be between 0 and 20"
            );
        }

        long result = 1;

        for (int i = 1; i <= number; i++) {
            result *= i;
        }

        return result;
    }

    /**
     * Calculates the factorial using recursion.
     *
     * @param number integer between 0 and 20
     * @return the factorial of the given number
     * @throws IllegalArgumentException if the number is outside the supported range
     */
    public long calculateFactorialRecursive(int number) {

        if (number < 0 || number > 20) {
            throw new IllegalArgumentException(
                    "Number must be between 0 and 20"
            );
        }

        if (number == 0 || number == 1) {
            return 1;
        }

        return number * calculateFactorialRecursive(number - 1);
    }
}
