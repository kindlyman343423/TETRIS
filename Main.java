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
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        Board board = new Board(50, 40);

        Block a = new Block(2, 0);
        Block b = new Block(2, 1);
        Block c = new Block(2, 2);
        Block d = new Block(2, 3);

        Shape one = new Shape(a, b, c, d); // created a shape

        board.insertShape(one);
        board.printBoard();
        System.out.println();
        
        //start game
        while(true)
        {
            board.clearboard(); // clear board
            if(!board.movedown(one)) //default move down
            {
                break;
            }
            System.out.println("ENTER THE OPTION");
            char ans=in.next().charAt(0);
            if(ans=='D' || ans=='d') //move right
            {
                if(!board.moveright(one))
                {
                    break;
                }
            }
            else if(ans=='A' || ans=='a') //moveleft
            {
                if(!board.moveleft(one))
                {
                    break;
                }
            }
            board.insertShape(one); //insert shape on board
            board.printBoard(); // print board
            System.out.println();
        }
        in.close();
    }
}