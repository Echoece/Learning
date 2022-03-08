package Day5.Enums;


enum Colors{
    RED, GREEN, BLUE;
    // enum constructor called separately for each
    // constant
    private Colors()
    {
        System.out.println("Constructor called for : " +
                this.toString());
    }

    public void colorInfo()
    {
        System.out.println("Universal Color");
    }
}

public class EnumDemo {
    public static void main(String[] args) {
        Colors currentColor = Colors.RED;
        System.out.println(currentColor);
        currentColor.colorInfo();
        /*
         output ::
                 Constructor called for : RED
                 Constructor called for : GREEN
                 Constructor called for : BLUE
                 RED
                 Universal Color
        */
        // returns array of all enum values, we can use this to traverse the enum
        Colors[] allColors = Colors.values();

        switch (currentColor){
            // or we can use the usual case RED : ....; break; statement
            case RED -> System.out.println("color is Red");
            case BLUE -> System.out.println("color is Blue");
            case GREEN -> System.out.println("color is green");
            default -> System.out.println("nothing");
        }
    }
}
