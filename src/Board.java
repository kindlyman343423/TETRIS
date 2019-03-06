import RAINBOW.Rain;

/*
 *  BOARD CLASS CONTAINS ALL METHODS
 * */
public class Board
{
    private int rows;
    private int cols;
    private char[][] arr;
    private int[] count_block;
    //constructors
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
    //print the board
    public void printBoard()
    {
        Rain R = new Rain();
        System.out.print(R.BYELLOW);
        for(int i=0;i<cols+2;i++)
        {
            System.out.print("=");
        }
        System.out.print(R.RESET);
        System.out.println();
        
        for(int i=0;i<rows;i++)
        {
            System.out.print(R.BYELLOW+"|"+R.RESET);
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println(R.BYELLOW+"|"+R.RESET);
        }

        System.out.print(R.BYELLOW);
        for(int i=0;i<cols+2;i++)
        {
            System.out.print("=");
        }
        System.out.print(R.RESET);
        System.out.println();
    }
    //clear the earlier filled array
    public void clearboard()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(arr[i][j]!='@')
                {
                    arr[i][j]=' ';
                }
            }
        }
    }
    //insert shape for showing only
    public void insertShape(Shape S) //get block array
    {
        for(int i=0;i<4;i++)
        {
            int r = S.getarrofblock()[i].getX();
            int c = S.getarrofblock()[i].getY();
            arr[r][c] = '#';
        }
    }
    //insert fixed shape
    public void insertFixedShape(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            int r = S.getarrofblock()[i].getX();
            int c = S.getarrofblock()[i].getY();
            arr[r][c] = '@';
        }
    }
    //move down
    public boolean movedown(Shape S)
    {
        boolean flag_touched = false;
        for(int i=0;i<4;i++)
        {
            //generate new coords
            int x = S.getarrofblock()[i].getX();
            int y = S.getarrofblock()[i].getY();

            //new coords
            x=x+1; //y unchanged
            //checking next down coords
            if(x==rows || arr[x][y]=='=' || arr[x][y]=='@')
            {
                flag_touched=true; //shape touched
                break;
            }
        }
        if(!flag_touched)
        {
            for(int i=0;i<4;i++)
            {
                int x = S.getarrofblock()[i].getX();
                int y = S.getarrofblock()[i].getY();
                //generate new coords
                S.getarrofblock()[i].setX(x+1);
                S.getarrofblock()[i].setY(y);
            }
            return false;
        }
        else //flag touched
        {
            return true;
        }
    }
    //move right
    public boolean moveright(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            //generate new coords
            int x = S.getarrofblock()[i].getX();
            int y = S.getarrofblock()[i].getY();
            y=y+1;
            if(y==cols)
            {
                return false;
            }
            S.getarrofblock()[i].setX(x);
            S.getarrofblock()[i].setY(y);
        }
        return true;
    }
    //move right
    public boolean moveleft(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            //generate new coords
            int x = S.getarrofblock()[i].getX();
            int y = S.getarrofblock()[i].getY();
            y=y-1;
            if(y==0)
            {
                return false;
            }
            S.getarrofblock()[i].setX(x);
            S.getarrofblock()[i].setY(y);
        }
        return true;
    }
}