<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<%@page contentType="text/html" pageEncoding="UTF-8"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Maintenance</title>
    </head>
    
    
    <body>
     <h1>Products</h1>
     <%@ page import="business.*, data.*, java.util.Date" %>
    
        

    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <th align="center">Code</th>
            <th align="center">Description</th>
            <th align="center">Price</th>
            <th colspan="2"></th>
        </tr>  

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>          
        <c:forEach var="product" items="${displayproducts}">              
        <tr>
            <td align="left">${product.code}</td>            
            <td align="left">${product.description}</td>
            <td align="left">${product.price}</td>
            <td>
            <a href="updateproduct.jsp?productCode=${product.code}&productDesc=${product.description}&productPrice=${product.price}">Edit</a>
            </td>
            <td>
             <a href="deleteproduct.jsp?productCode=${product.code}&productDesc=${product.description}&productPrice=${product.price}">Delete</a>
            </td>
        </tr>
            
    </c:forEach>
</table><br>
    
        <form action="addproduct.jsp" method="post"> 
            <input type="submit" value="Add product">
        </form>
    </body>
</html>

