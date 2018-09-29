public class Shape
{
    private Block[] arrofblock;

    public Shape(Block a,Block b,Block c,Block d)
    {
        arrofblock = new Block[4];
        this.arrofblock[0] = a;
        this.arrofblock[1] = b;
        this.arrofblock[2] = c;
        this.arrofblock[3] = d;
    }
    public Block[] getshape()
    {
        return arrofblock;
    }
    public String toString()
    {
        return "["+arrofblock[0].toString()+arrofblock[1].toString()+arrofblock[2].toString()+arrofblock[3].toString()+"]";
    }
}