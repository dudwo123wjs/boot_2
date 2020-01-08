<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"/>
<link href="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.css" rel="stylesheet">
<script src="http://cdnjs.cloudflare.com/ajax/libs/summernote/0.8.12/summernote.js"></script>
</head>
<body>
<c:import url="../template/nav.jsp"/>



	<div class="container">
		<form:form action="noticeWrite" modelAttribute="noticeVO"
			method="post" enctype="multipart/form-data" id="frm">
			<div class="form-group">
				<h3>title</h3>
				<form:input path="title" class="form-control" id="title" />
				<form:errors path="title" />
			</div>

			<div class="form-group">
				<h3>writer</h3>
				<form:input path="writer" class="form-control" id="writer" />
				<form:errors path="writer" />
			</div>

			<div class="form-group">
				<h3>contents</h3>
				<form:textarea path="contents" class="form-control" id="contents" />
				<form:errors path="contents" />
			</div>


			<input type="button" class="btn" value="add file" id="add">
			<div id="files" class="col-sm-12"></div>


			<button class="btn btn-primary">submit</button>
		</form:form>



	</div>




	<script type="text/javascript">
$('#contents').summernote({
    placeholder: 'write contents',
    height: 400
  });


var count=0;

$("#add").click(function() {
	if(count<5){
		var result ='<div class="input-group col-xs-3"><input type="file" name="files" class="form-control"><span class="input-group-addon"><i class="glyphicon glyphicon-remove del"></i></span> </div>';
		$("#files").append(result);
		count++;
	}else {
		alert("첨부파일은 최대 5개만 가능합니다.");
	}
});

$("#files").on("click", ".del", function() {
	$(this).parent().parent().remove();
	//$(this).remove();
	count--;
}); 
</script>
</body>

</html>