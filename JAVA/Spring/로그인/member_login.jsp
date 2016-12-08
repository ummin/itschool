<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<content tag ="loginlink">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/font-awesome.css">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="bootstrap-3.3.7-dist/resources/css/bootstrap-theme.min.css">
	</content>
	
	<content tag ="loginscript">
	<script src = "resources/js/jquery-3.1.1.min.js"></script>
	<script src = "resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
	<script src = "resources/js/parsley.min.js"></script>
	<script src = "resources/img"></script>
	</content>
	
</head>
<body >
 <form class="form-horizontal" action="loginup" method="POST" role="form" data-parsley-validate="true">
	
	
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
	 	<span class="text-success text-center"><h1>My First Login Page</h1></span>
	 	
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	<div class="row">
	 	 <div class="col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;"   >Email</div>
	 	 
	 	 </div>
	 	 <input class="col-md-8" id = "email" name = "email" type="email" size="50"  style="border-color:gray ; border-style:inset;"placeholder="Email"
	 	  required=""  data-parsley-type="email" autofocus
	 	  data-parsley-error-message="please insert your email" data-parsley-errors-container="div[id='validateEmail']"/>
	 	 </div>
	 	 
	 	 <div id="validateEmail" style="color:#ff0000"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	<div class="row">
	 	 <div class=" col-md-4">
	 	 
	 	 <div class="col-md-3"></div>
	 	 <div class="col-md-9 text-left" style="font-weight:bold;"   >Password</div>
	 	 
	 	 </div>
	 	 
	 	 <input class="col-md-8" id = "passord" name = "password" type="password" size="50"  style="border-color:gray ; border-style:inset;"placeholder="password"
	 	 required="" data-parsley-error-message="please insert your NAME" data-parsley-errors-container="div[id='validateName']"
	 	 />
	 	 </div>
		 <div id="validateName" style="color:#ff0000"></div>
		 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>
		 <div class="row" style="border-color:#ffffff; border-style:solid;"></div>

	 	
	 	 
	 	 <div class="row">
	 	 <div class="col-md-8"></div>
	 	 <button type="submit" class="btn btn-info btn-sm" >Login</button>
	  	 <button type="button" class="btn btn-info btn-sm" >Cancel</button>
	 	 </div>
	 	
	 	
	 	</div>
	
	
	
	
	
	 </div>
	<div class = "col-md-4"></div>

  </form>
 </body>
</html>