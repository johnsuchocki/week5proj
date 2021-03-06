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
<link href="https://fonts.googleapis.com/css?family=Cinzel"
	rel="stylesheet">
<link rel="stylesheet" href="main.css">

<meta http-equiv="Content-Type"
	content="text/html; charset=ISO-8859-1, width=device-width, initial-scale=1">
<title>Menu Database Home</title>
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
			<div class="col-sm-6">
				<div class="row placeholders">

					<h2 class="Users">Menu items</h2>
					<div class="table-responsive">
						<table class="table table-striped table-bordered">
							<thead>
								<tr>
									<th class="col-sm-1">ID #</th>
									<th class="col-sm-2">food name</th>
									<th class="col-sm-1">cost</th>
									<th class="col-sm-2">time served</th>
									<th class="col-sm-1">healthy option?</th>
									<th class="col-sm-1">edit</th>
									<th class="col-sm-1">delete</th>
								</tr>
							</thead>
							<tbody>

								<%@ page
									import="java.util.ArrayList, com.menuDB.DAO2, com.menuDB.MenuItem"%>
								<%!ArrayList<MenuItem> allItems = new ArrayList<>();%>
								<%!String menuID = null;%>
								<%!MenuItem currentItem = new MenuItem();%>
								<%
									allItems = DAO2.readFromDB();
									for (int i = 0; i < allItems.size(); i++) {
										currentItem = allItems.get(i);
										menuID = currentItem.getMenuID();
								%>
								<tr>
									<td id="id<%out.print(menuID);%>">
										<%
											out.print(menuID);
										%>
									</td>
									<td>
										<%
											out.print(currentItem.getFoodName());
										%>
									</td>
									<td>
										<%
											out.print(currentItem.getCost());
										%>
									</td>
									<td>
										<%
											out.print(currentItem.getTimeServed());
										%>
									</td>
									<td>
										<%
											out.print(currentItem.getHealthyMenu());
										%>
									</td>
									<td><form name="edit" action="FindItemInDBServ"
											method="post">
											<button name="edit" type="submit"
												value="<%out.print(menuID);%>">
												<img src="file_edit.png" width="17" height="17"
													class="img-responsive">
											</button>
										</form></td>
									<td><form name="delete" action="DeleteFromDBServ"
											method="post">
											<button name="delete" type="submit"
												value="<%out.print(menuID);%>">
												<img src="file_delete.png" width="16" height="16"
													class="img-responsive">
											</button>
										</form></td>
								</tr>

								<%
									} // for loop
								%>

							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>