<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<% System.out.println("In login.jsp Page"); %>
<form:form method="post" action="login.htm" commandName="loginModel">
   UserName:<form:input path="username" />
	<BR>
   PassWord:<form:password path="password" />
	<BR>
	<input type="submit" value="LOGIN" />
</form:form>