import java.util.ArrayList;
import java.util.List;

public class GenericsWildCards {
    public static void main(String[] args) {
     
        // as generics breaks parent child relation we use wild card to pass any objects
        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog());
        dogs.add(new Dog());
        fun(dogs);
        fun2(dogs);
        List<Animal> animals = new ArrayList<>();  
        fun3(animals);
        
    }

    public static void fun(List<?> animals){
        // we cannot read or write it with this way
        for(Object ob: animals){
            System.out.println(ob.getClass().getName());
        }
    }

    // for reading
    public static void fun2(List<? extends Animal> animals){
        for(Animal a:animals){
            System.out.println(a.getClass().getName());
        }
        // animals.add(new Dog()); not allowed
    }

    // for writing
    public static void fun3(List<? super Animal> animals){
        animals.add(new Dog());
        for(Object ob: animals){
            System.out.println(ob.getClass().getName());
        }
    }
}

class Animal{

    String type = "Memal";

    public void run(){
        System.out.println("I am running.");
    }
    public void eat(){
        System.out.println("I am eating.");
    }
}

class Dog extends Animal{
    String color = "Black";
    
    public void bark(){
        System.out.println("Dog is Barking.");
    }
}

// why generics accept primitive type -> because when eraser comes it replaces the T into object so primitive is not any object type will give error