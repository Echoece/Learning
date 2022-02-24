package Day2.CollectionFramework;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapDemo {
    public static void main(String[] args) {

        // the constructor have 4 more overloads,
        // 1) (int initialCapacity,float loadFactor)
        // 2) (int initialCapacity)
        // 3) (Map<? extends K,? extends V> m)
        // 4) (int initialCapacity, float loadFactor, boolean accessOrder)

        // HashMap Declaration
        LinkedHashMap<Integer, String> lhmap =
                new LinkedHashMap<>();

        //Adding elements to LinkedHashMap
        lhmap.put(22, "Abey");
        lhmap.put(33, "Dawn");
        lhmap.put(1, "Sherry");
        lhmap.put(2, "Karon");
        lhmap.put(100, "Jim");

        // Generating a Set of entries
        Set set = lhmap.entrySet();

        // Displaying elements of LinkedHashMap
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            Map.Entry me = (Map.Entry)iterator.next();
            System.out.print("Key is: "+ me.getKey() +
                    "& Value is: "+me.getValue()+"\n");
        }

        // methods mostly same as Hashmap,
    }
}
