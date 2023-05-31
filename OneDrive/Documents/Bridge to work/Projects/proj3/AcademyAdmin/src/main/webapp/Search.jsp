<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
Welcome to Learner's Academy, <%=session.getAttribute("uname") %>
<br> 
Login Successful!
</h1>
<form action="Search" method="post">

<h1>Class Report</h1><br/>
Enter the class id: <input type="text" name="Clsid"/><br/>
<input type="submit" value="Search">

</form>
<br>
<form action=Logout>
<input type = submit value=Logout>
</form>
</body>
</html>