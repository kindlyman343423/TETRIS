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
        
        //ROTATION OF A SHAPE
        Shape[][] rotation = new Shape[7][4];
        Block e = new Block(0,0);
        Block f = new Block(0,0);
        Block g = new Block(0,0);
        Block h = new Block(0,0);

        //LINE SHAPE 0
        rotation[0][0] = new Shape(e,f,g,h);
        rotation[0][2] = rotation[0][0];
        e = new Block(0,0);
        f = new Block(1,-1);
        g = new Block(2,-1);
        h = new Block(3,-1);
        rotation[0][1] = new Shape(e,f,g,h);
        rotation[0][3] = rotation[0][1];
        
        //SQUARE SHAPE 1
        e = new Block(0,0);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(0,0);
        rotation[1][0] = new Shape(e,f,g,h);
        rotation[1][1] = rotation[1][0];
        rotation[1][2] = rotation[1][1];
        rotation[1][3] = rotation[1][2];

        //LR SHAPE 2
        e = new Block(0,0);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(0,0);
        rotation[2][0] = new Shape(e,f,g,h);
        e = new Block(1,2);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(-1,0);
        rotation[2][1] = new Shape(e,f,g,h);
        e = new Block(3,1);
        f = new Block(3,1);
        g = new Block(0,0);
        h = new Block(0,0);
        rotation[2][2] = new Shape(e,f,g,h);
        e = new Block(0,2);
        f = new Block(0,0);
        g = new Block(-1,1);
        h = new Block(-1,1);
        rotation[2][3] = new Shape(e,f,g,h);

        //LL SHAPE 3
        
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
            board.clearboard(); // clear board
            flag_shape_fixed = board.movedown(LINE); // default move down

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
 *  LINE  0
 *  # # # #
 */
/*
 *  SQUARE  1
 *  # # 
 *  # #
 */
/*
 *  LR SHAPE 2
 *  #
 *  #
 *  # #
 */
/*
 *  LL SHAPE 3
 *    #
 *    # 
 *  # #
*/
/*
 *  TSHAPE 4
 *  # # #
 *    #
 */
/*
 *  ZL SHAPE 5
 *  # #
 *    # #
 */
/*
 *  ZR SHAPE 6
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

    public static void rotateShape(Shape S,int num)
    {

    }
}