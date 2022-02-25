package Day1.ExceptionHandling;

public class MethodOverridingExceptionDemo {
}

// case 1: superclass doesnt declare an exception, in this case subclass overridden method can't declare any checked
//         exception, but can declare unchecked exception.

class Parent{
    void msg() { System.out.println("parent method"); }
}

class TestExceptionChild extends Parent{
    /*
    void msg() throws IOException {             // overriding the method in child class with checked exception gives compile time error
        System.out.println("TestExceptionChild");
    }
    */
    void msg()throws ArithmeticException {      // But we can declare unchecked Exceptions here
        System.out.println("child method");
    }
}

// Case 2: superclass does declare an exception, in this case subclass overridden method can declare
//               case  1) same exception,
//               case  2) subclass exception or
//               case  3) no exception
//               case  4) cannot declare parent exception

class Parent1{
    void msg()throws RuntimeException { System.out.println("parent method"); }
}
class TestExceptionChild2 extends Parent1{
    void msg()throws RuntimeException {         // case 1: same exception
        System.out.println("child method");
    }

    /*void msg()throws ArithmeticException {    // case 2: subclass exception
        System.out.println("child method");
    }*/

    /*void msg()  {                             // case 1: no exception
        System.out.println("child method");
    }*/

    /*void msg()throws Exception {              // case : 4 declaring parent exception will cause compile time error.
        System.out.println("child method");
    }*/
}

