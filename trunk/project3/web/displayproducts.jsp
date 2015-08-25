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
    
       
    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <th align="center">Code</th>
            <th align="center">Description</th>
            <th align="center">Price</th>
            <th colspan="2"></th>
        </tr>  
             
</table><br>
    
        <form action="addproduct.jsp" method="post"> 
            <input type="submit" value="Add product">
        </form>
    </body>
</html>

