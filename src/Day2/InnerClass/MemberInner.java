package Day2.InnerClass;

public class MemberInner {
    public static void main(String[] args) {
        Outer1.Inner innerClass = new Outer1().new Inner();
        innerClass.show();
    }
}


class Outer1 {
    private int x=5;
    private void mm(){
        System.out.println("private method");
    }

    class Inner{
        //public static test();         // this would be compile time error, as we cant use static inside nested inner class
        public void show(){
            System.out.println("Nested Inner class");
            System.out.println(x);
            mm();
        }
    }
    //------------------------------
}
