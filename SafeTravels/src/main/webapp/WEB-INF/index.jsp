<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!-- New line below to use the JSP Standard Tag Library -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>    

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
<table class="table table-bordered table-dark">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Expense</th>
            <th scope="col"> Vendor</th>
            <th scope="col">Amount</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
    </thead>

    <tbody class="table-light">
         <c:forEach var="oneExpense" items="${results}">
         <tr>
         	<td scope="col"> <a href="/show/expense/${oneExpense.id} "><c:out value="${oneExpense.it}"/></a>  </td>
         	<td scope="col"> <c:out value="${oneExpense.vendor}"/> </td>
         	<td scope="col"> <c:out value="${oneExpense.amount}"/> </td>
         	<td><a href="/form/${oneExpense.id }/edit">edit</a></td>
         	<td>
         	<form action="/expense/${oneExpense.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
			</form>
         	
         	</td>
         </tr>
    </c:forEach>
    
    </tbody>
</table>


<h1>Add an Expense</h1>
<form:form action="/expense" method="post" modelAttribute="expense">
<p> <form:errors path="it"/> </p>
<p> <form:errors path="vendor"/> </p>
 <p> <form:errors path="description"/> </p>
 <p> <form:errors path="amount"/>  </p>
  
  
<ul>
   
    <li class="list-group-item">
    
        <form:label path="it" class="form-label" >Expense:</form:label>
        <form:input type="text" path="it" class="form-control"/>
        
        
     </li>
     <li class="list-group-item">
        <form:label path="vendor" class="form-label">Vendor:</form:label>
        <form:input type="text" path="vendor" class="form-control"/>
      
        
        </li>
        <li class="list-group-item">
        <form:label path="description" class="form-label">Description:</form:label>
        <form:textarea  path="description" class="form-control"/>
        
       
        </li>
        <li class="list-group-item">
        <form:label path="amount" class="form-label">Amount:</form:label>
        <form:input type="number" path="amount" class="form-control"/>
       
       
        </li>
       
    
</ul>
 <button>Submit</button>
</form:form>

</body>
</html>