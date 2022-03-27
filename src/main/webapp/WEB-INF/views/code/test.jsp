<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="rb" uri="http://www.springframework.org/tags" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

<form id="form" name="form" method="post" action="/infra/code/codeList">
<input type="hidden" id="thisPage" name="thisPage" value="<c:out value="${vo.thisPage}" default="1"/>">
<input type="hidden" id="ifcdSeq" name="ifcdSeq">
검색<input type="text" id="shCdValue" name="shCdValue">
<select name="shIfcgSeq">
	<option value="">@코드그룹@
	<c:forEach items="${list}" var="item" varStatus="status">		
		<option value="<c:out value="${item.ifcgSeq}"/>"><c:out value="${item.ifcgName}"/>
	</c:forEach>
</select>
<input type="submit" id="btn" name="btn">
<br>

<c:choose>
	<c:when test="${fn:length(codeList) eq 0}">
		<tr>
			<td class="text-center" colspan="9">There is no data!</td>
		</tr>	
	</c:when>
	<c:otherwise>
		<c:forEach items="${codeList}" var="item" varStatus="status">	
		
		<c:out value="${item.ifcdSeq}"/> |<a href="javascript:goForm(<c:out value="${item.ifcdSeq}"/>);"><c:out value="${item.ifcdName}"/></a> | <c:out value="${item.ifcdDelNy}"/> <br>
		
		</c:forEach>
	</c:otherwise>
</c:choose>	 



<nav aria-label="...">
  <ul class="pagination">
    <c:if test="${vo.startPage gt vo.pageNumToShow}">
		<li class="page-item"><a class="page-link" href="javascript:goList(<c:out value="${vo.startPage - 1}"/>);">Previous</a></li>
	</c:if>
<c:forEach begin="${vo.startPage}" end="${vo.endPage}" varStatus="i">
	<c:choose>
		<c:when test="${i.index eq vo.thisPage}">
        	<li class="page-item active"><a class="page-link" href="javascript:goList(<c:out value="${i.index}"/>);">${i.index}</a></li>
		</c:when>
		<c:otherwise>             
            <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value="${i.index}"/>);">${i.index}</a></li>
		</c:otherwise>
	</c:choose>
</c:forEach>     
	<c:if test="${vo.endPage ne vo.totalPages}">                
            <li class="page-item"><a class="page-link" href="javascript:goList(<c:out value="${i.index + 1}"/>);">Next</a></li>
	</c:if>  
  </ul>
</nav>
</form>




<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/infra/resources/js/validtion.js"></script>

<script type="text/javascript">


	goList = function(seq){
		alert(seq);
		
		$("#thisPage").val(seq);
		$("#form").submit();
		
	}
	
	goForm = function(seq){
		alert(seq);
		$("#ifcdSeq").val(seq);
		$("#form").attr("action","/infra/code/codeView");
		$("#form").submit();
		
	}
</script>