<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html ng-app="myApp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="<c:url value="/resources/angularjs/myscript.js" />"></script>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-controller="NavigationController">
	<div class="container">
		<div class="row">
			<h1>Freshmen web</h1>
		</div>
		<div class="row">
			<table>
				<tr>
					<td><label for="InputName">Name</label></td>
					<td><input type="text" name="InputName" ng-model="name"
						id="InputName"></td>
				</tr>
				<tr>
					<td><label for="InputCity">Occupation</label></td>
					<td><input type="text" name="InputOccupation"
						ng-model="occupation" id="InputOccupation"></td>
				</tr>
				<tr>
					<td><button ng-click="save()">Save</button></td>
					<td></td>
				</tr>
			</table>
		</div>
		<div class="row">
			<table class="table">
				<tr>
					<th>#</th>
					<th>Name</th>
					<th>Occupation</th>
					<th></th>
					<th></th>
				</tr>
				<tr ng-repeat="data in lstData">
					<td>{{$index+1}}</td>
					<td>{{data.name}}</td>
					<td>{{data.occupation}}</td>
					<td><a href="" ng-click="edit(data,$index)">Edit</a></td>
					<td><a href="" ng-click="remove(data,$index)">Delete</a></td>
				</tr>
			</table>
		</div>
	</div>
</body>
</html>