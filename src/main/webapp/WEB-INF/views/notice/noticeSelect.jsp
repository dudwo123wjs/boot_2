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
		<h2>Notice Select</h2>

	</div>
	
	
	<div class="container" style="height: 50px;">
  
  </div>
  
    <form class="form-horizontal container" action="noticeSelect">
  
  		<div>num : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${vo.num}</p>
					</div>
			</div>
		</div>
	
		<div>title : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${vo.title}</p>
					</div>
			</div>
		</div>
		
		<div>writer : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${vo.writer}</p>
					</div>
			</div>
		</div>
		
		<div>contents : </div>
		<div class="form-group">
			<div class="form-control"  style="height: 400px;">
					<div>
<%-- 							<input readonly="readonly"  type="text" value="${vo.contents}"> --%>
<%-- 							<textarea rows="30" cols="154" readonly="readonly" value="${vo.contents}"></textarea> --%>
							<p class="">${vo.contents}</p>
					</div>
			</div>
		</div>		
		
		<div>regDate : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${vo.regDate}</p>
					</div>

			</div>
		</div>		
		
		<div>hit : </div>
		<div class="form-group">
			<div class="form-control">
					<div>
						<p class="comment">${vo.hit}</p>
					</div>

			</div>
		</div>	
		
		<div>저장 사진 : </div>
		<div>
			<img alt="" src="../upload/${member.filesVO.fname}">
		</div>
	
		
<!-- 		<div>저장 사진</div> -->
<!-- 		<div> -->
<%-- 			<img alt="" src="../upload/${files.fname}"> --%>
<!-- 		</div> -->
		
<%-- 		<a class="btn btn-primary" href="./memberFileDown?id=${files.id}">FileDown</a> --%>		
		
		
		<div>
			<c:if test= "${not empty member}"> 
				<a href="#"
					class="btn btn-info"
					style="color: blue; background: black; border: 1px solid transparent;">수정</a>

				<a href="./noticeDelete?num=${vo.num}"
					class="btn btn-info"
					style="color: red; background: black; border: 1px solid transparent;">삭제</a>

<!-- 				<a href="#" -->
<!-- 					class="btn btn-info" -->
<!-- 					style="color: green; background: black; border: 1px solid transparent;">댓글 -->
<!-- 					달기</a> -->
			</c:if>

			<a href="${pageContext.request.contextPath}/notice/noticeList" class="btn btn-info"
				style="color: orange; background: black; border: 1px solid transparent;">목록</a>

		</div>
	
	</form>



	<div class="container" style="height: 50px;">

	</div>
	

</body>

</html>