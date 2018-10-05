/*
 *  BLOCK CLASS FOR MAKING COORDINATE BLOCK
 * */
public class Block
{
    private int x;
    private int y;

    public Block(int x,int y)
    {
        this.x = x;
        this.y = y;
    }
    //getters
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    //setters
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }

    //conversion
    public String toString()
    {
        return "("+x+","+y+")";
    }
}