package Day1.ExceptionHandling;

public class UserDefinedException {
    private static int accountId[] = {1001, 1002, 1003, 1004};
    private static String name[] = {"Nisha", "Shubha", "Sushil", "Abhi", "Akash"};
    private static double balance[] = {10000.00, 12000.00, 5600.0, 999.00, 1100.55};
    // In this demo we simulate an example of a bank account, it will print the information of members. If balance is less than 1000
    // it will throw our own custom exception.
    public static void main(String[] args) {
        try {
            // display the heading for the table
            System.out.println("ACCNO" + "\t" + "CUSTOMER" +
                    "\t" + "BALANCE");

            // display the actual account information
            for (int i = 0; i < 5; i++) {
                // display own exception if balance < 1000
                if (balance[i] < 1000) {
                    throw new MyException("Error: Account Name "+ name[i] + " has Balance is less than 1000");
                }

                System.out.println(accountId[i] + "\t" + name[i] +
                        "\t" + balance[i]);
            }
        } catch (MyException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());

        }
    }

}

class MyException extends Exception {
    MyException(String str){
        super(str);
    }
}
