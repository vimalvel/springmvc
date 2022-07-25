<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Doctor List</title>
</head>
<body>
	<div id="table root">
		<table>
			<thead>
			<tr>
			<th>Doctor Id</th>
			<th>Doctor Name</th>
			<th>Date Of Birth</th>
			<th>Speciality</th>
			<th>City</th>
			<th>Phone Number</th>
			<th>Fees</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach var = "doc" items = "${alldoctor}">
			<tr>
			<td>${doc.doc_id}</td>
			<td>${doc.doc_name}</td>
			<td>${doc.dob}</td>
			<td>${doc.speciality}</td>
		    <td>${doc.city}</td>
		    <td>${doc.phone_no}</td>
		    <td>${doc.fees}</td>
			</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>