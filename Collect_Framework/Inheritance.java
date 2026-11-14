public class Inheritance {
    public static void main(String[] args) {
        
        Dog d = new Dog();
        // System.out.println(d.type);
        // System.out.println(d.color);
        // d.run();
        // d.eat();
        // d.bark();

        Animal a = new Dog();
        System.out.println(a.type);
        // System.out.println(a.color); cannot access dog class fields and methods
        a.eat();
        a.run();
        // a.bark(); not methods as well but if there is over-ridden method like eat or run in dog then it will call the 
        // dog method. so it is called runtime polymorphism or dynamic method dispatch


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



