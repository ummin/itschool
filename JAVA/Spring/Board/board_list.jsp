<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<content tag= "link">
<link rel="stylesheet" href="resources/bootstrap3.3.7-dist/css/font-awesome.min.css">
<link rel="stylesheet" href="resources/bootstrap3.3.7-dist/css/bootstrap.min.css">
<link rel="stylesheet" href="resources/bootstrap3.3.7-dist/css/bootstrap-theme.min.css">
</content>

<content tag= "script">
<script src="resources/js/jquery-3.1.1.min.js"></script>
<script src="resources/bootstrap3.3.7-dist/js/bootstrap.min.js"></script>
<script src="resources/js/parsley.min.js"></script>
<script src="resources/img"></script>
</content>

</head>
<body class="div-bgcolor-gray" onload="doReset();">
<form id="boardList_form" name="boardPaiging" class="form-horizontal" action="boardPageList" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner"  style="height: 650px;backtround-color:#fff">
		<div class="row" style="margin-top:10px"></div>	
	    <span class="text-success text-center" ><h1><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Board List</h1></span>
	    <br><br>
		<div class="row">
			<div class="col-md-offset-2 col-md-8 text-center" style="margin-top:10px;background-color:#ccc;">
				<span class="col-md-2" > 글번호 </span>
				<span class="col-md-3" style=" border:1px solid #fff;"> 제목 </span>
				<span class="col-md-2" style=" border:1px solid #fff;"> 글쓴이 </span>
				<span class="col-md-3" style=" border:1px solid #fff;"> 날짜 </span>
				<span class="col-md-1" >조회</span>
				<span class="col-md-1" >파일</span>
			</div>
		</div>
		<c:forEach var="boards" items="${boards}" >
			<div class="row">
				<div class="col-md-offset-2 col-md-8 text-center" style="background-color:#eeeeee">
					<span class="col-md-2" style="  height:40px;padding:2px">${boards.b_ref}</span>
					<span class="col-md-3" style=" border:1px solid #fff;height:40px;padding:2px;text-align:left" >
					<c:if test = "${boards.b_step == 1 }">
						<img src = "resources/img/reply.jpg">
					</c:if>
					<a href="boardDetail?b_seq=${boards.b_seq}">${boards.b_title}</a>
					</span>
					<span class="col-md-3" style=" border:1px solid #fff;height:40px;padding:2px">${boards.b_name}</span>
					<span class="col-md-2" style=" border:1px solid #fff;height:40px;padding:2px">${boards.b_date}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${boards.b_hit}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">
					<c:if test = "${boards.b_attach != null }">
						<a href = "boardDownload?b_attach=${boards.b_attach}"><img src = "resources/img/reply.jpg"></a>
					</c:if>
					</span>
				
				</div>
			</div>
		</c:forEach>
		
		<div class="row">
			<div class="col-md-offset-2 col-md-8 resultMessage text-center" style="margin-top:10px">
				<c:forEach var="pages" items="${pages}" >
				<span><a href = "boardPageSelect?page=${pages}"> [${pages}]</a></span>
				</c:forEach>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-offset-2 col-md-8 resultMessage text-center" style="margin-top:10px">
				<span class="col-md-2" >
					<select name = "selectbox">
					<option value="b_title" <c:if test="${boardpaging.getSelectbox() == 'b_title'}">selected</c:if> >제목</option>
					<option value="b_name" <c:if test="${boardpaging.getSelectbox() == 'b_name'}">selected</c:if> >글쓴이</option>
					<option value="b_content" <c:if test="${boardpaging.getSelectbox() == 'b_content'}">selected</c:if> >내용</option>
					</select>
				</span>
				<span class="col-md-3">
					<input type="text" name="find" value = "${boardpaging.getFind()}" />
				</span>
				<span class="col-md-3">
					<i class="fa fa-search" aria-hidden="true"></i>
					<button  type="submit" class="btn btn-success resultButton"> 검색</button>
				</span>
				<span class="col-md-offset-2 col-md-2">
					<i class="fa fa-pencil" aria-hidden="true"></i>
					<button  type="button" onclick="location.href='memberboard'" class="btn btn-info resultButton"> 글쓰기</button>
				</span>
			</div>
		</div>

	</div>
</form>
</body>
</html>