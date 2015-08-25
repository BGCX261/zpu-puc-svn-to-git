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

import DB.*;
import DB.ItemsDB;

/*
 * @author Zhengwei Pu & Yizhuo Zhan
 */
public class admindeleteproduct extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         String itemname=request.getParameter("name");
        String url = "";
        String message = "";
        
            ItemsDB.delete(itemname);
            //<editor-fold defaultstate="collapsed" desc="comment">
            
            //</editor-fold>
        url="/adminviewproducts.jsp";
        message="Has deleted this item sucessfully!";            
    /*  
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        //Item item = new Item();
        

      
        String query = "DELETE FROM item " +
                "WHERE Itemname = '"+itemname+"'";
            try {
                ps = connection.prepareStatement(query);
                ResultSet rs = null;
                rs = ps.executeQuery();
                url="/adminviewproducts.jsp";
                rs.close();
                ps.close();
	} catch (java.sql.SQLException sql) {
	    sql.printStackTrace();
	}
        */    

        HttpSession session = request.getSession();
        session.setAttribute("Itemname", itemname);
        request.setAttribute("message", message);
        

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
        dispatcher.forward(request, response);  
    }

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
                processRequest(request, response);              
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}