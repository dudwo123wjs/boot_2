<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
<div class="container">
  <h2>Member My Page</h2>
  
  <div class="container" style="height: 50px;">
  
  </div>
  
    <form class="form-horizontal" action="memberMypage">
  
  		<div>아이디 : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${member.id}</p>
					</div>
			</div>
		</div>
	
		<div>비밀번호 : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${member.pw}</p>
					</div>
			</div>
		</div>
		
		<div>이름 : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${member.name}</p>
					</div>
			</div>
		</div>
		
		<div>이메일 : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${member.email}</p>
					</div>

			</div>
		</div>		
		
		<div>저장 사진</div>
		<div>
			<img alt="" src="../upload/${member.filesVO.fname}">
		</div>
		
		<a class="btn btn-primary" href="./memberFileDown?id=${files.id}">FileDown</a>

	</form>
	
  		<a class="btn btn-primary" href="${pageContext.request.contextPath}/member/memberUpdate" style="margin-top: 50px;">정보 수정하기</a>
  		<a href="./memberDelete" class="btn btn-danger" style="margin-top: 50px;">회원 탈퇴하기</a>

  <div class="container" style="height: 100px;">
  
  </div>
  
  
</div>
</body>

</html>