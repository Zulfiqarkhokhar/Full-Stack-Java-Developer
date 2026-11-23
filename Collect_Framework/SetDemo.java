import java.util.*;

public class SetDemo {
    public static void main(String[] args) {
        
        Set<String> set = new HashSet<>();

        set.add("Zulfiqar");
        set.add("Sajjad");
        set.add("Iqbal");

        System.out.println(set);

        // contains method give result in constant time because of the uniqueness and storing method

        System.out.println(set.contains("Sajjad")); // case sensitive

        // special note -> set internally use the map because both work on hashing algorithm
        // but in set the key is actual data we add and value are just Object that take space only

        // LinkedHashSet -> it maintain the insertion order same goes for LinkedHashMap
        // TreeMap and TreeSet -> they use BST -> Self Balancing (reb-black tree)


        // sorted set -> O(log n)
        // TreeSet Implement sortedset and navigableSet
        TreeSet<Integer> set1 = new TreeSet<>();

        set1.add(80);
        set1.add(23);
        set1.add(10);
        set1.add(90);
        set1.add(50);

        // SortedSet methods

        System.out.println(set1.first()); // larget value
        System.out.println(set1.last());// smallest

        System.out.println(set1.tailSet(23)); // inclusive and largest value set than given value
        System.out.println(set1.headSet(90));// exclusive and smallest value set than given

        System.out.println(set1.subSet(23, 90));


        // NavigableSet methods




    }
}
