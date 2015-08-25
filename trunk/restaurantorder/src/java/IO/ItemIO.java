package IO;

/*
 * @author Zhany
 */
import java.io.*;
import java.util.*;
import java.sql.*;
import DB.*;

public class ItemIO
{
    //private static ArrayList<Item> items = new ArrayList<Item>();
/*
    public static ArrayList<Item> getItems()
    {
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int quantity=0;
        items = null;
        items.add(item);

    }
*/
     public static Item getItem(String Itemname)
    {
        ArrayList<Item> items=ItemsDB.find();
        for (Item p : items)
        {
            if (Itemname != null &&
                Itemname.equalsIgnoreCase(p.getItemname()))
            {
                return p;
            }
        }
        return null;
    }

     /*
    public static boolean exists(String itemAttribute, String path)
    {
        items = getItems(path);
        for (Item p : items)
        {
            if (itemAttribute != null &&
                itemAttribute.equalsIgnoreCase(p.getAttribute()))
            {
                return true;
            }
        }
        return false;
    }
*/
    private static void saveItems(ArrayList<Item> items,
            String path)
    {
        try
        {
            File file = new File(path);
            PrintWriter out =
                new PrintWriter(
                new FileWriter(file));

            for (Item p : items)
            {
                out.println(p.getAttribute() + "|"
                        + p.getItemname() + "|"
                        + p.getPrice());
            }

            out.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
/*
    public static void insert(Item item, String path)
    {
        items = getItems(path);
        items.add(item);
        saveItems(items, path);
    }
     public static void update(Item item, String path)
    {
        items = getItems(path);
        for (int i = 0; i < items.size(); i++)
        {
            Item p = items.get(i);
            if (item.getAttribute() != null &&
                item.getAttribute().equalsIgnoreCase(p.getAttribute()))
            {
                items.set(i, item);

            }
        }
        saveItems(items, path);
    }

    public static void delete(Item item, String path)
    {
        items = getItems(path);
        for (int i = 0; i < items.size(); i++)
        {
            Item p = items.get(i);
            if (item != null &&
                item.getAttribute().equalsIgnoreCase(p.getAttribute()))
            {
                items.remove(i);
            }
        }
        saveItems(items, path);
    }
    */
}
