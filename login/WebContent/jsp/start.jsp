<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rental Services</title>
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
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<a href="#" onclick="userCheck(log)"> <img src="../car.jpg"
						style="width: 1200px; height: 450px" alt="Chania">
					</a>
				</div>

				<div class="item">
					<img src="http://localhost:8080/login/2.jpg" style="width: 1200px; height: 450px"
						alt="Chania">
				</div>

				<div class="item">
					<img src="http://localhost:8080/login/bike.jpg" style="width: 1200px; height: 450px" alt="">
				</div>

			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" role="button"
				data-slide="prev"> <span
				class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
				<span class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel" role="button"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
				<span class="sr-only">Next</span>
			</a>
		</div>
		<%@include file="footer.html"%>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js">
		
	</script>

	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script src="http://localhost:8080/login/js/bootstrap.min.js"></script>
	<script src="http://localhost:8080/login/calc.js"></script>
</body>
</html>