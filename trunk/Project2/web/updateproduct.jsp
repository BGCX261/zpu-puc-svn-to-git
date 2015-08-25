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

        <%@ taglib prefix="mma" uri="/WEB-INF/product.tld" %>

        <p><mma:Fill color="blue" field=""/> marks required fields</p>

        <h1>Products</h1>
        <p>You must enter a description for the product</p>

        <form action="updateServlet" method="post">    
            <table cellspacing="4" border="0">
                <tr>
                    <td align="right">Product Code:</td>
                    <td><input type="text" name="code" value="${param.productCode}"></td>
                </tr>
                
                <tr>
                    <td align="right">Product Description:</td>
                    <td><input type="text" name="description" 
                               value="${param.productDesc}">
                    <mma:Fill color="blue" field="${param.productDesc}"/>
                    </td>
                </tr>
                
                <tr>
                    <td align="right">Product Price:</td>
                    <td><input type="text" name="price" 
                               value="${param.productPrice}">
                    <mma:Fill color="blue" field="${param.productPrice}"/>
                    </td>
                </tr>
            </table>
                    <input type="submit" name="edit" value="Update Product">
        </form>


            <form action="displayproducts.jsp" method="post">
                    <input type="submit" name="view" value="View Products" >
            </form>


    </body>
</html>
