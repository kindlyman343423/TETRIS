public class Shape
{
    private Block[] arrofblock;
    private int currentstate;

    public Shape(Block a,Block b,Block c,Block d)
    {
        arrofblock = new Block[4];
        this.arrofblock[0] = a;
        this.arrofblock[1] = b;
        this.arrofblock[2] = c;
        this.arrofblock[3] = d;
        currentstate = 0;
    }
    //getters
    public int getcurrentstate()
    {
        return currentstate;
    }
    public Block[] getarrofblock()
    {
        return arrofblock;
    }
    //for conversion
    public String toString()
    {
        return "["+arrofblock[0].toString()+arrofblock[1].toString()+arrofblock[2].toString()+arrofblock[3].toString()+"]";
    }
}