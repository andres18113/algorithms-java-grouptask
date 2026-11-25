package ec.edu.uce.algorithms.complexity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class LogarithmicComplexityTest {

    @Test
    void returnsZeroForOne() {
        assertEquals(0, LogarithmicComplexity.countDivisions(1));
    }

    @Test
    void returnsOneForTwo() {
        assertEquals(1, LogarithmicComplexity.countDivisions(2));
    }

    @Test
    void returnsOneForThree() {
        assertEquals(1, LogarithmicComplexity.countDivisions(3)); // 3 -> 1
    }

    @Test
    void returnsThreeForEight() {
        assertEquals(3, LogarithmicComplexity.countDivisions(8));
    }

    @Test
    void returnsThreeForTen() {
        assertEquals(3, LogarithmicComplexity.countDivisions(10)); // 10 -> 5 -> 2 -> 1
    }

    @Test
    void returnsFourForSixteen() {
        assertEquals(4, LogarithmicComplexity.countDivisions(16));
    }

    @Test
    void returnsNineForOneThousand() {
        assertEquals(9, LogarithmicComplexity.countDivisions(1000));
    }

    @Test
    void handlesLargestInteger() {
        assertEquals(30, LogarithmicComplexity.countDivisions(Integer.MAX_VALUE));
    }

    @Test
    void rejectsZero() {
        try {
            LogarithmicComplexity.countDivisions(0);
            fail("Expected IllegalArgumentException for zero");
        } catch (IllegalArgumentException expected) {
            // expected behavior
        }
    }

    @Test
    void rejectsNegativeNumber() {
        try {
            LogarithmicComplexity.countDivisions(-5);
            fail("Expected IllegalArgumentException for a negative number");
        } catch (IllegalArgumentException expected) {
            // expected behavior
        }
    }
}