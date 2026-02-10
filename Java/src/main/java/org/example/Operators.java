package org.example;

public class Operators {
    public static void main(String[] args) {

        /*
        Arithmetic operator
        + - * / ++ --

        Relational operator
        == != > < >= <=

        Logical operator
        && || !

        Assignment operator
        = += -= *= /= %=

        Conditional operator
        ? :

         */

        int a=5,b=10,c=15,d=20;

        // Arithmetic operators
        System.out.println("a + b = " + (a+b));
        System.out.println("c % d = " + (c%d));
        System.out.println("a++ = " + (a++));
        System.out.println("a - b = " + (a-b));
        System.out.println("a-- = " + (a--));
        System.out.println("c * d = " + (c*d));
        System.out.println("c / d = " + (c/d));

        // Relational operators
        System.out.println("a == b = " + (a == b));
        System.out.println("a != b = " + (a != b));
        System.out.println("a > b = " + (a > b));
        System.out.println("a < b = " + (a < b));
        System.out.println("a >= b = " + (a >= b));
        System.out.println("a <= b = " + (a <= b));

        // Logical operators
        System.out.println("(a < b) && (c < d) = " + ((a < b) && (c < d)));
        System.out.println("(a > b) || (c < d) = " + ((a > b) || (c < d)));
        System.out.println("!(a == b) = " + (!(a == b)));

        // Assignment operators
        int x = 10;
        System.out.println("x = " + (x));
        x += 5;
        System.out.println("x += 5; x = " + x);
        x -= 3;
        System.out.println("x -= 3; x = " + x);
        x *= 2;
        System.out.println("x *= 2; x = " + x);
        x /= 4;
        System.out.println("x /= 4; x = " + x);

        // Conditional operator (ternary)
        int max = (a > b) ? a : b;
        System.out.println("max of a and b = " + max);
    }
}