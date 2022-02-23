package Day1.Polymorphism;

public class Covariant {
}

class Burger{ }
class HealthyBurger extends Burger{}
class BurgerFactory{
    public Burger createBurger(){
        return new Burger();
    }
}

// -> covariant return type only works for non-primitive return type.
// -> Covariant return type refers to return type of an overriding method.
// -> It allows to narrow down return type of an overridden method without any need to cast the type or check the return type.

// -> so since the parent class have return type Burger, in the overridden method we can have any child class of Burger ( HealthyBurger in this case)
//    as return type. this is known as covariant return types.

class HealthyBurgerFactory extends BurgerFactory{
    @Override
    public Burger createBurger() {
        return new HealthyBurger();
    }
}
