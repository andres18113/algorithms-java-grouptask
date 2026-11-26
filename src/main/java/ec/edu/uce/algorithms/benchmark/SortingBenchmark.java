package ec.edu.uce.algorithms.benchmark;

import ec.edu.uce.algorithms.sorting.BubbleSort;
import ec.edu.uce.algorithms.sorting.InsertionSort;
import ec.edu.uce.algorithms.sorting.SelectionSort;
import ec.edu.uce.algorithms.sorting.ShellSort;
import ec.edu.uce.algorithms.sorting.SortMetrics;
import ec.edu.uce.algorithms.sorting.SortingAlgorithm;

import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

/** Measures the four sorting algorithms on equivalent datasets. */
public final class SortingBenchmark {
    private static final int[] SIZES = {10, 100, 1_000, 10_000};
    private static final int WARM_UP_RUNS = 3;
    private static final int MEASURED_RUNS = 3;
    private static final long SEED = 42L;

    private SortingBenchmark() {
    }

    /**
     * Runs the benchmark and saves its results to a CSV file.
     *
     * @param args command-line arguments
     * @throws IOException if the results folder or file cannot be written
     */
    public static void main(String[] args) throws IOException {
        Path csv = Path.of("results", "tables", "benchmark_results.csv");
        Files.createDirectories(csv.getParent());

        try (PrintStream file = new PrintStream(csv.toFile(), StandardCharsets.UTF_8)) {
            run(file);
            if (file.checkError()) {
                throw new IOException("Could not write " + csv);
            }
        }

        System.out.println("CSV saved to: " + csv.toAbsolutePath());
    }

    /**
     * Runs the benchmark and writes one CSV row per algorithm, size and distribution.
     *
     * @param output the stream that receives the averaged results
     */
    public static void run(PrintStream output) {
        var algorithms = new SortingAlgorithm[]{
                new BubbleSort(), new SelectionSort(), new InsertionSort(), new ShellSort()
        };
        output.println("algorithm,size,distribution,comparisons,movements,average_ms");
        for (int size : SIZES) {
            runDistribution(algorithms, "ascending", DataGenerator.ascending(size), output);
            runDistribution(algorithms, "descending", DataGenerator.descending(size), output);
            runDistribution(algorithms, "random", DataGenerator.random(size, SEED), output);
            runDistribution(algorithms, "repeated", DataGenerator.repeated(size), output);
            runDistribution(algorithms, "nearly_sorted", DataGenerator.nearlySorted(size, SEED), output);
        }
    }

    private static void runDistribution(SortingAlgorithm[] algorithms, String distribution,
                                        int[] input, PrintStream output) {
        for (SortingAlgorithm algorithm : algorithms) {
            for (int run = 0; run < WARM_UP_RUNS; run++) {
                measure(algorithm, input);
            }

            long elapsedNanos = 0;
            long comparisons = 0;
            long movements = 0;
            for (int run = 0; run < MEASURED_RUNS; run++) {
                Measurement result = measure(algorithm, input);
                elapsedNanos += result.elapsedNanos();
                comparisons += result.comparisons();
                movements += result.movements();
            }

            double averageMilliseconds = elapsedNanos / (MEASURED_RUNS * 1_000_000.0);
            output.printf(Locale.ROOT, "%s,%d,%s,%d,%d,%.6f%n",
                    algorithm.getClass().getSimpleName(), input.length, distribution,
                    comparisons / MEASURED_RUNS, movements / MEASURED_RUNS, averageMilliseconds);
        }
    }

    private static Measurement measure(SortingAlgorithm algorithm, int[] input) {
        int[] values = input.clone();
        SortMetrics metrics = new SortMetrics();
        long start = System.nanoTime();
        algorithm.sort(values, metrics);
        long elapsedNanos = System.nanoTime() - start;

        for (int index = 1; index < values.length; index++) {
            if (values[index - 1] > values[index]) {
                throw new IllegalStateException(algorithm.getClass().getSimpleName() + " did not sort the array.");
            }
        }

        return new Measurement(elapsedNanos, metrics.getComparisons(), metrics.getMovements());
    }

    private record Measurement(long elapsedNanos, long comparisons, long movements) {
    }
}
