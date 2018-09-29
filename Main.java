import java.util.*;
/*
 *  LINE  
 *  # # # #
 */
/*
 *  SQUARE 
 *  # # 
 *  # #
 */
/*
 *  L
 *  #
 *  #
 *  # #
 */
/*
 *  T
 *  # # #
 *    #
 */
/*
 *  Z
 *  # #
 *    # #
 */
public class Main {
    public static void main(String[] args) 
    {
        Board board = new Board(60, 40);
        board.printBoard();

        Block a = new Block(2, 0);
        Block b = new Block(2, 1);
        Block c = new Block(2, 2);
        Block d = new Block(2, 3);

        Shape one = new Shape(a, b, c, d); // created a shape

        board.insertShape(one);
        board.printBoard();
        System.out.println();
        while(true)
        {
            if(!board.movedown(one))
            {
                break;
            }
            board.insertShape(one);
            board.printBoard();
            board.clearboard();
            System.out.println();
        }

    }
}