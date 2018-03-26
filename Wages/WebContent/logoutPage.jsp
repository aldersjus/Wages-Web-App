<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Confirm Log Out</title>
<style>
		body{
		background-color:#90CAF9;
		}
		#main{
		 	 text-align:center;
			 background-color:#fff;
			 padding: 50px;
			 border-radius: 1em;
			 width: 350px;
			 margin: 5em auto;
			 
		}
		.button{
			width: 230px;
		    padding: 10px 15px;
		    background-color:#BDBDBD;
			border:none;
		    text-align: center;
		    text-decoration: none;
		    font-size: 12px;
		    margin: 4px 2px;
		}
		p{
			 text-align: center;
			 background-color:#fff;
			 padding: 5px;
			 border-radius: 1em;
		}
	</style>
</head>
<body>
	<p>This application was built by Justin Alderson using HTML, CSS, JSP, JSTL, JNDI, Maven and Java Servlet 3.0</p>
	<hr>
	<div id="main">
		<h3><%=session.getAttribute("user") %>, to complete your log out click the button.</h3>
		<form action="LogoutServlet" method="post">
			<input type="submit" class="button" value="Logout">
		</form>
	</div>
</body>
</html>