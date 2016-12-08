<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>test</title>
	<link rel="stylesheet" href="resources/css/font-awesome.min.css">
	<link rel="stylesheet" href="resources/css/font-awesome.css">
	<link rel="stylesheet" href="resources/css/itschool.css">
	<link rel="stylesheet" href="resources/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/css/bootstrap-theme.min.css">
	
	<script src = "resources/js/jquery-3.1.1.min.js"></script>
	<script src = "resources/js/bootstrap.min.js"></script>
	
<!-- 	<style type="text/css"> -->
<!-- /* 		/* some custom styles to beautify this example */ */ -->
<!-- /* 		.demo-content{ */ -->
<!-- /* 			background: #ff0000; */ -->
<!-- /* 		} */ -->
<!-- /* 		.demo-content.bg-alt{ */ -->
<!-- /* 			background: #00ff00; */ -->
<!-- /* 		} */ -->
<!-- 	</style> -->
</head>
<!-- <script type="text/javascript"> -->
<!-- // 	$(document).ready(function(){ -->
<!-- // 		$('#test').click(function(){ -->
<!-- // 			alert(); -->
<!-- // 			$('#test').remove(); -->
<!-- // 			$('<div id = "newtest">This is new</div>').appendTo('body'); -->
<!-- // 		}); -->
<!-- // 	}); -->
<!-- </script> -->
<body>
	<div class="container">
		<div class="row">
			<div class="col-sm-6">
				<div class="div-bgcolor-red">.col-sm-6</div>
			</div>
			<div class="col-sm-6">
				<i class="fa fa-cloud down-icon" aria-hidden="true"></i>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-4">
				<div class="div-bgcolor-blue">.col-sm-6</div>
			</div >
			<div class="col-sm-8"  style="border-style : solid; border-color: #ff00ff;" >
				<div class="div-bgcolor-black">.col-sm-6</div>
			</div>
		</div>
	</div>
	<div class="row">
		&nbsp;
	</div>
	<div class="row col-sm-6"> 
		<div class="input-group col-sm-offset-6">
			<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
			<input class="form-control" type="text" size="20" placheolder="id"/>
		</div>
		<span class="input-group col-sm-offset-2"></span>
	</div>
	<div class="row col-sm-6">
		<button type="buton" class="btn btn-default">Default</button>
		<button type="buton" class="btn btn-primary">Primary</button>
		<button type="buton" class="btn btn-success">success</button>
		<button type="buton" class="btn btn-info">info</button>
		<button type="buton" class="btn btn-warning">warning</button>
		<button type="buton" class="btn btn-danger">danger</button>
		<button type="buton" class="btn btn-link">link</button>
	</div>
	<div class="container">
	<div class="row">
	  <div class="dropdown">
	    <button class="btn btn-primary dropdown-toggle" type="button" data-toggle="dropdown">Dropdown Example
	    <span class="caret"></span></button>
	    <ul class="dropdown-menu">
	      <li><a href="#">HTML</a></li>
	      <li><a href="#">CSS</a></li>
	      <li><a href="#">JavaScript</a></li>
	    </ul>
	  </div>
	</div>
	<div class="from-group">
		<label for="comment">Comment</label>
		<textarea class="form-control" rows="5" id="comment"></textarea>
	</div>
	<div class="row-fluid">
		<div class="radio">
			<label><input type="radio" name="optradio">Option2</label>
		</div>
		<div class="radio">
			<label><input type="radio" name="optradio">Option2</label>
		</div>
		<div class="radio">
			<label><input type="radio" name="optradio">Option3</label>
		</div>
	</div>
	<div class="row-fluid">
		<div class="checkbox">
			<label><input type="checkbox" value="">Option2</label>
		</div>
		<div class="checkbox">
			<label><input type="checkbox" value="">Option2</label>
		</div>
		<div class="checkbox disabled">
			<label><input type="checkbox" value="" disabled>Option3</label>
		</div>
	</div>
	</div>
</body>
</html>