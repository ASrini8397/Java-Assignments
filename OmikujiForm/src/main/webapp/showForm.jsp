<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<meta charset="UTF-8">
<title>Form Results</title>
</head>
<body>
<p>
 In <c:out value="${number}"/> years, you will live in <c:out value="${city}"/>
 with  <c:out value="${name}"/> as your room-mate  <c:out value="${hobby}"/> for a living. The
 next time you a <c:out value="${livingthing}"/> you will have good luck. Also,
 <c:out value="${compliment}"/>

</p>

<a href="/"> Go back</a>


</body>
</html>