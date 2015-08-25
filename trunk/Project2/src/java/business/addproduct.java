 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.Iterator;
import java.util.ArrayList;

import business.*;
import data.*;

/**
 *
 * @author nino
 */
public class addproduct extends HttpServlet {

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
            
            ServletContext sc = getServletContext(); 
            String path = sc.getRealPath("/WEB-INF/products.txt"); 
            
            String code=(String) request.getParameter("addcode");
            String description=(String) request.getParameter("adddescription");
            String price=(String) request.getParameter("addprice");
            double aprice=Double.parseDouble(price);
            
             Product addproduct=new Product();
                //Product upproduct=(Product) session.getAttribute( "deleproduct "); 
             addproduct.setCode(code);
             addproduct.setDescription(description);
             addproduct.setPrice(aprice);
             
            if(ProductIO.exists(code, path))
            {
                //refresh the ArrayList
                ProductIO.update(addproduct, path);
            }
            else
            {
                ProductIO.insert(addproduct, path);
            }
            
            String url="/displayServlet";
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(url); 
            dispatcher.forward(request, response); 
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
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
