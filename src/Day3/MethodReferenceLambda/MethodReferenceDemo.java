package Day3.MethodReferenceLambda;

import java.util.function.BiFunction;

public class MethodReferenceDemo {
    // constructor
    public MethodReferenceDemo(String str) {
        System.out.println(str.toUpperCase());
    }

    public static void main(String[] args) {
        // 1. here the we are passing a reference to the println function, so the
        //    display method will act like println method.
        MyLambda myLambda= System.out::println;
        myLambda.display("Hi");

        // 2. we can reference static methods of class
        myLambda = MethodReferenceDemo::reverse;
        myLambda.display("Hello");

        // 3. for non static methods, we need instance of that object
        myLambda = new MethodReferenceDemo("hi")::nonStaticMethod;
        myLambda.display("Hello");

        // 4. But if we are using in the same class, we can get away with using this keyword from
        //    a non static method
        //    example: myLambda= this::nonStaticMethod;

        // 5. we can reference object constructor too
        myLambda= MethodReferenceDemo::new;
        myLambda.display("Hello");

        // 6. we can also use predefined functional interface to refer methods
        BiFunction<Integer, Integer, Integer> adder = Arithmetic::add;
        BiFunction<Integer, Float, Float>adder2 = Arithmetic::add;
        BiFunction<Float, Float, Float>adder3 = Arithmetic::add;
        int result = adder.apply(10, 20);
        float result2 = adder2.apply(10, 20.0f);
        float result3 = adder3.apply(10.0f, 20.0f);
        System.out.println(result + " " + result2 + " "+ result3);

        // 7. in case of multiple parameters, its a bit complicated. this part yet to be studied fully by me.
        MyLambda2 myLambda2 = String::compareTo;
        System.out.println(myLambda2.display("hello","hello"));
    }

    // a non static method
    void nonStaticMethod(String str){
        System.out.println("from non static method : "+str);
    }
    // a static method
    static void reverse(String str){
        StringBuffer sb= new StringBuffer(str);
        sb.reverse();
        System.out.println(sb);
    }
}

@FunctionalInterface
interface MyLambda {
    void display(String str);
}

@FunctionalInterface
interface MyLambda2{
    int display(String str1, String str2);
}

class Arithmetic{
    public static int add(int a, int b){
        return a+b;
    }
    public static float add(int a, float b){
        return a+b;
    }
    public static float add(float a, float b){
        return a+b;
    }
}
