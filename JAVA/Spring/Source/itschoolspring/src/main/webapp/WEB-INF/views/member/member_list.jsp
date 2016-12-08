<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<content tag="link">
<link rel="stylesheet" href="resources/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="resources/css/table.min.css">
</content>

<content tag="script">
<script src = "resources/js/table.min.js"></script>
</content>


</head>

<content tag="local_script">

 <script type="text/javascript">
$(document).ready(function() {
	$('#example').DataTable();
	$("#allchk").click(function() {
		if($(this).is(':checked')) {
			$("input[name=unitchk]").prop("checked", true);
		}
		else{
			$("input[name=unitchk]").prop("checked", false);
		}
	});
	$("#example_filter").append("<button id ='selectdel' type = 'button' style='margin-left: 350px;'>선택삭제</button>");
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
        		
        		var url = "memberSelectedDelete?saveids="+saveids;
        		$(location).attr('href',url);
    		} else {
    			return;
    		}
    	}
    		
    });
} );
 </script>
 
</content>

<body>
<table id="example" class="display" cellspacing="0" width="80%"  align="right">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>Email</th>
                <th>Address</th>
                <th>Date</th>
                <th>Photo</th>
             	<th style ="text-align:center limportant;"><input type="checkbox" id="allchk" /></th>
            </tr>
        </thead>
        <tfoot>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Password</th>
                <th>Phone</th>
                <th>email</th>
                <th>Address</th>
                <th>Date</th>
            	<th>Photo</th>
            </tr>
        </tfoot>
        <tbody>
          <c:forEach var="member" items="${members}">
           <tr>
                <th><a href="memberUpdateForm?id=${member.id}">${member.id}</a></th>
                <th>${member.name}</th> 
                <th>${member.password}</th>
                <th>${member.phone1}-${member.phone2}-${member.phone3}</th>
                <th>${member.email}</th>
                <th>${member.addr1}+${member.addr2}</th>
                <th>${member.inputdate}</th>
                <th>${member.photo}</th>
                <th style ="text-align:center limportant;"><input type="checkbox" id="unitchk" name="unitchk" value ="${member.id}"/></th>
            </tr>
          </c:forEach>
        </tbody>
    </table>
</body>
</html>