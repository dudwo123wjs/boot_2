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
				<li class="active"><a href="${pageContext.request.contextPath}/">Home</a></li>
				<li class="dropdown"><a class="dropdown-toggle"data-toggle="dropdown" href="#">Notice<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<c:if test= "${not empty member}">
						<li><a href="${pageContext.request.contextPath}/notice/noticeWrite">Notice Write</a></li>
						</c:if>
						<li><a href="${pageContext.request.contextPath}/notice/noticeList">Notice List</a></li>
						<li><a href="#">Notice3</a></li>
					</ul></li>
				<li class="dropdown"><a class="dropdown-toggle"data-toggle="dropdown" href="#">Q&A<span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Q&A1</a></li>
						<li><a href="#">Q&A2</a></li>
						<li><a href="#">Q&A3</a></li>
				</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
  				<c:if test= "${not empty member}">  
				<li><a href="${pageContext.request.contextPath}/member/memberMypage"><span class="glyphicon glyphicon-user"></span>My Page</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogout"><span class="glyphicon glyphicon-user"></span>Logout</a></li>				
  				</c:if> 

 				<c:if test= "${empty member}"> 
				<li><a href="${pageContext.request.contextPath}/member/memberJoin"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li>
				<li><a href="${pageContext.request.contextPath}/member/memberLogin"><span class="glyphicon glyphicon-log-in"></span>Login</a></li>
 				</c:if> 				
			</ul>
		</div>
	</nav>