package ch.jdc.overloaded;

public class CalculatorOverloaded {
    static class Calculator {
        // Overloaded method: accepts an int and a double
        void compute(int a, double b) {
            System.out.println("int, double version called");
        }

        // Overloaded method: accepts a double and an int
        void compute(double a, int b) {
            System.out.println("double, int version called");
        }
    }

    public static void main(String[] args) {
        Calculator c = new Calculator();

        // Compilation error: The call c.compute(5, 10) is ambiguous
        // Explanation:
        // - The method compute(int a, double b) can accept (5, 10), because 10 can be promoted to a double.
        // - The method compute(double a, int b) can also accept (5, 10), because 5 can be promoted to a double.
        // - The compiler cannot decide which version of the method to call, resulting in an ambiguity error.
        //c.compute(5, 10); // -> java: reference to compute is ambiguous

        // This call works because the first argument is explicitly a double (3d),
        // so the compiler matches it to compute(double a, int b).
        c.compute(3d, 2); // Output: "double, int version called"

        // This call works because the second argument is explicitly a double (2d),
        // so the compiler matches it to compute(int a, double b).
        c.compute(1, 2d); // Output: "int, double version called"

        // Alternatively, you can pass a boxed double to make it explicit:
        c.compute(1, Double.valueOf(2)); // Output: "int, double version called"
    }
}

