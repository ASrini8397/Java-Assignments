<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    
<!-- ^this is important -->

<!DOCTYPE html>

<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
    crossorigin="anonymous">
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<script type="text/javascript" src="/js/app.js"></script>
<!-- For any Bootstrap that uses JS or jQuery-->
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<meta charset="UTF-8">
<title>Safe Travels</title>
</head>
<body>

<h1>Safe Travels</h1>

<h3>Edit Expense</h3>
<form:form action="/expense/${expense.id}" method="post" modelAttribute="expense">
    <input type="hidden" name="_method" value="put">
   <!--  this line remains the same -->
    <p>
<ul>
   
    <li class="list-group-item">
        <form:label path="it" class="form-label" >Expense:</form:label>
        <form:input type="text" path="it" class="form-control"/>
        <form:errors path="it"/>
        
     </li>
     <li class="list-group-item">
        <form:label path="vendor" class="form-label">Vendor:</form:label>
        <form:input type="text" path="vendor" class="form-control"/>
        <form:errors path="vendor"/>
        
        </li>
        <li class="list-group-item">
        <form:label path="description" class="form-label">Description:</form:label>
        <form:textarea  path="description" class="form-control"/>
        <form:errors path="description"/>
       
        </li>
        <li class="list-group-item">
        <form:label path="amount" class="form-label">Amount:</form:label>
        <form:input type="number" path="amount" class="form-control"/>
        <form:errors path="amount"/>
       
        </li>
       
    
</ul>
 <button>Submit</button>
</form:form>

</body>
</html>