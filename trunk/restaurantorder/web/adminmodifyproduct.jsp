<%@ include file="/include/header.html" %>

    <div id="signout">
        <a onclick="window.location='index.jsp'" href="index.jsp">Sign Out</a>
    </div>

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>
    
    <p><i>${message}</i></p>
      <div id="customerlogin">
     <%@page import="java.util.Iterator"%>
    <%@page import="java.util.ArrayList"%>
    <%@ page import="DB.*, IO.*" %>
    <%@page import="java.sql.*" %>
<%
    //Item item=(Item) session.getAttribute("edititem");
    //session.removeAttribute("edititem");
        String itemname=request.getParameter("name");
        ConnectionPool pool = ConnectionPool.getInstance();
        Connection connection = pool.getConnection();
        PreparedStatement ps = null;
        Item item = new Item();
        
	String query =  "select * from item where Name =" + "'" + itemname+"'" ;
            try {
                ps = connection.prepareStatement(query);
                ResultSet rs = null;
                rs = ps.executeQuery();    
            
            //get items from the database
	    if(rs.next()) {
                    item.setAttribute(rs.getString(2));
                    item.setItemname(rs.getString(3));
                    item.setDescription(rs.getString(4));
                    item.setPrice(rs.getFloat(5));
	    }
	    rs.close();
	    ps.close();
	} catch (java.sql.SQLException sql) {
	    sql.printStackTrace();
	}

%>
  <form action="adminmodifyproduct" method="post">

      <table class="tablecenter"  cellspacing="5" border="0">
        <tr>
          <td align="right">Attribute</td>
          <td><input type="text" name="Attribute" 
              value="<%=item.getAttribute()%>">
          </td>
        </tr>
        <tr>
          <td align="right">Item Name</td>
          <td><input type="text" name="Itemname"
              value="<%=item.getItemname()%>">
          </td>
        </tr>
        <tr>
          <td align="right">Description</td>
          <td><input type="text" name="Description"
              value="<%=item.getDescription()%>">
          </td>
        </tr>
        <tr>
          <td align="right">Price:</td>
          <td><input type="text" name="Price"
              value="<%=item.getPrice()%>">
          </td>
        </tr>
        <tr>
            <td></td>
            <td align="center">
                <br><input type="submit" value="Modify" name="adminmodifyproduct">
            </td>
            </tr>
      </table>
      
  </form>
</div>

<%@ include file="/include/footer.jsp" %>