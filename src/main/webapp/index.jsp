<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html xmlns = "http://www.w3.org/1999/xhtml" xmlns:th = "http://www.thymeleaf.org"
   xmlns:sec = "http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
	<title>Login</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
	<div th:if = "${param.error}">
         Invalid username and password.
      </div>
      <div th:if = "${param.logout}">
         You have been logged out.
      </div>
	<div class="container">
		<form action="login" method="get">
			<label>UserName</label>
			<input type="text" name="userName" id="userName">
			<label>Password</label>
			<input type="password" name="password" id="password">
			<input type="submit" value="Login"> 
		</form>
	</div>

</body>
</html>
