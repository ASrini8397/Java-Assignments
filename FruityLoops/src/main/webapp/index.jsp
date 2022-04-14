<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css"/>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<!-- YOUR own local CSS -->
<!-- <link rel="stylesheet" href="/css/main.css"/>
<script type="text/javascript" src="/js/app.js"></script> -->
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Fruity Loops</title>
</head>
<body>
<h1>Fruit Store</h1>
<table  class="table">
<thead>
<tr class="table-danger">
<th scope="col"> Name </th>
<th scope="col">Price:</th>

</tr>
</thead>
<tbody >
<tr class="table-info">
<td>
<c:forEach var="oneFruit" items="${fruitsInMyShop}">
        <p><c:out value="${oneFruit.name}"></c:out></p>
    </c:forEach>
    </td>
    
    <td>
<c:forEach var="oneFruit" items="${fruitsInMyShop}">
        <p><c:out value="${oneFruit.price}"></c:out></p>
    </c:forEach>
    </td>
    
    </tr>
</tbody>

</table>

</body>
</html>