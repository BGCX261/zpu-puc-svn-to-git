package DB;

//import role.Customer;
import java.sql.*;
import IO.Item;
import java.util.ArrayList;

public class ItemsDB {
    //check if the item has already existed in the DB
    public static boolean itemExists(String itemName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;

        String query = "SELECT count(*) FROM Item " +
               "WHERE itemName"+ "=" + "'" + itemName + "'";
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
    
    public static Item finditem(String itemName)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        Item item = new Item();
        
        String query = "SELECT * FROM item WHERE Name=" + "'" + itemName + "'";
        try{
            ps = connection.prepareStatement(query);
	    rs = ps.executeQuery();
	    if (rs.next()) {
		item.setAttribute(rs.getString(2));
                item.setAttribute(itemName);
		item.setDescription(rs.getString(4));
		item.setPrice(rs.getDouble(5));
	    }
	    rs.close();
	    ps.close();
            return item;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DButil.closeResultSet(rs);
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }
    }  
    
    /*
     *This method is used to insert new items
     */
    public static ArrayList<Item> find()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        ArrayList<Item> items=new ArrayList<Item>();
        items=null;
        
        String query = "select * from item";
        try
        {        
            ps = connection.prepareStatement(query);
            ResultSet rs = null;
	    rs = ps.executeQuery();
            while(rs.next()){
            Item item = new Item();
		item.setAttribute(rs.getString(2));
		item.setItemname(rs.getString(3));
		item.setDescription(rs.getString(4));
		item.setPrice(rs.getDouble(5));
                items.add(item);
            }
            return items;
        }
        catch(SQLException e)
        {
            e.printStackTrace();
            return null;
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }     
    } 
    /*
     *This method is used to insert new items
     */
    public static int insert(Item items)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;

        String query = 
                "INSERT INTO item (Attribute, Name, Description,Price) " +
                "VALUES (?, ?, ?,?)";
        try
        {        
            ps = connection.prepareStatement(query);
            ps.setString(1, items.getAttribute());
            ps.setString(2, items.getItemname());
            ps.setString(3, items.getDescription());
            ps.setDouble(4, items.getPrice());
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
        public static void update(Item iitem,String itemname)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE item SET " +
                "Attribute= '"+iitem.getAttribute()+"'"+","+
                "Description = '"+iitem.getDescription()+"'"+","+
                "Price = '"+iitem.getPrice()+"'"+
                "WHERE Name = '"+itemname+"'";
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
    
    public static void delete(String Itemname)
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "DELETE FROM item WHERE Name = '" + Itemname + "'";
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

    /*
     *Get all items in the database 
     */
    public static Item getItem( ) {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
	String query = "select * from Item";
	try {
            ps = connection.prepareStatement(query);
	    ResultSet rs = null;
	    rs = ps.executeQuery();
            
	    Item item = new Item();
            
	    if (rs.next()) {
		item.setAttribute(rs.getString(1));
		item.setItemname(rs.getString(2));
		item.setDescription(rs.getString(3));
		item.setPrice(rs.getDouble(4));
	    }
	    rs.close();
	    ps.close();
	    return item;
	} catch (java.sql.SQLException sql) {
	    sql.printStackTrace();
	    return null;
	}
    }    
}