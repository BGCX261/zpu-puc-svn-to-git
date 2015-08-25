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

        <h1>Products</h1>
        <p>You must enter a description for the product</p>

    
    <form action="addproductServlet" method="post">

    <table cellspacing="4" border="0">   
        <tr>
            <td align="right"><b>Product Code:</b></td>
            <td><input type="text" name="addcode"></td>
       </tr>
       <tr>
            <td align="right"><b>Product Description:</b></td>
            <td><input type="text" name="adddescription"></td>
       </tr>
       <tr>
            <td align="right"><b>Product Price:</b></td>
            <td><input type="text" name="addprice"></td>
        </tr>    
    </table>
    <input type="submit" value="Update Product">
  	</form>
    <br>
    
    <form action="displayproducts.jsp" method="post">
    	<input type="submit" value="View Products">
    </form>
    </body>
</html>
