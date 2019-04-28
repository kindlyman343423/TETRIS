import java.io.*;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;
import RAINBOW.*;
import java.text.*;
public class Tetris
{
    private Highscore scorelist = new Highscore();                                                      // created highscore object for storing highscores
    
    /**
     * New tetris game is created 
     **/
    public Tetris()
    {
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
        System.out.println(envcolor);
        System.out.println("#####  #####  #####  ####   #####  #####");
        System.out.println("  #    #        #    #   #    #    #    ");
        System.out.println("  #    ####     #    ####     #    #####");
        System.out.println("  #    #        #    #  #     #        #");
        System.out.println("  #    #####    #    #   #  #####  #####");
        System.out.println(color.RESET);
    }

    /**
     * This function will be display GAME OVER when game overs
     * @param envcolor for setting logo color
     * @return void
     **/
    private void endTetris(String envcolor)
    {
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
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
        Scanner in = new Scanner(System.in);                                                            // scanner for input in tetris
        Rain color = new Rain();                                                                        // use of rainbow package class for displaying colors on terminal
        System.out.println(color.BOLD);
        System.out.println("Select one option");
        System.out.println("0. Exit the game");                                                         // this option will exist the game
        System.out.println("1. Start new game");                                                        // it will start new game for new user
        System.out.println("2. Start saved game");                                                      // start old game of the user
        System.out.println("3. Highscores");                                                            // display highscores
        System.out.println("4. Settings");                                                              // display the settings
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
        Scanner in = new Scanner(System.in);                                                            // scanner for input in tetris
        Rain color = new Rain();                                                                        // for using rainbow
        try
        {
            //user data entry
            System.out.println(color.BOLD + "Enter the username" + color.RESET);
            String username = in.nextLine();                                                            // for entered username
            if(scorelist.checkDuplicateHighScoreName(username))                                         // check for duplicate name in highscore list
            {
                throw new DuplicateNameException("User Name cannot be duplicate");
            }
            else if(User.checkSpecialCharUsername(username))                                            // check if special char in username
            {
                throw new InvalidOptionException("User Name cannot contain special characters");
            }

            System.out.println(color.BOLD + "Create new password e.g: abcdef" + color.RESET);
            Console con = System.console();                                                             // used for taking password as an input
            char[] pass = con.readPassword();                                                           // reading password from the user
            String password = String.valueOf(pass);                                                     // convert password to string
            
            //CHECKING PASSWORD VALIDITY
            if(username.equals(password))                                                               // check password cannot be same as username
            {
                throw new SameNamePasswordException("Password cannot be same as username");
            }
            else if(password.length() < 5)                                                              // check password length
            {
                throw new WrongPasswordException("Invalid length of the password");
            }
            else if(password.equals("abcdef"))                                                          // check password will not be same as password
            {
                throw new SameNamePasswordException("Make your own password don't use example");
            }

            MessageDigest digest = MessageDigest.getInstance("SHA-256");                                // create sha 256 hash algo instance
            byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));                     // hash algo sha 256
            
            BigInteger hashno = new BigInteger(1,hash);
            String passhash = hashno.toString(16);                                                      // make sha 256 password string
            while (passhash.length() < 32) { 
                passhash = "0" + passhash; 
            } 

            System.out.println(color.BOLD+"Confirm password"+color.RESET);                              // confirming password
            char[] reenterpass = con.readPassword();                                                    // reading password again from console
            String reenterpassword = String.valueOf(reenterpass);                                       // convert char array to string
            byte[] rehash = digest.digest(reenterpassword.getBytes(StandardCharsets.UTF_8));            // hash algo sha 256
            hashno = new BigInteger(1,rehash);
            String passrehash = hashno.toString(16);
            while (passrehash.length() < 32) { 
                passrehash = "0" + passrehash; 
            } 

            User user = new User(username,password,new Date(),passhash,0);                              // created a new user

            if(!user.matchPassword(passrehash))                                                         // check password is right or not
            {
                throw new WrongPasswordException("Entered wrong password");
            }        

            System.out.println("Enter the size of the board in format i.e 20 20");                      // getting desired size from the user
            int R = in.nextInt();                                                                       // input number of rows
            int C = in.nextInt();                                                                       // input number of cols
            
            if(R<10 || C<10 || R>100 || C>100)                                                          // input validation
            {
                throw new IndexOutofBoardException("Wrong Input Valid size should be 0-100");
            }

            //the main game
            Board board = new Board(R, C);                                                              // initialize the board size
            boolean flag_shape_fixed = false;                                                           // initial shape is now fixed
            int shape_counter = 0;                                                                      // for counting and changing different shapes

            displayControls(board.getControlsColor());                                                  // displays the controls of the game

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
            Shape[][] rotation = new Shape[7][4];                                                       // array maintained for rotations of the shape
            rotation = makeRotationArray(rotation);                                                     // making initial array for rotation

            int pivot = (C/2) - 1;                                                                      // value for setting initial position of the shape
            // building the line blocks
            Block a = new Block(0, pivot);
            Block b = new Block(0, pivot+1);
            Block c = new Block(0, pivot+2);
            Block d = new Block(0, pivot+3);
            Shape LINE = new Shape(a, b, c, d, 0);                                                      // created line shape intially with 0

            if(!board.insertShape(LINE))                                                                // insert initial shape on board if it is possible
            {
                System.out.println(color.BRED + "ERROR WHILE INSERTING THE SHAPE" + color.RESET);
                System.exit(0);
            }                                  
            board.printBoard();                                                                         // print the initial board
            System.out.println();
            
            flag_shape_fixed = false;                                                                   // shape is fixed or not
            
            // GAME LOOPING
            while (true) 
            {
                board.clearboard();                                                                     // clear board for above
                flag_shape_fixed = board.movedown(LINE);                                                // default move down

                if(flag_shape_fixed)                                                                    // if flag shape cannot move down so making it fixed when it reach boundary
                {
                    board.insertFixedShape(LINE);                                                       // insert the fixed shape on board
                    board.printBoard();                                                                 // print the board
                    
                    if(shape_counter==6)                                                                // set shape counter to 0 when it becomes 6
                    {
                        shape_counter=0;
                    }
                    else
                    {
                        shape_counter++;
                    }
                    LINE = create_shape(LINE, shape_counter,pivot);                                     // creating new shape for second move with current state 0

                    flag_shape_fixed=false;                                                             // set shape fixed to false for next shape
                }

                System.out.println("ENTER THE OPTION");                                                 // displaying the options
                System.out.println("D/d -- right");                                                     // right option
                System.out.println("A/a -- left");                                                      // left option
                System.out.println("W/w -- rotate");                                                    // rotate option
                System.out.println("S/s -- down");                                                      // down option
                System.out.println("G/g -- save");                                                      // save option
                System.out.println("Q/q -- quit");                                                      // quit game option
                
                char ans = in.next().charAt(0);                                                         // filter single char from the string

                switch(ans)
                {
                    case 'D':
                    case 'd':
                        board.moveright(LINE);                                                          // this function will move the shape to right
                        break;
                    case 'A':
                    case 'a':
                        board.moveleft(LINE);                                                           // this function will move the shape to left
                        break;
                    case 'W':
                    case 'w':
                        {
                            //rotation of shape
                            int currentstate = LINE.getcurrentstate();                                  // get current state of the shape
                            if(currentstate >= 3)
                            {
                                currentstate=0;
                            }
                            else
                            {
                                currentstate++;
                            }
                            // System.out.println(LINE);
                            // System.out.println("CURRENTSTATE: " +currentstate);

                            // MAKE NEW COORDS FOR THE SHAPE FROM ROTATION ARRAY
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
                            
                            if( board.checkValidCoords(ex, ey) && board.checkValidCoords(fx, fy) && board.checkValidCoords(gx, gy) 
                            && board.checkValidCoords(hx, hy))                                          // check for all valid coords
                            {
                                e = new Block(ex,ey);
                                f = new Block(fx,fy);
                                g = new Block(gx,gy);
                                h = new Block(hx,hy);
                            }
                            else                                                                        // else set old coords
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
                            LINE = new Shape(e,f,g,h,currentstate);                                     // update the rotated shape
                        }
                        break;
                    case 'g':
                    case 'G':
                        int score = board.getPoints();                                                  // get the socre from the board
                        user.setUserScore(score);                                                       // set the score from board to user

                        saveGame(user,board,LINE,shape_counter);                                        // save the game

                        scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());    // add highscore to the highscore list
                        
                        scorelist.saveHighScore();                                                      // save the highscore
                        
                        saveTetris(board.getGameSavedColor());                                          // display the SAVED TETRIS on screen
                        System.exit(0);                                                                 // exit the game
                        break;
                    case 'q':
                    case 'Q':
                        exitTetris(board.getGameExitedColor());                                         // display exit tetris on game
                        System.exit(0);
                        break;
                    default:
                        break;
                }

                if(!board.insertShape(LINE))                                                            // insert initial shape on board if it is possible means game finished
                {
                    endTetris(board.getGameOverColor());                                                // display END TETRIS on screen

                    //set the score scored from board to user
                    int score = board.getPoints();                                                      // get the current score from the baord
                    user.setUserScore(score);                                                           // set the user score
                    
                    scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());        // add the highscore to the highscore list
                    System.exit(0);
                }
                board.printBoard();                                                                     // print board
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
         * FILE SAVING FORMAT
         * 
         * walia gaurav|Wed Apr 17 21:00:07 IST 2019|1|44104fcaef8476724152090d6d7bd9afa8ca5b385f6a99d3c6cf36b943b9872d|0|
         * 6|9|7|9|8|9|8|8|
         * 0|3|
         * 20|20|
         * [1;33m|[1;37m|[1;37m|[0m|[1;31m|[2m|[1;36m|[1;33m|[1;35m|
         *  | | | | | | | | | | | |@|@|@|@|@|@|@|@|
         *  | | | | | | | | | | | |@| |@|@| | | | |
         *  | | | | | | | | | | | |@| | | | | | | |
         **/
        try
        {   
            String filename = "db/"+U.getUserId()+".txt";                                               // create new filename
            
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();                                                                       // create new file if not present

            BufferedWriter geeks_out1 = new BufferedWriter(new FileWriter(file));                       // open the file for output
            
            /**
             * saving user info
             **/
            geeks_out1.write(U.getName()+"|"+U.getDate()+"|"+U.getUserId()+"|"+U.getPassHash()+"|"+U.getUserScore()+"|\n");

            for(int i=0;i<4;i++)                                                                        // saving line coords
            {
                int x = LINE.getarrofblock()[i].getX();
                int y = LINE.getarrofblock()[i].getY();
                geeks_out1.write(x +"|"+y+"|");
            }
            geeks_out1.write("\n");                                                         
            geeks_out1.write(LINE.getcurrentstate()+"|"+shape_counter+"|\n");                           // saving current state and shape counter

            //check for limit
            int limit = B.getUpperLimit();                                                              // get upperlimit
            int R = B.getRows();                                                                        // get board rows
            int C = B.getCols();                                                                        // get board cols
            
            geeks_out1.write(R +"|"+ C +"|\n");                                                         // saving rows and cols of current board
            
            //saving env variables
            String[] envcolors = B.getENV();                                                            // getting board env color array

            for(int i=0;i<envcolors.length;i++)                                                         // write the board env variables in file
            {
                geeks_out1.write(envcolors[i]+"|");
            }
            geeks_out1.write("\n");

            if(limit!=-1)                                                                               // if fixed blocks exists only save then
            {
                for(int i=R-1;i>=limit;i--)                                                             // storing the board array
                {
                    for(int j=0;j<C;j++)
                    {
                        geeks_out1.write(B.getARR()[i][j]+"|");                                         // store the array one by one
                        if(j==C-1)
                        {
                            geeks_out1.write("\n");
                        }
                    }
                }
            }
            
            geeks_out1.flush();                                                                         // flush  the stream
            geeks_out1.close();                                                                         // close the file stream

            //SAVE ID OF THE USER IN tetris.txt
            File savefile = new File("tetris.txt");                                                     // open the tetris.txt file
            BufferedWriter out = new BufferedWriter(new FileWriter(savefile));
            out.write(U.getUserId()+"");                                                                // store user id to tetris.txt in string format
            out.close();                                                                                // close the tetris.txt file
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
     * @implSpec WARNING DON'T CHANGE THIS FUNCTION AS ROTATION OF SHAPE WILL NOT OCCUR IF U CHANGE IT
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

        //LINE SHAPE 0
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
        
        //SQUARE SHAPE 1
        e = new Block(0,0);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(0,0);
        rotation[1][0] = new Shape(e,f,g,h,0);
        rotation[1][1] = new Shape(e,f,g,h,1);
        rotation[1][2] = new Shape(e,f,g,h,2);
        rotation[1][3] = new Shape(e,f,g,h,3);

        //LR SHAPE 2
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

        // LL SHAPE 3
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

        // T SHAPE 4
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
     * This function will return the sha 256 of a string
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
            MessageDigest digest = MessageDigest.getInstance("SHA-256");                                // create sha 256 hash algo instance
            byte[] bytearr = digest.digest(str.getBytes(StandardCharsets.UTF_8));
            BigInteger hashno = new BigInteger(1,bytearr);
            passhash = hashno.toString(16);                                                             // make sha 256 password string
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
        Scanner in = new Scanner(System.in);                                                            // scanner for user inputs
        Rain color = new Rain();

        try
        {
            System.out.println("Enter the old username:");
            String name = in.nextLine();                                                                // user name for verification
            
            int userid = scorelist.findIndexOfUser(name);                                               // collect id from the highscores
            
            if(userid == -1)                                                                            // if user is not present in highscores
            {
                throw new InvalidOptionException("Sorry you haven't saved a game with this username yet...");
            }

            String filename = "db/" + userid +".txt";                                                   // create new file name
            File file = new File(filename);                                                             // create new file structure
        
            if(!file.exists())                                                                          // check if userid file is present or not
            {
                throw new InvalidOptionException("Sorry your application is broken please reset the game");
            }

            //DECLARE VARIABLES FOR THE GAME PLAY
            User oldUser = null;                                                                        // user for starting existing game
            Board board = null;                                                                         // board created for existing game
            Block a=null;                                                                               // block created for making a shape
            Block b=null;                                                                               // block created for making a shape
            Block c=null;                                                                               // block created for making a shape
            Block d=null;                                                                               // block created for making a shape
            Shape LINE = null;                                                                          // LINE for initial shape position
            int R=-1;                                                                                   // rows of the board
            int C=-1;                                                                                   // cols of the board
            int shape_counter=-1;                                                                       // shape counter

            //PASSWORD CHECKING
            Console input = System.console();
            if(input==null)
            {
                throw new IllegalStateException("no console available");
            }
            System.out.println("Enter your password");
            char[] consolepassword = input.readPassword();                                              // read the password from the console
            String passhash = getSHA256(consolepassword);                                               // encrypt the password
            
            // READING THE USER PASSHASH
            BufferedReader read = new BufferedReader(new FileReader(file));
            String string=read.readLine();                                                              // reading the first user line for getting password hash
            String[] arr = string.split("[|]");
            read.close();
            
            if(!passhash.equals(arr[3]))                                                                // compare arr[3]/hash in file and passhash entered by the user
            {
                throw new WrongPasswordException("Entered wrong password, recover it in settings");
            }
            
            System.out.println("GOOD TO GO");
            
            //PARSING USER ID FILE
            int linecounter=1;                                                                          // variable for line counting while parsing
            BufferedReader br = new BufferedReader(new FileReader(file));
            int rowCount=0;
            while((string=br.readLine())!=null)
            {
                switch(linecounter)                                                                     // taking switch for parsing lines
                {
                    case 1:                                                                             // LINE 1: parse user information
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
                            
                            oldUser = new User(parsed[0],String.valueOf(consolepassword),dat,Integer.parseInt(parsed[2]),parsed[3],Integer.parseInt(parsed[4]));
                        }
                        break;
                    case 2:                                                                             // LINE 2: parse block's current location
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
                    case 3:                                                                             // LINE3: parse for current position of shape
                        {
                            String[] parsed = string.split("[|]");
                            /**
                             * parsed[0]    ->  currentstate
                             * parsed[1]    ->  shapecounter
                             **/
                            LINE = new Shape(a, b, c, d, Integer.parseInt(parsed[0]));                  // created line shape intially with 0
                            shape_counter = Integer.parseInt(parsed[1]);                                // set current shape counter for game
                        }
                        break;
                    case 4:                                                                             // LINE 4: storing board size
                        {
                            String[] parsed = string.split("[|]");
                            R = Integer.parseInt(parsed[0]);                                            // setting rows of the board
                            C = Integer.parseInt(parsed[1]);                                            // setting cols of the board
                            board = new Board(R,C);                                                     // create a new board
                            rowCount = R-1;
                        }
                        break;
                    case 5:                                                                             // LINE 5: storing env variables
                        {
                            String[] parsed = string.split("[|]");
                            board.setENV(parsed.clone());                                               // set environment variables of the user
                        }
                        break;
                    default:                                                                            // LINE >= 6 storing the board
                        if(linecounter >=6)
                        {
                            String[] parsed = string.split("[|]");
                            for(int i=0;i<C;i++)
                            {
                                board.getARR()[rowCount][i] = parsed[i].charAt(0);                      // insert data of baord from file
                            }
                            rowCount--;
                        }
                        board.countFixedLines();                                                        // count fixed blocks in all lines 
                    break;
                }
                linecounter++;
            }
            br.close();
        
            //START THE MAIN GAME
            boolean flag_shape_fixed = false;                                                           // initial shape is now fixed

            displayControls(board.getControlsColor());                                                  // displays the controls of the game

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
            Shape[][] rotation = new Shape[7][4];                                                       // array maintained for rotations of the shape
            rotation = makeRotationArray(rotation);                                                     // making initial array for rotation

            int pivot = (C/2) - 1;                                                                      // value for setting initial position of the shape
            // building the line blocks
            // Block a = new Block(0, pivot);
            // Block b = new Block(0, pivot+1);
            // Block c = new Block(0, pivot+2);
            // Block d = new Block(0, pivot+3);
            // Shape LINE = new Shape(a, b, c, d, 0);                                                   // created line shape intially with 0

            if(!board.insertShape(LINE))                                                                // insert initial shape on board if it is possible
            {
                System.out.println(color.BRED + "ERROR WHILE INSERTING THE SHAPE" + color.RESET);
                System.exit(0);
            }                                  
            board.printBoard();                                                                         // print the initial board
            System.out.println();
            
            flag_shape_fixed = false;                                                                   // shape is fixed or not
            
            // GAME LOOPING
            while (true) 
            {
                board.clearboard();                                                                     // clear board for above
                flag_shape_fixed = board.movedown(LINE);                                                // default move down

                if(flag_shape_fixed)                                                                    // if flag shape cannot move down so making it fixed when it reach boundary
                {
                    board.insertFixedShape(LINE);                                                       // insert the fixed shape on board
                    board.printBoard();                                                                 // print the board
                    
                    if(shape_counter==6)                                                                // set shape counter to 0 when it becomes 6
                    {
                        shape_counter=0;
                    }
                    else
                    {
                        shape_counter++;
                    }
                    LINE = create_shape(LINE, shape_counter,pivot);                                     // creating new shape for second move with current state 0

                    flag_shape_fixed=false;                                                             // set shape fixed to false for next shape
                }

                System.out.println("ENTER THE OPTION");                                                 // displaying the options
                System.out.println("D/d -- right");                                                     // right option
                System.out.println("A/a -- left");                                                      // left option
                System.out.println("W/w -- rotate");                                                    // rotate option
                System.out.println("S/s -- down");                                                      // down option
                System.out.println("G/g -- save");                                                      // save option
                System.out.println("Q/q -- quit");                                                      // quit game option

                char ans = in.next().charAt(0);                                                         // filter single char from the string

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
                            int currentstate = LINE.getcurrentstate();                                  // get and update current state of the block
                            if(currentstate >= 3)
                            {
                                currentstate=0;
                            }
                            else
                            {
                                currentstate++;
                            }

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
                            LINE = new Shape(e,f,g,h,currentstate);                                                 // create new rotated shape
                        }
                        break;
                    case 'g':
                    case 'G':
                        // set the score scored from board to user
                        int score = board.getPoints() + oldUser.getUserScore();                                     // get user old score and update it
                        oldUser.setUserScore(score);                                                                // set new highscore to the user

                        saveGame(oldUser,board,LINE,shape_counter);

                        scorelist.removeHighScore(oldUser.getName(),oldUser.getUserId(),oldUser.getUserScore());    // remove old highscore of the user from the highscore list
                        scorelist.addHighScore(oldUser.getName(),oldUser.getUserId(),oldUser.getUserScore());       // add new highscore of the user to the list
                        
                        scorelist.saveHighScore();                                                                  // save the user highscore to the userfile
                        
                        saveTetris(board.getGameSavedColor());                                                      // display GAME SAVED on board
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

                if(!board.insertShape(LINE))                                                                        // insert initial shape on board if it is possible means game finished
                {
                    endTetris(board.getGameOverColor());

                    //set the score scored from board to user
                    int score = board.getPoints() + oldUser.getUserScore();                                         // get user old score and update it
                    oldUser.setUserScore(score);
                    
                    scorelist.removeHighScore(oldUser.getName(),oldUser.getUserId(),oldUser.getUserScore());        // remove old highscore of the user from the highscore list
                    scorelist.addHighScore(oldUser.getName(),oldUser.getUserId(),oldUser.getUserScore());
                    System.exit(0);
                }                                                                                                   // insert shape on board
                board.printBoard();                                                                                 // print board
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
     * This function will handle settings and exceptions
     * 
     * @return void
     **/
    private void settings()
    {
        Rain color = new Rain();                                                // for using colors on terminal
        settingTetris();
        System.out.println(color.BOLD);
        System.out.println("---------------------------------------------");
        System.out.println("Enter one option:");
        System.out.println("0. Exit");
        System.out.println("1. Game Settings");
        System.out.println("2. User Settings");

        System.out.println(color.RESET);
        Scanner in = new Scanner(System.in);
        try
        {
            int option= in.nextInt();
            switch(option)
            {
                case 0:                                                         // exit the game
                    exitTetris(color.LGREEN);                                   // display GAME EXITED logo
                    System.exit(0);                                             // exit the game
                    break;
                case 1:                                                         // display game setting options
                    gameSettings();
                    break;
                case 2:                                                         // display user setting options
                    userSettings();
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

    /**
     * This function will show game settings and catching all options exceptions
     * 
     * @return void
     **/
    private void gameSettings()
    {
        Rain color = new Rain();
        Scanner in = new Scanner(System.in);
        System.out.println("GAME SETTINGS");
        System.out.println("Select one option");
        System.out.println("0. No change");
        System.out.println("1. Change User Interface");
        System.out.println("2. Reset the Default Environment Variables");
        System.out.println("3. Show game history");
        System.out.println("4. Delete all History");
        System.out.println("5. Reset the Tetris Game");
        try
        {
            int option = in.nextInt();
            switch(option)
            {
                case 0:
                    break;
                case 1:
                    changeDefaultEnVariables();                         // change User Interface
                    break;
                case 2:                                                 // reset the default variables
                    resetDefaultColors();
                    break;    
                case 3:                                                 // show user history
                    showHistory();
                    break;
                case 4:                                                 // delete all history
                    deleteHistory();
                    break;
                case 5:                                                 // reset all the game
                    resetAllGame();
                    break;
                default:
                    throw new InvalidOptionException("Invalid Game Settings option");
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println(color.BRED+e+"\nInvalid Game Settings option"+color.RESET);
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
     * This function will change the default environment variables of every new game. 
     * It changes colors of shape, board and game logos.
     * 
     * @throws exception
     * @return void
     **/
    private void changeDefaultEnVariables() throws Exception
    {
        Rain colors = new Rain();
        Scanner in = new Scanner(System.in);
        
        //READ DEFAULT.TXT TO env
        String[] env = new String[9];
        int envcounter=0;
        BufferedReader br = new BufferedReader(new FileReader("default.txt"));
        String str="";
        while((str = br.readLine())!=null)
        {
            String[] arr = str.split("[,]");
            env[envcounter++] = arr[0];
        }
        br.close();
        
        // ITERATE AND ASK USER FOR CHANGE
        for(int i=0;i<env.length;i++)
        {
            String result ="";
            switch(i)
            {
                case 0:
                    System.out.println("Do you want to change"+env[i]+ " default board color " + colors.RESET +"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 1:
                    System.out.println("Do you want to change"+env[i]+" default shape color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 2:
                    System.out.println("Do you want to change"+env[i]+" default fixed shape color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 3:
                    System.out.println("Do you want to change"+env[i]+" default background color "+colors.RESET+"(Y/N)");
                    result = changeDefaultBackgroundColors(in,env,i);       // change background colors
                    break;
                case 4:
                    System.out.println("Do you want to change"+env[i]+" default GAME OVER logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 5:
                    System.out.println("Do you want to change"+env[i]+" default GAME EXITED logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 6:
                    System.out.println("Do you want to change"+env[i]+" default GAME SAVED logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 7:
                    System.out.println("Do you want to change"+env[i]+" default CONTROLS logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
                case 8:
                    System.out.println("Do you want to change"+env[i]+" default HIGHSCORE logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                  // change the colors
                    break;
            }
            if(result.equals(env[i]))
            {
                System.out.println(colors.BRED+"No change occured !!!"+colors.RESET);
            }
            env[i] = result;                                                // update the array
        }

        // WRITE env to default.txt
        BufferedWriter bw = new BufferedWriter(new FileWriter("default.txt"));
        for(int i=0;i<env.length;i++)
        {
            bw.write(env[i]+"\n");
        }
        bw.close();
        in.close();
    }

    /**
     * This function will change the default background color of the game board
     * 
     * @param in for scanner
     * @param env for taking environment variables
     * @param index for changing the env variable
     * 
     * @exception thrown to changeDefaultEnVariables() method
     * @return string for changed color
     **/
    private String changeDefaultBackgroundColors(Scanner in,String[] env,int index) throws Exception
    {
        String backColor = env[index];
        Rain color = new Rain();
        char opt = in.next().charAt(0);
        if(opt=='Y')
        {
            System.out.println("Select one option");
            System.out.println("0. No Change");
            System.out.println("1. BGGREEN");
            System.out.println("2. BGRED");
            System.out.println("3. BGLGREEN");
            System.out.println("4. BGORANGE");
            System.out.println("5. BGLBLUE");
            System.out.println("6. BGPINK");
            System.out.println("7. BGDGREEN");
            System.out.println("8. BGWHITE");
            System.out.println("9. RESET");
            int option = in.nextInt();
            switch(option)
            {
                case 0:
                    break;
                case 1:
                    backColor = color.BGGREEN;
                    break;
                case 2:
                    backColor = color.BGRED;
                    break;
                case 3:
                    backColor = color.BGLGREEN;
                    break;
                case 4:
                    backColor = color.BGORANGE;
                    break;
                case 5:
                    backColor = color.BGLBLUE;
                    break;
                case 6:
                    backColor = color.BGPINK;
                    break;
                case 7:
                    backColor = color.BGDGREEN;
                    break;
                case 8:
                    backColor = color.BGWHITE;
                    break;
                case 9:
                    backColor = color.RESET;
                default:
                    in.close();
                    throw new InvalidOptionException("Invalid Background Color option");
            }
        }
        return backColor;
    }

    /**
     * This function will change the colors of the game
     * 
     * @param env for environment variables array
     * @param index for env variable index
     * 
     * @exception exceptions to changeDefaultEnVariables() method
     * 
     * @return string for changed environment color
     **/
    private String changeDefaultColors(Scanner in,String[] env,int index) throws Exception
    {
        Rain color = new Rain();
        String answer = env[index];
        char option = in.next().charAt(0);

        if(option=='Y')                             // changing color at the current index
        {
            System.out.println("Select one option");
            System.out.println("0. No change");
            System.out.println("1. DGREEN");
            System.out.println("2. BLACK");
            System.out.println("3. RED");
            System.out.println("4. LGREEN");
            System.out.println("5. YELLOW");
            System.out.println("6. BLUE");
            System.out.println("7. MAGENTA");
            System.out.println("8. CYAN");
            System.out.println("9. WHITE");
            System.out.println("10. Advanced settings");

            int opt = in.nextInt();
            switch(opt)
            {
                case 0:
                    break;
                case 1:
                    answer = color.DGREEN;
                    break;
                case 2:
                    answer = color.BLACK;
                    break;
                case 3:
                    answer = color.RED;
                    break;
                case 4:
                    answer = color.LGREEN;
                    break;
                case 5:
                    answer = color.YELLOW;
                    break;
                case 6:
                    answer = color.BLUE;
                    break;
                case 7:
                    answer = color.MAGENTA;
                    break;
                case 8:
                    answer = color.CYAN;
                    break;
                case 9:
                    answer = color.WHITE;
                    break;
                case 10:
                    answer = advancedDefaultColorChangeSettings(in,env,index);
                    break;
                default:
                    throw new InvalidOptionException("Invalid Color option");
            }
        }
        return answer;
    }

    /**
     * This function shows the advanced settings and return the color change done in this advanced colors.
     * 
     * @param in for scanner
     * @param env for environment variables array
     * @param index for environment varible index
     * 
     * @exception thrown to changeDefaultColors() method 
     * 
     * @return string for changed color
     **/
    private String advancedDefaultColorChangeSettings(Scanner in,String[] env,int index) throws Exception
    {   
        String advanceColor=env[index];
        Rain color = new Rain();
        System.out.println("Select one option");
        System.out.println("0. No change");
        System.out.println("1. RESET");
        System.out.println("2. BOLD");
        System.out.println("3. ITALIC");
        System.out.println("4. UNDERLINE");
        System.out.println("5. BDGREEN");
        System.out.println("6. IDGREEN");
        System.out.println("7. UDGREEN");
        System.out.println("8. BRED");
        System.out.println("9. IRED");
        System.out.println("10. URED");
        System.out.println("11. BLGREEN");
        System.out.println("12. ILGREEN");
        System.out.println("13. ULGREEN");
        System.out.println("14. BYELLOW");
        System.out.println("15. IYELLOW");
        System.out.println("16. UYELLOW");
        System.out.println("17. BBLUE");
        System.out.println("18. IBLUE");
        System.out.println("19. UBLUE");
        System.out.println("20. BMAGENTA");
        System.out.println("21. IMAGENTA");
        System.out.println("22. UMAGENTA");
        System.out.println("23. BCYAN");
        System.out.println("24. ICYAN");
        System.out.println("25. UCYAN");
        int option = in.nextInt();
        
        switch(option)
        {
            case 0:
                break;
            case 1:
                advanceColor = color.RESET;
                break;
            case 2:
                advanceColor = color.BOLD;
                break;
            case 3:
                advanceColor = color.ITALIC;
                break;
            case 4:
                advanceColor = color.UNDERLINE;
                break;
            case 5:
                advanceColor = color.BDGREEN;
                break;
            case 6:
                advanceColor = color.IDGREEN;
                break;
            case 7:
                advanceColor = color.UDGREEN;
                break;
            case 8:
                advanceColor = color.BRED;
                break;
            case 9:
                advanceColor = color.IRED;
                break;
            case 10:
                advanceColor = color.URED;
                break;
            case 11:
                advanceColor = color.BLGREEN;
                break;
            case 12:
                advanceColor = color.ILGREEN;
                break;
            case 13:
                advanceColor = color.ULGREEN;
                break;
            case 14:    
                advanceColor = color.BYELLOW;
                break;
            case 15:
                advanceColor = color.IYELLOW;
                break;
            case 16:
                advanceColor = color.UYELLOW;
                break;
            case 17:
                advanceColor = color.BBLUE;
                break;
            case 18:
                advanceColor = color.IBLUE;
                break;
            case 19:
                advanceColor = color.UBLUE;
                break;
            case 20:
                advanceColor = color.BMAGENTA;
                break;
            case 21:
                advanceColor = color.IMAGENTA;
                break;
            case 22:
                advanceColor = color.UMAGENTA;
                break;
            case 23:
                advanceColor = color.BCYAN;
                break;
            case 24:
                advanceColor = color.ICYAN;
                break;
            case 25:
                advanceColor = color.UCYAN;
                break;
            default:
                throw new InvalidOptionException("Invalid Advance option");
        }
        return advanceColor;
    }

    /**
     * This function will reset the default colors of the game board by deleting the default.txt file
     * 
     * @exception exception to gameSettings()
     **/
    private void resetDefaultColors() throws Exception
    {
        //delete the default.txt
        File file = new File("default.txt");
        if(!file.delete())
        {
            throw new InvalidOptionException("Game is error prone try reset the game in settings");
        }
    }

    private void showHistory()
    {

    }

    private void deleteHistory()
    {

    }

    private void resetAllGame()
    {

    }

    /**
     * This function will show the user settings and catching all exceptions in options
     **/
    private void userSettings()
    {
        Scanner in = new Scanner(System.in);
        Rain color = new Rain();
        System.out.println("USER SETTINGS");
        System.out.println("Select one option");
        System.out.println("0. No change");
        System.out.println("1. Show User Information");
        System.out.println("2. Verify the User"); 
        System.out.println("3. Change User's Environment Variables");
        System.out.println("4. Compare two users");
        System.out.println("5. Delete the old user");
        System.out.println("6. Reset/Recover user password");
        try
        {
            int option = in.nextInt();
            switch(option)
            {
                case 1:                                                 // show user information
                    showUserInfo();
                    break;
                case 2:
                    verifyUser(in);
                    break;
                case 3:                                                 // change user environment variables 
                    changeUserEnVariables();
                    break;
                case 4:                                                 // compare two users
                    compareTwoUsers();
                    break;
                case 5:                                                 // delete the old user
                    deleteOldUser();
                    break;
                case 6:                                                 // reset user password
                    resetUserPassword();
                    break;
                default:
                    throw new InvalidOptionException("Invalid user settings option");
            }
        }
        catch(InputMismatchException e)
        {
            System.out.println(color.BRED+e+"\nInvalid User Settings option"+color.RESET);
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
     * This function parses the user file and display
     * 
     * @exception thrown to userSettings()
     * @return void
     **/
    private void showUserInfo() throws Exception
    {
        Scanner in = new Scanner(System.in);
        String filename = verifyUser(in);                                                           // verify user name and password
        BufferedReader br = new BufferedReader(new FileReader(filename));                           // reading the userfile
        String str="";
        int linecount=1;                                                                            // variable for linecounter
        
        //DECLARE VARIABLES FOR THE GAME DISPLAY
        int rows=0;                                                                                 // for storing board rows
        int cols=0;                                                                                 // for storing board cols
        Board B = null;                                                                             // board created for displaying game
        Block a=null;                                                                               // block created for making a shape
        Block b=null;                                                                               // block created for making a shape
        Block c=null;                                                                               // block created for making a shape
        Block d=null;                                                                               // block created for making a shape
        Shape LINE = null;                                                                          // LINE for initial shape position
        int rowCount=0;
        String[] parse = null;                                                                      // string array for parsing
        while((str=br.readLine())!=null)                                                            // parsing line by line and display
        {
            switch(linecount)
            {
                case 1:
                    parse = str.split("[|]");
                    System.out.println("USER NAME: "+parse[0]);
                    System.out.println("USER ENTRY DATE: "+parse[1]);
                    System.out.println("USER ID: "+parse[2]);
                    System.out.println("USER SCORE: "+parse[4]);
                    break;
                case 2:
                    parse = str.split("[|]");
                    /**
                     * SHAPE COORDS
                     * parse[0]    parse[1]
                     * parse[2]    parse[3]
                     * parse[4]    parse[5]
                     * parse[6]    parse[7]
                     **/
                    a = new Block(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
                    b = new Block(Integer.parseInt(parse[2]), Integer.parseInt(parse[3]));
                    c = new Block(Integer.parseInt(parse[4]), Integer.parseInt(parse[5]));
                    d = new Block(Integer.parseInt(parse[6]), Integer.parseInt(parse[7]));
                    break;
                case 3:
                    parse = str.split("[|]");
                    /**
                     * parse[0]    ->  currentstate
                     * parse[1]    ->  shapecounter
                     **/
                    LINE = new Shape(a, b, c, d, Integer.parseInt(parse[0]));                       // created line shape intially
                    break;
                case 4:    
                    parse = str.split("[|]");
                    rows = Integer.parseInt(parse[0]);
                    cols = Integer.parseInt(parse[1]);
                    B = new Board(rows,cols);                                                       // initalize new board for display
                    rowCount = rows-1;                                                              // count rows for inserting board data
                    break;
                case 5:
                    {
                        String[] env = str.split("[|]");
                        B.setENV(env);                                                              // set new environment variables
                    }
                    break;
                default:
                    if(linecount >= 6)
                    {
                        parse = str.split("[|]");
                        for(int i=0;i<cols;i++)
                        {
                            B.getARR()[rowCount][i] = parse[i].charAt(0);                           // insert data of board from file
                        }
                        rowCount--;
                    }
                    break;
            }
            linecount++;
        }
        br.close();

        if(!B.insertShape(LINE))                                                                    // insert initial shape on board if it is possible
        {
            System.out.println("ERROR WHILE INSERTING THE SHAPE");
            System.exit(0);
        }                                  
        B.printBoard();                                                                             // print the initial board
        System.out.println();
    }

    /**
     * This function returns user filename after user verification
     * 
     * @exception exception to userSettings()
     * @return string for filename
     **/
    private String verifyUser(Scanner in) throws Exception
    {
        System.out.println("Enter the username you want to verify:");
        String name = in.nextLine();                                                                    // user name for verification
            
        int userid = scorelist.findIndexOfUser(name);                                                   // collect id from the highscores
            
        if(userid == -1)                                                                                // if user is not present in highscores
        {
            in.close();
            throw new InvalidOptionException("Sorry you haven't saved a game with this username yet...");
        }

        String filename = "db/" + userid +".txt";                                                       // create new file name
        File file = new File(filename);                                                                 // create new file structure
        
        if(!file.exists())                                                                              // check if userid file is present or not
        {
            in.close();
            throw new InvalidOptionException("Sorry your application is broken please reset the game");
        }

        //PASSWORD CHECKING
        Console input = System.console();
        if(input==null)
        {
            in.close();
            throw new IllegalStateException("no console available");
        }
        System.out.println("Enter your password");
        char[] consolepassword = input.readPassword();                                                  // read the password from the console
        String passhash = getSHA256(consolepassword);                                                   // encrypt the password
        
        // READING THE USER PASSHASH
        BufferedReader read = new BufferedReader(new FileReader(file));
        String string=read.readLine();                                                                  // reading the first user line for getting password hash
        String[] arr = string.split("[|]");
        read.close();
        
        if(!passhash.equals(arr[3]))                                                                    // compare arr[3]/hash in file and passhash entered by the user
        {
            in.close();
            throw new WrongPasswordException("Entered wrong password, recover it in settings");
        }

        return filename;
    }

    /**
     * This function will change the individual user environment colors
     * 
     * @exception exceptions userSettings()
     * @return void;
     **/
    private void changeUserEnVariables() throws Exception
    {
        Scanner in = new Scanner(System.in);                                                            // scanner for input
        String filename = verifyUser(in);                                                               // verify new user

        File tempfile = File.createTempFile("hello", ".tmp");                                           // create temp file

        // read and copy user userfile to tmp file
        BufferedReader br = new BufferedReader(new FileReader(filename));                               // read user file
        BufferedWriter bw = new BufferedWriter(new FileWriter(tempfile));                               // write the temp file
        String str="";
        int line=1;
        String[] env=null;
        while((str=br.readLine())!=null)
        {
            if(line==5)                                                                                 // extract user env variables from line 5
            {
                env = str.split("[|]");
            }
            bw.write(str+"\n");
            line++;
        }
        br.close();
        bw.close();

        
        Rain colors = new Rain();                                                                       // for colors on terminal

        for(int i=0;i<env.length;i++)
        {
            String result=env[i];                                                                       // store default variable
            switch(i)
            {
                case 0:
                    System.out.println("Do you want to change user's"+env[i]+ " default board color " + colors.RESET +"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 1:
                    System.out.println("Do you want to change user's"+env[i]+" default shape color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 2:
                    System.out.println("Do you want to change user's"+env[i]+" default fixed shape color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 3:
                    System.out.println("Do you want to change user's"+env[i]+" default background color "+colors.RESET+"(Y/N)");
                    result = changeDefaultBackgroundColors(in,env,i);                                   // change background colors
                    break;
                case 4:
                    System.out.println("Do you want to change user's"+env[i]+" default GAME OVER logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 5:
                    System.out.println("Do you want to change user's"+env[i]+" default GAME EXITED logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 6:
                    System.out.println("Do you want to change user's"+env[i]+" default GAME SAVED logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 7:
                    System.out.println("Do you want to change user's"+env[i]+" default CONTROLS logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
                case 8:
                    System.out.println("Do you want to change user's"+env[i]+" default HIGHSCORE logo color "+colors.RESET+"(Y/N)");
                    result = changeDefaultColors(in,env,i);                                             // change the colors
                    break;
            }
            if(result.equals(env[i]))                                                                   // if same environment variable found
            {
                System.out.println(colors.BRED+"No change occured !!!"+colors.RESET);
            }
            env[i] = result;                                                                            // update the env array
        }

        // copy temp file to userfile
        br = new BufferedReader(new FileReader(tempfile));                                              // open temp file for reading
        bw = new BufferedWriter(new FileWriter(filename));                                              // open user file for writing
        line=1;
        str="";
        while((str = br.readLine())!=null)
        {
            switch(line)
            {
                case 5:                                                                                 // change env array for line 5
                    for(int i=0;i<env.length;i++)
                    {
                        bw.write(env[i]+"|");
                    }
                    bw.write("\n");
                    break;
                default:
                    bw.write(str+"\n");
                    break;
            }
            line++;
        }
        br.close();
        bw.close();
        tempfile.delete();                                                                              // delete temp file
        in.close();
    }

    /**
     * This function will compare two users
     * 
     * @exception exception to userSettings()
     * @return void
     **/
    private void compareTwoUsers() throws Exception
    {
        Scanner in = new Scanner(System.in);                                                            // scanner for user input
        
        System.out.println("USER COMPARISON");
        System.out.println("Enter data of USER 1");
        String firstfile = verifyUser(in);                                                              // verify first username and password

        System.out.println("Enter data of USER 2");
        String secondfile = verifyUser(in);                                                             // verify second username and password

        if(firstfile.equals(secondfile))                                                                // check for 2 same user
        {
            throw new SameNamePasswordException("Comparsion with same user is not allowed");
        }
        System.out.print("comparing");

        Thread thread1 = new Thread(()->{                                                               // thread 1 for printing ...
            for(int i=0;i<20;i++)
            {
                try
                {
                    System.out.print(".");                                                              // print after 500 ms
                    Thread.sleep(500);
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
            }
            System.out.println();
        },"printthread");

        Thread thread2 = new Thread(()->{                                                               // thread for reading data from the files

            try
            {
                BufferedReader br1 = new BufferedReader(new FileReader(firstfile));                     // open first userfile
                String first = br1.readLine();
                String[] firstinfo = first.split("[|]");
                br1.close();
                BufferedReader br2 = new BufferedReader(new FileReader(secondfile));                    // open second userfile
                String second = br2.readLine();
                String[] secondinfo = second.split("[|]");
                br2.close();

                Thread.sleep(11000);

                // DISPLAY USER INFORMATION
                Rain color = new Rain();
                System.out.println();
                System.out.println(color.BLGREEN+"USER ID:\t\t"+color.RESET + firstinfo[2] +"\t\t\t\t\t"+secondinfo[2]);
                System.out.println(color.BLGREEN+"USERNAME:\t\t"+color.RESET+firstinfo[0] + "\t\t\t\t" + secondinfo[0]);
                System.out.println(color.BLGREEN+"ENTRY DATE:\t\t"+color.RESET+firstinfo[1] + "\t\t" + secondinfo[1]);
                System.out.println(color.BLGREEN+"SCORE:\t\t\t"+color.RESET+firstinfo[4] +"\t\t\t\t\t"+secondinfo[4]);

                System.out.println(color.BCYAN);
                if(Integer.parseInt(firstinfo[4]) > Integer.parseInt(secondinfo[4]))
                {
                    System.out.println(firstinfo[0] +" USER IS GOOD PLAYER THAN THE USER " + secondinfo[0]);
                }
                else if(Integer.parseInt(firstinfo[4]) < Integer.parseInt(secondinfo[4]))
                {
                    System.out.println(secondinfo[0] +" USER IS GOOD PLAYER THAN THE USER " + firstinfo[0]);
                }
                else
                {
                    System.out.println("BOTH THE USERS " +firstinfo[0]+" & "+secondinfo[0]+" ARE GOOD PLAYERS");
                }
                System.out.println(color.RESET);
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        },"calculate");
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();

        in.close();
    }

    private void deleteOldUser() throws Exception
    {

    }

    private void resetUserPassword() throws Exception
    {

    }
}