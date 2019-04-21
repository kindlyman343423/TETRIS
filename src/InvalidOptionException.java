/**
 * This exception is thrown when user inputs invalid option
 **/
public class InvalidOptionException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * constructor will set a new object of index out of board exception
     * 
     * @param String for thrown string
     **/
    public InvalidOptionException(String s)
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
        return "java.Tetris.InvalidOptionException\n"+ this.getMessage();   
    }
}