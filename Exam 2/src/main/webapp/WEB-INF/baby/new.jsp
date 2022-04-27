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
<title>Baby Names</title>
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

	<h1>New Baby Name</h1>
	<hr />
	</a>
	<a href="/baby"> <button class="btn btn-info">Home</button>
	</a>
	<a href="/logout"> <button class="btn btn-info">Log Out</button>
	</a>
	<p></p>


	<form:form action="/babes" method="post" modelAttribute="baby">


		<form:input type="hidden" path="owner" value="${thisLoggedInUser.id}" />


		<p>
			<form:label path="name">Name</form:label>
			<form:errors path="name" />
			<form:input path="name" placeholder="Ex: Optimus Prime" />
		</p>

		<p>
			<form:label path="origin">Origin</form:label>
			<form:errors path="origin" />
			<form:input path="origin" />
		</p>

		<p>
			<form:label path="meaning">Meaning</form:label>
			<form:errors path="meaning" />
			<form:input path="meaning" />
		</p>


		<p>
			<!-- select from all the libraries -->
			<form:select path="gender">

				<form:option value="male">
							Male
						</form:option>

				<form:option value="female">
							Female
						</form:option>

				<form:option value="neutral">
							Neutral
						</form:option>


			</form:select>
		</p>
	
		

		<input type="submit" value="Submit" class="btn btn-primary" />
	</form:form>

	<a href="/baby"> <button class="btn btn-primary">Cancel</button>
	</a>


	<hr />


</body>
</html>