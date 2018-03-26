<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Pay Slip</title>

</head>
<body>

	<p>This application was built by Justin Alderson using HTML,CSS,JSP,JSTL,JNDI, Maven and Java Servlet 3.0</p>
	<hr>
	<div id="top">
			<a href="logoutPage.jsp"> Logout Page</a>
			<br>
			Logged in as <%=session.getAttribute("user") %>.
			<br><br>
			<br><br>
	</div>
	
	<div id="maintwo">
			<table>
				<tr>
					<th> <%=session.getAttribute("user") %></th>
					<th> </th>
					<th> <%=request.getAttribute("month") %></th>
					<th> </th>
				</tr>
				<tr>
					<td>Hours Worked</td>
					<td><%=request.getAttribute("hoursWorked") %></td>
					<td>Overtime Worked</td>
					<td><%=request.getAttribute("overtimeWorked") %></td>
				</tr>
			
				<tr>
					<td>Base Pay</td>
					<td><%=request.getAttribute("base") %></td>
					<td>Overtime Pay</td>
					<td><%=request.getAttribute("overtime") %></td>
				</tr>
				
				<tr>
					<td>Shift Allowance</td>
					<td><%=request.getAttribute("shift") %></td>
					<td>Regularity Allowance</td>
					<td><%=request.getAttribute("regularity") %></td>
				</tr>
				
				<tr>
					<td>Health Deduction</td>
					<td>-<%=request.getAttribute("health") %></td>
					<td>Tax</td>
					<td>-<%=request.getAttribute("tax") %></td>
				</tr>
				
				<tr>
					<td>Total Pay</td>
					<td><%=request.getAttribute("total") %></td>
					<td>Actual Pay</td>
					<td><%=request.getAttribute("actual") %></td>
				</tr>
			</table>
	</div>
	
</body>
</html>












