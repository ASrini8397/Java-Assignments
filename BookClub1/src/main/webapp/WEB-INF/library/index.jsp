<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- c:out ; c:forEach etc. --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Formatting (dates) --> 
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!-- form:form -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!-- for rendering errors on PUT routes -->
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Cool JAVA APP</title>
    <link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="/css/main.css"> <!-- change to match your file/naming structure -->
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
	<h1>create a new Library</h1>
	<a href="/home">/home</a>
	<hr />
	
	<form:form action="/library" method="post" modelAttribute="library">
		<%-- <form:errors path="*"/> --%>
			<p>
				<form:label path="name">name</form:label>
				<form:errors path="name" />
				<form:input path="name" placeholder="Give the library a name"/>
			</p>
			<p>
				<form:label path="location">location</form:label>
				<form:errors path="location" />
				<form:textarea path="location" />
			</p>

			<input type="submit" value="Submit" />
		</form:form>
		<hr />
	<%-- 	${ allDaLibs.get(1).books.get(0).author}  --%>
		${ allDaLibs}
		<hr />
		<c:forEach items="${allDaLibs }" var="lib">
			<p>
			${lib.name }
				<c:forEach items="${lib.books}" var="b">
					<li>
						${b.title }
					</li>
				</c:forEach>
			</p>
		
		</c:forEach>
		<%-- ${allDaLibs } --%>
		
		
</div>
		
</body>
</html>