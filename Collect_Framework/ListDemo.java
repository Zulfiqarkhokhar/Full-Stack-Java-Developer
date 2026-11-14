import java.util.*;

public class ListDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        // fetch value based on index
        System.out.println(list.get(2));

        // to set different value on perticular index
        list.set(1,5);
        System.out.println(list);

        // to add multiple value on index
        list.addAll(1,List.of(7,8,9));
        System.out.println(list);

        // to remove element with index
        list.remove(0);

        // to get index
        System.out.println(list.indexOf(7));
        System.out.println(list.lastIndexOf(5));

        // we have listIterator

        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
