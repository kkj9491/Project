<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

	<c:url var="link" value="boardRead">
		<c:param name="brdno" value="${listitem.brdno}"	/>
	</c:url>
	<div class="listBody">
		<div class="listHiddenField pull-left field60">
			<c:choose>
				<c:when test="${listitemNo != null }">
					<c:out value="${listitemNo}"/>
				</c:when>
				<c:otherwise>
					<i class="fa fa-bell-o fa-fw"></i>				
				</c:otherwise>
			</c:choose>		
		</div>
		
		<div class="listHiddenField pull-right field100"><a href="boardList?bgno=<c:out value="${listitem.bgno}"/>"><c:out value="${listitem.bgname}"/></a></div>
				
		
	
	</div>