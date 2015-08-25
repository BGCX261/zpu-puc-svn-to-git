<%@ include file="/include/header.html" %>

    <div id="h1">
        <h1>Check out</h1>
    </div>
    
    <p><i>${message}</i></p>
      <div id="container">
  <form action="Checkout" method="post">

  <table class="tablecenter"  cellspacing="5" border="0">
    <tr>
      <td align="right">Creadit Card:</td>
      <td><input type="text" name="cardnumber" 
          value="${check.cardnumber}">
      </td>
    </tr>
    <tr>
      <td align="right">Security Number</td>
      <td><input type="password" name="Password"
          value="${check.number}">
      </td>
    </tr>
    <tr>
      <td align="right">Holder's Name:</td>
      <td><input type="text" name="Name"
          value="${check.Name}">
      </td>
    </tr>

  </table>
<input type="submit" value="Pay">
  </form>
      </div>

<%@ include file="/include/footer.jsp" %>