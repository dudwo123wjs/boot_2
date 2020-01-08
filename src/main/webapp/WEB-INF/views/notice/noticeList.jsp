<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>

  <div class="container" style="height: 50px;">
  	<h2>Notice List</h2>
  
  </div>

	<div class="container">
		<table class="table table-hover">
			<tr>
				<td>num</td>
				<td>title</td>
				<td>writer</td>
				<td>regDate</td>
				<td>hit</td>
			</tr>

			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td> 
					<a href="${notice}noticeSelect?num=${ vo.num }">${vo.title}</a>
					</td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
				</tr>
			</c:forEach>

		</table>

	</div>



  <div class="container" style="height: 50px;">
  
  </div> 



</body>

</html>