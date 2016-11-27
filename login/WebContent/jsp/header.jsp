<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Rental Services</title>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="http://localhost:8080/login/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="http://localhost:8080/login/css/bootstrap-theme.min.css"
	type="text/css" />
<link rel="stylesheet" href="http://localhost:8080/login/css/footer.css" type="text/css" />
</head>
<body>
	<jsp:useBean id="user" class="com.model.User" scope="session"></jsp:useBean>
	<%
		String logLabel="";
		try {
			logLabel = (String) request.getSession().getAttribute(
					"logLabel");
			if (logLabel == null) {
				logLabel = "Login";
			}
		} catch (Exception e) {}
	%>
	<nav class="navbar navbar-default">
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a href="start.jsp"> <img src="http://localhost:8080/login/logo.jpeg" height="50"
				width="120" alt="Chania">
			</a>
		</div>


		<form class="navbar-form navbar-left" action="http://localhost:8080/login/GetReservationStatus" method="post">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="Reservation Status Search" name="reservationId">
			</div>
			<button type="submit" class="btn btn-default">Submit</button>
		</form>
		<ul class="nav navbar-nav navbar-right">
			<li><a href="#" onclick="userCheck('<%=logLabel%>')">Order Car</a></li>
			<li><a href="http://localhost:8080/login/order.html">Order Bike</a></li>
			<li><a href="http://localhost:8080/login/order.html">Order Truck</a></li>
			<li><a href="http://localhost:8080/login/order.html">Order Truck</a></li>

			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">More <b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">Contact Us</a></li>
					<li><a href="#">About Us</a></li>
				</ul></li>
 
			<li><a href="#" onclick="checkLog('<%=logLabel%>')"><%=logLabel%></a></li>

		</ul>
	</div>
	</nav>

	<%
		String logvisibility;
		logvisibility = (String) request.getSession().getAttribute("logvisibility");
		if (logvisibility == null) {
			logvisibility = "hidden";
		}
		request.getSession().removeAttribute("logvisibility");
	%>


	<div id="loginModal" class="modal show" style="visibility:<%=logvisibility %>">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<%
						String frmheader,email="";
						frmheader = (String) request.getSession().getAttribute("frmheader");
						if (frmheader == null) {
							frmheader = "Login";
						}
						if(!frmheader.equals("Login"))
						{
							email = (String) request.getSession().getAttribute("email");
						}
						request.getSession().removeAttribute("frmheader");
						request.getSession().removeAttribute("email");
					%>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true" onclick="loginHide()">×</button>
					<h1 class="text-center"><%=frmheader%></h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" action="/login/LoginServlet"
						method="post">
						<div class="form-group">
							<input type="text" name="email" value="<%=email %>" class="form-control input-lg"
								placeholder="Email">
						</div>
						<div class="form-group">
							<input type="password" name="password"
								class="form-control input-lg" placeholder="Password">
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">Sign In</button>

						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" onclick="registerShow()">Register</button>
					<button class="btn btn-primary" onclick="loginHide()">Cancel</button>
				</div>
				</div>
			</div>
		</div>
	


	<div id="registerModal" class="modal show" style="visibility: hidden">
		<div class="modal-dialog" style="height:300px;">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" onclick="registerHide()">×</button>
					<h1 class="text-center">Register</h1>
				</div>
				<div class="modal-body">
					<form class="form col-md-12 center-block" action="/login/RegistratServlet"
						method="post">
						<div class="form-group">
							<input type="text" name="fname" id="fn"
								class="form-control input-lg" placeholder="FirstName">
						</div>
						<div class="form-group">
							<input type="text" name="lname" id="ln"
								class="form-control input-lg" placeholder="LastName">
						</div>
						<div class="form-group">
							<input type="text" id="email" name="email" value=""
								class="form-control input-lg" placeholder="Email">
						</div>
						<div class="form-group">
							<input type="password" name="password" id="pass"
								class="form-control input-lg" placeholder="Password">
						</div>
						<div class="form-group">
							<input type="text" name="address" id="ln"
								class="form-control input-lg" placeholder="Address">
						</div>
						<div class="form-group">
							<input type="text" name="phno" id="ln"
								class="form-control input-lg" placeholder="Phone No">
						</div>
						<div class="form-group">
							<input type="text" name="bdate" id="ln"
								class="form-control input-lg" placeholder="Birth Date">
						</div>
						<div class="form-group">
							<button class="btn btn-primary btn-lg btn-block">Register</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">					
						<button class="btn btn-primary" onclick="registerHide()">Cancel</button>
				</div>
			</div>
		</div>
	</div>


	<div id="userdialog" class="modal show" style="visibility: hidden;">
		<div class="modal-dialog" style="width: 300px;">
			<div class="modal-content">
				<!-- dialog body -->
				<div class="modal-body">
					<button type="button" class="close" data-dismiss="modal"
						onclick="userDialogHide()">&times;</button>
					<h3>Hi 
					<%="     " + logLabel%> &#9786;</h3>
				</div>
				<!-- dialog buttons -->
				<form action="/login/UserOption" method="post">
					<div class="modal-footer">
						<button type="submit" name="action" value="viewprofile"
							class="btn btn-primary btn-lg btn-block">View Profile</button>
					</div>
					<div class="modal-footer">
						<button type="submit" name="action" value="signout"
							class="btn btn-primary btn-lg btn-block">SignOut</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
