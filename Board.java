//contains the board
public class Board
{
    private int rows;
    private int cols;
    private char[][] arr;
    private int[] count_block;

    public Board(int rows,int cols)
    {
        this.rows=rows;
        this.cols=cols;
        arr = new char[rows][cols];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=' ';
            }
        }
    }
    //constructors
    //getters
    public char[][] getARR()
    {
        return arr;
    }
    //setters
    public void setARR(char[][] arr)
    {
        this.arr=arr;
    }
    //functions
    public void printBoard()
    {
        for(int i=0;i<rows;i++)
        {
            System.out.print("|");
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println("|");
        }
    }
    //clear board
    public void clearboard()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=' ';
            }
        }
    }
    //insert shape
    public void insertShape(Shape S) //get block array
    {
        for(int i=0;i<4;i++)
        {
            int r = S.getarrofblock()[i].getX();
            int c = S.getarrofblock()[i].getY();
            arr[r][c] = '#';
        }
    }
    //move down
    public boolean movedown(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            //generate new coords
            int x = S.getarrofblock()[i].getX();
            x=x+1;
            int y = S.getarrofblock()[i].getY();
            if(x==rows || y==cols)
            {
                return false;
            }
            S.getarrofblock()[i].setX(x);
            S.getarrofblock()[i].setY(y);
        }
        return true;
    }
}