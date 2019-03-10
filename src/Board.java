import RAINBOW.*;

/**
 * Board class for making board
 **/
public class Board
{
    private int rows;                                               // rows of the board
    private int cols;                                               // cols of the board
    private char[][] arr;                                           // array for making board
    private int[] count_block;                                      // store count the number of fixed block in the line
    
    /**
     * Parameterised Constructor for making new board
     **/
    public Board(int rows,int cols)
    {
        this.rows=rows;
        this.cols=cols;
        arr = new char[rows][cols];                                 // create dynamic array for printing board
        count_block = new int[rows];
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                arr[i][j]=' ';                                      // setting space in the board array
            }
        }
    }
    
    /**
     * This function will return board array
     * 
     * @return char array
     **/
    public char[][] getARR()
    {
        return arr;
    }

    /**
     * This function sets param array for the board
     * 
     * @param arr for char array 
     * @return void
     **/
    public void setARR(char[][] arr)
    {
        this.arr=arr;
    }
    
    /**
     * This function will print the board on the screen
     * 
     * @return void
     **/
    public void printBoard()
    {
        Rain R = new Rain();                                        // making object of rain class for using colors from rainbow
        System.out.print(R.BYELLOW);
        for(int i=0;i<cols+2;i++)                                   // printing the above == line
        {
            System.out.print("=");
        }
        System.out.print(R.RESET);
        System.out.println();
        
        for(int i=0;i<rows;i++)                                     // printing the left and right | | lines
        {
            System.out.print(R.BYELLOW+"|"+R.RESET);
            for(int j=0;j<cols;j++)
            {
                System.out.print(arr[i][j]);
            }
            System.out.println(R.BYELLOW+"|"+count_block[i]+R.RESET);
        }

        System.out.print(R.BYELLOW);
        for(int i=0;i<cols+2;i++)                                   // printing the below == line
        {
            System.out.print("=");
        }
        System.out.print(R.RESET);
        System.out.println();
    }

    /**
     * This function will clear the board except '@' fixed one
     * 
     * @return void
     **/
    public void clearboard()
    {
        for(int i=0;i<rows;i++)
        {
            for(int j=0;j<cols;j++)
            {
                if(arr[i][j]!='@')                                  // if fixed char don't found
                {
                    arr[i][j]=' ';                                  // printing space char for clearing
                }
            }
        }
    }

    /**
     * This function will insert shape on board for runtime
     * 
     * @param S for getting Shape for printing
     * 
     * @return void
     **/
    public void insertShape(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            int r = S.getarrofblock()[i].getX();                    // get x coordinate of the block
            int c = S.getarrofblock()[i].getY();                    // get y coordinate of the block
            arr[r][c] = '#';                                        // printing the block with # block for runtime
        }
    }

    /**
     * This function will insert the fixed shape
     * 
     * @param S for Shape to printed as fixed
     * 
     * @return void
     **/
    public void insertFixedShape(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            int r = S.getarrofblock()[i].getX();                    // get x coordinate of the block
            int c = S.getarrofblock()[i].getY();                    // get y coordinate of the block
            count_block[r]++;                                       // increment the line blocks counter
            arr[r][c] = '@';                                        // printing @ for fixed shape
        }
        
        deleteLine();                                               // check for line deletion
    }

    /**
     * This function will delete the line if the line is full of fixed blocks or not
     * 
     * @return boolean whether the lines are deleted or not
     **/
    private boolean deleteLine()
    {
        boolean deleted = false;
        for(int i=0;i<count_block.length;i++)
        {
            if(i>=cols)
            {
                //i line to delete
                deleted=true;
            }
        }
        return deleted;
    }

    /**
     * This function will move the block down
     * 
     * @param S for Shape movement
     * 
     * @return boolean to check whether shape get fixed or not
     **/
    public boolean movedown(Shape S)
    {
        boolean flag_touched = false;                               // flag for checking block touching
        for(int i=0;i<4;i++)
        {
            //Get block coordinates 
            int x = S.getarrofblock()[i].getX();                    // get x coords of every block
            int y = S.getarrofblock()[i].getY();                    // get y coords of every block

            /**
             * Generate new coords for checking
             * x incremented by one
             * y remain unchanged
             **/
            x=x+1; 

            /**
             * Checking next down coordinates
             **/
            if(x==rows || arr[x][y]=='=' || arr[x][y]=='@')
            {
                flag_touched=true;                                  // shape touched to end or fixed block or rows
                break;
            }
        }
        if(!flag_touched)                                           // if shape don't touch to anything then move down
        {
            for(int i=0;i<4;i++)
            { 
                //Get block coordinates 
                int x = S.getarrofblock()[i].getX();
                int y = S.getarrofblock()[i].getY();
                
                /**
                 * Generate new coords for down movement
                 * x incremented by one
                 * y remain unchanged
                 **/
                S.getarrofblock()[i].setX(x+1);
                S.getarrofblock()[i].setY(y);
            }
            return false;                                           // returning false as shape not fixed see @Main.java
        }
        else                                                        // if flag touched get true
        {
            return true;                                            // returning true as shape fixed
        }
    }
    
    /**
     * This function will move the shape right
     * 
     * @param S for moving Shape right
     * @return boolean whether the shape moved right or not
     **/
    public boolean moveright(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            //Get block coordinates
            int x = S.getarrofblock()[i].getX();
            int y = S.getarrofblock()[i].getY();
            
            /**
             * Generate new coords for checking and movement
             * x remain unchanged
             * y incremented by one
             **/
            y=y+1;

            if(y==cols)                                             // if y coordinate get equals to cols
            {
                return false;                                       // return false as shape can't go right
            }
            
            //setting coords to the block
            S.getarrofblock()[i].setX(x);
            S.getarrofblock()[i].setY(y);
        }
        return true;
    }

    /**
     * This function will move the shape left
     * 
     * @param S for moving Shape left
     * @return boolean whether the shape moved left or not
     **/
    public boolean moveleft(Shape S)
    {
        for(int i=0;i<4;i++)
        {
            //Get block coordinates
            int x = S.getarrofblock()[i].getX();
            int y = S.getarrofblock()[i].getY();
           
            /**
             * Generate new coords for checking and movement
             * x remain unchanged
             * y decremented by one
             **/
            y=y-1;

            if(y==0)                                                // if y coordinate become 0
            {
                return false;                                       // return false as shape can't go left
            }

            //setting coords to the block
            S.getarrofblock()[i].setX(x);
            S.getarrofblock()[i].setY(y);
        }
        return true;
    }
}