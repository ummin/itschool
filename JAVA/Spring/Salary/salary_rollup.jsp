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
 <form class="form-horizontal" id = "salarycreateform" name = "salarycreateform" action="salaryRollup" method="POST" role="form" data-parsley-validate="true">
	
	
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<div class="row"  style="border-color:#ffffff; border-style:solid;"></div>
	<span class="text-success text-center"><h1>Salary Create</h1></span>
	
	<div class="contatiner">
	<div class = "col-md-5"></div>
	
	 <div class = "col-md-3">
	 	
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	<div class="row">
	 	
	 	 
	 	 <div class="input-group" >
				 <span class="input-group-addon"><i class="fa fa-user" aria-hidden="true" style="font-weight: bold;">처리년도</i></span>
					<input id="year" name="yyyy" class="form-control" type="text" size="16" value="${yyyy}" autocomplete="off"
					  />
	 	 </div>
	 	 
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	 
	 	 <div class="input-group" >
				  <span class="input-group-addon"><i class="fa fa-male" aria-hidden="true" style="font-weight: bold;">처리   월 </i></span>
					<select class="selectpicker form-control" name="mm" required="" data-parsley-error-message="please select dependent20">
						<option value="01" >01</option>
						<option value="02" >02</option>
						<option value="03" >03</option>
						<option value="04" >04</option>
						<option value="05" >05</option>
						<option value="06" >06</option>
						<option value="07" >07</option>
						<option value="08" >08</option>
						<option value="09" >09</option>
						<option value="10" >10</option>
						<option value="11" >11</option>
						<option value="12" >12</option>
					</select>
	 	 </div>
	 	 
	 	 
		<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	<div class="row" style="border-color:#ffffff; border-style:solid;"></div>
	 	 
	 	 <div class="row">
	 	 <div class="col-md-7"></div>
	 	 <button type="submit" id = "create" class="btn btn-info btn-sm" >검색</button>
	  	 <a href="home"><button type="button" class="btn btn-danger btn-sm" >취소</button></a>
	  	 <div class="col-md-1"></div>
	 	 </div>
		</div> 	
	 </div>
	 
	<div class = "col-md-4"></div>

  </form>
 </body>
</html>