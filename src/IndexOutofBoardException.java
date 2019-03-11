public class IndexOutofBoardException extends Exception
{
    private static final long serialVersionUID = 1L;

    public IndexOutofBoardException(String s)
    {
        super(s);
    }

    public String toString()
    {
        return "java.Tetris.IndexOutofBoardException\n"+ this.getMessage();   
    }
}