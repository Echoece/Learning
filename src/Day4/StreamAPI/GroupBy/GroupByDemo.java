package Day4.StreamAPI.GroupBy;

import java.util.*;
import java.util.stream.Collectors;

public class GroupByDemo {
    public static void main(String[] args) {
        groupByExample();
    }

    public static void groupByExample(){
        List<Employee> employeeList = Employee.dummyData();

        /* Group by Employees by city before Java 8  */
        Map<String, List<Employee>> empByCity = new HashMap<>();

        for (Employee e: employeeList) {
            // if city isn't present as a key in the hashmap, we create a new entry
            if(!empByCity.containsKey(e.city)){
                empByCity.put(e.city,new ArrayList<Employee>());
            }
            empByCity.get(e.city).add(e);   // getting the value from empByCity via the key, then adding the current employee to the list.
        }
        System.out.println("Employees grouped by cities before Java 8 : " + empByCity);

        /* group objects of Employee class in Java 8 */
        empByCity = employeeList.stream().collect(Collectors.groupingBy(employee -> employee.city)); // we can use method reference too instead of lambda (preferred)
        System.out.println("Employees grouped by cities in Java 8: " + empByCity);

        Map<Integer,List<Employee>> empByAge = employeeList.stream().collect(Collectors.groupingBy(employee-> employee.age));
        // output : {18=[Rafsan,(Jessor,18)], 21=[Dipu,(Dhaka,21)], 22=[Mobin,(Dhaka,22)], 23=[Abdul,(Dhaka,23)], 26=[Mahin,(Khulna,26)], 29=[Karim,(Khulna,29)], 31=[Setu,(Rajshahi,31)]}
        System.out.println(empByAge);

    }

    static class Employee {
        String name;
        String city;
        int age;

        public Employee(String name, String city, int age) {
            this.name = name;
            this.city = city;
            this.age = age;
        }

        static List<Employee> dummyData(){
            return Arrays.asList(
                    new Employee("Dipu", "Dhaka", 21),
                    new Employee("Mobin", "Dhaka", 22),
                    new Employee("Abdul", "Dhaka", 23),
                    new Employee("Mahin", "Khulna", 26),
                    new Employee("Karim", "Khulna", 29),
                    new Employee("Setu", "Rajshahi", 31),
                    new Employee("Rafsan", "Jessor", 18)
            );
        }
        @Override
        public String toString() {
            return String.format("%s,(%s,%d)", name, city, age);
        }
    }
}
