package Day2.InnerClass;

public class LocalInner {
    public static void main(String[] args) {
        Outer outer= new Outer();
        outer.outerMethod();
    }
}

class Outer {
    int x= 5;
    int y = 10;

    void outerMethod() {
        System.out.println("inside outerMethod");
        int z = 20;
        class Inner {
            int x=6;
            void innerMethod() {
                System.out.println("inside innerMethod: " + x);             // 1. the inner class variable x
                System.out.println("inside innerMethod: " + y);             // 2. outer class variable y
                System.out.println("inside innerMethod: " + z);             // 3. inside method variable y
            }
        }

        Inner y = new Inner();
        y.innerMethod();
        System.out.println(x);
    }
}

