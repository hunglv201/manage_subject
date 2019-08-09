<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.ArrayList"%>
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
<%MonHoc m=(MonHoc)request.getAttribute("mon"); %>
	<h2>Manage Subject:</h2>
	<div class="container">
		<h3>add new subject:</h3>
	</div>
	<br>
	<div class=" col-sm-4 center-block">

		<form class="form-horizontal" action="CS" method="get">
		<input type="hidden" name="action" value="update">
			<div class="form-group">
				<label class="control-label col-sm-4" >ID</label>
				<div class="col-sm-8">
					<input type="text"  class="form-control" name="id" 
						value="<%=m.getId()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4" >Name
					subjet:</label>
				<div class="col-sm-8">
					<input type="text" class="form-control" name="tenmh" 
						value="<%=m.getTenmh()%>">
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-sm-4 ">Number of
					credits:</label>
				<div class="col-sm-8">
					<input class="form-control" name="sotc"
						 value="<%=m.getSotc()%>">
				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-4 col-sm-8">
					<button  class="btn btn-primary" type="submit">Submit</button>
				</div>
			</div>
		</form>
	</div>

</body>
</html>
