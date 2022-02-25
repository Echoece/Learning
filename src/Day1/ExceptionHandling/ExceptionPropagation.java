package Day1.ExceptionHandling;

public class ExceptionPropagation {
    public static void main(String[] args) {
        method1();
    }

    static void method1() {
        int a = method2(10, 0);
        System.out.println(a);
    }

    static int method2(int a, int b){
        if(b==0)
            throw new ArithmeticException();
        // here method will return the exception if b is zero, it wont execute the rest.
        // So this is kind of in a way working as alternate to return. In case we dont want this
        // behaviour, we will have to use finally block and put rest of our code inside there

        int c = a / b;
        System.out.println("something...");
        return c;
    }
}

/*
    -> Here the method2 we get an exception (arithmetic exception) in first line as its division by zero. So clearly the
    next line (return c) wont be executed.
    -> The exception will be passed on to the method that called method 2 ( method1() in this case ).
    -> it is not handled in method1() as well, so it will pass the exception to the main method.
    -> since the exception is not handled in the main method as well, it will pass the exception to the jvm and program
    will crash

    One solution could be of this problem, we could catch the error in any places that it propagate
    through, or originated

            static void method1(){
                try{
                    int a= method2(10,0);
                    System.out.println(a);
                }catch (ArithmeticException e){
                    System.out.println(e.getMessage());
                }
            }
*/
