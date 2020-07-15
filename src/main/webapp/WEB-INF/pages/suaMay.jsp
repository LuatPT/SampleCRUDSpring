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
	<div class="container" id="divUpdate">
		<form:form action="/SampleCRUD/suaMay" method="post" modelAttribute="temp">
			<label >Mã Máy: </label><form:input type="text" class="form-control" path="maMay" readonly="readonly"></form:input><br/>
			<label>Trạng Thái :</label> 
				<form:radiobutton path="trangThai" value="ON" /><label for="ON">ON</label>
				<form:radiobutton path="trangThai" value="OFF" /> <label for="OFF">OFF</label><br>
			<label >Vị Trí</label><form:input type="text" class="form-control" path="viTri" ></form:input> <br/> <hr/>
			<input type="submit" value="UPDATE" />
		</form:form>
	</div>
<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
</body>
<%@include file="footer.jsp" %>
</html>