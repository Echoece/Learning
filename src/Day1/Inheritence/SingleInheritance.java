package Day1.Inheritence;

public class SingleInheritance {

}

class Animal{
    void eat(){System.out.println("eating...");}
}

// Dog is an animal, this is inheritance
class Dog extends Animal{
    void bark(){System.out.println("barking...");}
}
