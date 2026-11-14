import java.util.*;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();

        map.put(101,"Zulfiqar");
        map.put(102,"Sajjad");
        map.put(103,"Iqbal");
        map.put(104,"Sajjad");

        System.out.println(map);

        // to verify key present or not
        System.out.println(map.containsKey(103));

        // to get value for any key
        System.out.println(map.get(102));
    }
}
