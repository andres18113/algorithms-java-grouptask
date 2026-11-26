package ec.edu.uce.algorithms.complexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class QuadraticComplexityTest {
    @Test
    void comparesEveryDistinctOrderedPair() {
        var result = QuadraticComplexity.analyze(new int[]{4, -2, 4, 0});

        assertEquals(12L, result.comparisons());
        assertEquals(2L, result.equalPairs());
    }

    @Test
    void measuredCountsMatchTheFormulaForDifferentLengths() {
        for (int size : new int[]{0, 1, 2, 10, 100, 1_000}) {
            var result = QuadraticComplexity.analyze(new int[size]);

            assertEquals((long) size * (size - 1), result.comparisons());
            assertEquals(result.comparisons(), result.equalPairs());
        }
    }

    @Test
    void rejectsNull() {
        assertThrows(IllegalArgumentException.class, () -> QuadraticComplexity.analyze(null));
    }
}
