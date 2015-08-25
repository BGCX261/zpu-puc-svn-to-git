package role;

/*
 * @author Zhengwei Pu & Yizhuo Zhan
 */

/*
 * There are three different kinds of staff: administrator, chef & waiter
*/
public class Staff {
    private String passWord;
    private String title;
    //private String emailAddress;
    
    public Staff()
    {}
    
    public Staff(String logtitle, String word)
    {
        title = logtitle;
        passWord = word;
    }
    
/*
    public Customer(String email, String word, String name)
    {
        lastName = name;
        emailAddress = email;
        passWord = word;
    }
*/
    
    public void setPassWord(String p)
    {
        passWord = p;
    }
    public String getPassWord()
    { 
        return passWord; 
    }
    
    public void setTitle(String l)
    {
        title = l;
    }

    public String getTitle()
    { 
        return title; 
    }
    
    /*
    public void setEmailAddress(String e)
    {
        emailAddress = e;
    }

    public String getEmailAddress()
    { 
        return emailAddress; 
    }  
     */
}
