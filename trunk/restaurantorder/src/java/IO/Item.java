package IO;

import java.text.NumberFormat; 
import java.io.Serializable; 
 
public class Item implements Serializable 
{ 
	private static final long serialVersionUID = 1L;
	private String Attribute; 
        private String Itemname;
        private String Description;
        private double Price;
    
    public Item() 
    { 
        Attribute = ""; 
        Itemname = ""; 
        Description = ""; 
        Price = 0; 
    }
    public Item(String Attribute,String Itemname,String Description,double Price) 
    { 
        this.Attribute =Attribute; 
        this.Itemname =Itemname;
        this.Description =Description;
        this.Price = Price; 
    }
     
    public void setAttribute(String Attribute) 
    { 
        this.Attribute = Attribute; 
    } 
     
    public String getAttribute() 
    { 
        return Attribute;  
    } 
     
    public void setItemname(String Itemname) 
    { 
        this.Itemname = Itemname; 
    } 
 
    
    public String getItemname() 
    { 
        return Itemname;  
    } 
    public void setDescription(String Description) 
    { 
        this.Description = Description; 
    } 
 
    public String getDescription() 
    { 
        return Description;  
    } 
     
    
    public void setPrice(double Price) 
    { 
        this.Price = Price; 
    } 
 
    public double getPrice() 
    { 
        return Price;  
    } 
     
    public String getPriceNumberFormat() 
    { 
        NumberFormat number = NumberFormat.getNumberInstance(); 
        number.setMinimumFractionDigits(2); 
        if (Price == 0) 
            return ""; 
        else 
            return number.format(Price);  
    }     
    public String getPriceCurrencyFormat() 
    { 
        NumberFormat currency = NumberFormat.getCurrencyInstance(); 
        return currency.format(Price); 
    } 
    
} 