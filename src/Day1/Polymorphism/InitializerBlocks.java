package Day1.Polymorphism;

public class InitializerBlocks { }

class StaticInitializationBlock {
    static int[] numArray = new int[10];
    // here numArray will be only initialized once. after that rest of the objects that are instantiated from this class will share the array.
    static {
        System.out.println("Running static initialization block.");
        for (int i = 0; i < numArray.length; i++) {
            numArray[i] = (int) (100.0 * Math.random());
        }
    }

    public StaticInitializationBlock() {
        System.out.println("Starting the Constructor");
    }

    void printArray() {
        System.out.println("The initialized values are:");
        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
        System.out.println("\n-------------------------");
    }
}
class InitializationBlock {
    int[] numArray= new int[10];
    // initialization block, difference is we dont use the word static like static initializer block
    {
        System.out.println("Starting the initialization block");
        for(int i=0;i <10 ; i++){
            numArray[i] = (int) ( 100* Math.random() );
        }
    }
    public InitializationBlock() {
        System.out.println("Starting the constructor");
    }
    void printArray() {
        System.out.println("The initialized values are:");
        for (int i = 0; i < numArray.length; i++) {
            System.out.print(numArray[i] + " ");
        }
        System.out.println("\n-------------------------");
    }
}
