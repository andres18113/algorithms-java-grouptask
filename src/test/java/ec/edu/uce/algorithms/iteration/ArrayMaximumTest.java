package ec.edu.uce.algorithms.iteration;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArrayMaximumTest {

    @Test
    public void testMaxIterativeNormalArray() {
        int[] numbers = {3, 1, 4, 1, 5, 9, 2, 6};
        assertEquals(9, ArrayMaximum.maxIterative(numbers), "El máximo debe ser 9");
    }

    @Test
    public void testMaxIterativeSingleElement() {
        int[] numbers = {42};
        assertEquals(42, ArrayMaximum.maxIterative(numbers), "El máximo debe ser el único elemento");
    }

    @Test
    public void testMaxIterativeEmptyArray() {
        int[] numbers = {};
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayMaximum.maxIterative(numbers);
        }, "Debe lanzar excepción si el arreglo está vacío");
    }
}
