<%@ page import="java.util.*" %>
<%
    // initialize the current year that's used in the copyright notice
    GregorianCalendar currentDate = new GregorianCalendar();
    int currentYear = currentDate.get(Calendar.YEAR);
%>
<div id="footer">
<p>    
<a href="adminlogin.jsp">Administrator Login</a><br>Developed by Zhengwei Pu & Yizhuo Zhan  <%=currentYear%>         
</p>
</div>
</body>
</html>