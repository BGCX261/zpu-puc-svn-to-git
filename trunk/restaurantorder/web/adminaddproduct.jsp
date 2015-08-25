<%@ include file="/include/header.html" %>

    <div id="signout">
        <a onclick="window.location='index.jsp'" href="index.jsp">Sign Out</a>
    </div>

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>
  
    <%@ page import="DB.*, IO.*" %>
    <%@ page import="java.sql.*" %>    
    <div id="customerlogin">
        
<form action="adminaddproduct" method="post"> 
    <table class="tablecenter"  cellspacing="5" cellpadding="5" border="1">
        <tr>
          <td align="right">Attribute</td>
          <td>
              <input type="text" name="Attribute" value="${item.Attribute}">
          </td>
        </tr>
        <tr>
          <td align="right">Itemname</td>
          <td>
              <input type="text" name="Itemname" value="${item.Itemname}">
          </td>
        </tr>
        <tr>
          <td align="right">Description</td>
          <td>
              <input type="text" name="Description" value="${item.Description}">
          </td>
        </tr>    
        <tr>
          <td align="right">Price</td>
          <td>
              <input type="text" name="Price" value="${item.Price}">
          </td>
        </tr>        
    </table>
                  <input type="submit" value="Addproduct" name="Add">
        </form>          

      </div>

<%@ include file="/include/footer.jsp" %>