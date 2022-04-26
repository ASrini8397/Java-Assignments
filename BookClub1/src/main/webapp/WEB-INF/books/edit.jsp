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
<title>Cool JAVA APP</title>
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
	<h1>Edit Book: ${book.title } </h1>
	book id : ${book.id }

	<hr />
	<form:form action="/books/${book.id}" 
				method="post"
				modelAttribute="book">
				
		<input type="hidden" name="_method" value="put">
		
		<p>
			<form:label path="title" class="form-label">Title</form:label>
			<form:errors path="title" />
			<form:input path="title" placeholder="${book.title }" class="list-group-item"/>
		</p>

		<%-- <p>Author ID        ${book.author.id }</p> --%>
		<form:hidden path="author" value="${book.author.id }"/>
		<p>
			<form:label path="pages" class="form-label">pages</form:label>
			<form:errors path="pages" />
			<form:input path="pages" class="list-group-item" />
		</p>	
		<form:hidden path="library" value="${book.library.id }"/>
		<input type="submit" value="Submit" />
	</form:form>
</div>
</body>
</html>