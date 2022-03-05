package Day4.Collectors;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {
        List<String> givenList = Arrays.asList("a", "bb", "ccc", "dd");
        List<String> listWithDuplicates = Arrays.asList("a", "bb", "c", "d", "bb");

        // The toList collector can be used for collecting all Stream elements into a List instance.
        List<String> result              = givenList.stream().collect(Collectors.toList());
        // Java 10 introduced a convenient way to accumulate the Stream elements into an unmodifiable List:
        List<String> unmodifiableResult  = givenList.stream().collect(Collectors.toUnmodifiableList());

        //  Converting Data as a Set
        Set<String> resultSet            = givenList.stream().collect(Collectors.toSet());
        Set<String> resultSet1           = listWithDuplicates.stream().collect(Collectors.toSet());
        // Since Java 10, we can easily create an unmodifiable Set using the toUnmodifiableSet() collector:
        Set<String> unmodifiableSet      = givenList.stream().collect(Collectors.toUnmodifiableSet());

        // Let's create a Stream instance representing a sequence of elements, and then collect them into a LinkedList instance:
        List<String> resultList = givenList.stream().collect(Collectors.toCollection(LinkedList::new));

        // sum method
        List<Product> productList = Product.dummyData();

        Double sumPrices = productList.stream().collect(Collectors.summingDouble(x->x.price));  // Sum of prices: 201000.0
        Integer sumId = productList.stream().collect(Collectors.summingInt(x->x.id));           // Sum of id's: 15

        Double average = productList.stream().collect(Collectors.averagingDouble(p->p.price));  // Average price is: 40200.0
        Long noOfElements = productList.stream().collect(Collectors.counting());                // Total elements : 5




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
