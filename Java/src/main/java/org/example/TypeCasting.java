package org.example;

public class TypeCasting {
    public static void main(String[] args) {

        // Implicit typeCasting
        // smaller to bigger -> widening or upCasting
        int a = 10;
        long b = a;

        float f = a;

        // Explicit typeCasting
        // bigger to smaller -> narrowing or downCasting
        long c = 100L;
        int d = (int) c;

        // Double to int
        double price = 19.99;
        int discountedPrice = (int) price;

        // Float to int
        float temperature = 98.6f;
        int roundedTemp = (int) temperature;

        // String to int (using Integer wrapper class)
        String numberString = "42";
        int convertedNumber = Integer.parseInt(numberString);

        // String to double
        String doubleString = "3.14";
        double pi = Double.parseDouble(doubleString);

        // Char to int (ASCII value)
        char letter = 'A';
        int asciiValue = (int) letter;

        // Int to char
        int charCode = 65;
        char convertedChar = (char) charCode;

        // Boolean - cannot be directly cast to other types
        boolean flag = true;
        // int flagValue = (int) flag;  // This will cause a compilation error

    }
}