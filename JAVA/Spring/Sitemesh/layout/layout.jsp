<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator" prefix="decorator" %>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/page" prefix="page" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="resources/vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="resources/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="resources/vendor/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="resources/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">


    <!-- jQuery -->
    <script src="resources/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="resources/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="resources/vendor/metisMenu/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="resources/vendor/raphael/raphael.min.js"></script>
    <script src="resources/vendor/morrisjs/morris.min.js"></script>
    <script src="resources/data/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="resources/dist/js/sb-admin-2.js"></script>
  
</head>

<body>

    <div id="wrapper">
	<page:applyDecorator name = "header"/>
	<page:applyDecorator name = "leftmenu"/>
	<decorator:body/>       
	
	
	<decorator:getProperty property="page.link"></decorator:getProperty>
	<decorator:getProperty property="page.script"></decorator:getProperty>
	<decorator:getProperty property="page.local_script"></decorator:getProperty>
	<decorator:getProperty property="page.result"></decorator:getProperty>
  	
	

            
	<div class="footer navbar-fixed-bottom" style="text-align: center important; width:100% ">
      	ⓒCopyright 2016.10.10 Itschool.ac.kr Ltd
      	</div>


  	
</body>

</html>
