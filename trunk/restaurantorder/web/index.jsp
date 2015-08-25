<%@ include file="/include/header.html" %>

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>
    
    <p><i>${message}</i></p>
      <div id="container">
  <form action="login" method="post">
      
  <table class="tablecenter" cellspacing="2" border="0">
    <tr valign="Middle">
      <td align="right">Email Address:</td>
      <td><input type="text" name="EmailAddress" 
          value="${customer.emailAddress}">
      </td>
    </tr>
    <tr valign="Middle">
      <td align="right">Password:</td>
      <td><input type="password" name="Password"
          value="${customer.passWord}">
      </td>
    </tr>
    <tr valign="Middle">
       <td align="right" >
        <input type="button" value="Register" onclick="window.location='register.jsp'"/>
        </td>
        <td align="center" >
            <input type="submit" value="Login" name="Login" size="18">
        </td>
    </tr>
  </table>
      
  </form>
      </div>

<%@ include file="/include/footer.jsp" %>
