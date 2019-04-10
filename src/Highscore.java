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

    private ArrayList<ScoreNode> list;                  // list for storing highscores
    
    /**
     * Constructor for highscore.
     * Allocating memory to highscore list.
     **/
    public Highscore()
    {
        //read data from db/highscore.txt contains id and score file
        list = new ArrayList<ScoreNode>();
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
        if(list.size()==0)                                  // if list is empty
        {
            list.add(newNode);                              // add a new node to list
        }
        else if(score >= list.get(0).getScore())            // if score is greater than or equal to the top score
        {
            list.add(0,newNode);
        }
        else if(score < list.get(list.size()-1).getScore()) // if score is less than last node
        {
            list.add(list.size(),newNode);
        }
        else
        {
            for(int i=0;i<list.size();i++)                  // traverse the list and add new node
            {
                if(score > list.get(i).getScore())
                {
                    list.add(i,newNode);
                    break;
                }
            }
        }
    }
    public void displayHighScore()
    {
        // Rain colors = new Rain();
        //print the list
        for(int i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getUserId()  +"\t\t"+list.get(i).getUserName() + "\t\t" + list.get(i).getScore());
        }
    }
    public void saveHighScore()
    {
        //save the user id and score to file
    }
}