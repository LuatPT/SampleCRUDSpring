<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Add New Computer</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container" id="divAdd">
		<form action="luuMay" method="post">
			<label >Mã Máy: </label><input type="text" class="form-control" name="maMay" placeholder="Nhập mã máy..."/><br/>
			<label>Trạng Thái :</label> 
				<input type="radio" id="on" name="trangThai" value="ON"><label for="ON">ON</label>
				<input type="radio" id="female" name="trangThai" value="OFF"> <label for="OFF">OFF</label><br>
			<label >Vị Trí</label><input type="text" class="form-control" name="viTri" placeholder="Nhập vị trí..."/> <br/> <hr/>
			<input type="submit" value="LƯU" />
		</form>
	</div>
<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
</body>
<%@include file="footer.jsp" %>
</html>