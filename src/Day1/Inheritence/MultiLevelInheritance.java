package Day1.Inheritence;

public class MultiLevelInheritance {
}

// Here BabyTiger is a Tiger and Tiger is a Pet. this is example of multilevel Inheritance
class Pet{
    void eat(){System.out.println("eating...");}
}
class Tiger extends Pet{
    void bark(){System.out.println("barking...");}
}
class BabyTiger extends Tiger{
    void weep(){System.out.println("weeping...");}
}
