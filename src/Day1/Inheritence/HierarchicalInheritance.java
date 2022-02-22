package Day1.Inheritence;

public class HierarchicalInheritance {
}


// Here both Dog and Cat extends Animal class. Both Dog and Cat is an Animal. This is example of hierarchical inheritance
class Animal1{
    void eat(){System.out.println("eating...");}
}
class Dog1 extends Animal1{
    void bark(){System.out.println("barking...");}
}
class Cat1 extends Animal1{
    void meow(){System.out.println("meowing...");}
}
