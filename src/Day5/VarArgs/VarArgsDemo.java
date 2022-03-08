package Day5.VarArgs;

public class VarArgsDemo {
    public static void main(String[] args) {
        display(1,"a", "B");
        display(1);
    }

    static void display(int num, String... values){
        System.out.println("number is "+num);
        for(String s:values){
            System.out.println(s);
        }
    }
}
