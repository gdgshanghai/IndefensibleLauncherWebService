<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="<c:url value="/resources/img/favicon.jpg"/>">

    <title>MemberApplication</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
	<!-- Add custom CSS here -->
	<style>
	body {
		margin-top: 60px;
	}
	</style>
	<!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]><script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
 	 <%@ include file="old_navigation.jsp" %>
	<div class="container">
		<div id="legend" class="">
			<legend class="">
				<h1>預約管理</h1>
			</legend>
		</div>
		<form:form id="applyForm" class="form-horizontal" modelAttribute="reservationForm" >
			<div class="table-responsive">
				<c:if test="${not empty reservationForm.reservations}">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>會員ID</th>
								<th>開始時間</th>
								<th>結束時間</th>
								<th>天氣</th>
								<th>事件</th>
								<th>審批狀態</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach var="reservation" items="${reservationForm.reservations}" varStatus="index">
								<tr>
									<td>${index.count}</td>
									<td>${reservation.memberidfk}</td>
									<td><fmt:formatDate value="${reservation.start}" pattern="yyyy-MM-dd HH:mm" /></td>
									<td><fmt:formatDate value="${reservation.end}" pattern="yyyy-MM-dd HH:mm" /></td>
									<td><input name="reservations[${index.index}].weather"   class="form-control" value="${reservation.weather}"/></td>
									<td><input name="reservations[${index.index}].event"  class="form-control" value="${reservation.event}"/></td>
									<td><select  class="form-control"
										name="reservations[${index.index}].status">
											<option
												<c:if test="${reservation.status=='申請中'}">selected</c:if>
												value="申請中">申請中</option>
											<option
												<c:if test="${reservation.status=='通過'}">selected</c:if>
												value="通過">通過</option>
									</select></td>
									<td style="display:none;" ><input name="reservations[${index.index}].id" value="${reservation.id}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
			</div>

			<div class="control-group">
				<label class="control-label"></label>
				<!-- Button -->
				<div class="controls">
					<button class="btn btn-success active">提交</button>
				</div>
			</div>
		</form:form>
		<div id="alertSuccess" class="alert alert-success" style="display: none;">提交成功  :)</div>
		<div class="alert alert-danger" style="display: none;">の(⊙o⊙)…  出錯了</div>
	</div>
	<!-- /container -->


	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    
   	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap-datetimepicker.min.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.form.js" />"></script>
	<script type="text/javascript">
		$(document).ready(function() {

			var options = {
				url : "Save", // target element(s) to be updated with server response 
				beforeSubmit : showRequest, // pre-submit callback 
				success : showResponse,
				type : 'post',
				error : errorResponse
			};

			$("#applyForm").ajaxForm(options);
		});
		function showRequest(formData, jqForm, options) { 
		    var queryString = $.param(formData); 
		    return true; 
		};
		function errorResponse(responseText, statusText, xhr, $form)  { 
		};
		function showResponse(responseText, statusText, xhr, $form)  { 
		    $("#alertSuccess").css('display','block'); 
		};
	</script>
  </body>
</html>
