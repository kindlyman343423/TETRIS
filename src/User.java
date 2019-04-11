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
    private byte[] passhash;        // sha256 hash for password

    /**
     * This constructor will make the user with id and name for using in highcscores
     * 
     * @param String for name
     * @param id for taking user id
     **/
    public User(String name,int id)
    {
        this.name = name;
        this.userId = id;
        this.entryDate = null;
        this.password = null;
        this.passhash = null;
    }

    /**
     * This constructor will create the new user
     * 
     * @param String name of the user
     * @param String password of the user
     * @param Date of entrydate of the user
     * @param idsetter for setting and maintaining the id
     **/
    public User(String name,String password,Date entryDate,byte[] arr)
    {
        this.name = name;
        this.password = password;
        this.entryDate = entryDate;
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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        passhash = arr.clone();                                             // copy password in hash format to user array
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
        return Arrays.toString(passhash);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setDate(Date d)
    {
        this.entryDate = d;
    }

    /**
     * This function matches the password of the user with the given password
     * 
     * @param byte[] arr for hash
     * 
     * @return boolean whether hash is matched or not
     **/
    public boolean matchPassword(byte[] hash)
    {
        if(passhash.length!=hash.length)
        {
            return false;
        }
        for(int i=0;i<hash.length;i++)
        {
            if(passhash[i]!=hash[i])
            {
                return false;
            }
        }
        return true;
    }
}