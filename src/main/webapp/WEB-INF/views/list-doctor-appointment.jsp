<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="root">
		<div id="doctorform">
			<form:form action="" method="post" modelAttribute="getdoc">
				<div>
					<label for="doc_id">Doctor ID</label>
					<div>
						<form:input path="doc_id" />
					</div>
				</div>
				<div>
					<label for="doc_name">Doctor Name</label>
					<div>
						<form:input path="doc_name" />
					</div>
				</div>
				<div>
					<label for="dob">DOB</label>
					<div>
						<form:input path="dob" />
					</div>
				</div>
				<div>
					<label for="speciality">Speciality</label>
					<div>
						<form:input path="speciality" />
					</div>
				</div>
				<div>
					<label for="city">City</label>
					<div>
						<form:input path="city" />
					</div>
				</div>
				<div>
					<label for="phone_no">Phone Number</label>
					<div>
						<form:input path="phone_no" />
					</div>
				</div>
				<div>
					<label for="fees">Fees</label>
					<div>
						<form:input path="fees" />
					</div>
				</div>
			</form:form>
		</div>
		<div id="applist"></div>
		<div>
			<div>
				<table>
					<thead>
						<tr>
							<th>App Id</th>
							<th>Date</th>
							<th>Doc Id</th>
							<th>Patient Name</th>
							<th>Fees</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="app" items="${applist}">
							<tr>
								<td>${app.APP_ID}</td>
								<td>${app.APP_DATE}</td>
								<td>${app.DOC_ID}</td>
								<td>${app.PATIENT_NAME}</td>
								<td>${app.FEES_COLLECTED}</td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
</body>
</html>