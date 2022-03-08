package Day5.Annotation;


import java.lang.annotation.Inherited;

public class AnnotationDemo {
    // 1. without this annotation, deprecation warnings will show
    //@SuppressWarnings("deprecation")  // we can also use  @SuppressWarnings("unchecked")

    public static void main(String args[])
    {
        // Creating object of this class inside main()
        Derived obj = new Derived();
        // Calling display() method inside main()
        obj.display();

        obj.deprecatedMethod();
    }
}

class Demo<T>{
    // 4. remove warnings about safe variable arguments
    @SafeVarargs
    private void show(T ...arg){
        for(T element: arg){
            System.out.println(element);
        }
    }
}

class Base {
    public void display() {
        System.out.println("Base display()");
    }
}
// this will create compile time error, as we write override, but we overloaded the function.
class Derived extends Base {
    // 2. override annotation
    //@Override
    public void display(int x) {
        System.out.println("Derived display(int )");
    }

    // 3. deprecated annotation
    @Deprecated
    public void deprecatedMethod(){}
}

// 4. functional interface annotation, in case we add another method we will get compile time error.

@FunctionalInterface
interface myInterface{
    void show();
    //void anotherMethod();
}
