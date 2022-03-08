package Day5.Annotation;

/**@author Rafiqul Islam
 * @version 1.0
 * @since 2022
 * @see Integer,java.math.BigDecimal
 *
 * Class for showing Java Doc demo
 * **/

public class JavaDocDemo {
    /**
     * @value 10 default
     * **/
    static int value= 10;

    /**
     * Parameterized constructor
     * @param s Some parameter
     */
    public JavaDocDemo(String s){ }

    /**
     * Issue a book to a student
     * @param roll id of student
     * @throws Exception if book not found, throw exception
     */
    public void issue(int roll) throws Exception{ }

    /**
     * check book is available
     * @param name book name
     * @return if book available return true, else return false
     */
    public boolean available(String name){
        return  true;
    }

    /**
     * Get Book Name
     * @param id book id
     * @return returns book name
     */
    public String getBookName(int id){
        return "";
    }

}
