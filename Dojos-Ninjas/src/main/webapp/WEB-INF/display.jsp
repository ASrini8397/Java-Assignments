<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true"%>

<!DOCTYPE html>

<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css" />
<script type="text/javascript" src="/js/app.js"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Dojos & Ninjas</title>
</head>
<body>

	<h1>Dojo Details</h1>
	<a href="/">Go Back</a>






	<table class="table table-bordered table-dark">
		<thead class="thead-dark">
			<tr>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Age</th>
			</tr>
		</thead>

		<tbody class="table-light">
			<c:forEach var="oneNinja" items="${ninjas}">
				<tr>

					<td scope="col"><c:out value="${oneNinja.first_name}" /></td>
					<td scope="col"><c:out value="${oneNinja.last_name}" /></td>
					<td><c:out value="${oneNinja.age}" /></td>
					<td>
				</tr>
			</c:forEach>


		</tbody>
	</table>


</body>
</html>