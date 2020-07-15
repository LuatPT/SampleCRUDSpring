<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html xmlns = "http://www.w3.org/1999/xhtml" xmlns:th = "http://www.thymeleaf.org"
   xmlns:sec = "http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<meta charset="UTF-8">
<title>View All Computers</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet" />
</head>
<body>
	<%@include file="header.jsp" %>
	<div class="container" id="headerF">
		<form action="timMay" method="post" id="searchForm">
			<input type="text" id="inputSearch" name="maMay1" class="form-control" placeholder="Type MaMay">
			<input type="submit" id="buttonSearch" class="btn btn-warning" value="Search" />
		</form><br/><br/>
		<a href="themMay"><button type="button" id="btnAdd" class="btn btn-primary">Add New Computer</button></a><hr/>
		<form th:action = "@{/logout}" method = "post">
         <input type = "submit" value = "Sign Out"/>
      </form>
	</div> 
	<div class="container" id="divTable">
		<table id="tableList" class="table table-striped">
	  <tr>
	    <th>Mã máy</th>
	    <th>Vị trí</th>
	    <th>Trạng Thái</th>
	    <th>Update</th>
	    <th>Delete</th>
	  </tr>
  	<c:forEach var="may" items="${listMay}">  
	  <tr>
	    <td>${may.maMay}</td>
	    <td>${may.viTri}</td>
	    <td>${may.trangThai}</td>
	   	<td><a href="xemSuaMay/${may.maMay}">Edit</a></td>  
	   <td><a href="xoaMay/${may.maMay}">Delete</a></td>  
	  </tr>
  	</c:forEach>  
	</table>
	</div>
	
	<iframe id="iframeYtb" width="1080" height="480" src="https://www.youtube.com/embed/aR-KAldshAE" frameborder="0" allow="accelerometer; autoplay; encrypted-media; gyroscope; picture-in-picture" allowfullscreen>
	</iframe>
<script src="<c:url value="/resources/js/jquery.min.js" />" ></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />" ></script>
</body>
<%@include file="footer.jsp" %>
</html>