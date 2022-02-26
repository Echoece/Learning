package Day3.FunctionalInterface;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        FunctionDemo.increment(2);

        // to run the function, we need to use apply() and pass arguments there
        int increment = incrementByOneFunction.apply(2);
        int multiply = multiplyByTen.apply(increment);

        // chaining functions with andThen() method instead of the two step we did just above
        Function<Integer,Integer> addByOneThenMultiplyByTen = incrementByOneFunction.andThen(multiplyByTen);
        System.out.println(addByOneThenMultiplyByTen.apply(1));

        // Bi-Functions, taking 2 argument and producing one result
        int incrementThenMultiply = incrementByOneAndThenMultiply.apply(1,10);
        System.out.println(incrementThenMultiply);
    }

    // 1. Normal way of using a function
    static int increment(int number){
        return  ++number;
    }
    static int incrementAndThenMultiply(int numberToIncrement, int numberToMultiply){return ( numberToIncrement+1 ) * numberToMultiply;}

    // 2. Functional programming way, this is equivalent increment method.
    static Function<Integer,Integer> incrementByOneFunction = number-> ++number;
    static Function<Integer, Integer> multiplyByTen = number -> number*10;

    // 3. Bi-function example (see the normal way of same function at top)
    static BiFunction<Integer,Integer,Integer> incrementByOneAndThenMultiply =
            ( numberToIncrement, numberToMultiply) -> ( numberToIncrement+1 ) * numberToMultiply;
}
