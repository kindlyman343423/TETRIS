/**
 * This exception is produced when wrong password is entered by the user while confirming
 **/
public class SameNamePasswordException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * constructor will set a new object of same name password exception
     * 
     * @param String for thrown string
     **/
    public SameNamePasswordException(String s)
    {
        super(s);
    }

    /**
     * This function will return the string representation of the exception object
     * 
     * @return String for display message
     **/
    public String toString()
    {
        return "java.Tetris.SameNamePasswordException\n"+ this.getMessage();   
    }
}