//Block class for making a block of a shape
public class Block
{
    private int xCoordinate;                    
    private int yCoordinate;                   

    /**
     * Parameterised constructor to make a new block
     **/
    public Block(int xCoordinate,int yCoordinate)
    {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    /**
     * This function will return the x coordinate of the block class
     * 
     * @return int
     **/
    public int getXCoordinate()
    {
        return xCoordinate;
    }
    
    /**
     * This function will return the y coordinate of the block class
     * 
     * @return int
     **/
    public int getYCoordinate()
    {
        return yCoordinate;
    }

    /**
     * This function will set x coordinate of the block
     * 
     * @param xCoordinate for setting coords 
     * @return void
     **/
    public void setXCoordinate(int xCoordinate)
    {
        this.xCoordinate = xCoordinate;
    }

    /**
     * This function will set y coordinate of the block
     * 
     * @param yCoordinate for setting coords 
     * @return void
     **/
    public void setYCoordinate(int yCoordinate)
    {
        this.yCoordinate = yCoordinate;
    }

    /**
     * This function will return string representation of the block
     * 
     * @return String
     */
    public String toString()
    {
        return "(" + xCoordinate + "," + yCoordinate + ")";
    }
}