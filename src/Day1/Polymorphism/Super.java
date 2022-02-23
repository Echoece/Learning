package Day1.Polymorphism;

public class Super {
}

class Person{
    int id;
    String name;
    int age;
    Person(int id,String name){
        this.id=id;
        this.name=name;
        this.age = 20;
    }

    void display(){
        System.out.println("parent display method");
    }
}

class Employee extends Person{
    float salary;
    Employee(int id, String name, float salary){
        super(id,name);//reusing parent constructor
        this.salary=salary;
    }
    void display(){
        System.out.println(id+" "+name+" "+salary);
        System.out.println(super.age );  // accessing parent member variable using super
        super.display(); // accessing parent methods.
    }
}
