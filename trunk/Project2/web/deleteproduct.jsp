<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>Products Maintaince</title>
    </head>

    <body>
        <!-- import packages and classes needed by the scripts -->
        <%@ page import="business.*, data.*, java.util.Date" %>

        
        <h1>Are you sure you want to delete this product?</h1>
        <table cellspacing="5" cellpadding="5" border="0">
            <tr>
                <td align="right">Product Code:</td>
                <td align="left">${param.productCode} </td>
            </tr>
            
            <tr>
                <td align="right">Product Description:</td>
                <td align="left">${param.productDesc}</td>
            </tr>
            
            <tr>
                <td align="right">Product Price:</td>
                <td align="left">${param.productPrice} </td>
             </tr>
        </table>
             
<table>
    <tr>
        <td>
            <form action="deleteServlet" method="post"> 
                <input type="hidden" name="productCode" value="${param.productCode}">    
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