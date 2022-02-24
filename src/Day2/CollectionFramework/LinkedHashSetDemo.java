package Day2.CollectionFramework;

import java.util.LinkedHashSet;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // the constructor have 3 more overloads,
        // 1) (int initialCapacity,float loadFactor)
        // 2) (int initialCapacity)
        // 3) (Collection<? extends E> c)

        // LinkedHashSet of String Type
        LinkedHashSet<String> lhset = new LinkedHashSet<>();

        // Adding elements to the LinkedHashSet
        lhset.add("Z");
        lhset.add("PQ");
        lhset.add("N");
        lhset.add("O");
        lhset.add("KK");
        lhset.add("FGH");
        System.out.println(lhset);

        // LinkedHashSet of Integer Type
        LinkedHashSet<Integer> lhset2 = new LinkedHashSet<Integer>();

        // Adding elements
        lhset2.add(99);
        lhset2.add(7);
        lhset2.add(0);
        lhset2.add(67);
        lhset2.add(89);
        lhset2.add(66);
        System.out.println(lhset2);

        // Similar methods like hashset
    }
}
