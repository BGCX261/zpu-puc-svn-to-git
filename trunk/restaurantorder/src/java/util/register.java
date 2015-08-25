package util;

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

import role.Customer;
import DB.CustomerDB;
/*
 * @author Zhengwei Pu & Yizhuo Zhan
 */
public class register extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet login</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet login at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */            
        } finally {            
            out.close();
        }
    }
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
                         throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String emailAddress = request.getParameter("emailaddress");
        String passWord = request.getParameter("password");
        String lastName = request.getParameter("lastname");

        // create the Customer object
        Customer customer = new Customer();
        customer.setEmailAddress(emailAddress);
        customer.setPassWord(passWord);
        customer.setLastName(lastName);
        
        String url = "";
        String message = "";
        
        if (CustomerDB.emailExists(emailAddress))
        {
            message = "This email address has already exists<br>" +
                      "Please change another email address for registering please!";
            url = "/register.jsp";            
        }
        else
        {
            //direct to the customer's customized page
            CustomerDB.insert(customer);
            url = "/Menu.jsp";
        }
        
        // store the Customer and message in the session
        HttpSession session = request.getSession();
        session.setAttribute("Customer", customer);
        request.setAttribute("message", message);
       // processRequest(request, response);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);  
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
