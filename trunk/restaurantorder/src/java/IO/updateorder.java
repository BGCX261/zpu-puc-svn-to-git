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

public class updateorder extends HttpServlet
{
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String name = request.getParameter("name");
        String quantityAsString = request.getParameter("quantity");
        int quantity = Integer.parseInt(quantityAsString);
        
        HttpSession session = request.getSession();

        Customer customer=(Customer) session.getAttribute("Customer");
        
        String eamiladdress=customer.getEmailAddress();
        session.setAttribute("EmaiAddress",eamiladdress);   

            Item item = ItemsDB.finditem(name);
            item.setItemname(name);     
            OrderItem oi = new OrderItem();
            oi.setItem(item);
            oi.setQuantity(quantity);
            
            OrderDB.update (customer,oi);

            session.setAttribute("OrderItem", oi);
            session.setAttribute("quantity",quantity);
                       
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