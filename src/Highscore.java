import java.io.*;
import java.util.*;
import RAINBOW.*;

/**
 * This class contains a list for storing highscores.
 * All the highscores operations are performed by this class.
 **/
public class Highscore
{
    /**
     * This class is for storing the highscores
     **/
    class ScoreNode
    {
        private String name;            // username
        private int userid;             // user id
        private int score;              // user score

        /**
         * This constructor will create a new score node
         **/
        public ScoreNode(String name,int userid,int score)
        {
            this.name = name;
            this.userid = userid;
            this.score = score;
        }

        public String getHighScoreUserName()
        {
            return this.name;
        }
        public int getHighScoreUserId()
        {
            return this.userid;
        }
        public int getHighScore()
        {
            return this.score;
        }
    }
    private ArrayList<ScoreNode> list;                                               // list for storing highscores
    
    /**
     * Constructor for highscore.
     * Allocating memory to highscore list.
     * read data from highscore.txt add in list
     **/
    public Highscore()
    {
        list = new ArrayList<ScoreNode>();                                           // create new arraylist of users

        /**
         * parse the format
         * username;userid;score
         **/
        File file = new File("highscore.txt");                                  // create a new file structure for highscore.txt
        try
        {
            if(!file.createNewFile())                                           // if new file is not created
            {
                //read the file and put data in arraylist
                BufferedReader br = new BufferedReader(new FileReader(file));
                String str="";

                while((str = br.readLine())!=null)
                {
                    String[] data = str.split(";");
                    String username = data[0];
                    int userid = Integer.parseInt(data[1]);
                    int score = Integer.parseInt(data[2]);

                    ScoreNode newNode = new ScoreNode(username,userid,score);
                    list.add(newNode);
                }

                br.close();
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println(e);
        }
    }

    /**
     * This function will add new highscore at the end of the game
     * 
     * @param username for getting user name
     * @param userid for getting user id
     * @param score for getting user score
     **/
    public void addHighScore(String username,int userid,int score)
    {   
        ScoreNode newNode = new ScoreNode(username,userid,score);

        //add according to score
        if(list.size()==0)                                                      // if list is empty
        {
            list.add(newNode);                                                  // add a new node to list
        }
        else if(score >= list.get(0).getHighScore())                                // if score is greater than or equal to the top score
        {
            list.add(0,newNode);                                                // add node at position 0 from front
        }
        else if(score < list.get(list.size()-1).getHighScore())                     // if score is less than last node
        {
            list.add(list.size(),newNode);                                      // add node from last
        }
        else
        {
            for(int i=0;i<list.size();i++)                                      // traverse the list and add new node at middle
            {
                if(score > list.get(i).getHighScore())
                {
                    list.add(i,newNode);
                    break;
                }
            }
        }
    }

    /**
     * This function will display the highscore board
     * 
     * @return void
     **/
    private void highScore()
    {
        Rain colors = new Rain();
        System.out.println(colors.BMAGENTA);
        System.out.println("  H   H  I  GGGGG  H   H   SSSSS   CCCC   OOO   RRRR   EEEEE  SSSSS");
        System.out.println("  H   H  I  G      H   H   S      C      O   O  R   R  E      S    ");
        System.out.println("  HHHHH  I  G GGG  HHHHH   SSSSS  C      O   O  RRRR   EEEE   SSSSS ");
        System.out.println("  H   H  I  G   G  H   H       S  C      O   O  R  R   E          S");
        System.out.println("  H   H  I  GGGGG  H   H   SSSSS   CCCC   OOO   R   R  EEEEE  SSSSS");
        System.out.println(colors.RESET);
    }

    /**
     * This function will display the runtime highscores saved in the list
     * This function is traversing the highscore list for displaying 
     * 
     * @return void
     **/
    public void displayHighScore()
    {
        highScore();                                                                                    // display the highscore board
        System.out.println("\tUser ID\t\t|\tUser Name\t|\tScore\t");
        System.out.println("----------------------------------------------------------------------");
        //print the list
        int idlength = 0;                                                                               // variable maintatining tabs
        for(int i=0;i<list.size();i++)
        {
            System.out.print("\t"+list.get(i).getHighScoreUserId());                                             // print the user id
            idlength = 20 - list.get(i).getHighScoreUserId();
            for(int j=0;j<idlength;j++)
            {
                System.out.print(" ");
            }
            
            System.out.print("|\t"+list.get(i).getHighScoreUserName());                                          // print the username on scoreboard
            idlength = 16 - list.get(i).getHighScoreUserName().length();
            for(int j=0;j<idlength;j++)
            {
                System.out.print(" ");
            }

            System.out.println("|\t"+list.get(i).getHighScore());                                           // print the user highscore
            idlength = 16 - list.get(i).getHighScore();
            for(int j=0;j<idlength;j++)
            {
                System.out.print(" ");
            }
            System.out.println();
        }

        if(list.size() == 0)                                                                            // print null when list has no element
        {
            System.out.println("\t----\t\t|\t----\t\t|\t----");
        }
    }

    /**
     * This function will save/write the highscore to the file after the end of the game
     * 
     * @return void
     **/
    public void saveHighScore()
    {
        //save the user to highscore.txt file
        try
        {
            File file = new File("highscore.txt");                                                              // create new file object of highscore.txt file
            file.createNewFile();                                                                               // create new file if not present

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));                                       // create buffered writer for writing the files
            
            /**
             * highscore.txt format
             * username;userid;score
             * username;userid;score
             **/

            for(int i=0;i<list.size();i++)                                                                      // traverse the list for writing to file
            {
                bw.write(list.get(i).getHighScoreUserName()+";"+list.get(i).getHighScoreUserId()+";"+list.get(i).getHighScore());// write the highscore file
            }
            bw.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}