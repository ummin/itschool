<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<content tag="local_link_memberinsert">
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Page</title>

	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/itschool.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/font-awesome.min.css">
<!-- </content> -->
<!-- <content tag="local_script_memberinsert1"> -->
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/parsley.min.js"></script>
</content>
</head>
<content tag="local_script_memberinsert2">
<script type="text/javascript">
	
</script>
</content>

<body class="div-bgcolor-gray" onload="doReset();">
<form id="salaryUpdate" name="salaryUpdate"  class="form-horizontal"action="salaryUpdate" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner">
	  <span class="text-success text-center"><h1>SALARY UPDATE </h1></span>
	  <br><br>
		<div class="row">
			<div class="col-md-4"><span></span></div>
			<div class="col-md-4">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					<input id="no" name="no" class="form-control" type="text" size="16" autocomplete="off" value="${salary.getNo()}" readonly="readonly"
					required="" data-parsley-error-message="please insert your No." data-parsley-errors-container="div[id='validateNo]" />
				</div>
				<div id="validateNo" style="color:#ff0000"></div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="20" autocomplete="off" value="${salary.getName()}"
					required="" data-parsley-error-message="please insert your NAME" data-parsley-errors-container="div[id='validateName']"  readonly="readonly" />
				</div>
				<div id="validateName" style="color:#ff0000"></div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true"></i></span>
					<select class="selectpicker form-control" name="dept" value="${salary.getDept()}">
						<option value="총무부" <c:if test="${salary.getDept() == '총무부'}">selected</c:if>>총무부</option>
						<option value="인사부" <c:if test="${salary.getDept() == '인사부'}">selected</c:if>>인사부</option>
						<option value="회계부" <c:if test="${salary.getDept() == '회계부'}">selected</c:if>>회계부</option>
					</select>
				</div>
				<div id="validateDept" style="color:#ff0000"></div>
				<br>
				<div class="input-group">
				<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					
					<span class="form-control" >
					<label class="radio-inline"><input type="radio" name="partner" value="1" ${salary.getPartner()=='1'?'checked':''}>기혼</label>
					<label class="radio-inline"><input type="radio" name="partner" value="0" ${salary.getPartner()=='0'?'checked':''}>미혼</label>
					</span>
					
				</div>
				
				<br>
				<div class="input-group" >
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true">20세 이하 부양자</i></span>
					<select class="selectpicker form-control" name="dependent20">
						<option value="0" <c:if test="${salary.dependent20 == '0'}">selected</c:if> >0</option>
						<option value="1" <c:if test="${salary.dependent20 == '1'}">selected</c:if> >1</option>
						<option value="2" <c:if test="${salary.dependent20 == '2'}">selected</c:if> >2</option>
						<option value="3" <c:if test="${salary.dependent20 == '3'}">selected</c:if> >3</option>
						<option value="4" <c:if test="${salary.dependent20 == '4'}">selected</c:if> >4</option>
					</select>
					
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true">60세 이상 부양자</i></span>
					<select class="selectpicker form-control" name="dependent60">
						<option value="0" <c:if test="${salary.dependent60 == '0'}">selected</c:if> >0</option>
						<option value="1" <c:if test="${salary.dependent60 == '1'}">selected</c:if> >1</option>
						<option value="2" <c:if test="${salary.dependent60 == '2'}">selected</c:if> >2</option>
						<option value="3" <c:if test="${salary.dependent60 == '3'}">selected</c:if> >3</option>
						<option value="4" <c:if test="${salary.dependent60 == '4'}">selected</c:if> >4</option>
					</select>			
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
					<input name="base"  value="${salary.getBase()}" class="form-control" type="text" size="11"  autocomplete="off"/>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
					<input name="extrapay1"   value="${salary.getExtrapay1()}" class="form-control" type="text" size="11" autocomplete="off"/>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
					<input name="extrapay2"  value="${salary.getExtrapay2()}"  class="form-control" type="text" size="11"  autocomplete="off"/>
				</div>
				<br>
				<div align="center">
					<c:if test="${sessionid == 'admin'}">
	  					<button type="submit" class="btn btn-info btn-sm" >Modify</button>
	  					<a href="salaryDeleteYN?no=${salary.getNo()}"><button type="button" class="btn btn-danger btn-sm" >Delete</button></a>
	  	 			 </c:if>
						
						<a href = "salarylist"><button name="cancel" type="button" id="cancel"
							class="btn btn-default">Cancel</button></a>
					</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		
	</div>
</form>
</body>
</html>