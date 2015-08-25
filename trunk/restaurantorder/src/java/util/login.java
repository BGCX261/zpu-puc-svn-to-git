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
public class login extends HttpServlet {

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
        
        HttpSession session = request.getSession();
        String emailAddress = request.getParameter("EmailAddress");
        String passWord = request.getParameter("Password");

        
        // create the Customer object
        Customer customer = new Customer();
        customer.setEmailAddress(emailAddress);
        customer.setPassWord(passWord);

        String url = "";
        String message = "";


        if (CustomerDB.emailExists(emailAddress))
        {
            //direct to the customer's customized page
            //CustomerDB.insert(customer);
            if(CustomerDB.checkpassword(emailAddress, passWord)){           
                message = "";
                url = "/Menu.jsp";
                session.setAttribute("Customer", customer);
            }
            else{
                message = "The password is not right<br>" +
                          "Please re-type again";
                url = "/index.jsp";
            }
        } 
        //if the email does not exist, it means the new comer have to go to the register page
        //to register a new account
        else{
            //direct to a false page
            message = "This email address does not exists<br>"+
                      "Please register.";
            url = "/register.jsp";
        }
        
        // store the Customer and message in the session
        request.setAttribute("message", message);
        
        //processRequest(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);          
        //fist to check if it fits the customer in the db, if not , redirect to a new page
        //if it fits, redirect to the customers' customized page
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
