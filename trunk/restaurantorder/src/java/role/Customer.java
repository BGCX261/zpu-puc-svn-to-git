package role;

/*
 * @author Zhengwei Pu & Yizhuo Zhan
 */

public class Customer {
    private String passWord;
    private String lastName;
    private String emailAddress;
    
    public Customer()
    {}
    
    public Customer(String email, String word)
    {
        emailAddress = email;
        passWord = word;
    }

    public Customer(String email, String word, String name)
    {
        lastName = name;
        emailAddress = email;
        passWord = word;
    }
    
    public void setPassWord(String p)
    {
        passWord = p;
    }
    public String getPassWord()
    { 
        return passWord; 
    }
    
    public void setLastName(String l)
    {
        lastName = l;
    }

    public String getLastName()
    { 
        return lastName; 
    }
    
    public void setEmailAddress(String e)
    {
        emailAddress = e;
    }

    public String getEmailAddress()
    { 
        return emailAddress; 
    }    
}
