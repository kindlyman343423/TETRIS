import java.io.*;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import RAINBOW.*;
public class Tetris
{
    /**
     * New tetris game is created 
     **/
    public Tetris()
    {
        Rain color = new Rain();
        System.out.println(color.BCYAN);
        System.out.println("#####  #####  #####  ####   #####  #####");
        System.out.println("  #    #        #    #   #    #    #    ");
        System.out.println("  #    ####     #    ####     #    #####");
        System.out.println("  #    #        #    #  #     #        #");
        System.out.println("  #    #####    #    #   #  #####  #####");
        System.out.println(color.RESET);
    }

    /**
     * This function will be display GAME OVER when game ends
     * 
     * @return void
     **/
    private void endTetris()
    {
        Rain color = new Rain();
        System.out.println(color.BRED);
        System.out.println("##### ##### ##### #####  ##### #       # ##### #####");
        System.out.println("#     #   # # # # #      #   #  #     #  #     #   #");
        System.out.println("#  ## ##### # # # ####   #   #   #   #   ####  #####");
        System.out.println("#   # #   # #   # #      #   #    # #    #     #  # ");
        System.out.println("##### #   # #   # #####  #####     #     ##### #   #");
        System.out.println(color.RESET);
    }

    /**
     * This function displays the banner of game exited
     * 
     * @return void
     **/
    private void exitTetris()
    {
        Rain color = new Rain();
        System.out.println(color.DGREEN);
        System.out.println("&&&&& &&&&& &&&&& &&&&&  &&&&& &   & & &&&&& &&&&& &&&& ");
        System.out.println("&     &   & & & & &      &      & &  &   &   &     &   &");
        System.out.println("&  && &&&&& & & & &&&&   &&&&    &   &   &   &&&&  &   &");
        System.out.println("&   & &   & &   & &      &      & &  &   &   &     &   &");
        System.out.println("&&&&& &   & &   & &&&&&  &&&&& &   & &   &   &&&&& &&&& ");
        System.out.println(color.RESET);
    }

    /**
     * This function displays the banner of save game
     * 
     * @return void
     **/
    private void saveTetris()
    {
        Rain color = new Rain();
        System.out.println(color.BCYAN);
        System.out.println("OOOOO OOOOO OOOOO OOOOO  OOOOO     O O       O OOOOO OOOO ");
        System.out.println("O     O   O O O O O      O        O O O     O  O     O   O");
        System.out.println("O  OO OOOOO O O O OOOO   OOOOO   OOOOO O   O   OOOO  O   O");
        System.out.println("O   O O   O O   O O          O  O     O O O    O     O   O");
        System.out.println("OOOOO O   O O   O OOOOO  OOOOO O       O O     OOOOO OOOO ");
        System.out.println(color.RESET);
    }

    /**
     * This function is displays the main functions in tetris game
     * 
     * @return void
     **/
    public void tetrisMain()
    {
        Scanner in = new Scanner(System.in);                            // scanner for input in tetris
        Rain color = new Rain();                                        // for using rainbow
        System.out.println(color.BOLD);
        System.out.println("Select one option");
        System.out.println("0. Exit the game");
        System.out.println("1. Start new game");
        System.out.println("2. Start saved game");
        System.out.println("3. Highscores");
        System.out.println("4. Settings");
        System.out.println(color.RESET);
        int option = in.nextInt();
        switch(option)
        {
            case 0:
                exitTetris();
                System.exit(0);
            case 1:
                playNewGame();
                break;
            case 2:
                playExistingGame();
                break;
            case 3:
                highscores();
                break;
            case 4: 
                settings();
                break;
            default:
                break;
        }

        in.close();
    }
    
    /**
     * This function will display the controls of the game
     * 
     * @return void
     **/
    private void displayControls()
    {
        Rain color = new Rain();
        System.out.println(color.BYELLOW);
        System.out.println("  $$$$$  $$$$$  $   $  $$$$$  $$$$   $$$$$  $      $$$$$  ");
        System.out.println("  $      $   $  $$  $    $    $   $  $   $  $      $      ");
        System.out.println("  $      $   $  $ $ $    $    $$$$   $   $  $      $$$$$  ");
        System.out.println("  $      $   $  $  $$    $    $  $   $   $  $          $  ");
        System.out.println("  $$$$$  $$$$$  $   $    $    $   $  $$$$$  $$$$$  $$$$$  ");

        System.out.println(color.BLGREEN);
        System.out.println("**********************************************************");
        System.out.println("*                                                        *");
        System.out.println("*           D/d     --      Shape will go right          *");
        System.out.println("*           A/a     --      Shape will go left           *");
        System.out.println("*           W/w     --      Shape will rotate            *");
        System.out.println("*           S/s     --      Shape will go down           *");
        System.out.println("*           G/g     --      Save the current game        *");
        System.out.println("*           Q/q     --      Quit the current game        *");
        System.out.println("*                                                        *");
        System.out.println("**********************************************************");
        System.out.println(color.RESET);
    }

    /**
     * This function will start a new tetris game
     * 
     * @return void
     **/
    private void playNewGame()
    {
        Scanner in = new Scanner(System.in);                                                    // scanner for input in tetris
        Rain color = new Rain();                                                                // for using rainbow
        try
        {
            //user data entry
            System.out.println(color.BOLD + "Enter the username" + color.RESET);
            String username = in.nextLine();                                                    // for entered username

            System.out.println(color.BOLD + "Create new password e.g: abcdef" + color.RESET);
            Console con = System.console();                                                     // used for taking password as an input
            char[] pass = con.readPassword();                                                   // reading password from the user
            String password = String.valueOf(pass);                                             // convert password to string
            
            //CHECKING PASSWORD VALIDITY
            if(username.equals(password))                                                       // check password cannot be same as username
            {
                throw new SameNamePasswordException("Password cannot be same as username");
            }
            else if(password.length() < 5)                                                      // check password length
            {
                throw new WrongPasswordException("Invalid length of the password");
            }
            else if(password.equals("abcdef"))                                                  // check password will not be same as password
            {
                throw new SameNamePasswordException("Make your own password don't use example");
            }

            MessageDigest digest = MessageDigest.getInstance("SHA-256");                        // create sha 256 hash algo instance
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));             // hash algo sha 256

            User user = new User(username,password,new Date(),hash,0);                          // created a new user
            
            System.out.println(color.BOLD+"Confirm password"+color.RESET);                      // confirming password
            char[] reenterpass = con.readPassword();                                            // reading password again
            String reenterpassword = String.valueOf(reenterpass);                               // convert password to string
            byte[] rehash = digest.digest(reenterpassword.getBytes(StandardCharsets.UTF_8));    // hash algo sha 256

            if(!user.matchPassword(rehash))                                                     // check password is right or not
            {
                throw new WrongPasswordException("Entered wrong password");
            }

            displayControls();                                                                  // displays the controls of the game        

            System.out.println("Enter the size of the board");                                  // getting desired size from the user
            int R = in.nextInt();                                                               // input number of rows
            int C = in.nextInt();                                                               // input number of cols
            
            if(R<10 || C<10 || R>100 || C>100)                                                  // input validation
            {
                throw new IndexOutofBoardException("Wrong Input Valid size should be 0-100");
            }

            Board board = new Board(R, C);                                                      // initialize the board size
            boolean flag_shape_fixed = false;                                                   // initial shape is now fixed
            int shape_counter = 0;                                                              // for counting and changing different shapes
            
            /**
             * MAKING 2D ARRAY FOR ROTATION
             * storing the rotation of different shapes
             *      0   1   2   3
             * 0 |  
             * 1 |
             * 2 |
             * 3 |
             * 4 |
             * 5 |
             * 6 |
             **/
            Shape[][] rotation = new Shape[7][4];                                               // array maintained for rotations of the shape
            rotation = makeRotationArray(rotation);                                             // making initial array for rotation

            int pivot = (C/2) - 1;                                                              // value for setting initial position of the shape
            // building the line blocks
            Block a = new Block(0, pivot);
            Block b = new Block(0, pivot+1);
            Block c = new Block(0, pivot+2);
            Block d = new Block(0, pivot+3);
            Shape LINE = new Shape(a, b, c, d, 0);                                              // created line shape intially with 0

            if(!board.insertShape(LINE))                                                        // insert initial shape on board if it is possible
            {
                System.out.println(color.BRED + "ERROR WHILE INSERTING THE SHAPE" + color.RESET);
                System.exit(0);
            }                                  
            board.printBoard();                                                                 // print the initial board
            System.out.println();
            
            flag_shape_fixed = false;                                                           // shape is fixed or not
            
            // GAME LOOPING
            while (true) 
            {
                board.clearboard();                                                             // clear board for above
                flag_shape_fixed = board.movedown(LINE);                                        // default move down

                if(flag_shape_fixed)                                                            // if flag shape cannot move down so making it fixed when it reach boundary
                {
                    board.insertFixedShape(LINE);                                               // insert the fixed shape on board
                    board.printBoard();                                                         // print the board
                    
                    if(shape_counter==6)                                                        // set shape counter to 0 when it becomes 6
                    {
                        shape_counter=0;
                    }
                    else
                    {
                        shape_counter++;
                    }
                    LINE = create_shape(LINE, shape_counter,pivot);                             // creating new shape for second move with current state 0

                    flag_shape_fixed=false;                                                     // set shape fixed to false for next shape
                }

                System.out.println("ENTER THE OPTION");                                         // displaying the options
                System.out.println("D/d -- right");                                             // right option
                System.out.println("A/a -- left");                                              // left option
                System.out.println("W/w -- rotate");                                            // rotate option
                System.out.println("S/s -- down");                                              // down option
                System.out.println("G/g -- save");                                              // save option
                System.out.println("Q/q -- quit");                                              // quit game option

                char ans = in.next().charAt(0);                                                 // filter single char from the string

                switch(ans)
                {
                    case 'D':
                    case 'd':
                        board.moveright(LINE);
                        break;
                    case 'A':
                    case 'a':
                        board.moveleft(LINE);
                        break;
                    case 'W':
                    case 'w':
                        {
                            //rotation of shape
                            int currentstate = LINE.getcurrentstate();
                            if(currentstate >= 3)
                            {
                                currentstate=0;
                            }
                            else
                            {
                                currentstate++;
                            }
                            // System.out.println(LINE);
                            System.out.println("CURRENTSTATE: " +currentstate);

                            int ex = LINE.getarrofblock()[0].getX() + rotation[shape_counter][currentstate].getarrofblock()[0].getX();
                            int ey = LINE.getarrofblock()[0].getY() + rotation[shape_counter][currentstate].getarrofblock()[0].getY();
                            int fx = LINE.getarrofblock()[1].getX() + rotation[shape_counter][currentstate].getarrofblock()[1].getX();
                            int fy = LINE.getarrofblock()[1].getY() + rotation[shape_counter][currentstate].getarrofblock()[1].getY();
                            int gx = LINE.getarrofblock()[2].getX() + rotation[shape_counter][currentstate].getarrofblock()[2].getX();
                            int gy = LINE.getarrofblock()[2].getY() + rotation[shape_counter][currentstate].getarrofblock()[2].getY();
                            int hx = LINE.getarrofblock()[3].getX() + rotation[shape_counter][currentstate].getarrofblock()[3].getX();
                            int hy = LINE.getarrofblock()[3].getY() + rotation[shape_counter][currentstate].getarrofblock()[3].getY();
                            Block e = null;
                            Block f = null;
                            Block g = null;
                            Block h = null;
                            
                            if( board.checkValidCoords(ex, ey) && board.checkValidCoords(fx, fy) && board.checkValidCoords(gx, gy) && board.checkValidCoords(hx, hy))
                            {
                                e = new Block(ex,ey);
                                f = new Block(fx,fy);
                                g = new Block(gx,gy);
                                h = new Block(hx,hy);
                            }
                            else
                            {
                                ex = LINE.getarrofblock()[0].getX();
                                ey = LINE.getarrofblock()[0].getY();
                                fx = LINE.getarrofblock()[1].getX();
                                fy = LINE.getarrofblock()[1].getY();
                                gx = LINE.getarrofblock()[2].getX();
                                gy = LINE.getarrofblock()[2].getY();
                                hx = LINE.getarrofblock()[3].getX();
                                hy = LINE.getarrofblock()[3].getY();
                                e = new Block(ex,ey);
                                f = new Block(fx,fy);
                                g = new Block(gx,gy);
                                h = new Block(hx,hy);
                                System.out.println("SORRY INVALID ROTATION !!!");
                            }
                            LINE = new Shape(e,f,g,h,currentstate);
                        }
                        break;
                    case 'g':
                    case 'G':
                        saveGame(user,board,LINE,shape_counter);
                        saveTetris();
                        System.exit(0);
                        break;
                    case 'q':
                    case 'Q':
                        System.exit(0);
                        break;
                    default:
                        break;
                }

                if(!board.insertShape(LINE))                            // insert initial shape on board if it is possible
                {
                    // System.out.println(color.BRED + "MAIN GAME OVER !!!" + color.RESET);
                    endTetris();
                    System.exit(0);
                }                                                       // insert shape on board
                board.printBoard();                                     // print board
                System.out.println();
            }
        }
        catch(Exception e)
        {
            System.out.println(color.BRED + e + color.RESET);
        }
        finally
        {
            in.close();
        }
    }

    /**
     * This function will save the game and save game variables
     * 
     * @param U for User data
     * @param B for Board
     **/
    private void saveGame(User U,Board B,Shape LINE,int shape_counter)
    {
        System.out.println("SAVED:"+LINE.getcurrentstate());
        try
        {   
            String filename = "db/"+U.getUserId()+".txt";
            
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();

            BufferedWriter geeks_out1 = new BufferedWriter(new FileWriter(file));           // open the file for output
            
            for(int i=0;i<4;i++)                                                            // saving line coords
            {
                int x = LINE.getarrofblock()[i].getX();
                int y = LINE.getarrofblock()[i].getY();
                geeks_out1.write(x +";"+y+";");
            }
            geeks_out1.write("\n~\n");                                                      // char for flags
            geeks_out1.write(LINE.getcurrentstate()+";"+shape_counter+";\n-\n");

            //check for limit
            int limit = B.getUpperLimit();                                                  // get upperlimit
            System.out.println(limit);
            int R = B.getRows();                                                            // get board rows
            int C = B.getCols();                                                            // get board cols
            
            if(limit!=-1)                                                                   // if fixed blocks exists only save then
            {
                for(int i=limit;i<R;i++)                                                    // storing the array
                {
                    for(int j=0;j<C;j++)
                    {
                        if(B.getARR()[i][j]!=' ')
                        {
                            geeks_out1.write(B.getARR()[i][j]+";");
                        }
                        else
                        {
                            geeks_out1.write(";");
                        }
                        if(j==C-1)
                        {
                            geeks_out1.write("\n");
                        }
                    }
                }
            }
            geeks_out1.write("=\n" + R +";"+ C +";\n");
            //saving user info
            geeks_out1.write("usr\n");
            geeks_out1.write(U.getName()+";"+U.getDate()+";"+U.getPassHash()+";");
            geeks_out1.flush();                                                 // flush  the stream
            geeks_out1.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }

    /*************************************************
     *              SHAPES IN THE GAME               *
     *                                               *                    
     *                   LINE  0                     *
     *                   # # # #                     *
     *                                               *
     *                   SQUARE 1                    *
     *                   # #                         *
     *                   # #                         *
     *                                               *
     *                   LR SHAPE 2                  *
     *                   #                           *
     *                   #                           *
     *                   # #                         *
     *                                               *
     *                   LL SHAPE 3                  *
     *                     #                         *
     *                     #                         *
     *                   # #                         *
     *                                               *
     *                   T SHAPE 4                   *
     *                   # # #                       *
     *                     #                         *
     *                                               *
     *                   ZL SHAPE 5                  *
     *                   # #                         *
     *                     # #                       *
     *                                               *
     *                   ZR SHAPE 6                  *
     *                     # #                       *
     *                   # #                         *
     *************************************************/

    /**
     * This function will create initial shapes
     * 
     * @param sh for shape
     * @param num integer for shapeno
     * @param pivot for initial position of the shape
     * 
     * @return the build shape
     **/
    private Shape create_shape(Shape sh,int num,int pivot)
    {
        switch(num)
        {
            case 0:
                //LINE SHAPE
                sh.getarrofblock()[0].setX(1);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(1);
                sh.getarrofblock()[1].setY(pivot+1);
                sh.getarrofblock()[2].setX(1);
                sh.getarrofblock()[2].setY(pivot+2);
                sh.getarrofblock()[3].setX(1);
                sh.getarrofblock()[3].setY(pivot+3);
                break;
            case 1:
                //SQUARE SHAPE
                sh.getarrofblock()[0].setX(1);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(1);
                sh.getarrofblock()[1].setY(pivot+1);
                sh.getarrofblock()[2].setX(2);
                sh.getarrofblock()[2].setY(pivot);
                sh.getarrofblock()[3].setX(2);
                sh.getarrofblock()[3].setY(pivot+1);
                break;
            case 2:
                //LR SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(3);
                sh.getarrofblock()[1].setY(pivot);
                sh.getarrofblock()[2].setX(4);
                sh.getarrofblock()[2].setY(pivot);
                sh.getarrofblock()[3].setX(4);
                sh.getarrofblock()[3].setY(pivot+1);
                break;
            case 3:
                //LL SHAPE
                sh.getarrofblock()[0].setX(2);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(3);
                sh.getarrofblock()[1].setY(pivot);
                sh.getarrofblock()[2].setX(4);
                sh.getarrofblock()[2].setY(pivot);
                sh.getarrofblock()[3].setX(4);
                sh.getarrofblock()[3].setY(pivot-1);
                break;
            case 4:
                //T SHAPE
                sh.getarrofblock()[0].setX(1);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(1);
                sh.getarrofblock()[1].setY(pivot+1);
                sh.getarrofblock()[2].setX(1);
                sh.getarrofblock()[2].setY(pivot+2);
                sh.getarrofblock()[3].setX(2);
                sh.getarrofblock()[3].setY(pivot+1);
                break;
            case 5:
                //ZL SHAPE
                sh.getarrofblock()[0].setX(1);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(1);
                sh.getarrofblock()[1].setY(pivot+1);
                sh.getarrofblock()[2].setX(2);
                sh.getarrofblock()[2].setY(pivot+1);
                sh.getarrofblock()[3].setX(2);
                sh.getarrofblock()[3].setY(pivot+2);
                break;
            case 6:
                //ZR SHAPE
                sh.getarrofblock()[0].setX(1);
                sh.getarrofblock()[0].setY(pivot);
                sh.getarrofblock()[1].setX(1);
                sh.getarrofblock()[1].setY(pivot+1);
                sh.getarrofblock()[2].setX(2);
                sh.getarrofblock()[2].setY(pivot-1);
                sh.getarrofblock()[3].setX(2);
                sh.getarrofblock()[3].setY(pivot);
                break;
            default:
                System.exit(0);

        }
        sh.setcurrentstate(0);
        return sh;
    }

    /**
     * This function will make the rotation array
     * 
     * @param rotation array for rotating the shapes
     * @return shapes array
     **/
    private Shape[][] makeRotationArray(Shape[][] rotation)
    {
        //initial shapes of the block
        Block e = new Block(0,0);
        Block f = new Block(0,0);
        Block g = new Block(0,0);
        Block h = new Block(0,0);

        //LINE SHAPE 0      --
        e = new Block(-2,-1);
        f = new Block(-1,0);
        g = new Block(0,1);
        h = new Block(1,2);
        rotation[0][0] = new Shape(e,f,g,h,0);
        e = new Block(-1,1);
        f = new Block(0,0);
        g = new Block(1,-1);
        h = new Block(2,-2);
        rotation[0][1] = new Shape(e,f,g,h,1);
        e = new Block(1,2);
        f = new Block(0,1);
        g = new Block(-1,0);
        h = new Block(-2,-1);
        rotation[0][2] = new Shape(e,f,g,h,2);
        e = new Block(2,-2);
        f = new Block(1,-1);
        g = new Block(0,0);
        h = new Block(-1,1);
        rotation[0][3] = new Shape(e,f,g,h,3);
        
        //SQUARE SHAPE 1    --
        e = new Block(0,0);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(0,0);
        rotation[1][0] = new Shape(e,f,g,h,0);
        rotation[1][1] = new Shape(e,f,g,h,1);
        rotation[1][2] = new Shape(e,f,g,h,2);
        rotation[1][3] = new Shape(e,f,g,h,3);

        //LR SHAPE 2    --
        e = new Block(-2,0);
        f = new Block(-1,-1);
        g = new Block(0,-2);
        h = new Block(1,-1);
        rotation[2][0] = new Shape(e,f,g,h,0);
        
        e = new Block(1,2);
        f = new Block(0,1);
        g = new Block(-1,0);
        h = new Block(0,-1);
        rotation[2][1] = new Shape(e,f,g,h,1);
        
        e = new Block(1,0);
        f = new Block(0,1);
        g = new Block(-1,2);
        h = new Block(-2,1);
        rotation[2][2] = new Shape(e,f,g,h,2);
        
        e = new Block(0,-2);
        f = new Block(1,-1);
        g = new Block(2,0);
        h = new Block(1,1);
        rotation[2][3] = new Shape(e,f,g,h,3);

        // LL SHAPE 3   --
        e = new Block(0,2);
        f = new Block(1,1);
        g = new Block(2,0);
        h = new Block(1,-1);
        rotation[3][0] = new Shape(e,f,g,h,0);

        e = new Block(2,0);
        f = new Block(1,-1);
        g = new Block(0,-2);
        h = new Block(-1,-1);
        rotation[3][1] = new Shape(e,f,g,h,1);

        e = new Block(0,-2);
        f = new Block(-1,-1);
        g = new Block(-2,0);
        h = new Block(-1,1);
        rotation[3][2] = new Shape(e,f,g,h,2);
        
        e = new Block(-2,0);
        f = new Block(-1,1);
        g = new Block(0,2);
        h = new Block(1,1);
        rotation[3][3] = new Shape(e,f,g,h,3);

        // T SHAPE 4    --
        e = new Block(-2, 0);
        f = new Block(-1, 1);
        g = new Block(0, 2);
        h = new Block(0, 0);
        rotation[4][0] = new Shape(e,f,g,h,0);

        e = new Block(0, 2);
        f = new Block(1, 1);
        g = new Block(2, 0);
        h = new Block(0, 0);
        rotation[4][1] = new Shape(e,f,g,h,1);

        e = new Block(2, 0);
        f = new Block(1, -1);
        g = new Block(0, -2);
        h = new Block(0, 0);
        rotation[4][2] = new Shape(e,f,g,h,2);

        e = new Block(0, -2);
        f = new Block(-1, -1);
        g = new Block(-2, 0);
        h = new Block(0, 0);
        rotation[4][3] = new Shape(e,f,g,h,3);

        // ZL SHAPE 5
        e = new Block(-2, 0);
        f = new Block(-1, 1);
        g = new Block(0, 0);
        h = new Block(1, 1);
        rotation[5][0] = new Shape(e,f,g,h,0);

        e = new Block(0, 2);
        f = new Block(1, 1);
        g = new Block(0, 0);
        h = new Block(1,-1);
        rotation[5][1] = new Shape(e,f,g,h,1);

        e = new Block(2, 0);
        f = new Block(1,-1);
        g = new Block(0, 0);
        h = new Block(-1,-1);
        rotation[5][2] = new Shape(e,f,g,h,2);

        e = new Block(0,-2);
        f = new Block(-1, -1);
        g = new Block(0, 0);
        h = new Block(-1,1);
        rotation[5][3] = new Shape(e,f,g,h,3);

        // ZR SHAPE 6
        e = new Block(-1, 1);
        f = new Block(0, 2);
        g = new Block(-1, -1);
        h = new Block(0, 0);
        rotation[6][0] = new Shape(e,f,g,h,0);

        e = new Block(1, 1);
        f = new Block(2, 0);
        g = new Block(-1, 1);
        h = new Block(0, 0);
        rotation[6][1] = new Shape(e,f,g,h,1);

        e = new Block(1, -1);
        f = new Block(0, -2);
        g = new Block(1, 1);
        h = new Block(0, 0);
        rotation[6][2] = new Shape(e,f,g,h,2);

        e = new Block(-1, -1);
        f = new Block(-2, 0);
        g = new Block(1, -1);
        h = new Block(0, 0);
        rotation[6][3] = new Shape(e,f,g,h,3);
        
        return rotation;
    }

    /**
     * This function will start the existing saved games
     **/
    private void playExistingGame()
    {

    }

    /**
     * This function will display the highscores
     **/
    private void highscores()
    {
        // class ScoreCard
        // {
        //     private int UserId;
        //     private String name;
        //     private int points;

        //     public ScoreCard(String name,int points,int userid)
        //     {
        //         this.name = name;
        //         this.points = points;
        //         this.UserId = userid;
        //     }
        // }
        // ArrayList<ScoreCard> list = new ArrayList<ScoreCard>();

        // ScoreCard card = new ScoreCard(user.getName(),points,user.getUserId());
        // list.add(card);
    }

    /**
     * This function will handle settings
     **/
    private void settings()
    {
        
    }
}