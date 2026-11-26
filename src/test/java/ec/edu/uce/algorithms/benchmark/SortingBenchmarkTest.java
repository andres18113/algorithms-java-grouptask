package ec.edu.uce.algorithms.benchmark;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SortingBenchmarkTest {
    @Test
    void printsAnAverageForEveryBenchmarkCombination() {
        var output = new ByteArrayOutputStream();
        try (var stream = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            SortingBenchmark.run(stream);
        }

        var rows = output.toString(StandardCharsets.UTF_8).lines().toList();
        assertEquals("algorithm,size,distribution,comparisons,movements,average_ms", rows.getFirst());
        assertEquals(81, rows.size());
        var algorithms = new HashSet<String>();
        var sizes = new HashSet<String>();
        var distributions = new HashSet<String>();
        var combinations = new HashSet<String>();
        for (String row : rows.subList(1, rows.size())) {
            String[] columns = row.split(",");
            assertEquals(6, columns.length);
            algorithms.add(columns[0]);
            sizes.add(columns[1]);
            distributions.add(columns[2]);
            assertTrue(combinations.add(String.join("/", columns[0], columns[1], columns[2])));
            assertTrue(Long.parseLong(columns[3]) >= 0);
            assertTrue(Long.parseLong(columns[4]) >= 0);
            assertTrue(Double.parseDouble(columns[5]) >= 0);
            if (columns[0].equals("SelectionSort")) {
                long n = Long.parseLong(columns[1]);
                assertEquals(n * (n - 1) / 2, Long.parseLong(columns[3]));
            }
        }
        assertEquals(Set.of("BubbleSort", "SelectionSort", "InsertionSort", "ShellSort"), algorithms);
        assertEquals(Set.of("10", "100", "1000", "10000"), sizes);
        assertEquals(Set.of("ascending", "descending", "random", "repeated", "nearly_sorted"), distributions);
    }
}
