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
	
  <h2>Member Update</h2>

	<form:form action="./memberUpdate" modelAttribute="memberVO" method="post" enctype="multipart/form-data">
	 <div class="form-group">
      <label for="Id">아이디:</label>
      <form:input path="id" placeholder="Enter Id"    class="form-control" id="id"/>
      <form:errors path="id" />
   	 </div>
   	 
   	<div class="form-group">
      <label for="pw">비밀번호:</label>
      <form:password path="pw" class="form-control" id="pw" placeholder="Enter password"/>
      <form:errors path="pw" cssStyle="color:red;" />
    </div>
    
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <form:password path="pw2" class="form-control" id="pw" placeholder="Enter password"/>
      <form:errors path="pw2" />
    </div>
	
	<div class="form-group">
      <label for="Name">이름:</label>
      <form:input path="name" class="form-control" id="name" placeholder="Enter Name"/>
    </div>
    
    <div class="form-group">
      <label for="Email">이메일:</label>
      <form:input path="email" class="form-control" id="email" placeholder="Enter Email"/>
    </div>
	
	<div class="form-group">
      <label for="File">사진:</label>
		<div>
			<img alt="" src="../upload/${member.filesVO.fname}">
		</div>
      
      <input type="file" class="form-control" id="files" name="files">
    </div>
	
	 <button type="submit" class="btn btn-default">Submit</button>
	
	</form:form>
	</div>
	
	
	
  <div class="container" style="height: 100px;">  
  </div>	
  
  
  <script type="text/javascript">
  		$("#id").blur(function(){
		var id=$("#id").val();

		$.ajax({
			type : "POST",
			url: "./memberIdCheck",
			data{
				id:id
				},
				sucess:function(data){
					if(data){
						arert("중복된 ID");
						$("#id").val("");
						
					}else{
						arert("사용 가능 ID")
						}
			});		
  	  	});

  </script>
  
  
		
</body>

</html>