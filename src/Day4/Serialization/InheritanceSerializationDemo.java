package Day4.Serialization;

import java.io.*;

/*
If parent class implements Serializable then automatically every child class by default implements Serializable. That is Serializable
nature is inheriting from parent to child.Hence even though child class doesn't implements Serializable , we can serialize child class
object if parent class implements serializable interface.
*/
public class InheritanceSerializationDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //Creating the object
        Student s1 =new Student(211,"ravi","Engineering",50000);
        //Creating stream and writing the object
        FileOutputStream fout=new FileOutputStream("f.txt");
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(s1);
        //closing the stream
        out.close();

        //Creating stream to read the object
        ObjectInputStream in=new ObjectInputStream(new FileInputStream("f.txt"));
        Student s=(Student)in.readObject();
        //printing the data of the serialized object
        System.out.println(s.id+" "+s.name+" "+s.course+" "+s.fee);
        //closing the stream
        in.close();

    }

    static class Person implements Serializable {
        final static long serialVersionUID = 12354L;
        int id;
        String name;
        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }
    static class Student extends Person {
        String course;
        int fee;
        public Student(int id, String name, String course, int fee) {
            super(id,name);
            this.course=course;
            this.fee=fee;
        }
    }
}


