package ec.edu.uce.algorithms;

import ec.edu.uce.algorithms.complexity.LinearComplexity;
import ec.edu.uce.algorithms.complexity.LogarithmicComplexity;
import ec.edu.uce.algorithms.complexity.QuadraticComplexity;
import ec.edu.uce.algorithms.factorial.FactorialAlgorithms;
import ec.edu.uce.algorithms.iteration.ArrayMaximum;
import ec.edu.uce.algorithms.recursion.ArrayMaximumRecursive;
import ec.edu.uce.algorithms.sorting.BubbleSort;
import ec.edu.uce.algorithms.sorting.InsertionSort;
import ec.edu.uce.algorithms.sorting.SelectionSort;
import ec.edu.uce.algorithms.sorting.ShellSort;
import ec.edu.uce.algorithms.sorting.SortMetrics;
import ec.edu.uce.algorithms.sorting.SortingAlgorithm;
import ec.edu.uce.algorithms.sum.ArraySum;

import java.io.PrintStream;
import java.util.Arrays;

/** Prints the assignment examples in the console. */
public final class Main {
    private Main() {
    }

    /**
     * Prints the examples for each activity.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        demonstrate(System.out);
    }

    static void demonstrate(PrintStream output) {
        output.println("Algorithm Analysis and Implementation in Java");

        int[] assignmentValues = {8, 3, 10, 2, 7};
        showComplexity(output, assignmentValues);
        showIterationAndRecursion(output, assignmentValues);
        showSorting(output);

        output.println("Run SortingBenchmark to save the sorting results as CSV.");
    }

    private static void showComplexity(PrintStream output, int[] values) {
        output.println();
        LinearComplexity linear = new LinearComplexity();
        long sum = linear.calculateSum(values);
        output.println("Linear: n=" + values.length + ", sum=" + sum);

        int[] sizes = {10, 100, 1_000};
        for (int size : sizes) {
            int[] input = new int[size];
            long measured = QuadraticComplexity.analyze(input).comparisons();
            long expected = (long) size * (size - 1);
            output.println("Quadratic n=" + size + ": measured=" + measured + ", expected=" + expected);
        }

        int[] numbers = {1, 10, 16};
        for (int number : numbers) {
            int divisions = LogarithmicComplexity.countDivisions(number);
            output.println("Logarithmic n=" + number + ": divisions=" + divisions);
        }
    }

    private static void showIterationAndRecursion(PrintStream output, int[] values) {
        output.println();
        FactorialAlgorithms factorial = new FactorialAlgorithms();
        long iterativeFactorial = factorial.calculateFactorialIterative(5);
        long recursiveFactorial = factorial.calculateFactorialRecursive(5);
        output.println("Factorial of 5: iterative=" + iterativeFactorial + ", recursive=" + recursiveFactorial);

        long iterativeSum = ArraySum.sumIterative(values);
        long recursiveSum = ArraySum.sumRecursive(values, 0);
        output.println("Array sum: iterative=" + iterativeSum + ", recursive=" + recursiveSum);

        int iterativeMaximum = ArrayMaximum.maxIterative(values);
        int recursiveMaximum = ArrayMaximumRecursive.maxRecursive(values);
        output.println("Array maximum: iterative=" + iterativeMaximum + ", recursive=" + recursiveMaximum);
    }

    private static void showSorting(PrintStream output) {
        output.println();
        int[] input = {45, 12, 90, 12, 3, 70, 45, 18};
        output.println("Sorting input: " + Arrays.toString(input));

        showSort(output, "BubbleSort", new BubbleSort(), input);
        showSort(output, "SelectionSort", new SelectionSort(), input);
        showSort(output, "InsertionSort", new InsertionSort(), input);
        showSort(output, "ShellSort", new ShellSort(), input);
    }

    private static void showSort(PrintStream output, String name, SortingAlgorithm algorithm, int[] input) {
        int[] copy = input.clone();
        SortMetrics metrics = new SortMetrics();
        algorithm.sort(copy, metrics);

        output.println(name + ": " + Arrays.toString(copy)
                + ", comparisons=" + metrics.getComparisons()
                + ", movements=" + metrics.getMovements());
    }
}
