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
<title>Create Dojo</title>
</head>
<body>
<h1>Create a new Dojo</h1>
<button> <a href="/ninja">Create Ninjas</a></button>

<form:form action="/create" method="post" modelAttribute="dojo">
<p> <form:errors path="name"/> </p>

  
  
<ul>
   
    <li class="list-group-item">
    
        <form:label path="name" class="form-label" >Dojo Name:</form:label>
        <form:input type="text" path="name" class="form-control"/>
        
        
     </li>
       
    
</ul>
 <button>Create Dojo</button>
</form:form>

<h1>All Dojos</h1>
<table class="table table-bordered table-dark">
    <thead class="thead-dark">
        <tr>
            <th scope="col">Dojo Name</th>
            <th>Actions</th>
        </tr>
    </thead>

    <tbody class="table-light">
         <c:forEach var="oneDojo" items="${dojos}">
         <tr>
         	<td scope="col"> <a href="/show/dojo/${oneDojo.id} "><c:out value="${oneDojo.name}"/></a>  </td>
         	<%-- <td>
          	<form action="/dojo/${oneDojo.id}" method="post">
	    	<input type="hidden" name="_method" value="delete">
	    	<input type="submit" value="Delete">
			</form>
			</td> --%>
      
         </tr>
    </c:forEach>
    
    </tbody>
</table>



</body>
</html>