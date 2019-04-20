import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import RAINBOW.*;
import java.text.*;
public class Tetris
{
    private Highscore scorelist = new Highscore();                          // created highscore object for storing highscores
    
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
     * New tetris game is created 
     * @param envcolor for changing environment color
     **/
    public Tetris(String envcolor)
    {
        Rain color = new Rain();
        System.out.println(envcolor);
        System.out.println("#####  #####  #####  ####   #####  #####");
        System.out.println("  #    #        #    #   #    #    #    ");
        System.out.println("  #    ####     #    ####     #    #####");
        System.out.println("  #    #        #    #  #     #        #");
        System.out.println("  #    #####    #    #   #  #####  #####");
        System.out.println(color.RESET);
    }

    /**
     * This function will be display GAME OVER when game ends
     * @param envcolor for setting logo color
     * @return void
     **/
    private void endTetris(String envcolor)
    {
        Rain color = new Rain();
        System.out.println(envcolor);
        System.out.println("##### ##### ##### #####  ##### #       # ##### #####");
        System.out.println("#     #   # # # # #      #   #  #     #  #     #   #");
        System.out.println("#  ## ##### # # # ####   #   #   #   #   ####  #####");
        System.out.println("#   # #   # #   # #      #   #    # #    #     #  # ");
        System.out.println("##### #   # #   # #####  #####     #     ##### #   #");
        System.out.println(color.RESET);
    }

    /**
     * This function displays the banner of game exited
     * @param envcolor for setting logo color
     * @return void
     **/
    private void exitTetris(String envcolor)
    {
        Rain color = new Rain();
        System.out.println(envcolor);
        System.out.println("&&&&& &&&&& &&&&& &&&&&  &&&&& &   & & &&&&& &&&&& &&&& ");
        System.out.println("&     &   & & & & &      &      & &  &   &   &     &   &");
        System.out.println("&  && &&&&& & & & &&&&   &&&&    &   &   &   &&&&  &   &");
        System.out.println("&   & &   & &   & &      &      & &  &   &   &     &   &");
        System.out.println("&&&&& &   & &   & &&&&&  &&&&& &   & &   &   &&&&& &&&& ");
        System.out.println(color.RESET);
    }

    /**
     * This function displays the banner of save game
     * @param envcolor for setting logo color 
     * @return void
     **/
    private void saveTetris(String envcolor)
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
     * This function will display the controls of the game
     * @param envcolor for setting logo color
     * @return void
     **/
    private void displayControls(String envcolor)
    {
        Rain color = new Rain();
        System.out.println(envcolor);
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
     * This function will display the banner of the settings
     * @param envcolor for printing the specific color
     **/
    private void settingTetris()
    {
        Rain color = new Rain();
        System.out.println(color.BYELLOW);
        System.out.println(" $$$$$ $$$$$ $$$$$ $$$$$ $ $   $ $$$$$ $$$$$ ");
        System.out.println(" $     $       $     $   $ $$  $ $     $     ");
        System.out.println(" $$$$$ $$$$    $     $   $ $ $ $ $  $$ $$$$$ ");
        System.out.println("     $ $       $     $   $ $  $$ $   $     $ ");
        System.out.println(" $$$$$ $$$$$   $     $   $ $   $ $$$$$ $$$$$ ");
        System.out.print(color.RESET);
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
        try
        {
            int option = in.nextInt();
            switch(option)
            {
                case 0:
                    exitTetris(color.BDGREEN);
                    System.exit(0);
                case 1:
                    playNewGame();
                    break;
                case 2:
                    playExistingGame();
                    break;
                case 3:
                    scorelist.displayHighScore();
                    break;
                case 4: 
                    settings();
                    break;
                default:
                    throw new InvalidOptionException("Invalid Option entered by the user");
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println(color.BRED+e+"\nInvalid Option entered by the user"+color.RESET);
        }
        catch(Exception e)
        {
            System.out.println(color.BRED+e+color.RESET);
        }
        finally
        {
            in.close();
        }
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
            if(scorelist.checkDuplicateHighScoreName(username))                                 // check for duplicate name in highscore list
            {
                throw new DuplicateNameException("User Name cannot be duplicate");
            }
            else if(User.checkSpecialCharUsername(username))                                    // check if special char in username
            {
                throw new InvalidOptionException("User Name cannot contain special characters");
            }

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
            
            BigInteger hashno = new BigInteger(1,hash);
            String passhash = hashno.toString(16);                                              // make sha 256 password string
            while (passhash.length() < 32) { 
                passhash = "0" + passhash; 
            } 

            System.out.println(color.BOLD+"Confirm password"+color.RESET);                      // confirming password
            char[] reenterpass = con.readPassword();                                            // reading password again from console
            String reenterpassword = String.valueOf(reenterpass);                               // convert char array to string
            byte[] rehash = digest.digest(reenterpassword.getBytes(StandardCharsets.UTF_8));    // hash algo sha 256
            hashno = new BigInteger(1,rehash);
            String passrehash = hashno.toString(16);
            while (passrehash.length() < 32) { 
                passrehash = "0" + passrehash; 
            } 
            // System.out.println(passhash);
            // System.out.println(passrehash);

            User user = new User(username,password,new Date(),passhash,0);                          // created a new user

            if(!user.matchPassword(passrehash))                                                     // check password is right or not
            {
                throw new WrongPasswordException("Entered wrong password");
            }        

            System.out.println("Enter the size of the board in format i.e 20 20");              // getting desired size from the user
            int R = in.nextInt();                                                               // input number of rows
            int C = in.nextInt();                                                               // input number of cols
            
            if(R<10 || C<10 || R>100 || C>100)                                                  // input validation
            {
                throw new IndexOutofBoardException("Wrong Input Valid size should be 0-100");
            }

            //the main game
            Board board = new Board(R, C);                                                      // initialize the board size
            boolean flag_shape_fixed = false;                                                   // initial shape is now fixed
            int shape_counter = 0;                                                              // for counting and changing different shapes

            displayControls(board.getControlsColor());                                          // displays the controls of the game

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
                        //set the score scored from board to user
                        int score = board.getPoints();
                        user.setUserScore(score);

                        saveGame(user,board,LINE,shape_counter);

                        scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());
                        
                        scorelist.saveHighScore();
                        
                        saveTetris(board.getGameSavedColor());
                        System.exit(0);
                        break;
                    case 'q':
                    case 'Q':
                        exitTetris(board.getGameExitedColor());
                        System.exit(0);
                        break;
                    default:
                        break;
                }

                if(!board.insertShape(LINE))                            // insert initial shape on board if it is possible means game finished
                {
                    // System.out.println(color.BRED + "MAIN GAME OVER !!!" + color.RESET);
                    endTetris(board.getGameOverColor());

                    //set the score scored from board to user
                    int score = board.getPoints();
                    user.setUserScore(score);
                    
                    scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());
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
        /**
         * walia gaurav|Wed Apr 17 21:00:07 IST 2019|1|44104fcaef8476724152090d6d7bd9afa8ca5b385f6a99d3c6cf36b943b9872d|0|
         * 6|9|7|9|8|9|8|8|
         * 0|3|
         * 20|20|
         * [1;33m|[1;37m|[1;37m|[0m|[1;31m|[2m|[1;36m|[1;33m|[1;35m|
         *  | | | | | | | | | | | |@|@|@|@|@|@|@|@|
         *  | | | | | | | | | | | |@| |@|@| | | | |
         *  | | | | | | | | | | | |@| | | | | | | |
         **/
        // System.out.println("SAVED:"+LINE.getcurrentstate());
        try
        {   
            String filename = "db/"+U.getUserId()+".txt";                                   // create new filename
            
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();                                                           // create new file if not present

            BufferedWriter geeks_out1 = new BufferedWriter(new FileWriter(file));           // open the file for output
            
            /**
             * saving user info
             **/
            geeks_out1.write(U.getName()+"|"+U.getDate()+"|"+U.getUserId()+"|"+U.getPassHash()+"|"+U.getUserScore()+"|\n");

            for(int i=0;i<4;i++)                                                            // saving line coords
            {
                int x = LINE.getarrofblock()[i].getX();
                int y = LINE.getarrofblock()[i].getY();
                geeks_out1.write(x +"|"+y+"|");
            }
            geeks_out1.write("\n");                                                         
            geeks_out1.write(LINE.getcurrentstate()+"|"+shape_counter+"|\n");               // saving current state and shape counter

            //check for limit
            int limit = B.getUpperLimit();                                                  // get upperlimit
            int R = B.getRows();                                                            // get board rows
            int C = B.getCols();                                                            // get board cols
            
            geeks_out1.write(R +"|"+ C +"|\n");                                             // saving rows and cols of current board
            
            //saving env variables
            String[] envcolors = B.getENV();

            for(int i=0;i<envcolors.length;i++)
            {
                geeks_out1.write(envcolors[i]+"|");
            }
            geeks_out1.write("\n");

            if(limit!=-1)                                                                   // if fixed blocks exists only save then
            {
                for(int i=R-1;i>=limit;i--)                                                 // storing the array
                {
                    for(int j=0;j<C;j++)
                    {
                        // if(B.getARR()[i][j]!=' ')
                        // {
                        //     geeks_out1.write(B.getARR()[i][j]+"|");
                        // }
                        // else
                        // {
                        //     geeks_out1.write("|");
                        // }
                        geeks_out1.write(B.getARR()[i][j]+"|");
                        if(j==C-1)
                        {
                            geeks_out1.write("\n");
                        }
                    }
                }
            }
            
            geeks_out1.flush();                                                             // flush  the stream
            geeks_out1.close();

            //save id of the user in tetris.java
            File savefile = new File("tetris.txt");
            BufferedWriter out = new BufferedWriter(new FileWriter(savefile));
            out.write(U.getUserId()+"");                                                    // store user id to tetris.txt in string format
            out.close();
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
     * This function will return the sha 25 6 of a string
     * 
     * @param password for input pasword in char array
     * 
     * @return string sha256 hash
     **/
    private String getSHA256(char[] password)
    {
        String passhash = "";
        try
        {
            String str = String.valueOf(password);
            MessageDigest digest = MessageDigest.getInstance("SHA-256");                        // create sha 256 hash algo instance
            byte[] bytearr = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            BigInteger hashno = new BigInteger(1,bytearr);
            passhash = hashno.toString(16);                                              // make sha 256 password string
            while (passhash.length() < 32) { 
                passhash = "0" + passhash; 
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return passhash;
    }


    /**
     * This function will start the existing saved games
     * check for password
     * then read files
     **/
    private void playExistingGame()
    {
        Scanner in = new Scanner(System.in);                                                // scanner for user inputs
        System.out.println("Enter the old username:");
        String name = in.nextLine();                                                        // user name for verification
        
        int userid = scorelist.findIndexOfUser(name);                                       // collect id from the highscores
        
        if(userid == -1)                                                                    // if user is not present in highscores
        {
            System.out.println("Sorry you haven't saved a game with this username yet...");
            in.close();
            return;   
        }

        String filename = "db/" + userid +".txt";                                                   // create new file name
        File file = new File(filename);                                                             // create new file structure
        
        if(!file.exists())                                                                          // check if userid file is present or not
        {
            System.out.println("Sorry your application is broken please reset the game");
            in.close();
            return;
        }

        User oldUser = null;                                                                        // user for starting existing game
        Board board = null;                                                                         // board created for existing game
        Block a=null;
        Block b=null;
        Block c=null;
        Block d=null;
        Shape LINE = null;                                                                          // LINE for initial shape position
        int R=-1;                                                                                   // rows of the board
        int C=-1;                                                                                   // cols of the board
        int shape_counter=-1;                                                                       // shape counter

        BufferedReader br=null;
        try
        {
            //PASSWORD CHECKING
            Console input = System.console();
            if(input==null)
            {
                System.out.println("no console available");
            }
            System.out.println("Enter your password");
            char[] consolepassword = input.readPassword();
            String passhash = getSHA256(consolepassword);
            
            // READING THE USER PASSHASH
            BufferedReader read = new BufferedReader(new FileReader(file));
            String string=read.readLine();                                                          // reading the first user line for getting password hash
            String[] arr = string.split("[|]");
            read.close();
            
            if(!passhash.equals(arr[3]))                                                            // compare arr[3]/hash in file and passhash entered by the user
            {
                throw new WrongPasswordException("Entered wrong password, recover it in settings");
            }
            
            System.out.println("GOOD TO GO");
            
            //PARSING USER ID FILE
            int linecounter=1;                                                                      // variable for line counting while parsing
            br = new BufferedReader(new FileReader(file));
            int rowCount=0;
            while((string=br.readLine())!=null)
            {
                switch(linecounter)                                                                 // taking switch for parsing lines
                {
                    case 1:                                                                         // LINE 1: parse user information
                        {
                            String[] parsed = string.split("[|]");                                  
                            /**
                             * parsed[0]    ->  username
                             * parsed[1]    ->  date
                             * parsed[2]    ->  userid
                             * parsed[3]    ->  passhash
                             * parsed[4]    ->  user score
                             */
                            // creating date from parsed[1] string
                            String strdate = parsed[1].substring(0, 19) + parsed[1].substring(23,parsed[1].length());
                            DateFormat df = new SimpleDateFormat("E MMM dd HH:mm:ss yyyy");
                            Date dat = df.parse(strdate);
                            
                            oldUser = new User(parsed[0],String.valueOf(consolepassword),dat,parsed[3],Integer.parseInt(parsed[4]));
                        }
                        break;
                    case 2:                                                                         // LINE 2: parse block's current location
                        {
                            String[] parsed = string.split("[|]");
                            /**
                             * SHAPE COORDS
                             * parsed[0]    parsed[1]
                             * parsed[2]    parsed[3]
                             * parsed[4]    parsed[5]
                             * parsed[6]    parsed[7]
                             **/
                            a = new Block(Integer.parseInt(parsed[0]), Integer.parseInt(parsed[1]));
                            b = new Block(Integer.parseInt(parsed[2]), Integer.parseInt(parsed[3]));
                            c = new Block(Integer.parseInt(parsed[4]), Integer.parseInt(parsed[5]));
                            d = new Block(Integer.parseInt(parsed[6]), Integer.parseInt(parsed[7]));
                        }
                        break;
                    case 3:                                                                         // LINE3: parse for current position of shape
                        {
                            String[] parsed = string.split("[|]");
                            /**
                             * parsed[0]    ->  currentstate
                             * parsed[1]    ->  shapecounter
                             **/
                            LINE = new Shape(a, b, c, d, Integer.parseInt(parsed[0]));              // created line shape intially with 0
                            shape_counter = Integer.parseInt(parsed[1]);                            // set current shape counter for game
                        }
                        break;
                    case 4:                                                                         // LINE 4: storing board size
                        {
                            String[] parsed = string.split("[|]");
                            R = Integer.parseInt(parsed[0]);                                        // setting rows of the board
                            C = Integer.parseInt(parsed[1]);                                        // setting cols of the board
                            board = new Board(R,C);                                                 // create a new board
                            rowCount = R-1;
                        }
                        break;
                    case 5:                                                                         // LINE 5: storing env variables
                        {
                            String[] parsed = string.split("[|]");
                            board.setENV(parsed.clone());                                           // set environment variables of the user
                        }
                        break;
                    default:                                                                        // LINE >= 6 storing the board
                        if(linecounter >=6)
                        {
                            String[] parsed = string.split("[|]");
                            for(int i=0;i<C;i++)
                            {
                                board.getARR()[rowCount][i] = parsed[i].charAt(0);
                            }
                            rowCount--;
                        }    
                    break;
                }
                linecounter++;
            }
            br.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        //the main game
        // Board board = new Board(R, C);                                                      // initialize the board size
        boolean flag_shape_fixed = false;                                                   // initial shape is now fixed
        // int shape_counter = 0;                                                              // for counting and changing different shapes

        displayControls(board.getControlsColor());                                          // displays the controls of the game

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
        // Block a = new Block(0, pivot);
        // Block b = new Block(0, pivot+1);
        // Block c = new Block(0, pivot+2);
        // Block d = new Block(0, pivot+3);
        // Shape LINE = new Shape(a, b, c, d, 0);                                              // created line shape intially with 0

        if(!board.insertShape(LINE))                                                        // insert initial shape on board if it is possible
        {
            Rain color = new Rain();
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
                    //set the score scored from board to user
                    // int score = board.getPoints();
                    // user.setUserScore(score);    

                    // saveGame(user,board,LINE,shape_counter);

                    // scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());
                    
                    // scorelist.saveHighScore();
                    
                    // saveTetris(board.getGameSavedColor());
                    // System.exit(0);
                    break;
                case 'q':
                case 'Q':
                    exitTetris(board.getGameExitedColor());
                    System.exit(0);
                    break;
                default:
                    break;
            }

            if(!board.insertShape(LINE))                            // insert initial shape on board if it is possible means game finished
            {
                // System.out.println(color.BRED + "MAIN GAME OVER !!!" + color.RESET);
                endTetris(board.getGameOverColor());

                //set the score scored from board to user
                // int score = board.getPoints();
                // user.setUserScore(score);
                
                // scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());
                System.exit(0);
            }                                                       // insert shape on board
            board.printBoard();                                     // print board
            System.out.println();
        }   
    }

    /**
     * This function will handle settings
     **/
    private void settings()
    {
        Rain color = new Rain();
        settingTetris();
        System.out.println(color.BOLD);
        System.out.println("---------------------------------------------");
        System.out.println("Enter one option:");
        System.out.println("0. Exit");
        System.out.println("1. Change Default Environment Variables");
        System.out.println("2. Change User's Environment Variables");
        System.out.println("3. Collect Information of the user");
        System.out.println("4. Compare two users");
        System.out.println("5. Delete the old user");
        System.out.println("6. Reset all users and highscores");
        System.out.println("7. Delete all History");
        System.out.println("8. Reset user password");
        System.out.println(color.RESET);
        Scanner in = new Scanner(System.in);
        try
        {
            int option= in.nextInt();
            switch(option)
            {
                case 0:
                    exitTetris(color.BRED);
                    System.exit(0);
                    break;
                case 1:
                    break;
                case 2: 
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6: 
                    break;
                case 7:
                    break;
                default:
                    throw new InvalidOptionException("Invalid Settings Option entered by the user");
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println(color.BRED+e+"\nInvalid Settings Option entered by the user"+color.RESET);
        }
        catch(Exception e)
        {
            System.out.println(color.BRED+e+color.RESET);
        }
        finally
        {
            in.close();
        }
    }
}