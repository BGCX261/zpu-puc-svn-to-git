/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

import role.Staff;
import DB.StaffDB;

public class adminlogin extends HttpServlet {

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
        /*
        String lastName = request.getParameter("lastName");
        String password = request.getParameter("password");
        String emailAddress = request.getParameter("emailAddress");        
        */
        String title = request.getParameter("Title");
        String passWord = request.getParameter("Password");

        // create the Customer object
        Staff staff = new Staff();
        staff.setTitle(title);
        //staff.setPassWord(passWord);

        String url = "";
        String message = "";


        if (title.equals("admin"))
        {
            //direct to the customer's customized page
            //CustomerDB.insert(customer);
            if(StaffDB.checkpassword(title,passWord)){
                message = "Welcome to admin page";
                url = "/adminviewproducts.jsp";
            }
            else{
                  message = "The password is not right<br>" +
                "Please re-type again";
                 url = "/adminlogin.jsp";
            }
    }
        //vedify the password      
        else if(title.equals("chef")){
            //direct to a false page
            if(StaffDB.checkpassword(title,passWord)){
                message = "Welcome to chef page";
                url = "/chef.jsp";
            }
            else{
                  message = "The password is not right<br>" +
                "Please re-type again";
                 url = "/adminlogin.jsp";
            }
        }
        else{
              if(StaffDB.checkpassword(title,passWord)){
                message = "Welcome to waiter page";
                url = "/waiter.jsp";
              }
              else{
                  message = "The password is not right<br>" +
                "Please re-type again";
                 url = "/adminlogin.jsp";
              }
        }
        // store the Customer and message in the session
        HttpSession session = request.getSession();
        session.setAttribute("Staff", staff);
        request.setAttribute("message", message);
        
        //processRequest(request, response);
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);      
        //fist to check if it fits the customer in the db, if not , redirect to a new page
        //if it fits, redirect to the customers' customized page
    }
}
