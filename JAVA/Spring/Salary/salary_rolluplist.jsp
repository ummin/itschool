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

<content tag="salaryscript">
 <script type="text/javascript">
$(document).ready(function() {
	$("#allchk").click(function() {
		if($(this).is(':checked')) {
			$("input[name=unitchk]").prop("checked", true);
		}
		else{
			$("input[name=unitchk]").prop("checked", false);
		}
	});
    $('#selectdel').click(function ( ){
    	var checked = $("input[name=unitchk]:checked").length;
    	var saveids = new Array();
    	if( checked == 0){
    		alert("선택하시오");
    		return;
    	} else {
    		var returnValue = confirm("삭제 하시겠습니까?");
    		if(returnValue){
    			$('#unitchk:checked').each(function(index){
        			saveids[index] = $(this).val();
        		});
        		
        		var url = "salarySelectedDelete?saveids="+saveids;
        		$(location).attr('href',url);
    		} else {
    			return;
    		}
    	}
    		
    });
} );
 </script>
</content>

<body class="div-bgcolor-gray" onload="doReset();">
<form id="boardList_form" name="boardPaiging" class="form-horizontal" action="salarylist" method="POST" role="form" data-parsley-validate="true">
	<div class="contatiner"  style="height: 650px;backtround-color:#fff">
		<div class="row" style="margin-top:10px"></div>	
	    <span class="text-success text-center" ><h1><i class="fa fa-pencil-square-o" aria-hidden="true"></i> Salary List</h1></span>
	    <br><br>
		<div class="row">
			<div class="col-md-offset-2 col-md-8 text-center" style="margin-top:10px;background-color:#ccc;">
				
				<span class="col-md-1" > Date </span>
				<span class="col-md-1" style=" border:1px solid #fff;"> No</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 부서 </span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 이름</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 배우자</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 부양20</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 부양60</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 월급여</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 보험</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 결정세</span>
				<span class="col-md-1" style=" border:1px solid #fff;"> 영수증</span>
				<span class="col-md-1" style ="text-align:center;"><input type="checkbox" id="allchk" />
			</div>
		</div>
		<c:forEach var="rollups" items="${rollups}" >
			<div class="row">
				<div class="col-md-offset-2 col-md-8 text-center" style="background-color:#eeeeee">
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.yyyymm}</span>
					<span class="col-md-1" style=" border:1px solid #fff;height:40px;padding:2px;text-align:center" >
					
					<a href="salaryDetail?no=${rollups.no}">${rollups.no}</a>
					</span>
					<span class="col-md-1" style=" border:1px solid #fff;height:40px;padding:2px">${rollups.dept}</span>
					<span class="col-md-1" style=" border:1px solid #fff;height:40px;padding:2px">${rollups.name}</span>
					<span class="col-md-1" style=" border:1px solid #fff;height:40px;padding:2px;text-align:center">${rollups.partner}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.dependent20}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.dependent60}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.amount}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.insurance/12}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.decisiontax}</span>
					<span class="col-md-1" style="  height:40px;padding:2px">${rollups.receipt}</span>
					<span class="col-md-1"style ="text-align:center;"><input type="checkbox" id="unitchk" name="unitchk" value ="${rollups.no}"/>
					</span>
				</div>
			</div>
		</c:forEach>
		
<!-- 		<div class="row"> -->
<!-- 			<div class="col-md-offset-2 col-md-8 resultMessage text-center" style="margin-top:10px"> -->
<%-- 				<c:forEach var="pages" items="${pages}" > --%>
<%-- 				<span><a href = "boardPageSelect?page=${pages}"> [${pages}]</a></span> --%>
<%-- 				</c:forEach> --%>
<!-- 			</div> -->
<!-- 		</div> -->
		
		<div class="row">
			<div class="col-md-offset-2 col-md-8 resultMessage text-center" style="margin-top:10px">
				<span class="col-md-2" >
					<select name = "selectbox">
					<option value="name" >제목</option>
					<option value="dept"  >글쓴이</option>
					</select>
				</span>
				<span class="col-md-3">
					<input type="text" name="find" />
				</span>
				<span class="col-md-3">
					<i class="fa fa-search" aria-hidden="true"></i>
					<button  type="submit" class="btn btn-success resultButton"> 검색</button>
				</span>
				<span class="col-md-offset-1 col-md-3">
					<i class="fa fa-pencil" aria-hidden="true"></i>
					<button  type="button" onclick="location.href='salaryInsertForm'" class="btn btn-info resultButton">입력</button>
					<button  class="btn btn-info resultButton" id ='selectdel' type = 'button' >선택삭제</button>
				</span>
			</div>
		</div>
	</div>
</form>
</body>
</html>