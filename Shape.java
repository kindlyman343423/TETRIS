public class Shape
{
    private Block[] shape;

    public Shape()
    {
        shape = new Block[4];
    }
    public Shape(Block a,Block b,Block c,Block d)
    {
        shape[0] = a;
        shape[1] = b;
        shape[2] = c;
        shape[3] = d;
    }
    public Block[] getshape()
    {
        return shape;
    }
    public String toString()
    {
        return "["+shape[0].toString()+shape[1].toString()+shape[2].toString()+shape[3].toString()+"]";
    }
}