package Day1.Abstraction;

public class InterfaceDemo {
    public static void main(String[] args) {
        DemoInterface.show1();  // calling static method of the interface
        DemoInterface.show2();  // calling static method of the interface

        DemoInterface demoInterface = new DemoInterface() {};   // anonymous class to avoid creating implementation classes
        demoInterface.show();   // calling default method of the interface
    }
}

interface DemoInterface {

    // Default method
    default void show()
    {
        System.out.println("Default TestInterface2");
    }

    // static method
    static void show1()
    {
        System.out.println("Static Method Executed");
    }
    static void show2()
    {
        System.out.println("Static Method Executed");
    }
}

// another interface example, a telephone class, mobile phone class etc can implement it.
interface iTelephone{
    public abstract void powerOn();
    public abstract void dial(int phoneNumber);
    public abstract void answer();
    public abstract boolean callPhone(int phoneNumber);
    public abstract boolean isRinging();
}
