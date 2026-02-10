package org.example;

import java.util.Scanner;

public class Loops {
    public static void main(String[] args) {

        // for loop
        System.out.println("For Loop");
        int x =5;
        for(int i=1 ; i<=x; i++){
            System.out.println(i + " * " + x + " = " + (i*x));
        }

        //while loop
        System.out.println("While Loop");
        int y=1;
        while(y<11){
            System.out.println(y + " * " + x + " = " + (y*x));
            y++;
        }

        // do while loop
        char c;
        do{
            System.out.println("enter y/e:");
            Scanner sc = new Scanner(System.in);
            c = sc.next().charAt(0);
        }while (c !='e');

        //enhanced for each loop
        System.out.println("Enhanced For Each Loop");
        String[] fruits = {"apple","banana","mango"};
        for(String fruit:fruits){
            System.out.println(fruit);
        }
    }
}
