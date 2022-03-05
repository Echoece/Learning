package Day4.Serialization;

import java.io.Serializable;

// in this  case, we cant serialize the Student class even though it implements Serializable. The reason being, the object
// inside isn't serializable
public class AggregationSerializationDemo {

    static class Address{
        String addressLine,city,state;
        public Address(String addressLine, String city, String state) {
            this.addressLine=addressLine;
            this.city=city;
            this.state=state;
        }
    }
    static class Student implements Serializable {
        int id;
        String name;
        Address address;    //HAS-A relationship or aggregation
        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
}

