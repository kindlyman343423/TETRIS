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
     * This class is used for making node used for making highscores list
     **/
    private static class ScoreNode
    {
        private User user;
        private int score;

        /**
         * Constructor
         * 
         * @param user for user data
         * @param score for score of the user
         **/
        public ScoreNode(User user,int score)
        {
            this.user = user;
            this.score = score;
        }

        /**
         * This function will return the score of the user
         * 
         * @return int for score
         **/
        public int getScore()
        {
            return this.score;
        }

        /**
         * This function will return the user name
         * 
         * @return string for username 
         **/
        public String getUserName()
        {
            return user.getName();
        }

        /**
         * This function will return the user id
         * 
         * @return int for user id
         **/
        public int getUserId()
        {
            return user.getUserId();
        }
    }

    private ArrayList<ScoreNode> list;                                          // list for storing highscores
    
    /**
     * Constructor for highscore.
     * Allocating memory to highscore list.
     **/
    public Highscore()
    {
        list = new ArrayList<ScoreNode>();

        //read data from highscore.txt contains id and score file
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
                    int id = Integer.parseInt(data[0]);
                    String name = data[1]; 
                    int score = Integer.parseInt(data[2]);
                    User dummyuser = new User(name,id);

                    ScoreNode newNode = new ScoreNode(dummyuser,score);
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
     * @param user for User object
     * @param score as integer
     **/
    public void addHighScore(User user,int score)
    {
        //create score node
        ScoreNode newNode = new ScoreNode(user,score);
        
        //add according to score
        if(list.size()==0)                                                      // if list is empty
        {
            list.add(newNode);                                                  // add a new node to list
        }
        else if(score >= list.get(0).getScore())                                // if score is greater than or equal to the top score
        {
            list.add(0,newNode);                                                // add node at position 0 from front
        }
        else if(score < list.get(list.size()-1).getScore())                     // if score is less than last node
        {
            list.add(list.size(),newNode);                                      // add node from last
        }
        else
        {
            for(int i=0;i<list.size();i++)                                      // traverse the list and add new node at middle
            {
                if(score > list.get(i).getScore())
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
            System.out.print("\t"+list.get(i).getUserId());                                             // print the user id
            idlength = 20 - list.get(i).getUserId();
            for(int j=0;j<idlength;j++)
            {
                System.out.print(" ");
            }
            
            System.out.print("|\t"+list.get(i).getUserName());                                          // print the username on scoreboard
            idlength = 16 - list.get(i).getUserName().length();
            for(int j=0;j<idlength;j++)
            {
                System.out.print(" ");
            }

            System.out.println("|\t"+list.get(i).getScore());                                           // print the user highscore
            idlength = 16 - list.get(i).getScore();
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
        //save the user id and score to highscore.txt file
        try
        {
            File file = new File("highscore.txt");                                                              // create new file object of highscore.txt file
            file.createNewFile();                                                                               // create new file if not present

            BufferedWriter bw = new BufferedWriter(new FileWriter(file));                                       // create buffered writer for writing the files
            
            for(int i=0;i<list.size();i++)                                                                      // traverse the list for writing to file
            {
                bw.write(list.get(i).getUserId()+";"+list.get(i).getUserName()+";"+list.get(i).getScore()+"\n");// write the highscore file
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