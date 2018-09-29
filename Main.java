public class Main
{
    public static void main(String[] args)
    {
        Board board = new Board(60,40);
        // board.printBoard();

        Block a = new Block(2,0);
        Block b = new Block(2,1);
        Block c = new Block(2,2);
        Block d = new Block(2,3);
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        Shape one = new Shape(a,b,c,d); //created a shape
        System.out.println(one);
        board.insertShape(one); 
        board.printBoard();       
    }
}