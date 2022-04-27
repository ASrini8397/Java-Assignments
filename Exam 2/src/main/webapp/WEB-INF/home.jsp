<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Exam</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
</head>
<body>
	<div class="container">
		<%-- <h1>Welcome ${thisUser.userName} id: ${user_id }</h1> --%>

	
		

		<h1>Hello ${thisUser.userName}, Here Are Some Name Suggestions</h1>
		<a href="/logout"> <button class="btn btn-info">Log Out</button>
	</a>
	<hr />
		


		<p style="background-color: teal; color: white">${delete_success }
		</p>
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
					<th>Upvotes</th>
					<th>Name</th>
					<th>Gender</th>
					<th>Origin</th>
					<th>Votes</th>
				</tr>
			</thead>

			<tbody class="table-light">
				<c:forEach items="${allbabes}" var="baby">
					<tr>
						<td>0 Likes :(</td>
						<td><a href="/baby/${baby.id}">${baby.name}</a></td>
						<td>${baby.gender }</td>

						<td>${baby.origin }</td>
						<td>No likes LOL</td>
<%-- 
						<td><c:if test="${baby.owner.id == user_id}"> --%>

								<%-- <a href="/baby/${baby.id }/edit"> edit</a>
								
								<form action="/baby/${baby.id}" method="post">
									<input type="hidden" name="_method" value="delete"> <input
										type="submit" value="Delete">
								</form>
								 --%>
						<%-- 	</c:if> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>

		<a href="/baby/new"> <input type="button" value="New Name"
			class="btn btn-primary" />
		</a>




	</div>
</body>
</html>