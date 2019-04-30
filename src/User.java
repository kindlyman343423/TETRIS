import java.io.*;
import java.util.*;
/**
 * Class for making the user
 **/
public class User
{
    private String name;            // name of the user
    private Date entryDate;         // storing entry date of the user
    private int userId;             // for user ids
    private String password;        // password of the user
    private String passhash;        // sha256 hash for password
    private int score;              // score made by the user

    /**
     * This constructor will create the old user
     * 
     * @param name for username
     * @param password for user password
     * @param entryDate for setting that old date
     * @param userid for userid
     * @param passhash for passowrd in shs256 hash
     * @param score for user score
     **/
    public User(String name,String password,Date entryDate,int userid,String passhash,int score)
    {
        this.name = name;
        this.entryDate = entryDate;
        this.userId = userid;
        this.password = password;
        this.passhash = passhash;
        this.score = score;
    }

    /**
     * This constructor will create the new user and take new id from tetris.txt file
     * It will also add user history to history.txt file
     * @param String name of the user
     * @param String password of the user
     * @param Date of entrydate of the user
     * @param idsetter for setting and maintaining the id
     **/
    public User(String name,String password,Date entryDate,String passhash,int score)
    {
        this.name = name;
        this.entryDate = entryDate;
        this.password = password;
        this.passhash = passhash;
        this.score = score;
        File file = new File("tetris.txt");                                 // create a file object for tetris.txt file
        
        try
        {
            if(file.createNewFile())                                        // initially if file not present then create new file
            {
                System.out.println("file created");
                this.userId = 1;                                            // initially create user with id 1
            }
            else                                                            // if file present then read and increment id by 1
            {
                // read tetris file for current id
                BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
                String str;
                int id = 0;
                while((str = br.readLine())!=null)
                {
                    id = Integer.parseInt(str);
                }
                this.userId = ++id;
                br.close();
            }
            //APPEND data to history.txt file
            BufferedWriter bw = new BufferedWriter(new FileWriter("history.txt",true));
            bw.write(name+"|"+entryDate+"|\n");
            bw.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This function will check whether username contains special char or not
     * returns true when the username has special char else return false
     * @param name for username
     * @return boolean for check
     **/
    public static boolean checkSpecialCharUsername(String name)
    {
        for(int i=0;i<name.length();i++)
        {
            char ch = name.charAt(i);
            switch(ch)
            {
                case '{':
                case '}':
                case '(':
                case ')':
                case '*':
                case '-':
                case '=':
                case '|':
                case ';':
                case ':':
                case '!':
                case ',':
                case '[':
                case ']':
                case '\\':
                case '/':
                case '@':
                case '~':
                case '$':
                    return true;
            }     
        } 
        return false;
    }

    /**
     * This function will return the score scored
     * 
     * @return int for score
     **/
    public int getUserScore()
    {
        return this.score;
    }

    /**
     * This function will set the new highscore
     * 
     * @param score in integer
     **/
    public void setUserScore(int score)
    {
        this.score = score;
    }

    /**
     * This function will return the name of the user
     * 
     * @return String for user name
     **/
    public String getName()
    {
        return this.name;
    }

    /**
     * This function will return the Entry Date of the user
     * 
     * @return Date for entered date;
     **/
    public Date getDate()
    {
        return this.entryDate;
    }

    /**
     * This function will return the User ID
     * 
     * @return int for user id
     **/
    public int getUserId()
    {
        return this.userId;
    }

    /**
     * This fuction return the password in string format
     * 
     * @return String for password
     **/
    public String getPassword()
    {
        return this.password;
    }

    /**
     * This function return the password hash in string format
     * 
     * @return string for pass hash
     **/
    public String getPassHash()
    {
        return passhash;
    }

    /**
     * This function will set the new name
     * 
     * @param name in string
     **/
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * This function will set the new date
     * 
     * @param d for new date
     **/
    public void setDate(Date d)
    {
        this.entryDate = d;
    }
}