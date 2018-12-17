<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
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
	<link href="js/dynatree/ui.dynatree.css" rel="stylesheet"/>

    <script src="js/jquery-2.2.3.min.js"></script>
	<script src="js/jquery-ui.js"></script>
    <script src="css/sb-admin/bootstrap.min.js"></script>
    <script src="css/sb-admin/metisMenu.min.js"></script>
    <script src="css/sb-admin/sb-admin-2.js"></script>
	<script src="js/dynatree/jquery.dynatree.js"></script>
	<script src="js/project9.js"></script>    
		
<script>


</script>
</head>


<body>

	<div id="wrapper">
		<jsp:include page="../../common/navigation.jsp"/>
		
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"><i class="fa fa0user fa-fw"></i><s:message code="menu.user"/></h1>								
				</div>			
			</div>
			
			<div class="row">
				<div class="col-lg-3">
					<div class="panel panel-default">
						<div class="panel-heading">
							<s:message code="common.deptList"/>						
						</div>
						<div style="max-height:400px;overflow:auto;">
							<div id="tree">							
							</div>
						</div>				
					</div>				
				</div>
				
				<div class="col-lg-6">
					<div class="panel panel-default">
						<div class="panel-heading">
							<s:message code="common.userList"/>
							<button class="btn btn-outline btn-primary pull-right" onclick="fn_addUser()"><s:message code="board.append"/></button>
						</div>
						<div class="panel-body" id="userlist">						
						</div>
					</div>				
				</div>			
			</div>	
		</div>	
		<!-- page-wrapper -->
	</div>
	<!-- wrapper -->
	
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" id="closeX" class="close" data-dismiss="modal" aria-hidden="true">&times</button>	
					<h4 class="modal-title" id="myModalLabel"><s:message code="menu.user"/></h4>
				</div>
				<div class="modal-body">
					<form id="form1" name="form1">
						<input type="hidden" name="userno" id="userno">
						<input type="hidden" name="deptno" id="deptno">
						<div class="row form-group">
							<div class="col-lg-1"></div>
							<label class="col-lg-2"><s:message code="common.id"/></label>
							<div class="col-lg-5">
								<input type="text" class="form-control" id="userid" name="userid" maxlength="20">								
							</div>
							<div class="col-lg-4">
								<button type="button" class="btn btn-default" onclick="fn_chkUserid()"><s:message code="common.idchk"/></button>
							</div>							
						</div>
						
						<div class="row form-group">
						
						</div>
					</form>				
				
				</div>
				<!-- modal-body -->
			</div>
			<!-- modal-content -->
		</div>	
		<!-- modal-dialog -->
	</div>
	<!-- modal -->
</body>

</html>