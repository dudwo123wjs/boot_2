<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="./template/boot.jsp"></c:import>
</head>
<body>
<c:import url="./template/nav.jsp"></c:import>
<div class="container">
		<form action="./">
			<select name="lang">
				<option>ko</option>
				<option>en</option>
			</select>
			<button type="submit">Change!</button>          
		</form>

<!-- 	<h1> -->
<%-- 		<spring:message code="hello"></spring:message> --%>
<%-- 		<spring:message code="hello2" text="? to 755" var="t"></spring:message> --%>
<%-- 		<c:if test="${not empty member}"> --%>
<%-- 			<spring:message code="login.Message" arguments="${member.id}님 , 이메일: ${member.email}" argumentSeparator=","></spring:message> --%>
<%-- 		</c:if> --%>
<!-- 	</h1> -->

	<!-- resources/static/images/모든 사진 파일들 여기 저장 -->
	<div class="container">
	<img alt="go.png" src="./images/go.png">
	</div>
	
</div>
</body>
</html>