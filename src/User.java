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

    private static int ID=0;        // storing id of the user

    /**
     * This constructor will create the new user
     * 
     * @param String name of the user
     * @param String password of the user
     * @param Date of entrydate of the user
     * @param idsetter for setting and maintaining the id
     **/
    public User(String name,String password,Date entryDate,byte[] arr,int idsetter)
    {
        this.name = name;
        this.password = password;
        this.entryDate = entryDate;
        ID = idsetter;
        ID++;
        this.userId = ID;
        passhash = arr.clone();
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