/**
 * This exception is produced when index get out of board coords
 **/
public class IndexOutofBoardException extends Exception
{
    private static final long serialVersionUID = 1L;

    /**
     * constructor will set a new object of index out of board exception
     * 
     * @param String for thrown string
     **/
    public IndexOutofBoardException(String s)
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
        return "java.Tetris.IndexOutofBoardException\n"+ this.getMessage();   
    }
}