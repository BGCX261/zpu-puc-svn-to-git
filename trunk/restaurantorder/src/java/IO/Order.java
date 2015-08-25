package IO;

import IO.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Order implements Serializable
{
    private ArrayList<OrderItem> items;
    
    public Order()
    {
        items = new ArrayList<OrderItem>();
    }
    
    public ArrayList<OrderItem> getItems()
    { 
        return items;
    }
    
    public int getCount()
    { 
        return items.size();
    }
    
    public void addItem(OrderItem item)
    {
        String name = item.getItem().getItemname();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++)
        {
            OrderItem OrderItem = items.get(i);
            if (OrderItem.getItem().getItemname().equals(name))
            {
                OrderItem.setQuantity(quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void removeItem(OrderItem item)
    {
        String code = item.getItem().getItemname();
        for (int i = 0; i < items.size(); i++)
        {
            OrderItem OrderItem = items.get(i);
            if (OrderItem.getItem().getItemname().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
}
