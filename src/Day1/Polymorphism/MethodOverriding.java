package Day1.Polymorphism;

public class MethodOverriding {
}

class OverRidingParent {
    void show()
    {
        System.out.println("Parent's show()");
    }
    // private methods are not overridden
    private void m1()
    {
        System.out.println("From parent m1()");
    }
    // but protected methods can be overridden
    protected void m2()
    {
        System.out.println("From parent m2()");
    }
}

class OverRidingChildren extends OverRidingParent {
    void show()
    {
        System.out.println("Children's show()");
        // => we can call parent's overridden method using super keyword
        super.show();
    }
    // new m1() method different from the parent m1() method. this is method overloading
    private void m1()
    {
        System.out.println("From child m1()");
    }

    // overriding method with more accessibility, parent m2 was protected but this is public.
    @Override
    public void m2()
    {
        System.out.println("From child m2()");
    }
}
