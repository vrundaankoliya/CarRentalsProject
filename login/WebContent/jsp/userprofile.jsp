<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%@include file="header.jsp"%>
	<h1>
		First Name =
		<jsp:getProperty property="fname" name="user" />
	</h1>
	<h1>
		Last Name =
		<jsp:getProperty property="lname" name="user" />
	</h1>
	<h1>
		Address =
		<jsp:getProperty property="address" name="user" />
	</h1>
	<h1>
		Phone Number =
		<jsp:getProperty property="phno" name="user" />
	</h1>
	<h1>
		Birth Date =
		<jsp:getProperty property="bdate" name="user" />
	</h1>
	<h1>
		Email =
		<jsp:getProperty property="email" name="user" />
	</h1>

	<%@include file="footer.html"%>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
		
	</script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="http://localhost:8080/login/js/bootstrap.min.js"></script>
	<script src="http://localhost:8080/login/calc.js"></script>
</body>
</html>