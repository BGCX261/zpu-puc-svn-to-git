<%@ include file="/include/header.html" %>

    <div id="signout">
        <a onclick="window.location='index.jsp'" href="index.jsp">Sign Out</a>
    </div>

    <div id="h1">
        <h1>Shopping</h1>
    </div>  
    <p><i>${message}</i></p>
    <div id="container">
    <%@page import="java.util.Iterator"%>
    <%@page import="java.util.ArrayList"%>
    <%@ page import="DB.*, IO.*" %>
    <%@page import="java.sql.*" %>
    
    <table class="tablecenter"  cellspacing="5" border="1">
        <tr>
            <th align="center">Attribute</th>
            <th align="center">Itemname</th>
            <th align="center">Description</th>
            <th align="center">Price</th>
            <th colspan="2"></th>
        </tr> 
        
    <%
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        int quantity=0;
        
	String query = "select * from item";
        try {
            ps = connection.prepareStatement(query);
	    ResultSet rs = null;
	    rs = ps.executeQuery();           
	    //Item item = new Item();   
            Order order = (Order) session.getAttribute("order"); 
            
            //get items from the database
            //OrderItem oi = new OrderItem();
            
	    while (rs.next()) {
                /*
                    item.setAttribute(rs.getString(1));
                    String itemname=rs.getString(2);
                    item.setItemname(rs.getString(2));
                    item.setDescription(rs.getString(3));
                    
                    //find that item from the DB
                    item=ItemsDB.finditem(itemname);                   
                    oi.setItem(item);
                    oi.setQuantity(quantity);
                    if (quantity > 0)
                        order.addItem(oi);
                    else if (quantity <= 0)
                        order.removeItem(oi);       
  */    
                
                %>     
            <tr>
                <td align="center"><%= rs.getString(2) %></td>
                <td align="center"><%= rs.getString(3) %></td>
                <td align="center"><%= rs.getString(4) %></td>
                <td align="center"><%= rs.getFloat(5) %> </td>
                <td align="center">                    
                    <a href="order?name=<%=rs.getString(3)%>">add to cart</a>                   
                 </td>
            </tr>
            
          <%   
	    }
            session.setAttribute("order", order);
	    rs.close();
	    ps.close();
	} catch (java.sql.SQLException sql) {
	    sql.printStackTrace();
	}
             %>
</table>
     </div>

<%@ include file="/include/footer.jsp" %>
