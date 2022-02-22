package Day1.WrapperClass;

public class WrapperClassDemo {

    public static void main(String[] args) {
        /* different ways to declare wrapper class, In cases where we want to convert from different data types we can
           use valueOf() method. Otherwise we can directly assign value.*/

        //Integer integer = new Integer(10);
        //Integer integer = Integer.valueOf(10);  // we can add string value here as well

        Integer integer = 10;
        Byte b = Byte.valueOf("15");
        Short s = Short.valueOf("123");
        Float f = Float.valueOf("123.5");
        Double d = Double.valueOf(123.555);
        Character c = Character.valueOf('A');
        Boolean bool = Boolean.valueOf("True");

        // methods, there is too many to write down here. Documentation is the best place to review all.

    }


}

