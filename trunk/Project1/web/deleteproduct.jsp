<%-- 
    Document   : deleteproduct
    Created on : 2011-9-27, 21:08:13
    Author     : nino
--%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Products Maintaince</title>
    </head>

    <body>
        <!-- import packages and classes needed by the scripts -->
        <%@ page import="business.*, data.*, java.util.Date" %>

        <%
                // get a relative file name
                ServletContext sc = this.getServletContext();
                String path = sc.getRealPath("/WEB-INF/products.txt");
                //String delcode = (String) session.getAttribute( "delecode ");
               // String deldescription = (String) session.getAttribute( "deledescription ");
                String url = request.getQueryString();
  		Product delproduct=new Product();
                delproduct=(Product)session.getAttribute("delproduct" + url);            
                String code = delproduct.getCode();
                String description = delproduct.getDescription();
                String price = delproduct.getPrice()+"";
                //String deleproductCode=request.getParameter( "edit"); 
                Product deleteproduct=ProductIO.getProduct(code,path);
                
                //String deleproductCode=(String) session.getAttribute( "deleproductCode");      
                //String deleproductCode=(String) request.getAttribute("dcode");
                
        %>

        
        <h1>Are you sure you want to delete this product?</h1>
        <table cellspacing="5" cellpadding="5" border="0">
            <tr>
                <td align="right">Product Code:</td>
                <td align="left"><%= code %> </td>
            </tr>
            
            <tr>
                <td align="right">Product Description:</td>
                <td align="left"><%= deleteproduct.getDescription() %></td>
            </tr>
            
            <tr>
                <td align="right">Product Price:</td>
                <td align="left"><%= deleteproduct.getPrice() %> </td>
             </tr>
        </table>
             
<table>
    <tr>
        <td>
            <form action="deleteServlet" method="post"> 
                <input type="hidden" name="productCode" value="<%= code %>">    
                <input type="submit" name="button1" value="Yes">
            </form>
        </td>
        <td>
            <form action="displayproducts.jsp" method="post">
                    <input type="submit" name="button2" value="No" >
            </form>
            </td>
    <tr>
</table>
    </body>
</html>