import java.util.*;

//USING RAINBOW 
import RAINBOW.*;

public class Main {
    public static void main(String[] args) 
    {
        Scanner in = new Scanner(System.in);
        Board board = new Board(50, 40); // initaize the board
        boolean flag_shape_fixed = false; // initial shape is now fixed
        int shape_counter = 0; //for different shapes

        // making the line blocks
        Block a = new Block(2, 19);
        Block b = new Block(2, 20);
        Block c = new Block(2, 21);
        Block d = new Block(2, 22);
        Shape LINE = new Shape(a, b, c, d); // created line shape

        // intial position of the shape
        board.insertShape(LINE); // insert initial shape
        board.printBoard(); // print the board
        System.out.println();
        
        flag_shape_fixed = false;
        // start game
        while (true) 
        {
            // System.out.println(LINE);
            board.clearboard(); // clear board
            flag_shape_fixed = board.movedown(LINE); // default move down
            System.out.println(shape_counter);
            if(flag_shape_fixed) 
            {
                board.insertFixedShape(LINE);
                board.printBoard();
                //create new shape
                if(shape_counter==6)
                {
                    shape_counter=0;
                }
                else
                {
                    shape_counter++;
                }
                LINE = create_shape(LINE, shape_counter);

                flag_shape_fixed=false;
            }
            System.out.println("ENTER THE OPTION");
            char ans = in.next().charAt(0);
            if (ans == 'D' || ans == 'd') // move right
            {
                if (!board.moveright(LINE)) 
                {
                    break;
                }
            } 
            else if (ans == 'A' || ans == 'a') // moveleft
            {
                if (!board.moveleft(LINE)) 
                {
                    break;
                }
            }
            else if(ans=='w' || ans=='W') //rotate shape
            {
                
            }
            else if(ans=='q' || ans=='Q') //EXIT GAME
            {
                System.exit(0);
            }
            // rotate shape
            board.insertShape(LINE); // insert shape on board
            board.printBoard(); // print board
            System.out.println();
        }
        in.close();
    }

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
    public static Shape create_shape(Shape sh,int num)
    {
        switch(num)
        {
            case 0:
                //LINE SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(2);
                sh.getarrofblock()[1].setY(20);
                sh.getarrofblock()[2].setX(2);
                sh.getarrofblock()[2].setY(21);
                sh.getarrofblock()[3].setX(2);
                sh.getarrofblock()[3].setY(22);
                break;
            case 1:
                //SQUARE SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(2);
                sh.getarrofblock()[1].setY(20);
                sh.getarrofblock()[2].setX(3);
                sh.getarrofblock()[2].setY(19);
                sh.getarrofblock()[3].setX(3);
                sh.getarrofblock()[3].setY(20);
                break;
            case 2:
                //LR SHAPE
                sh.getarrofblock()[0].setX(3);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(4);
                sh.getarrofblock()[1].setY(19);
                sh.getarrofblock()[2].setX(5);
                sh.getarrofblock()[2].setY(19);
                sh.getarrofblock()[3].setX(5);
                sh.getarrofblock()[3].setY(20);
                break;
            case 3:
                //LL SHAPE
                sh.getarrofblock()[0].setX(3);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(4);
                sh.getarrofblock()[1].setY(19);
                sh.getarrofblock()[2].setX(5);
                sh.getarrofblock()[2].setY(19);
                sh.getarrofblock()[3].setX(5);
                sh.getarrofblock()[3].setY(18);
                break;
            case 4:
                //T SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(2);
                sh.getarrofblock()[1].setY(20);
                sh.getarrofblock()[2].setX(2);
                sh.getarrofblock()[2].setY(21);
                sh.getarrofblock()[3].setX(3);
                sh.getarrofblock()[3].setY(20);
                break;
            case 5:
                //ZL SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(2);
                sh.getarrofblock()[1].setY(20);
                sh.getarrofblock()[2].setX(3);
                sh.getarrofblock()[2].setY(20);
                sh.getarrofblock()[3].setX(3);
                sh.getarrofblock()[3].setY(21);
                break;
            case 6:
                //ZR SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(19);
                sh.getarrofblock()[1].setX(2);
                sh.getarrofblock()[1].setY(20);
                sh.getarrofblock()[2].setX(3);
                sh.getarrofblock()[2].setY(18);
                sh.getarrofblock()[3].setX(3);
                sh.getarrofblock()[3].setY(19);
                break;
            default:
                System.exit(0);

        }
        return sh;
    }
}