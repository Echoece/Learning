package Day4.Generics;


// A class that can refer to any type is known as a generic class. Here, we are using the T type parameter to create the generic class of specific type.

import java.util.ArrayList;
import java.util.List;

// generics in class, Here T and U are two types
public class GenericDemo<T,U> {
    T genericObject;
    U anotherGenericObject;

    // Generics in method parameter
    void add(T obj, U anotherObj){
        genericObject = obj;
        anotherGenericObject = anotherObj;
    }

    // generics as return type
    T getObj(){ return genericObject; }
    U getAnotherObj(){ return anotherGenericObject; }

    // wildcards, means any class extending Parent (can be multilevel subclass too)
    public static void drawShape(List<? extends Parent> element){
        element.get(0).draw();
    }

    public static void main(String[] args) {
        List<Parent> parents = new ArrayList<>();
        List<Child1> child1s = new ArrayList<>();
        List<GrandChild> grandChildren = new ArrayList<>();

        drawShape(grandChildren);
    }
}


abstract class Parent{
    abstract void draw();
}

class Child1 extends Parent{
    @Override
    void draw() {
        // do something
    }
}

class Child2 extends Parent{
    @Override
    void draw() {
        // do something
    }
}

class GrandChild extends Child1{
    @Override
    void draw() {
        // do something
    }
}
