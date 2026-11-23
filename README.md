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
