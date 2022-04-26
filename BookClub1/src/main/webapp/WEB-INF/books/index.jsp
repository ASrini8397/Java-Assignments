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
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div>
		<h1>All Books!</h1>
		<a href="/books/new">create new book</a>

		<p style="background-color: teal; color: white">${delete_success }
		</p>
		<table class="table table-bordered table-dark">
			<thead class="thead-dark">
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Author</th>
					<th>pages</th>
					<th>Library</th>
					<th>actions</th>
				</tr>
			</thead>

			<tbody class="table-light">
				<c:forEach items="${allbooks}" var="book">
					<tr>
						<td>${book.id }</td>
						<td><a href="/books/${book.id}">${book.getTitle()}</a></td>
						<td>${book.author.userName }</td>
						<td>${book.pages }</td>
						<td>${book.getLibrary().getName()}</td>
						<td>
						

								<c:if test="${book.author.id == user_id}">

									<a href="/books/${book.id }/edit"> edit</a>
									<form action="/books/${book.id}" method="post">
										<input type="hidden" name="_method" value="delete"> <input
											type="submit" value="Delete"></form>
								</c:if> 
									
									
										
									

								<hr />
						<%-- <a href="/books/${book.id }/edit">edit book</a>
 --%></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr />

		<%-- <c:forEach items="${alldabooks}" var="book">
			<li>${book.id }- 
					<p>${user_id }</p>
			<p>${book.author.id}</p>
			
				<c:if test="${book.author.id== user_id}">
			
					

					<a href="/books/${book.id }/edit">
				
					 ${book.title}</a>
				</c:if> -
				<form action="/books/${book.id}" method="post">
					<input type="hidden" name="_method" value="delete"> <input
						type="submit" value="Delete">
				</form>

			</li>
			<hr />
		</c:forEach> --%>
	</div>

</body>
</html>