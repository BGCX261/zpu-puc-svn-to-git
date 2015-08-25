<%@ include file="/include/header.html" %>
        
 <script language="JavaScript"> 
  function validate(form) 
  { 
      if (form.emailaddress.value=="") 
      { 
            alert("Please fill in your Email Address"); 
            form.emailaddress.focus(); 
      } 
      else if (form.password.value=="") 
      { 
            alert("Please fill in your Password"); 
            form.password.focus(); 
      } 
      else if (form.lastname.value=="") 
      { 
            alert("Please fill in your Lastname"); 
            form.lastname.focus(); 
      } 
             else 
       { 
             form.submit(); 
       } 
  } 
  </script> 

    <div id="h1">
        <h1>Restaurant Order Online System</h1>
    </div>
  
  <p><i>${message}</i></p>

  <div id="container">
  <form action="register" method="post">

  <table class="tablecenter"  cellspacing="5" border="0">
    <tr valign="Middle">
      <td align="right">Email Address:</td>
      <td><input type="text" name="emailaddress" 
          value="${customer.emailAddress}">
      </td>
    </tr>
    <tr valign="Middle">
      <td align="right">Password:</td>
      <td><input type="password" name="password"
          value="${customer.passWord}">
      </td>
    </tr>
    <tr valign="Middle">
      <td align="right">LastName:</td>
      <td><input type="text" name="lastname"
          value="${customer.lastName}">
      </td>
    </tr>    
    <tr >
            <td></td>
          <td align="right"><br><input type="button" value="Register" 
            onClick="validate(this.form)">
          </td>  
    </tr>
  </table>
  </form>
      </div>
          
<%@ include file="/include/footer.jsp" %>
