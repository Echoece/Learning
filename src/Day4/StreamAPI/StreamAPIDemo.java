package Day4.StreamAPI;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

public class StreamAPIDemo {
    public static void main(String[] args) throws IOException {
            // 1. stream works with array
            // 2. Integer,Long and Double primitive value streams has separate interface. They contain the sum() method.
            // 3. String stream is possible with workaround, converting string to IntStream
        String [] arr = {"Hello", "World", "program"};
        Stream<String> streamOfArray = Stream.of(arr);

        //List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 5, 10, 7, 25, 44, 102,500));
        List<Integer> list = List.of(1, 2, 5, 10, 7, 25, 44, 102,500);

        //----------------------------------------------------------------------
        // 1. Creating a stream
        Stream<String> streamEmpty = Stream.empty();    // empty String
            // a. using stream of
        Stream<String> streamOfArray1 = Stream.of("a", "b", "c");

            // b. From a collection
        Stream<Integer> stream = list.stream();

            // c. using streamBuilder
            // Note : the desired type should be additionally specified in the right part of the statement, otherwise the
            //        build() method will create an instance of the Stream<Object>:
        Stream<String> streamBuilder =
                Stream.<String>builder().add("a").add("b").add("c").build();

            // d. using generate(Supplier<T> s)
            // Note: The generate() method accepts a Supplier<T> for element generation. As the resulting stream is
            //       infinite, the developer should specify the desired size, or the generate() method will work until it reaches the memory limit
        Stream<String> streamGenerated =
                Stream.generate(() -> "element").limit(10); // this will create a sequence of ten strings with the value “element.”

            // e. using iterate(T seed, UnaryOperator<T> f)
            // Note: 1. this also is infinite, so like generate() we have to specify the desired size.
            //       2. The first element of the resulting stream is the first parameter of the iterate() method. When
            //          creating every following element, the specified function is applied to the previous element
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);  // sequence will be: 40, 42, 44, ....

        // we can create stream of primitive data type int, long and double. Using the new interfaces alleviates unnecessary
        // auto-boxing, which allows for increased productivity.
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        // String as a source for creating a stream is possible with the help of the chars() method of the String class.
        // Since there is no interface for CharStream in JDK, we use the IntStream to represent a stream of chars instead.
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");         // It breaks a String into sub-strings according to specified RegEx

        // stream of file :  Java NIO class Files allows us to generate a Stream<String> of a text file through the lines() method.
        //                   Every line of the text becomes an element of the stream
        Path path = Paths.get("D:\\demo.txt");
        Stream<String> streamOfStrings = Files.lines(path);
        Stream<String> streamWithCharset =
                Files.lines(path, Charset.forName("UTF-8"));

        // We can instantiate a stream, and have an accessible reference to it, as long as only intermediate operations
        // are called. Executing a terminal operation makes a stream inaccessible.
        Stream<String> stream11 =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"));
        Optional<String> anyElement = stream11.findAny();           // findAny() is a terminal operation.
        //Optional<String> firstElement = stream11.findFirst();       // this line will give error as we try to reuse after terminal operation

        //----------------------------------------------------------------------

        // 2. Stream Pipeline: If we need more than one modification, we can chain intermediate operations. Intermediate operations which reduce
        // the size of the stream should be placed before operations which are applying to each element. So we need to keep methods such as
        // skip(), filter(), and distinct() at the top of our stream pipeline.
        List<String> list1 = Arrays.asList("abc1", "abc2", "abc3");
        long size = list1.stream()
                .skip(1).map(element -> element.substring(0, 3)).sorted()
                .count();

        // 3. Lazy invocation : Intermediate operations are lazy. This means that they will be invoked only if it is
        //                      necessary for the terminal operation execution. In other words, intermediate operations won't
        //                      be performed unless we use terminal condition.
        // https://www.baeldung.com/java-8-streams for example

        // 4. Reduce() : similar to javascript reduce() function
        // Note: here we are working with a stream of (1,2,3). IntStream.range(), Stream.of(), Arrays.asList() etc. are examples.

            // with just accumulator parameter, result = 1+2+3
        OptionalInt reduced = IntStream.range(1, 4).reduce((a, b) -> a + b);

            // with identity and accumulator parameter, result = 10 + 1 + 2 +3
        int reducedParams = Stream.of(1, 2, 3).reduce(10, (a, b) -> a + b, (a, b) -> a + b);

            // with identity, accumulator and combiner.
            // step 1 : the accumulator ran three times by adding every element of the stream to identity = (10 + 1 = 11; 10 + 2 = 12; 10 + 3 = 13)
            // step 2 : Now combiner can merge these three results. It needs two iterations for that =  (12 + 13 = 25; 25 + 11)
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> a + b, (a, b) -> a + b);

        // 5. collect() examples:
        List<Product> productList = Product.dummyProducts();        // creating dummy data

            // Converting a stream to the Collection (Collection, List or Set):
        List<String> collectorCollection = productList.stream().map(Product::getName).collect(Collectors.toList());

            // Reducing to String:
        String listToString = productList.stream().map(Product::getName).collect(Collectors.joining(", ", "[", "]"));

            // Processing the average value of all numeric elements of the stream:
        double averagePrice = productList.stream().collect(Collectors.averagingInt(Product::getPrice));

            // Processing the sum of all numeric elements of the stream:
        int summingPrice = productList.stream().collect(Collectors.summingInt(Product::getPrice));

            // Collecting statistical information about stream’s elements:
        IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));
        System.out.println(statistics);     // output : {count=5, sum=86, min=13, average=17.200000, max=23}

            // Grouping of stream’s elements according to the specified function, here , the stream was reduced to the Map,
            // which groups all products by their price.
        Map<Integer, List<Product>> collectorMapOfLists = productList.stream().collect(Collectors.groupingBy(Product::getPrice));

            // Dividing stream’s elements into groups according to some predicate:
        Map<Boolean, List<Product>> mapPartioned = productList.stream().collect(Collectors.partitioningBy(element -> element.getPrice() > 15));

            // Pushing the collector to perform additional transformation, In this particular case, the collector has converted a stream
            // to a Set, and then created the unchangeable Set out of it.
        Set<Product> unmodifiableSet = productList.stream()
                .collect(Collectors.collectingAndThen(
                            Collectors.toSet(),
                            Collections::unmodifiableSet
                ));

            // Custom collector: If for some reason a custom collector should be created, the easiest and least verbose way of doing
            //                   so is to use the method of() of the type Collector.

        Collector<Product, ?, LinkedList<Product>> toLinkedList =
                Collector.of(LinkedList::new, LinkedList::add,
                        (first, second) -> {
                            first.addAll(second);
                            return first;
                        });
        LinkedList<Product> linkedListOfPersons =
                productList.stream().collect(toLinkedList);

        // 6. Parallel streams:
            // When the source of a stream is a Collection or an array, it can be achieved with the help of the parallelStream() method
        Stream<Product> streamOfCollection = productList.parallelStream();
        boolean isParallel = streamOfCollection.isParallel();
        boolean bigPrice = streamOfCollection
                .map(product -> product.getPrice() * 12)
                .anyMatch(price -> price > 200);

        // If the source of a stream is something other than a Collection or an array, the parallel() method should be used:
        IntStream intStreamParallel = IntStream.range(1, 150).parallel();
        boolean isParallel1 = intStreamParallel.isParallel();

        // The stream in parallel mode can be converted back to the sequential mode by using the sequential() method:
        IntStream intStreamSequential = intStreamParallel.sequential();
        boolean isParallel2 = intStreamSequential.isParallel();
    }

    static class Product{
        private int price;
        private String name;

        Product(int price, String name){
            this.price = price;
            this.name = name;
        }

        public int getPrice() {
            return price;
        }

        public String getName() {
            return name;
        }

        public static List<Product> dummyProducts(){
            return Arrays.asList(
                    new Product(23, "potatoes"),
                    new Product(14, "orange"),
                    new Product(13, "lemon"),
                    new Product(23, "bread"),
                    new Product(13, "sugar")
            ) ;
        }
    }
}
