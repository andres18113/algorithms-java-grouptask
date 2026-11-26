package ec.edu.uce.algorithms;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MainTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final PrintStream console = new PrintStream(output, true, StandardCharsets.UTF_8);

    @Test
    void printsComplexityAndPairedExamples() {
        Main.demonstrate(console);
        String text = output.toString(StandardCharsets.UTF_8);

        assertTrue(text.contains("Linear: n=5, sum=30"));
        assertTrue(text.contains("Quadratic n=100: measured=9900, expected=9900"));
        assertTrue(text.contains("Logarithmic n=16: divisions=4"));
        assertTrue(text.contains("Factorial of 5: iterative=120, recursive=120"));
        assertTrue(text.contains("Array sum: iterative=30, recursive=30"));
        assertTrue(text.contains("Array maximum: iterative=10, recursive=10"));
    }

    @Test
    void showsTheSortedArrayForEachAlgorithm() {
        Main.demonstrate(console);
        String text = output.toString(StandardCharsets.UTF_8);

        String sorted = ": [3, 12, 12, 18, 45, 45, 70, 90]";
        assertTrue(text.contains("BubbleSort" + sorted));
        assertTrue(text.contains("SelectionSort" + sorted));
        assertTrue(text.contains("InsertionSort" + sorted));
        assertTrue(text.contains("ShellSort" + sorted));
    }
}
