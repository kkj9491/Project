<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${searchVO.totPage>1}">
	
	<div id="dataTables-example_paginate" class="dataTables_paginate paging_simple_numbers">
		<ul class="pagination">
			
		
		</ul>
	</div>


</c:if>