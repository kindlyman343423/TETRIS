/**
 * Block class for making a block of a shape
 **/
public class Block
{
    private int x;                  // block x coordinate
    private int y;                  // block y coordinate

    /**
     * Parameterised constructor to make a new block
     **/
    public Block(int x,int y)
    {
        this.x = x;
        this.y = y;
    }

    /**
     * This function will return the x coordinate of the block class
     * 
     * @return int
     **/
    public int getX()
    {
        return x;
    }
    
    /**
     * This function will return the y coordinate of the block class
     * 
     * @return int
     **/
    public int getY()
    {
        return y;
    }

    /**
     * This function will set x coordinate of the block
     * 
     * @param x for setting coords 
     * @return void
     **/
    public void setX(int x)
    {
        this.x = x;
    }

    /**
     * This function will set y coordinate of the block
     * 
     * @param y for setting coords 
     * @return void
     **/
    public void setY(int y)
    {
        this.y = y;
    }

    /**
     * This function will return string representation of the block
     * 
     * @return String
     */
    public String toString()
    {
        return "("+x+","+y+")";
    }
}