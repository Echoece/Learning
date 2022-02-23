package Day1.Polymorphism;

public class RuntimePolymorphism {
    public static void main(String[] args) {
        Bank b;
        // here, which version of getRateOfInterest() will be called is decided on runtime rather than compile time. This is
        // why it's RuntimePolymorphism
        b= new BracBank();   //  this is called upcasting
        System.out.println("Rate f interest = "+ b.getRateOfInterest());

        b = new JanataBank();
        System.out.println("Rate f interest = "+ b.getRateOfInterest());

        b = new SonaliBank();
        System.out.println("Rate f interest = "+ b.getRateOfInterest());
    }
}

class Bank{
    float getRateOfInterest(){return 0;}
}
class BracBank extends Bank{
    float getRateOfInterest(){return 8.4f;}
}
class JanataBank extends Bank{
    float getRateOfInterest(){return 7.3f;}
}
class SonaliBank extends Bank{
    float getRateOfInterest(){return 9.7f;}
}

/*------------------------------------------------------------*/

// we cant achieve runtime polymorphism for data member variables. Consider the following example:
class Bike3{
    int speedlimit=90;
}
class Honda3 extends Bike{
    int speedlimit=150;

    public static void main(String args[]){
        Bike obj=new Honda3();
        System.out.println(obj.speedlimit); // here output is 90
    }
}

/*------------------------------------------------------------*/
// Here is an example of multilevel polymorphism
class Animal{
    void eat(){System.out.println("eating");}
}
class Dog extends Animal{
    void eat(){System.out.println("eating fruits");}
}
class BabyDog extends Dog{
    // Note: in case we comment out the eat() of BabyDog class, it wont have any override of the parent class. In this case
    // the Dog class eat() Method will be executed.
    void eat(){System.out.println("drinking milk");}
    public static void main(String args[]){
        Animal a1,a2,a3;
        a1=new Animal();
        a2=new Dog();
        a3=new BabyDog();
        a1.eat();
        a2.eat();
        a3.eat();
    }
}
