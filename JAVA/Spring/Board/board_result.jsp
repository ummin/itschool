<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/font-awesome.css">
	<link rel="stylesheet" href="resources/css/itschool.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
	
	<script src = "resources/js/jquery-3.1.1.min.js"></script>
	<script src = "resources/js/bootstrap.min.js"></script>
	<script src = "resources/js/parsley.min.js"></script>
	<script src = "resources/img"></script>
</head>

<content tag="result">
<style>
.resultPage{
	font-size:35px;
	text-align: center !important;
	margin-top: 50px;
}
.resultMessage{
	margin-top:20px;
        font-size=25px;
        background-color:#e0e0d1;
        text-align:center !important;
        line-height: 250px;
        padding : 15px; 
 }
.resultButton{
	text-align: center !important;
	margin-top: 5px;
}  

</style>
</content>
<body>
	<form action="index" method="get" >
	<div class="contatiner">
	<div class="row">
		<div class ="col-md-offset-4 col-md-4 resultPage">Result Page</div>
	</div>
	<div class="row">
		<div class ="col-md-offset-4 col-md-4 resultMessage">
		<c:if test="${result == 'ok'}">
			OK....................
		</c:if>
		${msg}
		</div>
	</div>
	<div class="row">
		<a href="boardlist"><button type="button" class = "col-md-offset-4 col-md-4 btn btn-success resultButton">확인</button></a>
		</div>
	</div>
	
	</div>
	</form>
</body>
</html>