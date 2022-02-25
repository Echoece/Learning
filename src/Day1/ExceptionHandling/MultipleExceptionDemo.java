package Day1.ExceptionHandling;

/*
    -> At a time only one exception occurs and at a time only one catch block is executed.
    -> All catch blocks must be ordered from most specific to most general, i.e. catch for ArithmeticException must come before catch for Exception.
*/
public class MultipleExceptionDemo {
    public static void main(String[] args) {
        int A[] = {1,2,3,4,5,6};
        int a=10;
        int b=0;
        // in this case there are two exception,
        // 1. array index out of bound
        // 2. Division by zero
        // the first exception it catches it will jump to
        // the catch block, only that exception will be thrown ( in this case array out of bound)
        try{
            int c=a/b;
            System.out.println(A[10]);
            System.out.println(c);
        }catch (ArithmeticException e){
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("after the exception part ");
        }

        // this could be done in nested block as well
        try{
            int c=a/b;
            System.out.println(c);

            try{
                System.out.println(A[10]);
            }catch (ArrayIndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }

        }catch (ArithmeticException e){
            e.printStackTrace();
        }

        finally {
            System.out.println("after the exception part ");
        }
    }
}
