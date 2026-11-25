package ec.edu.uce.algorithms.benchmark;

import ec.edu.uce.algorithms.sorting.SelectionSort;
import ec.edu.uce.algorithms.sorting.SortMetrics;

public final class QuadraticBenchmark {

    private static final int[] SIZES = {10, 100, 1_000, 10_000};
    private static final int RUNS = 3;
    private static final long SEED = 42L;

    private QuadraticBenchmark() {
    }

    public static void main(String[] args) {
        System.out.println("algorithm,size,distribution,avg_ms,comparisons,movements");

        for (int n : SIZES) {
            for (String distribution : new String[]{
                    "ascending", "descending", "random", "repeated", "nearlySorted"}) {
                runCombination(n, distribution);
            }
        }
    }

    private static void runCombination(int n, String distribution) {
        long totalComparisons = 0L;
        long totalMovements = 0L;
        double totalMs = 0.0;

        for (int run = 0; run < RUNS; run++) {
            int[] data = buildData(n, distribution);
            SortMetrics metrics = new SortMetrics();
            SelectionSort sorter = new SelectionSort();

            // El tiempo solo mide el algoritmo, sin incluir la generación de datos
            long start = System.nanoTime();
            sorter.sort(data, metrics);
            long elapsed = System.nanoTime() - start;

            totalMs += elapsed / 1_000_000.0;
            totalComparisons += metrics.getComparisons();
            totalMovements += metrics.getMovements();
        }

        double avgMs = totalMs / RUNS;
        long avgComparisons = totalComparisons / RUNS;
        long avgMovements = totalMovements / RUNS;

        System.out.printf("%s,%d,%s,%.6f,%d,%d%n",
                "SelectionSort", n, distribution, avgMs, avgComparisons, avgMovements);
    }

    private static int[] buildData(int n, String distribution) {
        return switch (distribution) {
            case "ascending" -> DataGenerator.ascending(n);
            case "descending" -> DataGenerator.descending(n);
            case "random" -> DataGenerator.random(n, SEED);
            case "repeated" -> DataGenerator.repeated(n);
            case "nearlySorted" -> DataGenerator.nearlySorted(n, SEED);
            default -> throw new IllegalArgumentException("Unknown distribution: " + distribution);
        };
    }
}