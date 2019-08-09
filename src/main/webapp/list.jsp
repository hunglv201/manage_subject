<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
<%@page import="entity.MonHoc"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mangeSubject</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

</head>
<body>
	<%ArrayList<MonHoc> list=(ArrayList<MonHoc>)request.getAttribute("list"); %>
	
	<h2>Manage Subject:</h2>
	<div class="container">
		<h3>List Subject</h3>
		<a class="btn btn-primary" href="formAdd.jsp"> <span
			class="glyphicon glyphicon-plus"></span> <span>Add Subject</span>
		</a> <br> <br>
		<table class="table table-striped">
			<thead>
			
				<tr>
					<th scope="col">ID</th>
					<th scope="col">Name Subject</th>
					<th scope="col">number of credits</th>
					<th scope="col">Update</th>
					<th scope="col">Delete</th>
				</tr>
			
			</thead>
			<tbody>
				<%for( MonHoc i:list){ %>
				<tr>
					<td><%=i.getId() %></td>
					<td><%=i.getTenmh() %></td>
					<td><%=i.getSotc() %></td>
					<td><a class=" btn btn-success" href="CS?action=form&id=<%=i.getId()%>"> <span
							class="glyphicon glyphicon-pencil"></span>
					</a></td>
					<td><a class=" btn btn-danger" href="CS?action=delete&id=<%=i.getId()%>"> <span
							class="glyphicon glyphicon-remove"></span>
					</a></td>
				</tr>
				<%}%>
				
			</tbody>
		</table>
	</div>
</body>
</html>
