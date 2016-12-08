<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<content tag="boardlink">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/font-awesome.css">
	<link rel="stylesheet" href="resources/css/itschool.css">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/bootstrap-theme.min.css">
	</content>
	
	<content tag="boardscript">
	<script src = "resources/js/jquery-3.1.1.min.js"></script>
	<script src = "resources/js/bootstrap-3.3.7-dist/bootstrap.min.js"></script>
	<script src = "resources/js/parsley.min.js"></script>
	<script src = "resources/img"></script>
	</content>
</head>
<body >
 <form class="form-horizontal" action="boardUpdate" method="POST" role="form" data-parsley-validate="true">
	
	
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	
	<div class="contatiner">
	<div class = "col-md-4"></div>
	
	 <div class = "col-md-4">
	 	<span class="text-success text-center"><h1>My First Board Page</h1></span>
	 	
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	<div class="row">
	 	 <div class="col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;"   >ID</div>
	 	 
	 	 </div>
	 	 <input class="col-md-8" id = "b_id" name = "b_id" type="text" size="50"  style="border-color:gray ; border-style:inset;"readonly="readonly"
	 	  required="" data-parsley-error-message="please insert your Id" data-parsley-errors-container="div[id='validateID']" value="${board.getB_id()}"/>
	 	 </div>
	 	 
	 	 <div id="validateID" style="color:#ff0000"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	<div class="row">
	 	 <div class=" col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;" >NAME</div>
	 	 
	 	 </div>
	 	 
	 	 <input class="col-md-8" id = "b_name"  name = "b_name" type="text" size="50"  style="border-color:gray ; border-style:inset;"
	 	 value="${board.getB_name()}" readonly="readonly" required="" data-parsley-error-message="please insert your NAME" data-parsley-errors-container="div[id='validateName']"
	 	 />
	 	 </div>
		 <div id="validateName" style="color:#ff0000"></div>
		<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
		<div class="row" style="border-color:#ffffff; border-style:solid;"></div>

	 	<div class="row">
	 	 <div class=" col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;"  >TITLE</div>
	 	 
	 	 </div>
	 	 
	 	 <input class="col-md-8" id = "b_title"  name = "b_title" type="text" size="50" style="border-color:gray ; border-style:inset; "autofocus
	 	 required="" data-parsley-error-message="please insert your TITLE" data-parsley-errors-container="div[id='validateTitle']"
	 	 value="${board.getB_title()}"
	 	 />
	 	 </div>
	 	<div id="validateTitle" style="color:#ff0000"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	
	 	<div class="row">
	 	
	 	<div class=" col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;" >Email</div>
	 	 
	 	 </div>
	 	 
	 	 <input class="col-md-8" id = "b_email"  name = "b_email" type="text" size="50" 
	 	  style="border-color:gray ; border-style:inset;" value="${board.getB_email()}"
	 	  required="" data-parsley-error-message="please insert your Email" data-parsley-errors-container="div[id='validateEmail']"
	 	  readonly="readonly">
	 	 </div>
	 	 <div id="validateEmail" style="color:#ff0000"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	
	 	<div class="row">
	 	<div class="col-md-4">
	 	<div class="col-md-9 text-right " style="font-weight:bold;" >FILE</div>
	 	</div>
	 	
	 	 <input type = "file" name="file" style="border-color:#ffffff; border-style:solid;"/>
	 	 
	 	<div class="row">
	 	 <div class="col-md-4">
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	  <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left " align=center style="font-weight:bold;" >CONTENT</div>
	 	 </div>
	 	 <textarea class ="col-md-8" rows="5" id = "b_content"  name = "b_content" style="border-color:gray ; border-style:inset;"
	 	  required="" data-parsley-error-message="please insert your Context" data-parsley-errors-container="div[id='validateContext']"
	 	
	 	 >${board.getB_content()}</textarea>
	 	 </div>
	 	 <div id="validateContext" style="color:#ff0000"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	 <div class="row">
	 	 <div class="col-md-4"></div>
	  	 <a href="boardlist"><button type="button" class="btn btn-info btn-sm" >Cancel</button></a>
	  	 <c:if test="${sessionid == 'admin' || sessionid == board.getB_id()}">
	  		<input type = "hidden" id= "b_seq", name = "b_seq" value="${board.getB_seq()}">
	  		<button type="submit" class="btn btn-info btn-sm" >Modify</button>
	  		<a href="boardDeleteYN?b_seq=${board.getB_seq()}"><button type="button" class="btn btn-danger btn-sm" >Delete</button></a>
	  	  </c:if>
	  	  
	  	  <c:if test="${sessionid == 'admin' && board.b_step == 0 }">
	  	   <a href="boardReply?b_seq=${board.getB_seq()}"><button type="button" class="btn btn-info btn-sm" >Reply</button></a>
	  	  </c:if>
	  	  
	 	 </div>
	 	</div>
	 </div>
	<div class = "col-md-4"></div>

	</div>
  </form>
 </body>
</html>