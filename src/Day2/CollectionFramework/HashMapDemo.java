package Day2.CollectionFramework;

import java.util.*;

public class HashMapDemo {

    public static void main(String[] args) {
        // the constructor have 3 more overloads,
        // 1) (int initialCapacity,float loadFactor)
        // 2) (int initialCapacity)
        // 3) (Map<? extends K,? extends V> m)

        Map<Integer,String> hashMap= new HashMap<>();
        /*Adding elements to HashMap*/
        hashMap.put(12, "Chaitanya");
        hashMap.put(2, "Rahul");
        hashMap.put(7, "Singh");
        hashMap.put(49, "Ajeet");
        hashMap.put(3, "Anuj");

        // hashmap.putAll(Map<? extends K,? extends V> m);  // Copies all of the mappings from the specified map to this map.
        // hashMap.putIfAbsent(); // study more on this later


        Set set= hashMap.entrySet(); // Returns a Set view of the mappings contained in this map.
        Set keySet = hashMap.keySet(); // Returns a Set view of the keys contained in this map.
        Collection collections = hashMap.values();   // Returns a Collection view of the values contained in this map.

                /*------------------------------------------------------------*/

        // Iterating through the HashMap, (for each method looks easiest)
            // 1. using the iterator
        Iterator iterator=hashMap.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer,String> mapElement = (Map.Entry<Integer, String>) iterator.next();
            System.out.println("ID : "+ mapElement.getKey() + " Name: "+ mapElement.getValue());
        }
            // 2. For-each loop
        for( Map.Entry<Integer,String> element: hashMap.entrySet() ){
            System.out.println("ID : "+ element.getKey() + " Name: "+ element.getValue());
        }
            //3. For-each method
        hashMap.forEach((key,value)->{
            System.out.println("ID : "+ key+ " Name: "+ value);
        });

                /*------------------------------------------------------------*/

        // hashMap.merge(); // study more on this later
        int size = hashMap.size(); // Returns the number of key-value mappings in this map.
        boolean isEmpty = hashMap.isEmpty(); // Returns true if this map contains no key-value mappings.
        String value1= hashMap.get(1); // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        String Value2 =hashMap.getOrDefault(1,"Rahul"); // Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.
        boolean containsValue = hashMap.containsValue("Rahul"); // Returns true if this map maps one or more keys to the specified value.
        boolean containsKey = hashMap.containsKey(2);   // Returns true if this map contains a mapping for the specified key.
        String value3 = hashMap.get(2); // Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
        String value4 = hashMap.getOrDefault(2, null); // Returns the value to which the specified key is mapped, or defaultValue if this map contains no mapping for the key.

        hashMap.replace(2,"Govinda"); // Replaces the entry for the specified key only if it is currently mapped to some value.
        hashMap.replace(2,"Rahul", "Govinda"); // Replaces the entry for the specified key only if currently mapped to the specified value.
        // hashmap.replaceAll(); // study more on this later
        hashMap.clear(); // Removes all of the mappings from this map.

        /*hashMap.compute();                // study more on this later
        hashMap.computeIfAbsent();
        hashMap.computeIfPresent();*/
    }
}
