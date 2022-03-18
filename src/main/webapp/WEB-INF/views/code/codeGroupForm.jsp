<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>

<form id="form" method="post" action="/infra/code/codeGroupInst">
	<input type="text" id="ifcgName" name="ifcgName" placeholder="아이디">
	<input type="submit" id="btnSubmit" value="제출">
</form>


<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/infra/resources/js/validation.js"></script>

<script type="text/javascript">

	$("#btnSubmit").on("click", function(){
		if(checkNull($("#shIfcgName"),  $("#shIfcgName").val(), "코드그룹을 입력해주세요")) return false;


</script>