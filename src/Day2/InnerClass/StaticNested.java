package Day2.InnerClass;

public class StaticNested {
    public static void main(String[] args) {
        // since its a static class , we dont need to instantiate an object of parent class.
        Outer2.Inner staticNested = new Outer2.Inner();
        // Outer.Inner innerClass = new Outer().new Inner(); // for non static-nested inner class
    }
}


class Outer2 {
    private static void outerMethod() {
        System.out.println("inside outerMethod");
    }
    private void test(){}

    static class Inner {
        public static void main(String[] args) {
            System.out.println("inside inner class Method");
            outerMethod();
            //test();       // this would be error as static nested class can only access static members of parent class
        }
    }

}
