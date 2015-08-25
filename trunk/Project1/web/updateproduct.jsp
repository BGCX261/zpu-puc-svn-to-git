<%-- 
    Document   : updateProduct
    Created on : 2011-9-21, 21:07:03
    Author     : nino
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">     
    </head>
    
    <body>
        <%@ page import="business.*, data.*, java.util.Date" %>

          <%
                ServletContext sc = this.getServletContext();
                String path = sc.getRealPath("/WEB-INF/products.txt");
                                    
                
                String url = request.getQueryString();
  		Product editproduct=new Product();
                editproduct=(Product)session.getAttribute("editproduct" + url);        
                   
                String code = editproduct.getCode();
                String description = editproduct.getDescription();
                String price = editproduct.getPrice()+"";
                  
          %>
        <h1>Products</h1>
        <p>You must enter a description for the product</p>

<form action="updateServlet" method="post">          
            <table cellspacing="4" border="0">
                <tr>
                    <td align="right">Product Code:</td>
                    <td><input type="text" name="updatecode" value="<%=code %>"></td>
                </tr>
                <tr>
                    <td align="right">Product Description:</td>
                    <td><input type="text" name="updatedescription" value="<%=description%>"></td>
                </tr>
                <tr>
                    <td align="right">Product Price:</td>
                    <td><input type="text" name="updateprice" value="<%=price %>"></td>
                </tr>
  </table>                    
                        <input type="submit" name="edit" value="Update Product">                    
                    </form>

            <form action="displayproducts.jsp" method="post">
                    <input type="submit" name="view" value="View Products" >
            </form>

    </body>
</html>
