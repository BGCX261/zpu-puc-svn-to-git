<%@ include file="/include/header.html" %>

    <div id="signout">
        <a onclick="window.location='index.jsp'" href="index.jsp">Sign Out</a>
    </div>

    <h1>Restaurant Order Online System</h1>
  
    <%@page import="java.util.Iterator"%>
    <%@page import="java.util.ArrayList"%>
    <%@ page import="DB.*, IO.*" %>
    <%@page import="java.sql.*" %>    
    <p><i>${message}</i></p>
 <div id="container">
    <div id="adminproduct">

    <table class="tablecenter"  cellspacing="5" cellpadding="5" border="1">
        <tr>
            <th align="center">Attribute</th>
            <th align="center">Itemname</th>
            <th align="center">Description</th>
            <th align="center">Price</th>
            <th align="center"> </th>
        </tr> 
        
    <%
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        
	String query = "select * from item";
        try {
            ps = connection.prepareStatement(query);
	    ResultSet rs = null;
	    rs = ps.executeQuery();
            
	    Item item = new Item();
            
            //get items from the database
	    while (rs.next()) {
		item.setAttribute(rs.getString(2));
		item.setItemname(rs.getString(3));
		item.setDescription(rs.getString(4));
		item.setPrice(rs.getFloat(5));
                session.setAttribute("edititem",item);
                //String att=rs.getString(2);
                
     %>
     
            <tr>
                <td align="left"><%= rs.getString(2) %></td>               
                <td align="left"><%= rs.getString(3) %></td>
                <td align="left"><%= rs.getString(4) %></td>
                <td align="left"><%= rs.getFloat(5) %></td>
                
                
                <td align="left"><a href="adminmodifyproduct.jsp?name=<%=rs.getString(3)%>">Edit this item</a></td>
                <td align="left"><a href="admindeleteproduct?name=<%=rs.getString(3)%>">Delete this item</a></td>
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
      <a href="adminaddproduct.jsp">Add new course or drink to this system!</a>
      </div>
</div>

<%@ include file="/include/footer.jsp" %>