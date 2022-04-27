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
<title>Baby Name Details</title>
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
</head>
<body>

	<div>
		<h1>${oneBabyName.name}</h1>
		<a href="/baby"> <button class="btn btn-info">Home</button>
	</a>
	<a href="/logout"> <button class="btn btn-info">Log Out</button>
	</a>
		<hr />
		<p><h3>add by ( ${oneBabyName.owner.userName} )
		</h3>
		</p>

		<p>Gender ${oneBabyName.gender}</p>
		<p>Origin ${oneBabyName.origin}</p>
		<p>Meaning ${oneBabyName.meaning}</p>
	</div>
	<td><c:if test="${oneBabyName.owner.id == user_id}">


			<a href="/baby/${oneBabyName.id }/edit"> <input type="button"
				value="Edit" class="btn btn-primary" />
			</a>


		</c:if>
</body>
</html>