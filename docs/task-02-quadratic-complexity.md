# Task 02: Quadratic Complexity O(n²)

## Dominant Operation
The dominant operation in Selection Sort is the **ordering comparison** `values[j] < values[minIndex]`, which is executed once per pair `(i, j)` with `j > i`.

## Theoretical Analysis
For an array of size `n`, the outer loop runs `n-1` times. In iteration `i` (0-indexed), the inner loop runs `n-1-i` times. Therefore:

T(n) = (n-1) + (n-2) + ... + 1 = n(n-1)/2

Since `n(n-1)/2 = (n² - n)/2`, the dominant term is `n²`, so:

**T(n) = O(n²)**

This holds for **best, average, and worst case**, because Selection Sort always scans the entire remaining subarray to find the minimum. Auxiliary space is **O(1)**.

## Measured Evidence
The benchmark was run using `System.nanoTime()` excluding input generation, with 3 runs per combination. The following table confirms the theoretical formula `n(n-1)/2`:

| Size (n) | Expected Comparisons n(n-1)/2 | Measured Comparisons | Match |
|----------|-------------------------------|----------------------|-------|
| 10       | 45                            | 45                   | Yes   |
| 100      | 4950                          | 4950                 | Yes   |
| 1000     | 499500                        | 499500               | Yes   |
| 10000    | 49995000                      | 49995000             | Yes   |

The same comparison counts appear for all five distributions (ascending, descending, random, repeated, nearly sorted), confirming that the comparison count is **independent of the input distribution**.

## Time Evidence
The measured average time grows quadratically with `n`. For example:
- n=100: ~0.21 ms
- n=1000: ~2.02 ms
- n=10000: ~24.84 ms

When the size increases by a factor of 10, the execution time increases by a factor of 100, consistent with O(n²) behavior.

## Conclusion
Theoretical T(n) = n(n-1)/2 and Big O = O(n²) are **empirically confirmed** by the benchmark.