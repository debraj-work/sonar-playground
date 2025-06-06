package com.example.modulea;

/**
 * A simple calculator class with basic operations.
 */
public class Calculator {

    /**
     * Adds two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return sum of a and b
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * Subtracts second number from first number.
     * 
     * @param a first number
     * @param b second number
     * @return difference of a and b
     */
    public int subtract(int a, int b) {
        return a - b;
    }

    /**
     * Multiplies two numbers.
     * 
     * @param a first number
     * @param b second number
     * @return product of a and b
     */
    public int multiply(int a, int b) {
        return a * b;
    }

    /**
     * Divides first number by second number.
     * This method will be tested in module-c, not in module-a.
     * 
     * @param a first number
     * @param b second number
     * @return quotient of a and b
     * @throws ArithmeticException if b is zero
     */
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero");
        }
        return a / b;
    }

    /**
     * Calculates the power of a number.
     * 
     * @param base the base number
     * @param exponent the exponent (must be non-negative)
     * @return base raised to the power of exponent
     * @throws IllegalArgumentException if exponent is negative
     */
    public int power(int base, int exponent) {
        if (exponent < 0) {
            throw new IllegalArgumentException("Exponent must be non-negative for power operation");
        }

        int result = 1;
        for (int i = 0; i < exponent; i++) {
            result = multiply(result, base);
        }
        return result;
    }

    /**
     * Calculates the modulo of first number by second number.
     *
     * @param a first number
     * @param b second number
     * @return remainder of a divided by b
     * @throws ArithmeticException if b is zero
     */
    public int modulo(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Modulo by zero");
        }
        return a % b;
    }
}
