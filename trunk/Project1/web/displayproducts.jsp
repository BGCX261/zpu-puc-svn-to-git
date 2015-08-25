<%--
    Document   : displayproducts
    Created on : 2011-9-21, 21:03:27
    Author     : nino
--%>
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

        
<%
        ServletContext sc = getServletContext(); 
        String path = sc.getRealPath("/WEB-INF/products.txt");
        ArrayList<Product> products=ProductIO.getProducts(path);    
%>

    <table cellspacing="5" cellpadding="5" border="1">
        <tr>
            <th align="center">Code</th>
            <th align="center">Description</th>
            <th align="center">Price</th>
            <th colspan="2"></th>
        </tr>  
        
        <%
        for(int i=0;i<products.size();i++)
        //for(Product p: products)
        {  
        %>
                      
        <tr>
            <td align="left"><%= (products.get(i)).getCode() %></td>            
            <td align="left"><%= (products.get(i)).getDescription() %></td>
            <td align="left"><%= (products.get(i)).getPrice() %></td>
            <td>
                <form action="<%= response.encodeURL("updateproduct.jsp?"+i)%>" method="post"> 
                    <input type="hidden" name="edit" value="(products.get(i)).getCode()" />
                    <input type="submit" value="Edit" />
                    
                    <%
                     //session.setAttribute("edproductCode",p.getCode()); 
                    //String ecode=(products.get(i)).getCode();
                    //request.setAttribute("ecode",ecode);
                            Product editproduct=new Product();
                            editproduct.setCode((products.get(i)).getCode());
                            editproduct.setDescription((products.get(i)).getDescription());
                            editproduct.setPrice((products.get(i)).getPrice());
                            session.setAttribute("editproduct"+i, editproduct);  
                    %>
                </form>
            </td>
            <td>
                <form action="<%=response.encodeURL("deleteproduct.jsp?"+i)%>" method="post">
                    <input type="submit" value="Delete" />
                    <%   
                            Product delproduct=new Product();
                            delproduct.setCode((products.get(i)).getCode());
                            delproduct.setDescription((products.get(i)).getDescription());
                            delproduct.setPrice((products.get(i)).getPrice());
                            session.setAttribute("delproduct"+i, delproduct);  
                        //session.setAttribute("dcode",dcode);
                        //session.setAttribute( "deleproductCode",p.getCode()); 
                        //request.setAttribute( "deleproduct ",deleproduct); 
                        //String  dcode=products.get(i).getCode();
                        //session.setAttribute( "delecode ",dcode); 
                        //.setAttribute( "deleprice ",dprice);                 
%>                    
               </form>
            </td>
        </tr>
            
    <% 
            } 
    %> 
    </table><br>
    
        <form action="addproduct.jsp" method="post"> 
            <input type="submit" value="Add product">
        </form>
    </body>
</html>

