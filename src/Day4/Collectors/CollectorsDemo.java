package Day4.Collectors;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");

        // Converting Data as a List
        List<String> result              = givenList.stream().collect(Collectors.toList());
        // Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List:
        List<String> unmodifiableResult  = givenList.stream().collect(Collectors.toUnmodifiableList());

        //  Converting Data as a Set
        Set<String> resultSet            = givenList.stream().collect(Collectors.toSet());
        Set<String> resultSet1           = listWithDuplicates.stream().collect(Collectors.toSet());
        // Since Java 10, we can easily create an unmodifiable Set using the toUnmodifiableSet() collector:
        Set<String> unmodifiableSet      = givenList.stream().collect(Collectors.toUnmodifiableSet());

        // converting data to map: To do this, we need to provide two functions:
                //keyMapper   :  to extract a Map key from a Stream element
                //valueMapper :  to extract a value associated with a given key.

        // this will create map with key as lower case elements from stream, and value as the length of stream.
        Map<String, Integer> resultMap = givenList.stream().collect(Collectors.toMap(key-> key.toLowerCase(), value-> value.length()));
        Map<String, Integer> resultMap1 = givenList.stream().collect(Collectors.toMap(Function.identity(), value-> value.hashCode()));

        // Let's create a Stream instance representing a sequence of elements, and then collect them into a LinkedList instance:
        List<String> resultList = givenList.stream().collect(Collectors.toCollection(LinkedList::new));

        // sum method
        List<Product> productList = Product.dummyData();

        Double sumPrices = productList.stream().collect(Collectors.summingDouble(x->x.price));  // Sum of prices: 201000.0
        Integer sumId = productList.stream().collect(Collectors.summingInt(x->x.id));           // Sum of id's: 15

        Double average = productList.stream().collect(Collectors.averagingDouble(p->p.price));  // Average price is: 40200.0
        Long noOfElements = productList.stream().collect(Collectors.counting());                // Total elements : 5

        // CollectingAndThen is a special collector that allows us to perform another action on a result straight after collecting ends.

    }

    static class Product{
        int id;
        String name;
        float price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        static List<Product> dummyData(){
            return Arrays.asList(
                    new Product(1,"HP Laptop",25000f),
                    new Product(2,"Dell Laptop",30000f),
                    new Product(3,"Lenevo Laptop",28000f),
                    new Product(4,"Sony Laptop",28000f),
                    new Product(5,"Apple Laptop",90000f)
            );

        }
    }
}
