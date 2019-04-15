/**
 * This exception is when user name is not valid or duplicate to another user
 **/
public class DuplicateNameException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * constructor will set a new object of index out of board exception
     * 
     * @param String for thrown string
     **/
    public DuplicateNameException(String s)
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
        return "java.Tetris.DuplicateNameException\n"+ this.getMessage();   
    }
}