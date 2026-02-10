package org.example;

public class SwitchCase {
    public static void main(String[] args) {

        int val = 4;
        switch(val){
            case 1:{
                System.out.println("January");
                break;
            }
            case 2:{
                System.out.println("February");
                break;
            }
            case 3:{
                System.out.println("March");
                break;
            }
            default:{
                System.out.println("Invalid month");
            }

        }

    }
}
