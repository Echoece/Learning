package Day5.StaticImport;
import static java.lang.System.*;

public class StaticImportDemo {
    public static void main(String[] args) {
        out.println("Hello");   //Now no need of System.out as we used static import
        out.println("Java");
    }
}
