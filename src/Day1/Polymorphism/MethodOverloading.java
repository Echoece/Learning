package Day1.Polymorphism;

public class MethodOverloading {

}


/*------------------------------------------------------------*/

// 1. method overloading with number of parameters
class Adder{
    static int add(int a,int b){ return a+b; }
    static int add(int a,int b,int c) { return a+b+c; }
}

// 2. method overloading with changing data type of the arguments
class Adder2{
    static int add(int a, int b){return a+b;}
    static double add(double a, double b){return a+b;}
}

// this will be compile time error, as it will have ambiguity (A grammar is ambiguous if at least one sentence in
// its language has more than one valid parse tree). So, we can see return type difference alone is not enough for method overloading.

class Adder3{
    //static int add(int a,int b){return a+b;}
    //static double add(int a,int b){return a+b;}
}

/*------------------------------------------------------------*/
// 1. type promotion
// here if we call OverloadingCalculation1.sum(10, 10), even though we pass two int in the method arguments, the 2nd int literal
// will be promoted to long type implicitly.
class OverloadingCalculation1{
    static void sum(int a,long b){System.out.println(a+b);}
    static void sum(int a,int b,int c){System.out.println(a+b+c);}
}
// 2. Type promotion in case of ambiguity
// here will be ambiguity as compiler won't know which method to run if we call for example sum(20,20).
class OverloadingCalculation3{
    static void sum(int a,long b){System.out.println("a method invoked");}
    static void sum(long a,int b){System.out.println("b method invoked");}
}

/*------------------------------------------------------------*/
