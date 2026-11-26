# Algorithm Analysis and Implementation in Java

A console project for implementing, testing, and comparing algorithms.

## Team Members

- Ivana Arce
- Jimmy Condor
- Emily Gamboa
- Kevin Ramirez

## Build and run

Use Java 21 and Maven. In IntelliJ IDEA, open `pom.xml` as a Maven project and select JDK 21 as the Project SDK.

```powershell
mvn clean verify
java -cp target/classes ec.edu.uce.algorithms.Main
```

Run `mvn test` to run the JUnit 5 tests.

The default command demonstrates complexity, iteration, recursion, and all four sorts.
Use `--help` to see the available modes.

## Sorting benchmark

```powershell
java -cp target/classes ec.edu.uce.algorithms.Main --benchmark > sorting-results.csv
```

The benchmark compares Bubble, Selection, Insertion, and Shell Sort for arrays of
10, 100, 1,000, and 10,000 elements. It uses ascending, descending, random,
repeated, and nearly sorted inputs. Randomized generators use seed 42.
Each sorter receives a fresh clone and new counters in every run.

Each combination has three warm-up runs followed by three measured runs.
Only the sorting call is timed with `System.nanoTime()`. Data generation,
copying, validation, and CSV output happen outside that interval.
The output has 80 rows summarizing 240 measured runs and reports time in
milliseconds. Comparisons count ordering checks and movements count writes to
the array. When saving evidence, record the Java version, operating system,
and CPU used for the benchmark.

## Quadratic comparison

The console demo runs a separate comparison exercise. For an array of length
`n`, the outer loop chooses each of its `n` elements. The inner loop compares
it with the other `n - 1` elements and skips the same index. The comparison
count is therefore `T(n) = n(n - 1)`, time is O(n²), and auxiliary space is O(1).
The run compares both directions of a pair, so `(i, j)` and `(j, i)` each count.
Selection Sort separately makes `n(n - 1) / 2` ordering comparisons.

| Input size | Expected comparisons | Measured comparisons |
| ---: | ---: | ---: |
| 10 | 90 | 90 |
| 100 | 9,900 | 9,900 |
| 1,000 | 999,000 | 999,000 |


## Project structure

Production code lives in `src/main/java` under `ec.edu.uce.algorithms`. Put tests in `src/test/java` using the corresponding package names.

Create these subpackages as their implementations are added.

| Subpackage | Purpose |
| --- | --- |
| `complexity` | Operation counting and complexity analysis |
| `iteration` | Iterative algorithms |
| `recursion` | Recursive algorithms |
| `sorting` | Sorting algorithms |
| `benchmark` | Dataset generation and performance measurement |
