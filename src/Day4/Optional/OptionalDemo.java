package Day4.Optional;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String name = "Rafiqul Islam";


        // 1. Creating Optional
        Optional<String> empty = Optional.empty();              // create an empty Optional object,
        Optional<String> opt = Optional.of(name);               // dont pass null reference here, we will get nullpointer exception
        Optional<String> opt1 = Optional.ofNullable(name);      // if we pass a null reference, it doesn't throw an exception, returns an empty Optional object:


        // 2. Checking if value present:
        boolean isPresent = opt.isPresent();                        // true
        boolean isPresent1 = Optional.empty().isPresent();          // false


        // 3. Conditional Action With ifPresent()
        opt1.ifPresent(element -> System.out.println(element.length()));        // only executes the function if value is present, otherwise do nothing


        // 4. Default Value With orElse()  and orElseGet()
        String nullName = null;
        String name1 = Optional.ofNullable(nullName).orElse("john");        // output will be john in this case as we pass null value
        String name2 = Optional.ofNullable(nullName).orElseGet(() -> "john".toLowerCase());     // difference from orElse is, that instead of taking a default value, it takes a function to execute


        // 5. Exceptions With orElseThrow():
        // instead of returning a default value (like orElse() or orElseGet() ), it throws an exception
        String name3 = Optional.ofNullable(nullName).orElseThrow(IllegalArgumentException::new);
        // Java 10 introduced a simplified no-arg version of orElseThrow() method. In case of an empty Optional it throws a NoSuchElementException:
        String name4 = Optional.ofNullable(nullName).orElseThrow();


        // 6. Returning Value With get()
        //  get() can only return a value if the wrapped object is not null; otherwise, it throws a no such element exception. This is the major
        //  flaw of the get() method. Ideally, Optional should help us avoid such unforeseen exceptions.So, it's advisable to use the other
        //  variants that enable us to prepare for and explicitly handle the null case.
        String name5 = opt.get();
        String name6 = Optional.ofNullable(nullName).get(); // NoSuchElementException is thrown


        // 7. Conditional Return With filter()
        Optional<Integer> yearOptional = Optional.of(2016);
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();       // if true, returns the optional object, if false return empty optional object


        // 8. Transforming Value With map()
        List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);
        int size = listOptional.map(List::size).orElse(0);

        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword =  passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();


        // 9. Transforming Value With flatMap()
        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

                // using map function
        Optional < Optional<String> > nameOptionalWrapper = personOptional.map(Person::getName);
        Optional<String> nameOptional                     = nameOptionalWrapper.orElseThrow(IllegalArgumentException::new);
        String name7                                      = nameOptional.orElse("");

                // using flatmap function
        String name8                                      = personOptional.flatMap(Person::getName).orElse("");






    }

    static class Person {
        private String name;
        private int age;
        private String password;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Optional<String> getName() {
            return Optional.ofNullable(name);
        }

        public Optional<Integer> getAge() {
            return Optional.ofNullable(age);
        }

        public Optional<String> getPassword() {
            return Optional.ofNullable(password);
        }

        // normal constructors and setters
    }
}
