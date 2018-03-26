<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.time.LocalDate" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<style>
			body{
				background-color:#90CAF9;
			}
			p{
				 text-align: center;
				 background-color:#fff;
				 padding: 5px;
				 border-radius: 1em;
			}
			#main{
			 	 text-align:center;
				 background-color:#fff;
				 padding: 50px;
				 border-radius: 1em;
				 width: 250px;
				 margin: 5em auto;
			 
			}
			#top{
				 width: 200px;
				 height:40px;
				 background-color:#fff;
				 padding:5px;
				 border-radius: 1em;
			}
			table,th,td{
				padding:10px;
			}
		</style>
		
		<title>Logged in</title>	
	</head>
	<body>
		<p>This application was built by Justin Alderson using HTML, CSS, JSP, JSTL, JNDI, Maven and Java Servlet 3.0</p>
		<hr>
		<%
			String[] titles = {"January","February","March","April","May","June","July","August","September","October","November","December"};
			request.setAttribute("months", titles);
			LocalDate d = LocalDate.now();
			int month = d.getMonthValue();
			request.setAttribute("date", month);
		%>
		<div id="top">
			<a href="logoutPage.jsp"> Logout Page</a>
			<br>
				Logged in as <%=session.getAttribute("user")%>.
			<br><br>
			<br><br>
		</div>
		<div id="main">
			<table>
				<tr>
					<th>Month</th>
					<th>Pay Slip</th>
				</tr>
				<c:set var="date" scope="page" value="${date}"></c:set>
				<c:forEach var="temp" begin="1" end="12">
					<c:choose>
						<c:when test="${temp <= date}">
							<tr>
								<td>${months[temp - 1]}</td>
								<td><a href=${pageContext.request.contextPath}/DisplayPayServlet?month=${months[temp-1]}>Link to pay slip</a></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr>
							 	<td>${months[temp - 1]}</td>
								<td>Link to pay slip</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</c:forEach>
			</table>
		</div>
		
	</body>
</html>
















