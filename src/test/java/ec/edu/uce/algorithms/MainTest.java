package ec.edu.uce.algorithms;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    @Test
    void demonstratesTheRequiredModules() {
        var output = new ByteArrayOutputStream();
        try (var stream = new PrintStream(output, true, StandardCharsets.UTF_8)) {
            assertEquals(0, Main.run(new String[0], stream, stream));
        }

        String report = output.toString(StandardCharsets.UTF_8);
        assertTrue(report.contains("Quadratic n=100: measured=9900, expected=9900"));
        assertTrue(report.contains("Logarithmic n=16: divisions=4"));
        assertTrue(report.contains("Factorial of 5: iterative=120, recursive=120"));
        assertTrue(report.contains("Array sum: iterative=30, recursive=30"));
        assertTrue(report.contains("Array maximum: iterative=10, recursive=10"));
        for (String algorithm : new String[]{"BubbleSort", "SelectionSort", "InsertionSort", "ShellSort"}) {
            assertTrue(report.contains(algorithm + ": [3, 12, 12, 18, 45, 45, 70, 90]"));
        }
    }

    @Test
    void invalidArgumentsPrintUsageAndReturnAnError() {
        var error = new ByteArrayOutputStream();
        try (var stream = new PrintStream(error, true, StandardCharsets.UTF_8)) {
            assertEquals(2, Main.run(new String[]{"--unknown"}, stream, stream));
        }
        assertTrue(error.toString(StandardCharsets.UTF_8).contains("--benchmark"));
    }
}
