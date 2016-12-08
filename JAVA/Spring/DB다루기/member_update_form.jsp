<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<script src="resources/js/jquery-3.1.1.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/parsley.min.js"></script>
<script src="resources/img"></script>
</head>
<script type="text/javascript">

	$(document).ready(function() {

		$('#photo').change(function(event) {
			var tmppath = URL.createObjectURL(event.target.files[0]);
			alert($(this).val());
			$('#image').attr('src', tmppath);
		});

		
	});
</script>
<body class="div-bgcolor-gray">
	<form id="insert_form" name="insert_form" class="form-horizontal"
		action="memberUpdate" method="POST" role="form"
		data-parsley-validate="true" enctype="multipart/form-data">
		<div class="contatiner">
			<span class="text-success text-center"><h1>My First
					UPDATAE Page</h1></span>
			<p class="text-success text-center">이것은 연습을 하기위한 페이지 입니다.</p>
			<br>
			<br>
			<div class="row">
				<div class="col-md-4">
					<span></span>
				</div>
				<div class="col-md-3">
					<div class="input-group">
						<span class="input-group-addon">
						<i class="fa fa-user"aria-hidden="true"></i>
						</span> 
						
							<input name="id" class="form-control"
							text="text" size="16"  id="id" required=""
							autocomplete="off" value = "${member.getId()}" readonly="readonly"/> <span
							class="input-group-btn">
						
							
						</span>
					</div>
					<div id="validateId" style="color: #ff0000"></div>

					<input type="hidden" id="confirm_chk" name="confirm_chk" value="no" />

					<br>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"
							aria-hidden="true"></i></span> <input name="password" type="password"
							id="password" class="form-control" text="text" size="16"
							required="true"
							data-parsley-error-message="please insert your Password"
							data-parsley-errors-container="div[id='validatePw']"
							autocomplete="off" value = "${member.getPassword()}" />
					</div>
					<div id="validatePw" style="color: #ff0000"></div>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-unlock-alt"
							aria-hidden="true"></i></span> <input name="repassword" value = "${member.getPassword()}" type="password"
							id="repassword" class="form-control" text="text" size="16"
							required="true"
							data-parsley-error-message="please Check Password and RePassword"
							data-parsley-equalto="#password"
							data-parsley-errors-container="div[id='validateRePw']"
							autocomplete="off" />
					</div>
					<div id="validateRePw" style="color: #ff0000"></div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-male"
							aria-hidden="true"></i></span> <input id="name" name="name"
							class="form-control" text="text" size="20" 
							required="" data-parsley-error-message="please insert your Name"
							data-parsley-errors-container="div[id='validateName']"
							autocomplete="off"  value = "${member.getName()}"/>
					</div>
					<div id="validateName" style="color: #ff0000"></div>
				</div>
				<div class="col-md-1">
					<img name="image" id="image" src="resources/test1.png"
						class="img-thumbnail" width="120px" height="120px"> <br>
					<div align="right">

						<input type="file" id="photo" name="imgfile">

					</div>
				</div>
				<div class="col-md-4"></div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-4">
					<span></span>
				</div>
				<div class="col-md-4">
					<div class="input-group">

						<select class="form-control" id="phone1" name="phone1" required=""
							data-parsley-error-message="please insert your Name"
							data-parsley-errors-container="div[id='validatePhone']" value = "${member.getPhone1()}">
							<option>011</option>
							<option>010</option>
							<option>017</option>
							<option>019</option>
							<option>018</option>
						</select> <span class="input-group-addon">-</span> <input id="phone2"
							name="phone2" class="form-control" text="text" size="4"
							required=""
							data-parsley-error-message="please insert your Name"
							data-parsley-errors-container="div[id='validatePhone']"
							autocomplete="off"
							value = "${member.getPhone2()}" />
							 <span class="input-group-addon">-</span> <input
							id="phone3" name="phone3" class="form-control" text="text"
							size="4" placeholder="Number" required=""
							value = "${member.getPhone3()}"
							data-parsley-error-message="please insert your Name"
							data-parsley-errors-container="div[id='validatePhone']"
							autocomplete="off" />
					</div>
					<div id="validatePhone" style="color: #ff0000"></div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-location-arrow" aria-hidden="true"></i></span> <input
							name="zipcode" value = "${member.getZipcode()}"class="form-control" text="text" size="6"
							autocomplete="off" /> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">Searching</button>
						</span>
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-home"
							aria-hidden="true"></i></span> <input id="addr1" name="addr1"
							class="form-control" text="text" size="50"
							required="" value = "${member.getAddr1()}"
							data-parsley-error-message="please insert your Address"
							data-parsley-errors-container="div[id='validateAdr']"
							autocomplete="off" />
					</div>
					<div id="validateAdr" style="color: #ff0000"></div>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-home"
							aria-hidden="true"></i></span> <input id="addr2" name="addr2"
							class="form-control" text="text" size="30" value = "${member.getAddr2()}"
							autocomplete="off" />
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-envelope"
							aria-hidden="true"></i></span> <input id="email1" name="email"
							class="form-control" text="text" size="30" 
							autocomplete="off" /> <span class="input-group-addon"><label>@</label></span>
						<input id="email2" name="email_domain" class="form-control"
							text="text" size="30" placeholder="example.com"
							autocomplete="off" />
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i
							class="fa fa-credit-card" aria-hidden="true"></i></span> <input
							id="cardno" name="cardno" class="form-control" text="text"
							size="30" value = "${member.getCardno()}" autocomplete="off" />
					</div>
					<br>
					<div class="input-group">
						<span class="input-group-addon"><i class="fa fa-briefcase"
							aria-hidden="true"></i></span> <input id="Job" name="job"
							class="form-control" text="text" size="30" 
							autocomplete="off" value = "${member.getJob()}"  />
					</div>
					<br>
					<div align="center">
						<button name="save" class="btn btn-default" id="save"
							type="submit">Save</button>
						<span>&nbsp;&nbsp;</span> <span>&nbsp;&nbsp;</span>
						
						
						<button name="cancel" type="button" id="cancel"
						 class="btn btn-default" onclick="location.href='membercancel'">Cancel</button>
						
						<span>&nbsp;&nbsp;</span> <span>&nbsp;&nbsp;</span>
						<button name="cancel" type="button" id="cancel"
							onclick="location.href='memberDeleteYn?id=${member.getId()}'" class="btn btn-default">Delete</button>
							
					</div>
					<div align="right">
						<kbd name="inputdate">2016.10.07</kbd>
					</div>
				</div>
				<div class="col-md-4"></div>
			</div>

		</div>
	</form>
</body>
</html>