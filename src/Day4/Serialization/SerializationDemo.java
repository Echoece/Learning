package Day4.Serialization;

import java.io.*;

public class SerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Dog d1=new Dog();
        Cat c1=new Cat();

        System.out.println("Serialization started");
        // creating the objectOutputStream using a FileOutputStream
        FileOutputStream fos=new FileOutputStream("abc.ser");
        ObjectOutputStream oos=new ObjectOutputStream(fos);
        // writing objects
        oos.writeObject(d1);
        oos.writeObject(c1);
        oos.close();
        System.out.println("Serialization ended");

        System.out.println("Deserialization started");
        FileInputStream fis=new FileInputStream("abc.ser");
        ObjectInputStream ois=new ObjectInputStream(fis);
        // We can serialize any no of objects to the file but in which order we serialized in the same order only we have to deserialize
        Dog d2=(Dog)ois.readObject();
        Cat c2=(Cat)ois.readObject();
        ois.close();
        System.out.println("Deserialization ended");

        System.out.println(d2.i+"................"+d2.j);
        System.out.println(c2.i+"................"+c2.j);
    }
}


class Dog implements Serializable {
    int i=10;
    int j=20;
}

class Cat implements Serializable
{
    int i=30;
    int j=40;
}


