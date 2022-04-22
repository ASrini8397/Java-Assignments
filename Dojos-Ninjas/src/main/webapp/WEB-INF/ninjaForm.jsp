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
<title>Create Ninja</title>
</head>
<body>
	<h1>Create a new Ninja</h1>
	
	<form:form action="/createninja" method="post" modelAttribute="ninja">
	


		<ul>

			<li class="list-group-item"><form:label path="dojo"
					class="form-label">Select Dojo:</form:label> <form:select
					path="dojo" class="form-control">

					<c:forEach var="oneDojo" items="${dojos}">
						<form:option value="${oneDojo}">
							<c:out value="${oneDojo.name}" />
						</form:option>
					</c:forEach>
				</form:select></li>

			<li class="list-group-item"><form:label path="first_name"
					class="form-label">First Name:</form:label> <form:input
					path="first_name" class="form-control" /></li>
					
			<li class="list-group-item"><form:label path="last_name"
					class="form-label">Last Name:</form:label> <form:input
					path="last_name" class="form-control" /></li>
					
			<li class="list-group-item"><form:label path="age"
					class="form-label">Age:</form:label> <form:input
					path="age" class="form-control" type="number" /></li>
					
					





		</ul>
		<button>Create Ninja</button>
	</form:form>


</body>
</html>