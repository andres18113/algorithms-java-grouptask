package ec.edu.uce.algorithms;

import ec.edu.uce.algorithms.benchmark.SortingBenchmark;
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

/** Runs the algorithm demonstrations or the sorting benchmark from the console. */
public final class Main {
    private static final String USAGE = "Usage: Main [--demo | --benchmark | --help]";

    private Main() {
    }

    /**
     * Runs the selected console mode. With no arguments, shows the demonstrations.
     *
     * @param args an optional mode flag
     */
    public static void main(String[] args) {
        int status = run(args, System.out, System.err);
        if (status != 0) {
            System.exit(status);
        }
    }

    static int run(String[] args, PrintStream output, PrintStream errors) {
        if (args.length == 0 || (args.length == 1 && args[0].equals("--demo"))) {
            demonstrate(output);
        } else if (args.length == 1 && args[0].equals("--benchmark")) {
            SortingBenchmark.run(output);
        } else if (args.length == 1 && args[0].equals("--help")) {
            output.println(USAGE);
        } else {
            errors.println(USAGE);
            return 2;
        }
        return 0;
    }

    private static void demonstrate(PrintStream output) {
        output.println("Algorithm Analysis and Implementation in Java");
        output.println();

        int[] assignmentValues = {8, 3, 10, 2, 7};
        output.printf("Linear: n=%d, sum=%d%n",
                assignmentValues.length, new LinearComplexity().calculateSum(assignmentValues));
        for (int size : new int[]{10, 100, 1_000}) {
            var result = QuadraticComplexity.analyze(new int[size]);
            long expected = (long) size * (size - 1);
            output.printf("Quadratic n=%d: measured=%d, expected=%d%n",
                    size, result.comparisons(), expected);
        }
        for (int number : new int[]{1, 10, 16}) {
            output.printf("Logarithmic n=%d: divisions=%d%n",
                    number, LogarithmicComplexity.countDivisions(number));
        }

        output.println();
        var factorial = new FactorialAlgorithms();
        output.printf("Factorial of 5: iterative=%d, recursive=%d%n",
                factorial.calculateFactorialIterative(5), factorial.calculateFactorialRecursive(5));
        output.printf("Array sum: iterative=%d, recursive=%d%n",
                ArraySum.sumIterative(assignmentValues), ArraySum.sumRecursive(assignmentValues, 0));
        output.printf("Array maximum: iterative=%d, recursive=%d%n",
                ArrayMaximum.maxIterative(assignmentValues), ArrayMaximumRecursive.maxRecursive(assignmentValues));

        output.println();
        int[] sortingValues = {45, 12, 90, 12, 3, 70, 45, 18};
        output.println("Sorting input: " + Arrays.toString(sortingValues));
        var algorithms = new SortingAlgorithm[]{
                new BubbleSort(), new SelectionSort(), new InsertionSort(), new ShellSort()
        };
        for (SortingAlgorithm algorithm : algorithms) {
            int[] copy = sortingValues.clone();
            var metrics = new SortMetrics();
            algorithm.sort(copy, metrics);
            output.printf("%s: %s, comparisons=%d, movements=%d%n",
                    algorithm.getClass().getSimpleName(), Arrays.toString(copy),
                    metrics.getComparisons(), metrics.getMovements());
        }
        output.println("Run with --benchmark to produce the full sorting experiment as CSV.");
    }
}
