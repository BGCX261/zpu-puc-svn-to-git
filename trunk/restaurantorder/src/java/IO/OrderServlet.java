package IO;

import java.lang.String;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DB.ItemsDB;
import DB.OrderDB;
import role.Customer;

public class OrderServlet extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String quantityAsString = request.getParameter("quantity");
        //double amount;
        
        HttpSession session = request.getSession();

        Order order = (Order) session.getAttribute("order");
        Customer customer=(Customer) session.getAttribute("Customer");
        
        String eamiladdress=customer.getEmailAddress();
        session.setAttribute("EmaiAddress",eamiladdress);
        int quantity = 1;        

            Item item = ItemsDB.finditem(name);
            item.setItemname(name);
            double price=item.getPrice();
            
            OrderItem oi = new OrderItem();
            oi.setItem(item);
            oi.setQuantity(quantity);
            
            if(OrderDB.itemExists(eamiladdress, name)==false){
                OrderDB.insert(customer, oi);
            }
            //if the user enters a negative or invalid quantity,
            //the quantity is automatically reset to 1.            
            else{
                try
                {
                    quantity = Integer.parseInt(quantityAsString);
                    if (quantity < 0)
                        quantity = 1;
                    else{
                        oi.setQuantity(quantity);
                        OrderDB.update(customer, oi);
                    }
                }
                    catch(NumberFormatException e)
                    {
                        quantity = 1;
                    }
            }           

            session.setAttribute("order", order);
            session.setAttribute("quantity",quantity);
            //session.setAttribute("amount",amount);
            
        String url = "/MyOrder.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     */
    public String getServletInfo()
    {
        return "Short description";
    }
    // </editor-fold>
}