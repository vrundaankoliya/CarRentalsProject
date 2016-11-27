<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Order</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://localhost:8080/login/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:8080/login/css/bootstrap-theme.min.css"
	type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/login/css/footer.css" type="text/css" />
</head>
<body>
	<div class="container">
		<%@include file="header.jsp"%>
		<div class="modal-body">
			
				<div class="form-group">
					<h1><span class="label label-default">Thanks for your booking your order number is : <%=request.getSession().getAttribute("confirmationNo") %></span></h1>
				</div>
				
		</div>
	</div>
		<div class="container">
		<%@include file="footer.html"%>
		</div>
		<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
		
	</script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="http://localhost:8080/login/js/bootstrap.min.js"></script>
	<script src="http://localhost:8080/login/calc.js"></script>
	<div class="container">
</body>
</html>