<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    
    <title><s:message code="common.pageTitle"/></title>
    <link href="css/sb-admin/bootstrap.min.css" rel="stylesheet">
    <link href="css/sb-admin/metisMenu.min.css" rel="stylesheet">
    <link href="css/sb-admin/sb-admin-2.css" rel="stylesheet">
    <link href="css/sb-admin/font-awesome.min.css" rel="stylesheet" type="text/css">
	<link href="js/dynatree/ui.dynatree.css" rel="stylesheet" id="skinSheet"/>

    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="css/sb-admin/bootstrap.min.js"></script>
    <script src="css/sb-admin/metisMenu.min.js"></script>
    <script src="css/sb-admin/sb-admin-2.js"></script>
	<script src="js/project9.js"></script>
<script>
function fn_formSubmit(){
	document.form1.submit();	
}
</script>
	
</head>	

<body>

	<div id="wrapper">
	
		<jsp:include page="../common/navigation.jsp" />
		
		<div id="page-wrapper">
			<div class="row">
				<h1 class="page-header"><i class="fa fa-gear fa-fw"></i><s:message code="crud.title"/></h1>
			</div>
			<!-- row -->		
			
			<div class="row">
				<div class="col-lg-12">
					<button type="button" class="btn btn-default pull-right" onclick="fn_moveToURL('crudForm')">
					<i class="fa fa-edit fa-fw"></i><s:message code="board.new"/></button>
				</div>			
			</div>
			<!-- row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<div class="listHiddenField pull-left field60"><s:message code="board.no" /></div>
					<div class="listHiddenField pull-left field100"><s:message code="crud.crdate" /></div>
					<div class="listHiddenField pull-left field100"><s:message code="crud.usernm" /></div>
					<div class="listTitle"><s:message code="crud.crtitle" /></div>
				</div>
				
				<c:if test="${listview.size()==0}">
					<div class="listBody height200">
					</div>
				</c:if>
				
				<c:forEach var="listview" items="${listview}" varStatus="status">
					<c:url var="link" value="crudRead">
						<c:param name="crno" value="${listview.crno}" />
					</c:url>
					
					<div class="listBody">
						
					</div>
				
				</c:forEach>
							
			</div>		
			<!-- panel panel-default -->
		</div>	
		<!-- page-wrapper -->
	</div>
	<!-- wrapper -->
</body>

</html>