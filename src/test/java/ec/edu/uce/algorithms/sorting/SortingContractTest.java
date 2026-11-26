package ec.edu.uce.algorithms.sorting;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class SortingContractTest {
    static Stream<SortingAlgorithm> algorithms() {
        return Stream.of(new BubbleSort(), new SelectionSort(), new InsertionSort(), new ShellSort());
    }

    @ParameterizedTest
    @MethodSource("algorithms")
    void sortsInPlaceAndPreservesDuplicatesAndNegativeValues(SortingAlgorithm algorithm) {
        int[] values = {3, -2, 3, -2, 0};
        algorithm.sort(values, new SortMetrics());
        assertArrayEquals(new int[]{-2, -2, 0, 3, 3}, values);
    }
}
