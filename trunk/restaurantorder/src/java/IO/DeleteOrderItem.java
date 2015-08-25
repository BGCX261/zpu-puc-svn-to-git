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

/*
 * @author nino
 */
public class DeleteOrderItem extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        
        HttpSession session = request.getSession();

        Customer customer=(Customer) session.getAttribute("Customer");
        
        String eamiladdress=customer.getEmailAddress();
        session.setAttribute("EmaiAddress",eamiladdress);   

        Item item = ItemsDB.finditem(name);
        item.setItemname(name);     
            
        OrderDB.delete (customer,name);
                       
        String url = "/MyOrder.jsp";
        RequestDispatcher dispatcher =
                getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
