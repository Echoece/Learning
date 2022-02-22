package Day1.Inheritence;

public class Aggregation {
    public static void main(String[] args) {
        Address address1=new Address("Dhaka","Dhaka","Bangladesh");
        Address address2=new Address("Barisal","Khulna","Bangladesh");

        Employee e=new Employee(1,"Echo",address1);
        Employee e2=new Employee(2,"Rafiqul",address2);

        e.display();
        e2.display();
    }

}
// Employee has an Address. this is aggregation relationship
class Employee {
    int id;
    String name;
    Address address;

    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    void display() {
        System.out.println(id + " " + name);
        System.out.println(address.city + " " + address.state + " " + address.country);
    }
}

class Address{
    String city,state,country;

    public Address(String city, String state, String country) {
        this.city = city;
        this.state = state;
        this.country = country;
    }
}
