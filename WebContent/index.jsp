<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>유니쿨 유지보수 현황</title>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript">
	function schoolSearch() {
		var sch_name = $('#sch_name').val();
		$.post('./searchSchool.jsp',{sch_name:sch_name},function(result) {
			alert(result);
			$('#sch_span').html(data);
		});
	}
</script>
<%
	
 %>
</head>
<body>
	<div id="form">
		<form id="school_form" name="school_form" action="#" onsubmit="javascript:schoolSearch()">
			학교명: <input type="text" id="sch_name"><input type="submit" value="검색">
		</form>
	</div>
	<div id="school">
		<span id="sch_span"></span>
	</div>
</body>
</html>