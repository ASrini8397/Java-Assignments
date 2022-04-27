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
<title>Edit the Baby Name details</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/main.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- change to match your file/naming structure -->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>Edit Baby: ${baby.name }</h1>
		<a href="/baby"> <button class="btn btn-info">Home</button>
	</a>
	<a href="/logout"> <button class="btn btn-info">Log Out</button>
	</a>

		<hr />
		<form:form action="/baby/${baby.id}" method="post"
			modelAttribute="baby">

			<input type="hidden" name="_method" value="put">

			<p>
				<form:label path="name" class="form-label">Name</form:label>
				<form:errors path="name" />
				<form:input path="name" placeholder="${baby.name }"
					class="list-group-item" />
			</p>

			<%-- <p>Author ID        ${book.author.id }</p> --%>
			<form:hidden path="owner" value="${baby.owner.id }" />
			<p>
				<form:label path="origin" class="form-label">Origin</form:label>
				<form:errors path="origin" />
				<form:input path="origin" class="list-group-item"
					placeholder="${baby.origin }" />
			</p>

			<p>
				<form:label path="gender" class="form-label">Gender</form:label>
				<form:errors path="gender" />
				<form:input path="gender" placeholder="${baby.gender }"
					class="list-group-item" />
			</p>

			<p>
				<form:label path="meaning" class="form-label">Meaning</form:label>
				<form:errors path="meaning" />
				<form:textarea path="meaning" placeholder="${baby.meaning }"
					class="list-group-item" />
			</p>


			<%-- <form:hidden path="library" value="${book.library.id }"/> --%>
			<input type="submit" value="Submit" class="btn btn-primary" />
		</form:form>
		<form action="/baby/${baby.id}" method="post">
			<input type="hidden" name="_method" value="delete"> <input
				type="submit" value="Delete" class="btn btn-danger">
		</form>
		
			<a href="/baby"> <button class="btn btn-primary">Cancel</button>
	</a>
	</div>
</body>
</html>