<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- https://www.w3schools.com/bootstrap/bootstrap_navbar.asp -->
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/">Young Jae Jeon</a>
			</div>
			<ul class="nav navbar-nav">
				<li class="active"><a href="${pageContext.request.contextPath}/">홈페이지 이동</a></li>
				<li class="dropdown"><a class="dropdown-toggle"data-toggle="dropdown" href="#">공지<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:if test= "${not empty member}">
						<li><a href="${pageContext.request.contextPath}/notice/noticeWrite">공지 작성</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath}/notice/noticeList">공지 게시판</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"data-toggle="dropdown" href="#">질문<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">질문 작성</a></li>
						<li><a href="#">질문 게시판</a></li>
				</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
  				<c:if test= "${not empty member}">  
				<li><a href="${pageContext.request.contextPath}/member/memberMypage"><span class="glyphicon glyphicon-user"></span>내 정보 보기</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-user"></span>로그아웃</a></li>				
  				</c:if> 

 				<c:if test= "${empty member}"> 
				<li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span>회원 가입</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>
 				</c:if> 				
			</ul>
		</div>
	</nav>