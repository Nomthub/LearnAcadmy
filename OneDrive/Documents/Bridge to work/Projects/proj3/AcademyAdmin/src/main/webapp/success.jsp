<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login success</title>
</head>
<body>
<%
	if(session.getAttribute("uname")==null){
		response.sendRedirect("Logininput.jsp");
	}
	else{
		response.sendRedirect("Search.jsp");
	}
%>

</body>
</html>