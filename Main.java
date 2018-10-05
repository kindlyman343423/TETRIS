import java.util.*;

//USING RAINBOW 
import RAINBOW.*;
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
 *  LR SHAPE
 *  #
 *  #
 *  # #
 */
/*
 *  LL SHAPE
 *    #
 *    # 
 *  # #
*/
/*
 *  TSHAPE
 *  # # #
 *    #
 */
/*
 *  ZL SHAPE
 *  # #
 *    # #
 */
/*
 *  ZR SHAPE
 *    # #
 *  # #
 */
public class Main 
{
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        Board board = new Board(50, 40);    //initaize the board
        boolean flag_shape_fixed = false; //initial shape is now fixed

        //making the line blocks
        Block a = new Block(2, 19);
        Block b = new Block(2, 20);
        Block c = new Block(2, 21);
        Block d = new Block(2, 22);
        Shape LINE = new Shape(a, b, c, d); // created line shape

        a.setX(2);
        a.setY(19);
        b.setX(2);
        b.setY(20);
        c.setX(3);
        c.setY(19);
        d.setX(3);
        d.setY(20);
        Shape SQUARE = new Shape(a,b,c,d); //SQAURE SHAPE

        a.setX(3);
        a.setY(19);
        b.setX(4);
        b.setY(19);
        c.setX(5);
        c.setY(19);
        d.setX(5);
        d.setY(20);
        Shape LRSHAPE = new Shape(a,b,c,d); //LR SHAPE

        a.setX(3);
        a.setY(19);
        b.setX(4);
        b.setY(19);
        c.setX(5);
        c.setY(19);
        d.setX(5);
        d.setY(18);
        Shape LLSHAPE = new Shape(a,b,c,d); //LL SHAPE
        
        a.setX(2);
        a.setY(19);
        b.setX(2);
        b.setY(20);
        c.setX(2);
        c.setY(21);
        d.setX(3);
        d.setY(20);
        Shape TSHAPE = new Shape(a,b,c,d); //TSHAPE

        a.setX(2);
        a.setY(19);
        b.setX(2);
        b.setY(20);
        c.setX(3);
        c.setY(20);
        d.setX(3);
        d.setY(21);
        Shape ZLSHAPE = new Shape(a,b,c,d); //ZLSHAPE

        a.setX(2);
        a.setY(19);
        b.setX(2);
        b.setY(20);
        c.setX(3);
        c.setY(18);
        d.setX(3);
        d.setY(19);
        Shape ZRSHAPE = new Shape(a,b,c,d); //ZRSHAPE
        
        //intial position of the shape
        board.insertShape(LINE); //insert initial shape 
        board.printBoard(); //print the board
        System.out.println();
        System.exit(0);
        //start game
        while(true)
        {
            board.clearboard(); // clear board
            if(!board.movedown(LINE)) //default move down
            {
                break;
            }
            System.out.println("ENTER THE OPTION");
            char ans=in.next().charAt(0);
            if(ans=='D' || ans=='d') //move right
            {
                if(!board.moveright(LINE))
                {
                    break;
                }
            }
            else if(ans=='A' || ans=='a') //moveleft
            {
                if(!board.moveleft(LINE))
                {
                    break;
                }
            }
            board.insertShape(LINE); //insert shape on board
            board.printBoard(); // print board
            System.out.println();
        }
        in.close();
    }
}