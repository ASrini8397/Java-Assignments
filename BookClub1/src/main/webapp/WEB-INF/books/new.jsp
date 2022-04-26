<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) -->
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cool JAVA APP</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="/css/main.css">
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>New Book</h1>
		<hr />
		<a href="/home">/home</a> <a href="/books">/books</a>
		<p></p>


		<form:form action="/books" method="post" modelAttribute="book">
			<%-- <form:errors path="*"/> --%>

			<form:input type="hidden" path="author"
				value="${thisLoggedInUser.id}" />
			<!-- MAKE SURE YOU HAVE A ROUTE GUARD TO USE THE SESSION ID -->
			<%-- <form:input type="hidden" path="author" value="${user_id }"/> --%>

			<p>
				<form:label path="title">Title</form:label>
				<form:errors path="title" />
				<form:input path="title" placeholder="Book Title" />
			</p>

			<p>
				<form:label path="pages">pages</form:label>
				<form:errors path="pages" />
				<form:input path="pages" />
			</p>


			<p>
				<!-- select from all the libraries -->
				<form:select path="library">
					<c:forEach items="${alldaLibraries }" var="lib">
						<form:option value="${lib.id }">
							${lib.getName() }
						</form:option>
					</c:forEach>

				</form:select>
			</p>

			<input type="submit" value="Submit" />
		</form:form>
		<hr />

		<!-- loop though all the books -->
		<%-- <c:forEach items="${alldabooks}" var="book">
			<li>${book.title }</li>
		</c:forEach>
 --%>
		<p>Libraries :
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
					<th>Library Location</th>
					<th>Books:</th>

				</tr>
			</thead>
			<tbody class="table-light">
				<c:forEach items="${alldaLibraries}" var="l">
					<tr>
						<td>${l.name}</td>
						<td><c:forEach items="${l.books}" var="b">

								${b.title}

							</c:forEach>
								</td>
					</tr>


				
					
				</c:forEach>




			</tbody>
		</table>
</body>
</html>