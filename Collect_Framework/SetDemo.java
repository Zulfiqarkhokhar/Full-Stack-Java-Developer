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
    }
}
