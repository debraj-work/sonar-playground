package com.example.modulec;

import com.example.modulea.Calculator;
import com.example.moduleb.StringUtils;

/**
 * Main application class for Module C that uses functionality from both Module A and Module B.
 */
public class ModuleCApp {

    private final Calculator calculator;
    private final StringUtils stringUtils;

    public ModuleCApp() {
        this.calculator = new Calculator();
        this.stringUtils = new StringUtils();
    }

    /**
     * Performs a calculation and formats the result as a string.
     * 
     * @param a first number
     * @param b second number
     * @param operation the operation to perform (add, subtract, multiply, divide, power)
     * @return the formatted result
     */
    public String performOperation(int a, int b, String operation) {
        int result;

        switch (operation.toLowerCase()) {
            case "add":
                result = calculator.add(a, b);
                break;
            case "subtract":
                result = calculator.subtract(a, b);
                break;
            case "multiply":
                result = calculator.multiply(a, b);
                break;
            case "divide":
                result = calculator.divide(a, b);
                break;
            case "power":
                if (b < 0) {
                    throw new IllegalArgumentException("Exponent must be non-negative for power operation");
                }
                result = 1;
                for (int i = 0; i < b; i++) {
                    result = calculator.multiply(result, a);
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown operation: " + operation);
        }

        String resultString = a + " " + getOperationSymbol(operation) + " " + b + " = " + result;

        // Use StringUtils to check if the result is a palindrome
        if (stringUtils.isPalindrome(String.valueOf(result))) {
            resultString += " (palindrome)";
        }

        // For power operation, also show the reversed result string
        if (operation.equalsIgnoreCase("power")) {
            String reversedResult = stringUtils.reverse(resultString);
            resultString += " (reversed: " + reversedResult + ")";
        }

        return resultString;
    }

    /**
     * Gets the symbol for the given operation.
     * 
     * @param operation the operation name
     * @return the operation symbol
     */
    private String getOperationSymbol(String operation) {
        switch (operation.toLowerCase()) {
            case "add": return "+";
            case "subtract": return "-";
            case "multiply": return "*";
            case "divide": return "/";
            case "power": return "^";
            default: return "?";
        }
    }

    /**
     * Main method to demonstrate the functionality.
     * 
     * @param args command line arguments
     */
    public static void main(String[] args) {
        ModuleCApp app = new ModuleCApp();

        System.out.println(app.performOperation(10, 5, "add"));
        System.out.println(app.performOperation(10, 5, "subtract"));
        System.out.println(app.performOperation(10, 5, "multiply"));
        System.out.println(app.performOperation(10, 5, "divide"));
        System.out.println(app.performOperation(2, 3, "power"));
    }
}
