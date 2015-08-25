package DB;
import IO.Item;
import IO.OrderItem;
import role.Customer;
import role.Customer;
import java.sql.*;
import DB.ItemsDB;

/**
 * @author Zhengwei Pu & Yizhuo Zhan
 */

public class OrderDB {
    
    public static boolean itemExists(String EmailAddress,String itemName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT count(*) FROM OrderDB WHERE Itemname ='" + itemName + "'and EmailAddress='"+EmailAddress+"'";
        try
        {
            ps = connection.prepareStatement(query);
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
    
    //insert items 
    public static int insert(Customer customer,OrderItem orderitem)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO OrderDB (EmailAddress,Itemname,Quantity) " +"VALUES (?,?,?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1,customer.getEmailAddress());
            ps.setString(2, orderitem.getItem().getItemname());
            ps.setInt(3, orderitem.getQuantity());
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
    
    public static void update (Customer customer,OrderItem orderitem)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "UPDATE OrderDB SET " +
                "Quantity= '"+orderitem.getQuantity()+"'"+
                "WHERE EmailAddress = '"+customer.getEmailAddress()+"'and Itemname='"+orderitem.getItem().getItemname()+"'";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.execute();
	    ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }    
    
        public static void delete (Customer customer,String itemname)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = "DELETE FROM orderdb WHERE EmailAddress = '"+customer.getEmailAddress()+"'"+
                "and Itemname='"+itemname+"'";
        try
        {        
            ps = connection.prepareStatement(query);
	    ps.execute();
            ps.close();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }  
        
   public static double caltotal(Customer customer)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        double total=0.0;
        
        String query = 
                "SELECT * from OrderDB WHERE EmailAddress='" +customer.getEmailAddress()+"'";
        try
        {        
            ps = connection.prepareStatement(query);
	    ResultSet rs = null;
	    rs = ps.executeQuery(); 
            while (rs.next()) {
                    String itemname=rs.getString(3);
                    Item item = new Item();
                    item=ItemsDB.finditem(itemname);
                    double price=item.getPrice();
                    int quantity=Integer.parseInt(rs.getString(4));
                    double itemamount=price*quantity;
                    total+=itemamount;
         }
            return total;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return 0.0;
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }         
}