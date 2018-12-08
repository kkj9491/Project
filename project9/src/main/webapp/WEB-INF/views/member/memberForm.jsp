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

    <script src="js/jquery-2.2.3.min.js"></script>
    <script src="css/sb-admin/bootstrap.min.js"></script>
    <script src="css/sb-admin/metisMenu.min.js"></script>
    <script src="css/sb-admin/sb-admin-2.js"></script>
	<script src="js/project9.js"></script>

<script>

$(function(){
	<c:if test="${save eq 'OK'}">
		alert("저장되었습니다.")
	</c:if>
		
	$("#photofile").change(function(){
		readImage(this);
	});		
});

function readImage(input){
	if(input.files && input.files[0]){
		var reader = new FileReader();
		reader.onload = function(e){
			$('#previewImg').attr('src', e.target.result);
		}
		reader.readAsDataURL(input.files[0]);
	}	
}

function fn_formSubmit(){
	if(!chkInputValue("#usernm", "<s:message code="common.name"/>")) return false;
	
	$("#form1").submit();
}

function fn_changePW(){
	
	
}


</script>	
	
</head>

<body>

	<div id="wrapper">
		<jsp:include page="../common/navigation.jsp"/>
		
		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header"><i class="fa fa-user fa-fw"></i><s:message code="menu.profile"/></h1>				
				</div>										
			</div>
			<!-- row -->
			
			<div class="row">
				<div class="col-lg-7">
					<form id="form1" name="form1" role="form" action="userSave" method="post" enctype="multipart/form-data">
						<div class="row form-group">
							<div class="col-lg-1"></div>
							<label class="col-lg-2"><s:message code="common.id"/></label>
							<div class="col-lg-5">
								<input type="text" class="form-control" id="userid" name="userid"
									maxlength="20" readonly="readonly" value="<c:out value="${userInfo.userid}"/>">						
							</div>							
						</div>
						<div class="row form-group">
							<div class="col-lg-1"></div>
							<label class="col-lg-2"><s:message code="common.name"/></label>
							<div class="col-lg-8">
								<input type="text" class="form-control" id="usernm" name="usernm" maxlength="20" value="<c:out value="${userInfo.usernm}"/>">
							</div>						
						</div>				
						<div class="row form-group">
							<div class="col-lg-1"></div>
							<div class="col-lg-2"><label><s:message code="common.photo"/></label></div>
							<div class="col-sm-3">
								<img id="previewImg" style="width:100%; height: 120px; max-width: 100px;" src="fileDownload?downname=<c:out value="${userInfo.photo}"/>">
							</div>
							<div class="col-lg-5">
								<input type="file" name="photofile" id="photofile" accept='image/*'/>							
							</div>
						</div>
					</form>				
				</div>
			
			</div>
			<!-- row -->
			<button type="button" class="btn btn-primary" onclick="fn_formSubmit()"><s:message code="common.btnSave"/></button>			
			<button type="button" class="btn btn-primary" onclick="fn_changePW()"><s:message code="common.changePassword"/></button>
		</div>	
		<!-- page-wrapper -->
	</div>
	<!-- wrapper -->
	
	<div id="myModal" style="display: none;" class="modal fade bs-example-modal-sm" role="dialog" tabindex="-1" aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">x</span>
					</button>
					<h4 class="modal-title" id="mySmallModalLabel"><s:message code="common.changePassword"/></h4>									
				</div>
				<div class="modal-body">
					<div class="row form-group">
						<div class="col-lg-4"><label><s:message code="common.password"/></label></div>					
						<div class="col-sm-8">
							<input type="password" class="form-control" id="userpw" name="userpw" maxlength="20">
						</div>
					</div>
					<div class="row form-group">
						<div class="col-lg-4"><label><s:message code="common.passwordRe"/></label></div>
						<div class="col-sm-8">
							<input type="password" class="form-control" id="userpw2" name="userpw2" maxlength="20">
						</div>
					</div>				
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal" id="close"><s:message code="common.btnClose"/></button>
					<button type="button" class="btn btn-primary" onclick="fn_changePWSave()"><s:message code="common.btnSave"/></button>			
				</div>			
			</div>		
		</div>	
	</div>
	
</body>

</html>  