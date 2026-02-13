package org.example.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ArrayListDemo {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        list.add(1);//index 0
        list.add(5);
        list.add(3);
        System.out.println(list.get(2));

        for(int i : list){
            System.out.println(i);
        }

        System.out.println(list.size());//3

        System.out.println(list.contains(5));
        System.out.println(list.contains(10));

        list.remove(1);
        for(int i : list){
            System.out.println(i);
        }

        // add in between

        list.add(1, 10);
        for(int i : list){
            System.out.println(i);
        }

        // replace value
        list.set(1, 20);
        for(int i : list){
            System.out.println(i);
        }

        List<String> list1 = Arrays.asList("Apple","Banana","Orange");
        System.out.println(list1.toString());
//        list1.add("Mango");// exception

        Collections.sort(list);
        System.out.println(list);

    }
}
