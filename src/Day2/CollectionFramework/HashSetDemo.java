package Day2.CollectionFramework;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetDemo {
    public static void main(String[] args) {
        // the constructor have 3 more overloads,
        // 1) (int initialCapacity,float loadFactor)
        // 2) (int initialCapacity)
        // 3) (Collection<? extends E> c)
        Set<String> hashSet= new HashSet<>();
        hashSet.addAll(Arrays.asList("Dhaka", "Khulna","Chittagong","dhaka"));

        // Adds the specified element to this set if it is not already present.
        hashSet.add("Monipur");
        // Removes all of the elements from this set.
        hashSet.remove("Monipure");
        // removes all element of the array
        hashSet.clear();
        // Returns true if this set contains the specified element.
        boolean isContain = hashSet.contains("Monipur");
        // Returns an iterator over the elements in this set. this have bunch of methods as well.
        Iterator<String> iterator = hashSet.iterator();

        // Returns the number of elements in this set (its cardinality).
        int size = hashSet.size();

        // Methods inherited from interface java.util.Set : addAll, containsAll, equals, hashCode, removeAll, retainAll, toArray, toArray

    }
}
