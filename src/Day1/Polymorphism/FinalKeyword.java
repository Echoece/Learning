package Day1.Polymorphism;

public class FinalKeyword {
}
// 1. final variable example:
class Bike{
    final int speedlimit= 90; //final variable
    void run(){
        // speedlimit=400;  // here will be compile time error, as we try to change the value of a final variable.
    }
    final void runBike(){System.out.println("running");}
}

/*---------------------------------------*/

// 2. final methods example:
class Honda extends Bike{
    // this will be compile time error, as we are trying to override a final method.
    /*void runBike(){
        System.out.println("running safely with 100kmph");
    }*/

    // this class inherit the parent runBike method even though its final.
}

/*---------------------------------------*/

// 3. final class example:
final class Bus{}

// This will be compile time error as we trying to extend a final class
// class Honda1 extends Bus{ }

/*---------------------------------------*/

// 4. blank final variable example:
class Bike10 {
    final int speedlimit;   // blank final variable, can only be initialized in side constructor
    Bike10() {
        speedlimit = 70;
    }
}

/*---------------------------------------*/

// 5. static blank final variable example:
class A{
    static final int data;  // static blank final variable, can only be initialized inside static block
    static{ data=50;}
}

/*---------------------------------------*/

// 6. final parameter example:
class Bike11{
    void cube(final int n){
        //n=n+2;    // can't be changed as n is final, will be compile time error
    }
}

