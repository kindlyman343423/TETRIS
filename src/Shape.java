public class Shape
{
    private Block[] blockArray;
    private int currentState;

    public Shape(Block firstBlock,Block secondBlock,Block thirdBlock,Block fourthBlock,int currentState)
    {
        final int BLOCK_ARRAY_SIZE = 4;
        blockArray = new Block[BLOCK_ARRAY_SIZE];

        this.blockArray[0] = firstBlock;
        this.blockArray[1] = secondBlock;
        this.blockArray[2] = thirdBlock;
        this.blockArray[3] = fourthBlock;
        this.currentState = currentState;
    }
    
    /**
     * This function will return the current state of the shape
     * 
     * @return int for current state
     **/
    public int getCurrentState()
    {
        return currentState;
    }

    /**
     * This will set new state
     * 
     * @param state for setting state
     * @param void 
     **/
    public void setCurrentState(int currentState)
    {
        this.currentState = currentState;
    }

    /**
     * This function will return the block array of a shape
     * 
     * @return blocks array
     **/
    public Block[] getBlockArray()
    {
        return blockArray;
    }
    
    /**
     * This function will print the string representation of the block
     * 
     * @return string
     **/
    public String toString()
    {
        return "[" + blockArray[0].toString() + blockArray[1].toString() + blockArray[2].toString() + blockArray[3].toString() + "]";
    }
}