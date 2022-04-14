<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Count</title>
</head>
<body>

<h1>You have visited https://localhost:8080:<c:out value="${countToShow}"/>  times</h1>
 <a href="/"><p>Go back:</p></a>


</body>
</html>