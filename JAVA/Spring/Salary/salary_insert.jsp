<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Member Page</title>

	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/itschool.css">
	<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/font-awesome.min.css">
	
<!-- </content> -->
<!-- <content tag="local_script_memberinsert1"> -->
<content tag="salaryinsert">
	<script src="resources/js/jquery-3.1.1.min.js"></script>
	<script src="resources/bootstrap-3.3.7-dist/js/bootstrap.js"></script>
	<script src="resources/js/parsley.min.js"></script>
</content>
</head>
<content tag="local_script_salaryinsert">
<script type="text/javascript">
$(document).ready(function() {

	$('#save').click(function() {
		if ($('#confirm_chk').val() == 'no') {
			alert("사원번호 중복체크를 하시오");
			return;
		}
		$('#salaryInsert').submit();
	});

	$('#confirm').click(function() {
		var no = $('#no').val();

		if (no == "") {
			alert("사원번호를 입력하시오");
			return;
		}
		$.ajax({
			type : 'POST',
			data : "no=" + no,
			dataType : 'json',
			url : 'noconfirm',
			success : function(data) {
				if (data == 0) {
					alert("사용가능한 사원번호 입니다.");
					$('#confirm_chk').attr('value', 'yes');
				} else {
					alert("중복입니다.");
				}
				return false;
			}
		});

	});

});
</script>
</content>

<body class="div-bgcolor-gray" onload="doReset();">
<form id="salaryInsert" name="salaryInsert"  class="form-horizontal"action="salaryInsert" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner">
	  <span class="text-success text-center"><h1>SALARY INSERT </h1></span>
	  <br><br>
		<div class="row">
			<div class="col-md-4"><span></span></div>
			<div class="col-md-4">
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					<input id="no" name="no" class="form-control" type="text" size="16" placeholder="사번" autocomplete="off"
					required="" data-parsley-error-message="please insert your No." data-parsley-errors-container="div[id='validateNo]" />
					<span class="input-group-btn">
					<button class="btn btn-success" type="button" id="confirm">Confirm</button>
					</span>
				</div>
				<div id="validateNo" style="color:#ff0000"></div>
				<input type="hidden" id="confirm_chk" name="confirm_chk" value="no" />
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true"></i></span>
					<input name="name" class="form-control" type="text" size="20" placeholder="이름" autocomplete="off"
					required="" data-parsley-error-message="please insert your NAME" data-parsley-errors-container="div[id='validateName']" />
				</div>
				<div id="validateName" style="color:#ff0000"></div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true"></i></span>
					<select class="selectpicker form-control" name="dept" required="" data-parsley-error-message="please select dept">
						<option value="총무부">총무부</option>
						<option value="인사부">인사부</option>
						<option value="회계부">회계부</option>
					</select>
				</div>
				<div id="validateDept" style="color:#ff0000"></div>
				<br>
				
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-user" aria-hidden="true"></i></span>
					
					<span class="form-control"  required="" data-parsley-error-message="please select parter">
					<label><input type="radio" name="partner" value="1">기혼</label>
					<label><input type="radio" name="partner" value="0">미혼</label>
					</span>
					
				</div>
				
				<br>
				<div class="input-group" >
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true">20세 이하 부양자</i></span>
					<select class="selectpicker form-control" name="dependent20" required="" data-parsley-error-message="please select dependent20">
						<option value="0" >0</option>
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
					</select>
					
					<span class="input-group-addon"><i class="fa fa-male" aria-hidden="true" required="" data-parsley-error-message="please select dependent20">60세 이상 부양자</i></span>
					<select class="selectpicker form-control" name="dependent60">
						<option value="0" >0</option>
						<option value="1" >1</option>
						<option value="2" >2</option>
						<option value="3" >3</option>
						<option value="4" >4</option>
					</select>			
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-location-arrow" aria-hidden="true"></i></span>
					<input name="base" class="form-control" type="text" size="11" placeholder="기본급" autocomplete="off"  required="" data-parsley-error-message="please insert base"/>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
					<input name="extrapay1" class="form-control" type="text" size="11" placeholder="수당 1" autocomplete="off"  required="" data-parsley-error-message="please insert extrapay"/>
				</div>
				<br>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
					<input name="extrapay2" class="form-control" type="text" size="11" placeholder="수당 2" autocomplete="off"  required="" data-parsley-error-message="please insert extrapay"/>
				</div>
				
				<span>&nbsp;&nbsp;</span>
				<span>&nbsp;&nbsp;</span>
				<div class="input-group">
					<span class="input-group-addon"><i class="fa fa-home" aria-hidden="true"></i></span>
					<input name="insurance" class="form-control" type="text" size="11" placeholder="국민보험" autocomplete="off"  required="" data-parsley-error-message="please insert insurance"/>
				</div>
				<br>
				<div align="center">
					<button id="save" name="save" type="button" class="btn btn-success">Save</button>
					<span>&nbsp;&nbsp;</span>
					<span>&nbsp;&nbsp;</span>
					<button type="button" name="cancel" class="btn btn-default">Cancel</button>
				</div>
			</div>
			<div class="col-md-4"></div>
		</div>
		
	</div>
</form>
</body>
</html>