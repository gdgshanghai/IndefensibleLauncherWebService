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
	<%@ include file="navigation.jsp" %>
	<div class="container">
		<div id="legend" class="">
			<legend class="">
				<h1>會員</h1>
			</legend>
		</div>
		<form:form id="applyForm" class="form-horizontal" modelAttribute="applicantForm" >
			<div class="table-responsive">
				<c:if test="${not empty applicantForm.applicants}">
					<table class="table">
						<thead>
							<tr>
								<th>#</th>
								<th>姓名</th>
								<th>入会日期</th>
								<th>信用卡信息</th>
								<th>會員類型</th>


							</tr>
						</thead>
						<tbody>
							<c:forEach var="applicant" items="${applicantForm.applicants}" varStatus="index">
								<tr>
									<td>${index.count}</td>
									<td>${applicant.applicantname}</td>
									<td><fmt:formatDate value="${applicant.modifieddate}"
											pattern="yyyy-MM-dd" /></td>
									<td>${applicant.creditcardnumber}</td>
									<td>${applicant.membertype}</td>
									<td style="display:none;" ><input name="applicants[${index.index}].id" value="${applicant.id}"/></td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</c:if>
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
		});
	</script>
  </body>
</html>
