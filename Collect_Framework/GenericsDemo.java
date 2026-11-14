class GenericsDemo{
    public static void main(String[] args) {
        
        Box<Integer> b1 = new Box<>(10);
        Box<String> b2 = new Box<>("Hello");

        System.out.println(b1.getValue());
        System.out.println(b2.getValue());

        Demo<Double> d1 = new Demo<>(1.22);
        // Demo<String> d2 = new Demo<>("Hello"); this is error to use String on bounded generic class

    }
}

// generics

class Box<T>{
    T value;
    Box(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}

// bounds on generic to be specific like Number

class Demo<T extends Number>{
    T value;
    Demo(T value){
        this.value = value;
    }

    public T getValue(){
        return value;
    }
    public void setValue(T value){
        this.value = value;
    }
}