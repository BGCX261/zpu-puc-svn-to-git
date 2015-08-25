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
import java.sql.*;

import DB.ItemsDB;
import DB.*;

/*
 * @author Zhengwei Pu & Yizhuo Zhan
 */
public class adminmodifyproduct extends HttpServlet {

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet adminaddproducts</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet adminaddproducts at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
        } finally {            
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Attribute = request.getParameter("Attribute");
        String Itemname = request.getParameter("Itemname");
        String Description = request.getParameter("Description");
        Float Price = Float.valueOf(request.getParameter("Price"));          

        // create the Item object
        Item item = new Item();
        item.setAttribute(Attribute);
        item.setItemname(Itemname);
        item.setDescription(Description);
        item.setPrice(Price);
/*
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
        String query = "UPDATE Item SET " +
                "Price = ?, " +
                "WHERE Itemname = '"+Itemname+"'";
        try
        {
            ps = connection.prepareStatement(query);
            ps.setDouble(4, item.getPrice());
            ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
            DButil.closePreparedStatement(ps);
            pool.freeConnection(connection);
        }      
*/    
        ItemsDB.update(item,Itemname);
        //    ItemsDB.update(Itemname);
            String url="/adminviewproducts.jsp";
            String message="Has modified this item sucessfully!";   
            
        HttpSession session = request.getSession();
        session.setAttribute("Item", item);
        request.setAttribute("message", message);
        
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);                
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}