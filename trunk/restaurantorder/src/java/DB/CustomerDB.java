/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import role.Customer;
import java.sql.*;
/**
 * @author Zhengwei Pu & Yizhuo Zhan
 */

public class CustomerDB {
    //check if the emailaddress exists in the DB
    public static boolean emailExists(String emailAddress)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        //String query = "SELECT EmailAddress FROM Customer " + 
         //       "WHERE EmailAddress = ?"; 
        String query = "SELECT count(*) FROM Customer " +
               "WHERE EmailAddress"+ "=" + "'" + emailAddress + "'";
        try
        {
            ps = connection.prepareStatement(query);
            //ps.setString(1, emailAddress);
            rs = ps.executeQuery();
	    if (rs.next()) {
		if (rs.getInt(1) > 0) {
		    return true;
		}
	    }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DButil.closeResultSet(rs);
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
        return false;
    }   
    
    public static int insert(Customer customer)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO Customer (EmailAddress, PassWord, LastName) " +
                "VALUES (?, ?, ?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, customer.getEmailAddress());
            ps.setString(2, customer.getPassWord());
            ps.setString(3, customer.getLastName());
            return ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0;
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }

    public static boolean checkpassword(String emailAddress,String passWord)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "SELECT count(*) FROM Customer " +
                "WHERE EmailAddress"+ "=" + "'" + emailAddress+ "' and password = " + "'" + passWord + "'";
        try
        {
            ps = connection.prepareStatement(query);
            //ps.setString(1, emailAddress);
            rs = ps.executeQuery();
	    if (rs.next()) {
		if (rs.getInt(1) > 0) {
		    return true;
		}
	    }
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return false;
        }
        finally
        {
            DButil.closeResultSet(rs);
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    return false;    
    }      
}
