<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Imports -->
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<meta http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1, width=device-width, initial-scale=1">
<title>Update Menu item</title>
</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<!-- side bar -->
			<div class="col-sm-3 col-md-2 sidebar">
				<ul class="nav nav-sidebar">
					<li class="active"><a href="index.jsp">Home</a></li>
					<li><a href="add.html">Add an item</a></li>
				</ul>
			</div>

			<!-- main content -->
			<div class="col-sm-9">
				<div class="row placeholders">

					<%@ page
						import="com.menuDB.DAO2, com.menuDB.MenuItem, com.menuDB.AddToDBServ"%>
					<%!MenuItem itemToBeUpdated = new MenuItem();%>
					<%
						String menuID = (String) session.getAttribute("menuID");
					%>
					<%
						itemToBeUpdated = DAO2.findInDB(menuID);
					%>

					<h2 class="Users">User</h2>
					<div class="table-responsive">
						<form action="UpdateInDBServ" method="post">
							<table class="table table-striped table-bordered">
								<thead>
									<tr>
										<th class="col-sm-1">ID #</th>
										<th class="col-sm-2">food name</th>
										<th class="col-sm-2">cost</th>
										<th class="col-sm-3">time served</th>
										<th class="col-sm-1">healthy option?</th>
										<th class="col-sm-1"></th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><input type="text" class="form-control" name="menuID"
											id="menuID"
											value="<%out.print(itemToBeUpdated.getMenuID());%>"
											readonly></td>
										<td><input type="text" class="form-control"
											name="foodname" id="foodname"
											value="<%out.print(itemToBeUpdated.getFoodName());%>"></td>
										<td><input type="text" class="form-control"
											name="cost" id="cost"
											value="<%out.print(itemToBeUpdated.getCost());%>"></td>
										<td><input type="text" class="form-control" name="timeserved"
											id="timeserved"
											value="<%out.print(itemToBeUpdated.getTimeServed());%>"></td>
										<td><input type="text" class="form-control" name="healthymenu"
											id="healthymenu" value="<%out.print(itemToBeUpdated.getHealthyMenu());%>"></td>
										<td><button class="btn btn-default" name="submit"
												type="submit" id="submit">Submit</button></td>
									</tr>
								</tbody>
							</table>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>