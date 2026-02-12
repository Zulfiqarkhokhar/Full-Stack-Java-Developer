package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaExample {

    public static void main(String[] args) {

        MathsOperations add = (a,b)->a+b;
        MathsOperations subtract = (a,b)->a-b;
        MathsOperations multiply = (a,b)->a*b;
        MathsOperations divide = (a,b)->a/b;
        System.out.println(add.operation(10, 5));

        // Predicate --> Functional interface (Boolean valued function)
        Predicate<Integer> isEven = x->x%2==0;
        System.out.println(isEven.test(10));

        Predicate<String> isStartWithA = x->x.startsWith("A");
        System.out.println(isStartWithA.test("Apple"));
        Predicate<String> isEndWithA = x->x.endsWith("A");
        System.out.println(isEndWithA.test("Apple"));
        Predicate<String> and = isStartWithA.and(isEndWithA);
        System.out.println(and.test("ApplA"));

        // Function --> work for you

        Function<Integer,Integer> doubleIt = x->x*2;
        System.out.println(doubleIt.apply(10));
        Function<Integer,Integer> tripleIt = x->x*3;
        System.out.println(tripleIt.apply(10));
        System.out.println(doubleIt.andThen(tripleIt).apply(10));

        // Consumer
        Consumer<Integer> printIt = x->System.out.println(x);
        printIt.accept(13);

        List<Integer> list = Arrays.asList(1,2,3,4,5);
        Consumer<List<Integer>> printList = x->{
            for (int i : x){
                System.out.println(i);
            }
        };
        printList.accept(list);

        // Supplier

        Supplier<String> greeting = ()->"Hello";
        System.out.println(greeting.get());

        // method reference---> use method without invoking and in place of lambda expression
        List<String> names = Arrays.asList("Zulfiqar","Ali","Mohammad");
        names.forEach(System.out::println);

    }
}
