package Day3.MethodReferenceLambda;

public class LambdaDemo {
    public static void main(String[] args) {
        Demo demo= new Demo();
        demo.method1();
    }
}

@FunctionalInterface
interface LambdaInterfaceDemo{
    public void display(int a,int b);
}

class Demo{
    int d=10;
    public void method1(){
        final int c=5;
        LambdaInterfaceDemo lambdaInterfaceDemo = (a,b)->{
            System.out.println(a+b);

            // -> lambda can have local variable
            int count=5;
            System.out.println(count);

            // -> lambda can access local variable,but it needs to be final or effectively final (value isn't modified)
            System.out.println(c);

            // -> lambda can access instance variable as well, and can also modify them. They dont need to final.
            System.out.println(d);
        };
        lambdaInterfaceDemo.display(4,6);
    }
}

