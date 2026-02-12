package org.example;

public class LambdaExample {

    public static void main(String[] args) {

        MathsOperations add = (a,b)->a+b;
        MathsOperations subtract = (a,b)->a-b;
        MathsOperations multiply = (a,b)->a*b;
        MathsOperations divide = (a,b)->a/b;
        System.out.println(add.operation(10, 5));

    }
}
