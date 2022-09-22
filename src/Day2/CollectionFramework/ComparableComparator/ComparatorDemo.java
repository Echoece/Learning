package Day2.CollectionFramework.ComparableComparator;

import java.util.*;

public class ComparatorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>( Arrays.asList(187,713,444,251,678,477,59) );

        Collections.sort(list);

        // sorting in ascending order
        System.out.println("\nAscending Order Sort using our own comparator:");
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        list.forEach((element)-> System.out.print(element+" "));

        // sorting in descending order, lambda function example
        System.out.println("\nDescending Order Sort using our own comparator:");
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
        list.forEach((element)-> System.out.print(element+ " "));

        // sorting the list based on last number in ascending order
        System.out.println("\nAscending Order Sort for the last digit using our own comparator:");
        Collections.sort(list, Comparator.comparingInt(o -> (o % 10)));         // using the static utility function from Collection.Comparator
        list.forEach((element)-> System.out.print(element+ " "));


        // String Example
        List<String> list1= new ArrayList<>( Arrays.asList("Nina", "Anika", "Munni","Luna","Abid","Ziad") );
        // sorting in ascending order
        System.out.println("\nAscending Order Sort using our own comparator:");
        list1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        list1.forEach((element)-> System.out.print(element + " "));

        // sorting in descending order, lambda function example
        System.out.println("\nDescending Order Sort using our own comparator:");
        list1.sort((o1, o2) -> o2.compareTo(o1));
        list1.forEach((element)-> System.out.print(element + " "));

        // sorting in ascending order for the 2nd letter
        System.out.println("\nAscending order sort for the 2nd letter using our own comparator");
        list1.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Character.compare(o1.charAt(1),o2.charAt(1)) ;
            }
        });
        list1.forEach((element-> System.out.println(element+" ")));

    }
}
