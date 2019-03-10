public class Shape
{
    private Block[] arrofblock;
    private int currentstate;

    public Shape(Block a,Block b,Block c,Block d,int currentstate)
    {
        arrofblock = new Block[4];
        this.arrofblock[0] = a;
        this.arrofblock[1] = b;
        this.arrofblock[2] = c;
        this.arrofblock[3] = d;
        this.currentstate = currentstate;
    }
    //getters
    public int getcurrentstate()
    {
        return currentstate;
    }

    /**
     * This will set new state
     * 
     * @param state for setting state
     * @param void 
     **/
    public void setcurrentstate(int state)
    {
        this.currentstate = state;
    }

    /**
     * This function will return the block array of a shape
     * 
     * @return blocks array
     **/
    public Block[] getarrofblock()
    {
        return arrofblock;
    }
    
    /**
     * This function will print the string representation of the block
     * 
     * @return string
     **/
    public String toString()
    {
        return "["+arrofblock[0].toString()+arrofblock[1].toString()+arrofblock[2].toString()+arrofblock[3].toString()+"]";
    }
}