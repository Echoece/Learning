package Day3.FunctionalInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateDemo {
    public static void main(String[] args) {
        // 1. Simple predicate
        Predicate<Integer> lessThan18 = i -> (i < 18);            // Creating predicate
        System.out.println(lessThan18.test(18));               // Calling the predicate

        // 2: Predicate Chaining
        Predicate<Integer> greaterThanTen = (i) -> i > 10;
        Predicate<Integer> lowerThanTwenty = (i) -> i < 20;
        // and function, it is logical AND equivalent of two predicate
        boolean result = greaterThanTen.and(lowerThanTwenty).test(15);              // 15 is > 10 and < 20. So AND operation is true
        // negate function, it is logical NOT equivalent of  two predicate
        boolean result2 = greaterThanTen.and(lowerThanTwenty).negate().test(15);    // 15 is > 10 and < 20. negate of this result is false.
        boolean result3 = greaterThanTen.or(lowerThanTwenty).test(30);              // 20 is > 10 but not <20, so OR operation is true

        // 3. Predicate as argument of a method
        predicate(10, i->i>5);

        // 4. Predicate in a collection
        List<Integer> arrayList = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
        List<Integer> greaterThan1 = processNumbers(arrayList, i -> i>1);

        // 5. uses of predicate in stream API, inside the filter method in this case
        List<Integer> list = arrayList.stream()
                .filter(i -> i>1).collect(Collectors.toList());

    }

    // dummy method for demo uses of predicate in collections
    private static List<Integer> processNumbers(List<Integer> numbers,
                                                Predicate<Integer> predicate){

        List<Integer> result = new ArrayList<Integer>();

        for (Integer element: numbers)
            if (predicate.test(element))
                result.add(element);

        return result;
    }

    // dummy method for demo uses of predicate in a function
    private static void predicate(int number, Predicate<Integer> predicate)
    {
        if (predicate.test(number)) {
            System.out.println("Number " + number);
        }
    }
}
