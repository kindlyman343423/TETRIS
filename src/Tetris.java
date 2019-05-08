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
        createHistoryFile();                                                                       
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
        createHistoryFile();                                                                            
    }

    /**
     * This function will create user tetris history file if not present for maintaining the history
     * 
     * @return void
     **/
    private void createHistoryFile()
    {
        try
        {
            File history = new File("history.txt");
            history.createNewFile();
        }
        catch(Exception e)
        {
            System.out.println("unpredictable stage !!!");
        }
    }

    /**
     * This function will be display GAME OVER when game overs
     * @param envcolor for setting logo color
     * @return void
     **/
    private void displayGameOverLogo(String envcolor)
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
    private void displayGameExitedLogo(String envcolor)
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
    private void displayGameSavedLogo(String envcolor)
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
    private void displaySettingLogo()
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
                    displayGameExitedLogo(color.BDGREEN);
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
     * This function will start a new tetris game for a new user
     * 
     * @return void
     **/
    private void playNewGame()
    {
        Scanner in = new Scanner(System.in);                                                            
        Rain color = new Rain();                                                                        // for using rainbow library
        try
        {
            System.out.println(color.BOLD + "Enter the username" + color.RESET);
            String username = in.nextLine();                                                            
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
            char[] charpass = con.readPassword();                                                       // reading password from the user
            String password = String.valueOf(charpass);                                                 // convert password to string
            
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

            System.out.println(color.BOLD+"Confirm password"+color.RESET);                              // confirming password
            char[] confirmcharpassword = con.readPassword();                                            // reading password again from console
            String repassword = String.valueOf(confirmcharpassword);                                    // convert char array to string
            if(!password.equals(repassword))                                                            // check password is right or not
            {
                throw new WrongPasswordException("Entered wrong password");
            }

            String passwordhash = getSHA256(charpass);
            User user = new User(username,password,new Date(),passwordhash,0);                          // created a new user

            System.out.println("Enter the size of the board in format i.e 20 20");                      // getting desired size from the user
            int ROWS = in.nextInt();                                                                    // input number of rows
            int COLS = in.nextInt();                                                                    // input number of cols
            
            if(ROWS<10 || COLS<10 || ROWS>100 || COLS>100)                                              // input validation
            {
                throw new IndexOutofBoardException("Wrong Input Valid size should be 0-100");
            }

            //the main game
            Board board = new Board(ROWS, COLS);                                                        // initialize the board size
            boolean flagShapeFixed = false;                                                             // initial shape is now fixed
            int shapeCounter = 0;                                                                       // for counting and changing different shapes

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
            final int ROTATION_ARRAY_COLS = 4;
            final int ROTATION_ARRAY_ROWS = 7;
            Shape[][] rotationArray = new Shape[ROTATION_ARRAY_ROWS][ROTATION_ARRAY_COLS];              // array maintained for rotations of the shape
            rotationArray = makeRotationArray(rotationArray);                                           // making initial array for rotation

            final int pivot = (COLS/2) - 1;                                                             // value for setting initial position of the shape
            
            /**
             * BUILDING LINE BLOCKS
             * 
             * MAKING INITIAL SHAPE
             * [][][][]
             **/
            final int INITIAL_ROW  = 0;                                                                 // for initial shape row
            final int INITIAL_COL1 = pivot;                                                             // for initial shape col1
            final int INITIAL_COL2 = pivot + 1;                                                         // for initial shape col2
            final int INITIAL_COL3 = pivot + 2;                                                         // for initial shape col3
            final int INITIAL_COL4 = pivot + 3;                                                         // for initial shape col4
            Block firstBlock    = new Block(INITIAL_ROW, INITIAL_COL1);
            Block secondBlock   = new Block(INITIAL_ROW, INITIAL_COL2);
            Block thirdBlock    = new Block(INITIAL_ROW, INITIAL_COL3);
            Block fourthBlock   = new Block(INITIAL_ROW, INITIAL_COL4);
            
            final int INITIAL_STATE = 0;
            Shape SHAPE = new Shape(firstBlock, secondBlock, thirdBlock, fourthBlock, INITIAL_STATE);   // created line shape intially with 0

            if(!board.insertShape(SHAPE))                                                               // insert initial shape on board if it is possible
            {
                System.out.println(color.BRED + "ERROR WHILE INSERTING THE SHAPE" + color.RESET);
                System.exit(0);
            }                                  

            board.printBoard();                                                                         // print the initial board
            flagShapeFixed = false;                                                                     // shape is not fixed
            
            // GAME LOOPING
            while (true) 
            {
                board.clearboard();                                                                     // clear board for above
                flagShapeFixed = board.movedown(SHAPE);                                                 // default move down

                if(flagShapeFixed)                                                                      // if flag shape cannot move down so making it fixed when it reach boundary
                {
                    board.insertFixedShape(SHAPE);                                                      // insert the fixed shape on board
                    board.printBoard();                                                                 // print the board
                    
                    if(shapeCounter==6)                                                                 // set shape counter to 0 when it becomes 6
                    {
                        shapeCounter=0;
                    }
                    else
                    {
                        shapeCounter++;
                    }
                    SHAPE = create_shape(SHAPE, shapeCounter,pivot);                                    // creating new shape for second move with current state 0

                    flagShapeFixed=false;                                                               // set shape fixed to false for next shape
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
                        board.moveright(SHAPE);                                                         // this function will move the shape to right
                        break;
                    case 'A':
                    case 'a':
                        board.moveleft(SHAPE);                                                          // this function will move the shape to left
                        break;
                    case 'W':
                    case 'w':
                        {
                            //rotation of shape
                            int currentstate = SHAPE.getcurrentstate();                                 // get current state of the shape
                            if(currentstate >= 3)
                            {
                                currentstate=0;
                            }
                            else
                            {
                                currentstate++;
                            }

                            // MAKE NEW COORDS FOR THE SHAPE FROM ROTATION ARRAY
                            int ex = SHAPE.getarrofblock()[0].getX() + rotationArray[shapeCounter][currentstate].getarrofblock()[0].getX();
                            int ey = SHAPE.getarrofblock()[0].getY() + rotationArray[shapeCounter][currentstate].getarrofblock()[0].getY();
                            int fx = SHAPE.getarrofblock()[1].getX() + rotationArray[shapeCounter][currentstate].getarrofblock()[1].getX();
                            int fy = SHAPE.getarrofblock()[1].getY() + rotationArray[shapeCounter][currentstate].getarrofblock()[1].getY();
                            int gx = SHAPE.getarrofblock()[2].getX() + rotationArray[shapeCounter][currentstate].getarrofblock()[2].getX();
                            int gy = SHAPE.getarrofblock()[2].getY() + rotationArray[shapeCounter][currentstate].getarrofblock()[2].getY();
                            int hx = SHAPE.getarrofblock()[3].getX() + rotationArray[shapeCounter][currentstate].getarrofblock()[3].getX();
                            int hy = SHAPE.getarrofblock()[3].getY() + rotationArray[shapeCounter][currentstate].getarrofblock()[3].getY();
                            Block e = null;
                            Block f = null;
                            Block g = null;
                            Block h = null;
                            
                            if( board.checkValidCoords(ex, ey) && board.checkValidCoords(fx, fy) && board.checkValidCoords(gx, gy) 
                            && board.checkValidCoords(hx, hy))                                          // check for all valid coordinates
                            {
                                e = new Block(ex,ey);
                                f = new Block(fx,fy);
                                g = new Block(gx,gy);
                                h = new Block(hx,hy);
                            }
                            else                                                                        // else set old coordinates
                            {
                                ex = SHAPE.getarrofblock()[0].getX();
                                ey = SHAPE.getarrofblock()[0].getY();
                                fx = SHAPE.getarrofblock()[1].getX();
                                fy = SHAPE.getarrofblock()[1].getY();
                                gx = SHAPE.getarrofblock()[2].getX();
                                gy = SHAPE.getarrofblock()[2].getY();
                                hx = SHAPE.getarrofblock()[3].getX();
                                hy = SHAPE.getarrofblock()[3].getY();
                                e = new Block(ex,ey);
                                f = new Block(fx,fy);
                                g = new Block(gx,gy);
                                h = new Block(hx,hy);
                                System.out.println("SORRY INVALID ROTATION !!!");
                            }
                            SHAPE = new Shape(e,f,g,h,currentstate);                                    // update the rotated shape
                        }
                        break;
                    case 'g':
                    case 'G':
                        int score = board.getPoints();                                                  // get the socre from the board
                        user.setUserScore(score);                                                       // set the score from board to user

                        saveGame(user,board,SHAPE,shapeCounter);                                        // save the game

                        scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());    // add highscore to the highscore list
                        
                        scorelist.saveHighScore();                                                      // save the highscore
                        
                        displayGameSavedLogo(board.getGameSavedColor());                                // display the SAVED TETRIS on screen
                        System.exit(0);                                                                 // exit the game
                        break;
                    case 'q':
                    case 'Q':
                        displayGameExitedLogo(board.getGameExitedColor());                              // display exit tetris on game
                        System.exit(0);
                        break;
                    default:
                        break;
                }

                if(!board.insertShape(SHAPE))                                                           // insert initial shape on board if it is possible means game finished
                {
                    displayGameOverLogo(board.getGameOverColor());                                     

                    //set the score scored from board to user
                    int score = board.getPoints();                                                      // get the current score from the baord
                    user.setUserScore(score);                                                           // set the user score
                    
                    scorelist.addHighScore(user.getName(),user.getUserId(),user.getUserScore());        // add the highscore to the highscore list
                    System.exit(0);
                }
                board.printBoard();                                                                 
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
     * @param user for User data
     * @param board for Board
     * @param SHAPE for shape
     * @param shapeCounter for shape counter
     **/
    private void saveGame(User user,Board board,Shape SHAPE,int shapeCounter)
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
            String filename = "db/"+user.getUserId()+".txt";                                            // create new filename
            
            File file = new File(filename);
            file.getParentFile().mkdirs();
            file.createNewFile();                                                                       // create new file if not present

            BufferedWriter out = new BufferedWriter(new FileWriter(file));                              // open the file for output
            
            /**
             * saving user info
             **/
            out.write(user.getName()+"|"+user.getDate()+"|"+user.getUserId()+"|"+user.getPassHash()+"|"+user.getUserScore()+"|\n");

            final int BLOCK_COUNT_IN_BLOCK = 4;
            for(int i=0;i<BLOCK_COUNT_IN_BLOCK;i++)                                                     // saving line coords
            {
                int xCoordinate = SHAPE.getarrofblock()[i].getX();
                int yCoordinate = SHAPE.getarrofblock()[i].getY();
                out.write(xCoordinate + "|" + yCoordinate + "|");
            }
            out.write("\n");                                                         
            out.write(SHAPE.getcurrentstate() + "|" + shapeCounter + "|\n");                            // saving current state and shape counter

            //check for limit
            int limit = board.getUpperLimit();                                                          // get upperlimit
            int ROWS = board.getRows();                                                                 // get board rows
            int COLS = board.getCols();                                                                 // get board cols
            
            out.write(ROWS +"|"+ COLS +"|\n");                                                          // saving rows and cols of current board
            
            //saving env variables
            String[] envcolors = board.getENV();                                                        // getting board env color array
            for(int i=0;i<envcolors.length;i++)                                                         // write the board env variables in file
            {
                out.write(envcolors[i]+"|");
            }
            out.write("\n");

            if(limit!=-1)                                                                               // if fixed blocks exists only save then
            {
                for(int i=ROWS-1;i>=limit;i--)                                                          // storing the board array
                {
                    for(int j=0;j<COLS;j++)
                    {
                        out.write(board.getARR()[i][j]+"|");                                            // store the array one by one
                        if(j==COLS-1)
                        {
                            out.write("\n");
                        }
                    }
                }
            }
            out.flush();                                                                                // flush  the stream
            out.close();                                                                                // close the file stream

            //SAVE ID OF THE USER IN tetris.txt
            File savefile = new File("tetris.txt");                                                     // open the tetris.txt file
            BufferedWriter outSaveFile = new BufferedWriter(new FileWriter(savefile));
            outSaveFile.write(user.getUserId()+"");                                                     // store user id to tetris.txt in string format
            outSaveFile.close();                                                                        // close the tetris.txt file
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
     *                   [][][][]                    *
     *                                               *
     *                   SQUARE 1                    *
     *                   [][]                        *
     *                   [][]                        *
     *                                               *
     *                   LR SHAPE 2                  *
     *                   []                          *
     *                   []                          *
     *                   [][]                        *
     *                                               *
     *                   LL SHAPE 3                  *
     *                     []                        *
     *                     []                        *
     *                   [][]                        *
     *                                               *
     *                   T SHAPE 4                   *
     *                   [][][]                      *
     *                     []                        *
     *                                               *
     *                   ZL SHAPE 5                  *
     *                   [][]                        *
     *                     [][]                      *
     *                                               *
     *                   ZR SHAPE 6                  *
     *                     [][]                      *
     *                   [][]                        *
     *************************************************/

    /**
     * This function will create initial shapes
     * WARNING: Don't change this function magic values it will destroy shape coordinates
     * 
     * @param SHAPE for shape
     * @param shapeno integer for shape number
     * @param pivot for initial position of the shape
     * 
     * @return the build shape
     **/
    private Shape create_shape(Shape SHAPE,int shapeno,int pivot)
    {
        switch(shapeno)
        {
            case 0:
                //LINE SHAPE
                SHAPE.getarrofblock()[0].setX(1);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(1);
                SHAPE.getarrofblock()[1].setY(pivot+1);
                SHAPE.getarrofblock()[2].setX(1);
                SHAPE.getarrofblock()[2].setY(pivot+2);
                SHAPE.getarrofblock()[3].setX(1);
                SHAPE.getarrofblock()[3].setY(pivot+3);
                break;
            case 1:
                //SQUARE SHAPE
                SHAPE.getarrofblock()[0].setX(1);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(1);
                SHAPE.getarrofblock()[1].setY(pivot+1);
                SHAPE.getarrofblock()[2].setX(2);
                SHAPE.getarrofblock()[2].setY(pivot);
                SHAPE.getarrofblock()[3].setX(2);
                SHAPE.getarrofblock()[3].setY(pivot+1);
                break;
            case 2:
                //LR SHAPE
                SHAPE.getarrofblock()[0].setX(2);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(3);
                SHAPE.getarrofblock()[1].setY(pivot);
                SHAPE.getarrofblock()[2].setX(4);
                SHAPE.getarrofblock()[2].setY(pivot);
                SHAPE.getarrofblock()[3].setX(4);
                SHAPE.getarrofblock()[3].setY(pivot+1);
                break;
            case 3:
                //LL SHAPE
                SHAPE.getarrofblock()[0].setX(2);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(3);
                SHAPE.getarrofblock()[1].setY(pivot);
                SHAPE.getarrofblock()[2].setX(4);
                SHAPE.getarrofblock()[2].setY(pivot);
                SHAPE.getarrofblock()[3].setX(4);
                SHAPE.getarrofblock()[3].setY(pivot-1);
                break;
            case 4:
                //T SHAPE
                SHAPE.getarrofblock()[0].setX(1);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(1);
                SHAPE.getarrofblock()[1].setY(pivot+1);
                SHAPE.getarrofblock()[2].setX(1);
                SHAPE.getarrofblock()[2].setY(pivot+2);
                SHAPE.getarrofblock()[3].setX(2);
                SHAPE.getarrofblock()[3].setY(pivot+1);
                break;
            case 5:
                //ZL SHAPE
                SHAPE.getarrofblock()[0].setX(1);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(1);
                SHAPE.getarrofblock()[1].setY(pivot+1);
                SHAPE.getarrofblock()[2].setX(2);
                SHAPE.getarrofblock()[2].setY(pivot+1);
                SHAPE.getarrofblock()[3].setX(2);
                SHAPE.getarrofblock()[3].setY(pivot+2);
                break;
            case 6:
                //ZR SHAPE
                SHAPE.getarrofblock()[0].setX(1);
                SHAPE.getarrofblock()[0].setY(pivot);
                SHAPE.getarrofblock()[1].setX(1);
                SHAPE.getarrofblock()[1].setY(pivot+1);
                SHAPE.getarrofblock()[2].setX(2);
                SHAPE.getarrofblock()[2].setY(pivot-1);
                SHAPE.getarrofblock()[3].setX(2);
                SHAPE.getarrofblock()[3].setY(pivot);
                break;
            default:
                System.exit(0);
        }
        SHAPE.setcurrentstate(0);
        return SHAPE;
    }

    /**
     * This function will make the rotation array
     * @implSpec WARNING DON'T CHANGE THIS FUNCTION AS ROTATION OF SHAPE WILL NOT OCCUR IF U CHANGE IT
     * 
     * @param rotationArray for rotating the shapes
     * 
     * @return shapes array
     **/
    private Shape[][] makeRotationArray(Shape[][] rotationArray)
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
        rotationArray[0][0] = new Shape(e,f,g,h,0);
        e = new Block(-1,1);
        f = new Block(0,0);
        g = new Block(1,-1);
        h = new Block(2,-2);
        rotationArray[0][1] = new Shape(e,f,g,h,1);
        e = new Block(1,2);
        f = new Block(0,1);
        g = new Block(-1,0);
        h = new Block(-2,-1);
        rotationArray[0][2] = new Shape(e,f,g,h,2);
        e = new Block(2,-2);
        f = new Block(1,-1);
        g = new Block(0,0);
        h = new Block(-1,1);
        rotationArray[0][3] = new Shape(e,f,g,h,3);
        
        //SQUARE SHAPE 1
        e = new Block(0,0);
        f = new Block(0,0);
        g = new Block(0,0);
        h = new Block(0,0);
        rotationArray[1][0] = new Shape(e,f,g,h,0);
        rotationArray[1][1] = new Shape(e,f,g,h,1);
        rotationArray[1][2] = new Shape(e,f,g,h,2);
        rotationArray[1][3] = new Shape(e,f,g,h,3);

        //LR SHAPE 2
        e = new Block(-2,0);
        f = new Block(-1,-1);
        g = new Block(0,-2);
        h = new Block(1,-1);
        rotationArray[2][0] = new Shape(e,f,g,h,0);
        
        e = new Block(1,2);
        f = new Block(0,1);
        g = new Block(-1,0);
        h = new Block(0,-1);
        rotationArray[2][1] = new Shape(e,f,g,h,1);
        
        e = new Block(1,0);
        f = new Block(0,1);
        g = new Block(-1,2);
        h = new Block(-2,1);
        rotationArray[2][2] = new Shape(e,f,g,h,2);
        
        e = new Block(0,-2);
        f = new Block(1,-1);
        g = new Block(2,0);
        h = new Block(1,1);
        rotationArray[2][3] = new Shape(e,f,g,h,3);

        // LL SHAPE 3
        e = new Block(0,2);
        f = new Block(1,1);
        g = new Block(2,0);
        h = new Block(1,-1);
        rotationArray[3][0] = new Shape(e,f,g,h,0);

        e = new Block(2,0);
        f = new Block(1,-1);
        g = new Block(0,-2);
        h = new Block(-1,-1);
        rotationArray[3][1] = new Shape(e,f,g,h,1);

        e = new Block(0,-2);
        f = new Block(-1,-1);
        g = new Block(-2,0);
        h = new Block(-1,1);
        rotationArray[3][2] = new Shape(e,f,g,h,2);
        
        e = new Block(-2,0);
        f = new Block(-1,1);
        g = new Block(0,2);
        h = new Block(1,1);
        rotationArray[3][3] = new Shape(e,f,g,h,3);

        // T SHAPE 4
        e = new Block(-2, 0);
        f = new Block(-1, 1);
        g = new Block(0, 2);
        h = new Block(0, 0);
        rotationArray[4][0] = new Shape(e,f,g,h,0);

        e = new Block(0, 2);
        f = new Block(1, 1);
        g = new Block(2, 0);
        h = new Block(0, 0);
        rotationArray[4][1] = new Shape(e,f,g,h,1);

        e = new Block(2, 0);
        f = new Block(1, -1);
        g = new Block(0, -2);
        h = new Block(0, 0);
        rotationArray[4][2] = new Shape(e,f,g,h,2);

        e = new Block(0, -2);
        f = new Block(-1, -1);
        g = new Block(-2, 0);
        h = new Block(0, 0);
        rotationArray[4][3] = new Shape(e,f,g,h,3);

        // ZL SHAPE 5
        e = new Block(-2, 0);
        f = new Block(-1, 1);
        g = new Block(0, 0);
        h = new Block(1, 1);
        rotationArray[5][0] = new Shape(e,f,g,h,0);

        e = new Block(0, 2);
        f = new Block(1, 1);
        g = new Block(0, 0);
        h = new Block(1,-1);
        rotationArray[5][1] = new Shape(e,f,g,h,1);

        e = new Block(2, 0);
        f = new Block(1,-1);
        g = new Block(0, 0);
        h = new Block(-1,-1);
        rotationArray[5][2] = new Shape(e,f,g,h,2);

        e = new Block(0,-2);
        f = new Block(-1, -1);
        g = new Block(0, 0);
        h = new Block(-1,1);
        rotationArray[5][3] = new Shape(e,f,g,h,3);

        // ZR SHAPE 6
        e = new Block(-1, 1);
        f = new Block(0, 2);
        g = new Block(-1, -1);
        h = new Block(0, 0);
        rotationArray[6][0] = new Shape(e,f,g,h,0);

        e = new Block(1, 1);
        f = new Block(2, 0);
        g = new Block(-1, 1);
        h = new Block(0, 0);
        rotationArray[6][1] = new Shape(e,f,g,h,1);

        e = new Block(1, -1);
        f = new Block(0, -2);
        g = new Block(1, 1);
        h = new Block(0, 0);
        rotationArray[6][2] = new Shape(e,f,g,h,2);

        e = new Block(-1, -1);
        f = new Block(-2, 0);
        g = new Block(1, -1);
        h = new Block(0, 0);
        rotationArray[6][3] = new Shape(e,f,g,h,3);
        
        return rotationArray;
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
            
            final int LENGTH_OF_HASHNO = 16;
            passhash = hashno.toString(LENGTH_OF_HASHNO);                                               // make sha 256 password string
            
            final int TOTAL_LENGTH = 32;
            while (passhash.length() < TOTAL_LENGTH) { 
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
        Scanner in = new Scanner(System.in);                                                        
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
                        
                        displayGameSavedLogo(board.getGameSavedColor());                                                      // display GAME SAVED on board
                        System.exit(0);
                        break;
                    case 'q':
                    case 'Q':
                        displayGameExitedLogo(board.getGameExitedColor());
                        System.exit(0);
                        break;
                    default:
                        break;
                }

                if(!board.insertShape(LINE))                                                                        // insert initial shape on board if it is possible means game finished
                {
                    displayGameOverLogo(board.getGameOverColor());

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
        displaySettingLogo();
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
                    displayGameExitedLogo(color.LGREEN);                                   // display GAME EXITED logo
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
        System.out.println(color.BOLD);
        System.out.println("GAME SETTINGS");
        System.out.println("Select one option");
        System.out.println("0. No change");
        System.out.println("1. Change User Interface");
        System.out.println("2. Reset the Default Environment Variables");
        System.out.println("3. Show game history");
        System.out.println("4. Delete all History");
        System.out.println("5. Reset the Tetris Game");
        System.out.println(color.RESET);
        try
        {
            int option = in.nextInt();
            switch(option)
            {
                case 0:
                    displayGameExitedLogo(color.BLGREEN);
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

        if(option=='Y')                                                     // changing color at the current index
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

    /**
     * This function will print history board
     * 
     * @return void
     **/
    private void printHistoryBoard()
    {
        System.out.println();
        System.out.println("\t\tH   H H HHHHH HHHHH HHHHH HHHH  H   H");
        System.out.println("\t\tH   H H H       H   H   H H   H  H H ");
        System.out.println("\t\tHHHHH H HHHHH   H   H   H HHHH    H  ");
        System.out.println("\t\tH   H H     H   H   H   H H  H    H  ");
        System.out.println("\t\tH   H H HHHHH   H   HHHHH H   H   H  ");
        for(int i=0;i<76;i++)
        {
            System.out.print("~");
        }
        System.out.println();
    }

    /**
     * This function will show history
     * 
     * @exception exceptions thrown to gameSettings()
     * @return void
     **/
    private void showHistory() throws Exception
    {
        printHistoryBoard();
        
        BufferedReader br = new BufferedReader(new FileReader("history.txt"));      // read history file
        String str="";
        int len=0;                                                                  // varibles for space adjustment
        int count=0;
        while((str=br.readLine())!=null)
        {
            String[] arr = str.split("[|]");
            System.out.print("\t"+arr[0]);
            len = 32-arr[0].length();
            
            for(int i=0;i<len;i++)
            {
                System.out.print(" ");
            }
            System.out.println("|\t"+arr[1]);
            count++;
        }
        if(count==0)
        {
            System.out.println("NO HISTORY PRESENT !!!");
        }
        br.close();
    }

    /**
     * This function will erase the history
     * 
     * @return void
     **/
    private void deleteHistory() throws Exception
    {
        File history = new File("history.txt");
        history.delete();                                               // delete history file
    }

    /**
     * This function will reset the whole game
     * 
     * @exception exception to gameSettings()
     * @return void
     **/
    private void resetAllGame() throws Exception
    {
        Scanner in = new Scanner(System.in);                                                            // scanner for input
        Rain colors = new Rain();                                                                       // included rainbow library
        
        System.out.println(colors.BRED);                                                                // printing the message
        System.out.println("Do you want to reset the game(Y/N), by doing reset:");
        System.out.println("=> all the saved games will be deleted");
        System.out.println("=> all the highscores are erased");
        System.out.println("=> all the history will be deleted");
        System.out.println("So carefully answer it !!!");
        System.out.println(colors.RESET);

        char option = in.next().charAt(0);
        in.close();

        if(option!='Y')                                                                                  // if option is not 'Y' then exception is thrown
        {
            throw new InvalidOptionException("Invalid option entered !!! game is not reset, try again");
        }

        // DELETE tetris.txt
        File tetris = new File("tetris.txt");
        tetris.delete();

        //DELETE history.txt
        File history = new File("history.txt");
        history.delete();

        // DELETE highscore.txt
        File highscore = new File("highscore.txt");
        highscore.delete();

        // DELETE default.txt
        File defaultfile = new File("default.txt");
        defaultfile.delete();

        // DELETE DB
        File dir = new File("db");
        String[] enteries = dir.list();
        for(String s:enteries)
        {
            // System.out.println(s);
            File newfile = new File(dir.getPath(),s);
            newfile.delete();
        }
        dir.delete();
    }

    /**
     * This function will show the user settings and catching all exceptions in options
     **/
    private void userSettings()
    {
        Scanner in = new Scanner(System.in);
        Rain color = new Rain();
        System.out.println(color.BOLD);
        System.out.println("USER SETTINGS");
        System.out.println("Select one option");
        System.out.println("0. No change");
        System.out.println("1. Show User Information");
        System.out.println("2. Verify the User"); 
        System.out.println("3. Change User's Environment Variables");
        System.out.println("4. Compare two users");
        System.out.println("5. Delete the old user");
        System.out.println("6. Reset/Recover user password");
        System.out.println(color.RESET);
        try
        {
            int option = in.nextInt();
            switch(option)
            {
                case 0:
                    displayGameExitedLogo(color.BCYAN);
                    break;
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

    /**
     * This function will delete old user from this game
     * 
     * @exception exceptions thrown to userSettings()
     * @return void
     **/
    private void deleteOldUser() throws Exception
    {
        Scanner in = new Scanner(System.in);
        String userfile = verifyUser(in);
        BufferedReader br = new BufferedReader(new FileReader(userfile));                                           // read user file
        String read = br.readLine();
        String[] parsedata = read.split("[|]");                                                                     // parse user data
        br.close();

        scorelist.removeHighScore(parsedata[0], Integer.parseInt(parsedata[2]), Integer.parseInt(parsedata[4]));    // delete user from scorelist
        scorelist.saveHighScore();                                                                                  // save highscore list
        
        File file = new File(userfile);
        file.delete();                                                                                              //delete userfile
        in.close();
    }

    /**
     * This function will reset the user password
     * with authenication and password verification
     * 
     * @exception exceptions to userSettings()
     * 
     * @return void 
     **/
    private void resetUserPassword() throws Exception
    {
        Scanner in = new Scanner(System.in);                                                                        // scanner for input
        Rain color = new Rain();                                                                                    // rain for displaying colors
        System.out.println("RESET USER PASSWORD");
        
        System.out.println("Enter the username");
        String username = in.nextLine();                                                                            // enter username for reset

        int highscoreid = scorelist.findIndexOfUser(username);                                                      // find the id of this user in highscore list
        if(highscoreid == -1)                                                                                       // if user is not present in highscores
        {
            in.close();
            throw new InvalidOptionException("Sorry you haven't saved a game with this username yet...");
        }

        System.out.println("Enter the USER ID");
        int userid = in.nextInt();                                                                                  // entering userid for verification
        if(userid!=highscoreid)                                                                                     // verify user entered id and highscorelist id
        {
            in.close();
            throw new InvalidOptionException("Invalid id entered by the user enter the another one");
        }

        System.out.println("Enter the USER HIGHSCORE");
        int userscore = in.nextInt();                                                                               // verify user highscore
        int highscore = scorelist.findScoreOfUser(username, userid);                                                // find user score in highscore list
        if(highscore==-1 || userscore!=highscore)
        {
            in.close();   
            throw new InvalidOptionException("Invalid user score");
        }

        System.out.println("USER AUTHENTICATED !!!");
        
        // READING HASHSTRING FROM THE FILE
        String filename = "db/"+userid+".txt";
        if(!new File(filename).exists())                                                                            // if user file don't exists
        {
            in.close();
            throw new InvalidOptionException("Try reseting the game");
        }

        // READ USER FILE FOR PASSOWRD HASH
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String read = br.readLine();
        String[] arr = read.split("[|]");
        String hashstring = arr[3];                                                                                 // readed hashstring from the user id file
        br.close();
        
        System.out.println(color.BOLD + "Create new password e.g: abcdef" + color.RESET);
        Console con = System.console();                                                                             // used for taking password as an input
        char[] pass = con.readPassword();                                                                           // reading password from the user
        String password = String.valueOf(pass);                                                                     // change char array to string
        String passhashstring = getSHA256(pass);                                                                    // calculate hash 256 of entered password
        
        //CHECKING PASSWORD VALIDITY
        if(username.equals(password))                                                                               // check password cannot be same as username
        {
            in.close();
            throw new SameNamePasswordException("Password cannot be same as username");
        }
        else if(password.length() < 5)                                                                              // check password length
        {
            in.close();
            throw new WrongPasswordException("Invalid length of the password");
        }
        else if(password.equals("abcdef"))                                                                          // check password will not be same as password
        {
            in.close();
            throw new SameNamePasswordException("Make your own password don't use example");
        }
        else if(hashstring.equals(passhashstring))                                                                 // match entered password with userid password hash
        {
            in.close();
            throw new SameNamePasswordException("This password cannot be assigned, try new one");
        }
        
        // PASSWORD CONFIRMATION
        System.out.println(color.BOLD+"Confirm password"+color.RESET);                                              // confirming password
        char[] confirmpassword = con.readPassword();                                                                // reading password again from console
        String confirmpasswordstring = String.valueOf(confirmpassword);
        
        if(password.equals(confirmpasswordstring))
        {
            System.out.println("Password Verified !!!");
        }
        
        // update password in userfile
        File tempfile = File.createTempFile("copy", ".tmp");
        
        arr[3] = passhashstring;                                                                                    // updated hashvalue
        
        // read and copy user userfile to tmp file
        BufferedReader BR = new BufferedReader(new FileReader(filename));                                           // read user file
        BufferedWriter BW = new BufferedWriter(new FileWriter(tempfile));                                           // write the temp file
        String str="";
        while((str=BR.readLine())!=null)
        {
            BW.write(str+"\n");
        }
        BR.close();
        BW.close();

        // copy temp file to userfile
        BR = new BufferedReader(new FileReader(tempfile));                                                          // open temp file for reading
        BW = new BufferedWriter(new FileWriter(filename));                                                          // open user file for writing
        int line=1;
        str="";
        while((str = BR.readLine())!=null)
        {
            switch(line)
            {
                case 1:                                                                                             // change user array for line 1
                    for(int i=0;i<arr.length;i++)
                    {
                        BW.write(arr[i]+"|");
                    }
                    BW.write("\n");
                    break;
                default:
                    BW.write(str+"\n");
                    break;
            }
            line++;
        }
        BR.close();
        BW.close();
        tempfile.delete();                                                                              // delete temporary files

        System.out.println("PASSWORD CHANGED !!!");
        in.close();
    }
}