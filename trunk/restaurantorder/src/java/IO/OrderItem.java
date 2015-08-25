package IO;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class OrderItem implements Serializable
{
    private Item item;
    private int quantity;
    public double subtotal=0;
    
    
    public OrderItem() {}
    
    public void setItem(Item it)
    {
        item = it;
    }

    public Item getItem()
    { 
        return item;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = item.getPrice() * quantity;
        subtotal+=total;
        return total;
    }
    public double getSubTotal()
    {
        DecimalFormat df2  = new DecimalFormat("###.00");
        return Double.parseDouble(df2.format(subtotal));
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
    public String getSubTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getSubTotal());
    }
    
    
}