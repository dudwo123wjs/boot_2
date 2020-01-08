<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<h2>Member Join</h2>
		
	<div class="container" style="height: 50px;"> 
   </div>
   
	<form:form action="./memberJoin" modelAttribute="memberVO" method="post" enctype="multipart/form-data">
			<div class="form-group">
				<label for="ID">ID:</label>
				<form:input path="id" class="form-control" id="id" placeholder="Enter id"/>
				<form:errors path="id" cssStyle="color:red;"/>
			</div>
			
			<div class="form-group">
				<label for="pw">PW:</label> 
				<form:password path="pw" class="form-control" id="pw" placeholder="Enter password"/>
				<form:errors path="pw"  cssStyle="color:red;"/>
			</div>
			
			<div class="form-group">
				<label for="pw">PW:</label>
				<form:password path="pw2" class="form-control" id="pw" placeholder="Enter password"/>
				<form:errors path="pw2"  cssStyle="color:red;"/>
				
			</div>
			
			<div class="form-group">
				<label for="name">NAME:</label>
				<form:input path="name" class="form-control" id="name" placeholder="Enter Name"/>
				<form:errors path="name" cssStyle="color:red;"/>				
			</div>	
			
			<div class="form-group">
				<label for="Email">EAMIL:</label>	
				<form:input path="email" class="form-control" id="email" placeholder="Enter Email"/>
				
			</div>	
	
			<div class="form-group">
				<label for="File">FILE:</label>
				<input type="File" class="form-control" id="Files" name="files">
			</div>	
	
			<div class="checkbox">
				<label><input type="checkbox" name="remember"> Remember me</label>
			</div>
			<button type="submit" class="btn btn-default">Join</button>
	
	
	
	</form:form>
	
  </div>
	
	
	
	
  <div class="container" style="height: 100px;">  
  </div>	
		
</body>

</html>