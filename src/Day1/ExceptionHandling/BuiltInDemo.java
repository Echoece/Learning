package Day1.ExceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class BuiltInDemo {
    public static void main(String[] args) {
        BuiltInException.arithmeticException();
        BuiltInException.arrayIndexOutOfBound();
        BuiltInException.fileNotFound();
        BuiltInException.stringIndexOutOfBoundException();
        BuiltInException.numberFormatException();
        BuiltInException.nullPointerException();
        //BuiltInException.test();
    }
}

class BuiltInException {
    // this is giving error, when i try to put parent exception class first before child classes.
    /*
    public static void test(){
        try{
            int a[]=new int[5];
            a[5]=30/0;
        }
        catch(Exception e){System.out.println("common task completed");}
        catch(ArithmeticException e){System.out.println("task1 is completed");}
        catch(ArrayIndexOutOfBoundsException e){System.out.println("task 2 completed");}
        System.out.println("rest of the code...");
    }
    */

    // If we divide any number by zero, there occurs an ArithmeticException.
    public static void arithmeticException() {
        try {
            int a = 30, b = 0;
            int c = a / b;  // cannot divide by zero
            System.out.println("Result = " + c);
        } catch (ArithmeticException e) {
            System.out.println("Can't divide a number by 0");
        }
    }

    // When an array exceeds to it's size, the ArrayIndexOutOfBoundsException occurs. there may be other reasons to occur ArrayIndexOutOfBoundsException.
    public static void arrayIndexOutOfBound() {
        try {
            int a[] = new int[5];
            a[5] = 9; // accessing 6th element (5 index) in an array of size 5
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index is Out Of Bounds");
        }
    }

    public static void fileNotFound() {
        try {
            File file = new File("E://file.txt");   // this file does not exist
            FileReader fr = new FileReader(file);
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");// Note: need to close the resources in finally block in a real application
        }
    }

    // If the formatting of any variable or number is mismatched, it may result into NumberFormatException. Suppose we
    // have a string variable that has characters; converting this variable into digit will cause NumberFormatException.
    public static void numberFormatException() {
        try {
            int num = Integer.parseInt("akki"); // "akki" is not a number
            System.out.println(num);
        } catch (NumberFormatException e) {
            System.out.println("Number format exception");
        }
    }

    public static void stringIndexOutOfBoundException() {
        try {
            String a = "This is like chipping "; // length is 22
            char c = a.charAt(24); // accessing 25th element
            System.out.println(c);
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException");
        }
    }

    // If we have a null value in any variable, performing any operation on the variable throws a NullPointerException.
    public static void nullPointerException(){
        class Foo{
            int age;
        }
        try {
            Foo a=null; //null value
            System.out.println(a.age);
        } catch(NullPointerException e) {
            System.out.println("NullPointerException..");
        }
    }
}
