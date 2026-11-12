package org.example;

import java.util.HashSet;
import java.util.Set;

class Demo{
    public static void main(String[] args) {

        int arr[]={1,1,2,2,3,3,3,4};
        Set<Integer> set = new HashSet<>();
        for(int n:arr){
            set.add(n);
        }

        System.out.println(set);
    }
}