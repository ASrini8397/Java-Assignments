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
<title>Omikuji Form</title>
</head>
<body>
<h3>Send an Omikuji!</h3>
<div>
 <form action="/omikuji" method="post">
<ul>
   
    <li class="list-group-item">
        <label class="form-label">Number:</label>
        <input type="number" name="number" min=5 max=25 class="form-control">
     </li>
     <li class="list-group-item">
        <label class="form-label">City:</label>
        <input type="text" name="city" class="form-control">
        </li>
        <li class="list-group-item">
        <label class="form-label">Name:</label>
        <input type="text" name="name" class="form-control">
        </li>
        <li class="list-group-item">
        <label class="form-label">Enter your hobbies:</label>
        <input type="text" name="hobby" class="form-control">
        </li>
        <li class="list-group-item">
        <label class="form-label">Name any living thing:</label>
        <input type="text" name="livingthing" class="form-control">
        </li>
        <li class="list-group-item">
        <label class="form-label">Say Something Nice to Someone:</label>
        <input type="text" name="compliment" class="form-control">
        
        </li>
        <label class="form-label">Send and show a friend!</label>
        <button>Submit</button>
    
</ul>
</form>
</div>
</body>
</html>