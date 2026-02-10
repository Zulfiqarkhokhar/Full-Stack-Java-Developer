package org.example;

public class ConditionalStatements {
    public static void main(String[] args) {

        int age = 32;
        if(age>30){
            System.out.println("Welcome to my House");
            if (age==31){
                System.out.println("Your are my bro");
            } else if (age == 32) {
                System.out.println("Your are dam good man");
            } else {
                System.out.println("You are my sister");
            }
        }
        else{
            System.out.println("Please be mature!");
        }
    }
}
