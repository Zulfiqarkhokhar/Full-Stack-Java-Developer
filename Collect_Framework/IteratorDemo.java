import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo{
    public static void main(String[] args) {
        
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        // Iterator is interface implemented by Iterable
        // it gives us hasNext and next methods for iterating elements

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        // enhanced for loop worked same
        // it is cotted upon iterator
        for(int l:list){
            System.out.println(l);
        }
    }
    
}
