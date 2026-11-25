package ec.edu.uce.algorithms.benchmark;

import java.util.Random;

/**
 * Generates arrays with the five distributions required by the project standard.
 */
public final class DataGenerator {

    private DataGenerator() {
    }

    public static int[] ascending(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i + 1;
        }
        return data;
    }

    public static int[] descending(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = n - i;
        }
        return data;
    }

    public static int[] random(int n, long seed) {
        Random random = new Random(seed);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = random.nextInt(1_000_000);
        }
        return data;
    }

    public static int[] repeated(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = 7;
        }
        return data;
    }

    public static int[] nearlySorted(int n, long seed) {
        int[] data = ascending(n);
        Random random = new Random(seed);
        int swaps = Math.max(1, n / 20);
        for (int k = 0; k < swaps; k++) {
            int i = random.nextInt(n);
            int j = random.nextInt(n);
            int temp = data[i];
            data[i] = data[j];
            data[j] = temp;
        }
        return data;
    }
}