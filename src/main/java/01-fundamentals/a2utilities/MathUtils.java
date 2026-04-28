package a2utilities;

import java.util.Random;

public class MathUtils {
    public static void main(String[] args) {

        generateRandom();

        // Math.max() - returns the maximum of two values
        int maxNumber = Math.max(10, 20);
        System.out.println("Max: " + maxNumber); // Output: 20
        float maxFloat = Math.max(15.5f, 12.7f);
        System.out.println("Max of floats: " + maxFloat); // Output: 15.5


        // Math.min() - returns the minimum of two values
        int minNumber = Math.min(10, 20);
        System.out.println("Min: " + minNumber); // Output: 10
        float minFloat = Math.min(15.5f, 12.7f);
        System.out.println("Min of floats: " + minFloat); // Output: 12.7

        // Math.pow() - returns the value of the first argument raised to the power of the second argument
        double powerIntResult = Math.pow(2, 3);
        System.out.println("2^3 (int): " + powerIntResult); // Output: 8.0
        double powerFloatResult = Math.pow(2.5, 2);
        System.out.println("2.5^2 (float): " + powerFloatResult); // Output: 6.25


        // Math.abs() - returns the absolute value of a number
        int absoluteIntValue = Math.abs(-5);
        System.out.println("Absolute value of -5 (int): " + absoluteIntValue); // Output: 5
        float absoluteFloatValue = Math.abs(-8.9f);
        System.out.println("Absolute value of -8.9 (float): " + absoluteFloatValue); // Output: 8.9


        // Math.ceil() - returns the smallest (closest to negative infinity) double value that is greater than or equal to the argument
        double ceilIntResult = Math.ceil(5.3);
        System.out.println("Ceil of 5.3 (int): " + ceilIntResult); // Output: 6.0
        float ceilFloatResult = (float) Math.ceil(5.3f);
        System.out.println("Ceil of 5.3 (float): " + ceilFloatResult); // Output: 6.0

        // Math.floor() - returns the largest (closest to positive infinity) double value that is less than or equal to the argument
        double floorIntResult = Math.floor(5.9);
        System.out.println("Floor of 5.9 (int): " + floorIntResult); // Output: 5.0
        float floorFloatResult = (float) Math.floor(5.9f);
        System.out.println("Floor of 5.9 (float): " + floorFloatResult); // Output: 5.0

        // Math.log10() - returns the base-10 logarithm of a double value
        double log10IntResult = Math.log10(1000);
        System.out.println("Log base 10 of 1000 (int): " + log10IntResult); // Output: 3.0
        double log10FloatResult = Math.log10(1000.0f);
        System.out.println("Log base 10 of 1000 (float): " + log10FloatResult); // Output: 3.0


        // Math.log() - returns the natural logarithm (base e) of a double value
        double logResult = Math.log(Math.E); // Log base e of e is 1
        System.out.println("Log base e of e: " + logResult); // Output: 1.0

        // Math.round() - returns the closest long or int, as a value to the argument
        long roundedValue = Math.round(5.6);
        System.out.println("Round of 5.6: " + roundedValue); // Output: 6

        // Math.PI - a constant representing the mathematical constant pi (π)
        System.out.println("Value of PI: " + Math.PI);

        // Math.E - a constant representing the mathematical constant e
        System.out.println("Value of E: " + Math.E);

        // Math.sqrt() - returns the square root of a double value
        double sqrtResult = Math.sqrt(25);
        System.out.println("Square root of 25: " + sqrtResult); // Output: 5.0
    }

    private static void generateRandom() {
        // Math.random() - returns a double value with a positive sign, greater than or equal to 0.0 and less than 1.0
        double randomValue = Math.random();//  0.0 and less than 1.0.
        System.out.println("Random value: " + randomValue);

        Random s = new Random();
        for (int i = 0; i < 200; i++) {
            int diceThrow = s.nextInt(5) + 1;//Generates int between 0 and 5
            System.out.print(diceThrow + " ");
        }
        System.out.println();
    }


}