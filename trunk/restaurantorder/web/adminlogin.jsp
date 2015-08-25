<%@ include file="/include/header.html" %>

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>

    <p><i>${message}</i></p>

    <div id="adminlogin">
  <form action="adminlogin" method="post">
  <table class="tablecenter"  cellspacing="5" border="0">
    <tr>
      <td align="right">Title</td>
      <td><input type="text" name="Title"
          value="${staff.passWord}">
      </td>
    </tr>
    
      <tr>
      <td align="right">Password:</td>
      <td><input type="password" name="Password"
          value="${staff.passWord}">
      </td>
    </tr>
    <tr>
        <td align="right"> </td>
        <td align="right"><br><input type="submit" value="Login" name="Login"></td>
    </tr>
  </table>
  </form>
      </div>
          
<%@ include file="/include/footer.jsp" %>
