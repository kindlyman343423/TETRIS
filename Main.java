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
 *  LSHAPE
 *  #
 *  #
 *  # #
 */
/*
 *  TSHAPE
 *  # # #
 *    #
 */
/*
 *  ZSHAPE
 *  # #
 *    # #
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
        Shape one = new Shape(a, b, c, d); // created line shape

        Shape SQUARE = new Shape(a,b,c,d); //SQAURE SHAPE

        Shape LSHAPE = new Shape(a,b,c,d); //LSHAPE
        
        Shape TSHAPE = new Shape(a,b,c,d); //TSHAPE

        Shape ZSHAPE = new Shape(a,b,c,d); //ZSHAPE
        
        //intial position of the shape
        board.insertShape(one); //insert initial shape 
        board.printBoard(); //print the board
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