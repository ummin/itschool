<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
 <form class="form-horizontal" action="boardInsert" method="POST" role="form" data-parsley-validate="true" enctype="multipart/form-data">
	
	
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
	 	  required="" data-parsley-error-message="please insert your Id" data-parsley-errors-container="div[id='validateID']" value="${sessionid}"/>
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
	 	 value="${sessionname}" readonly="readonly" required="" data-parsley-error-message="please insert your NAME" data-parsley-errors-container="div[id='validateName']"
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
	 	 
	 	 <input class="col-md-8" id = "b_title"  name = "b_title" type="text" size="50" style="border-color:gray ; border-style:inset; " placeholder="TITLE" autofocus
	 	 required="" data-parsley-error-message="please insert your TITLE" data-parsley-errors-container="div[id='validateTitle']"
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
	 	  style="border-color:gray ; border-style:inset;" value="${sessionemail}"
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
	 	 <textarea class ="col-md-8" rows="5" id = "b_content"  name = "b_content" style="border-color:gray ; border-style:inset;" placeholder="CONTEXT"
	 	  required="" data-parsley-error-message="please insert your Context" data-parsley-errors-container="div[id='validateContext']"
	 	 ></textarea>
	 	 </div>
	 	 <div id="validateContext" style="color:#ff0000"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	 <div class="row">
	 	 <div class="col-md-9"></div>
	 	 <button type="submit" class="btn btn-info btn-sm" >Save</button>
	  	 <a href="boardlist"><button type="button" class="btn btn-info btn-sm" >Cancel</button></a>
	 	 </div>
	 	
	 	</div>
	
	 </div>
	<div class = "col-md-4"></div>

	</div>
  </form>
 </body>
</html>