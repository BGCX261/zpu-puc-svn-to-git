<%@ include file="/include/header.html" %>

    <div id="signout">
        <a onclick="window.location='index.jsp'" href="index.jsp">Sign Out</a>
    </div>

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>
    
    <p><i>${message}</i></p>
      <div id="container">


<table class="tablecenter"  border="1" cellpadding="5">
  <tr>
    <th>Quantity</th>
    <th>Description</th>
    <th>Price</th>
  </tr>

<%@ page import="IO.*, java.util.ArrayList,java.text.DecimalFormat,java.text.NumberFormat "%>
    <%@ page import="DB.*, IO.*" %>
    <%@page import="java.sql.*" %>
    
<% 
   double total=0;
   int Quantity=1;
   ConnectionPool pool = ConnectionPool.getInstance();
   Connection connection = pool.getConnection();
   PreparedStatement ps = null;
   ArrayList<Item> items=new ArrayList();
   String emailaddress=(String) session.getAttribute("EmaiAddress");
   Integer quantity=(Integer) session.getAttribute("quantity");
   Double amount=(Double) session.getAttribute("amount");
   
	String query = "select * from orderdb WHERE EmailAddress='"+emailaddress+"'";
        try {
            ps = connection.prepareStatement(query);
	    ResultSet rs = null;
	    rs = ps.executeQuery();           
	    //Item item = new Item();   
            Order order = (Order) session.getAttribute("order"); 
                   
   //         Int Quantity = (Int) session.getAttribute("quantity"); 
	    while (rs.next()) {
                    Item item=new Item();
                    String itemname=rs.getString(3);
                    
                    //find that item from the DB
                    item=ItemsDB.finditem(itemname);
                    OrderItem orderitem=new OrderItem();
                    orderitem.setItem(item);
                    items.add(item);
                %>     
  <tr valign="top">
    <td>
        <form action="updateorder?name=<%=itemname%>" method="post">
        <input type="hidden" name="name" 
               value="<%=itemname%>">
        <input type="text" size=2 name="quantity" 
               value="<%= quantity%>">
        <input type="submit" value="Update">
      </form>
    </td>
    <td>
      <%=item.getDescription()%>
    </td>
    <td>
      <%=item.getPrice()%>
    </td>
    <td>
      <form action="DeleteOrderItem?name=<%=itemname%>" method="post">
        <input type="hidden" name="name" 
               value="<%=itemname%>">
        <input type="hidden" name="delete" 
               value="0">
        <input type="submit" value="Remove Item">
      </form>
    </td>
  </tr>
            
          <%   
	    }
	    rs.close();
	    ps.close();
	} catch (java.sql.SQLException sql) {
	    sql.printStackTrace();
	}
             %>
</table>

<form action="<%= response.encodeURL("Menu.jsp")%>" method="post">
  <input type="submit" name="continue" value="Continue Shopping">
</form>

<form action="Checkout" method="post">
  <input type="submit" name="checkout" value="Checkout">
</form>

<%@ include file="/include/footer.jsp" %>