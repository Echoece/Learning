package Day1.ExceptionHandling;

public class ThrowVsThrows {
    public static void main(String[] args) {
        try {
            fun();
        }catch (NullPointerException e){
            System.out.println("caught inside the main");
        }
        /*
        Output ::
                caught inside the fun() method
                caught inside the main
        */
    }

    // throw example
    static void fun(){
        try{
            // throwing an exception here
            throw new NullPointerException();
        }catch (NullPointerException e){
            System.out.println("caught inside the fun() method");
            throw e;// throwing the exception again
        }
    }

    // throws example
    static void fun2() throws ArithmeticException{
        try{
            int x = 1/0;
        }catch (ArithmeticException e){
            e.printStackTrace();;
        }
        System.out.println("next statement... , this will print if since we are catching the exception");
        //-----------------------------------------------------
        // but if we dont catch the exception
        int y= 1/0;
        // this line will not print
        System.out.println("Last statement... , this will not print cause we arnt catching the exception. only declaring it");
    }
}
