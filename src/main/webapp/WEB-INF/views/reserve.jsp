
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="shortcut icon"
	href="<c:url value="/resources/img/favicon.jpg"/>">

<title>Membership application</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/daterangepicker/daterangepicker-bs3.css" />" rel="stylesheet">

<!-- Add custom CSS here -->
<link href="<c:url value="/resources/css/custom.css" />" rel="stylesheet">
<style>
body {
	margin-top: 60px;
}
</style>

</head>

<body>

	<%@ include file="navigation.jsp"%>

	<div class="container">

		<form id="applyForm" class="form-horizontal" role = "form" >
			<fieldset>
				<div id="legend" class="">
					<legend class="">
						<h1>會員預約</h1>
					</legend>
				</div>

					<div class="control-group">
					<!-- Text input-->
					<label class="control-label" for="input01">會員ID</label>
					<div class="controls">
						<input id="memberId_input" placeholder="" class="form-control"
							type="text" name="memberId">
						<p class="help-block"></p>
					</div>
				</div>
				
				
				<div class="control-group">
					<label class="control-label" for="reservationtime">預約時間</label>
					<div class="controls">
						<div class="input-prepend">
							<input type="text" name="reservation" id="reservationtime" class="form-control" />
						</div>
					</div>
				</div>





				<div class="control-group">
					<label class="control-label"></label>
					<!-- Button -->
					<div class="controls">
						<button class="btn btn-success">預約</button>
					</div>

				</div>

			</fieldset>

		</form>
		<div id="alertSuccess" class="alert alert-success"
			style="display: none;">提交成功 :)</div>
		<div id="alertError" class="alert alert-danger" style="display: none;">の(⊙o⊙)…
			出錯了,請正確填寫</div>
	</div>
	<!-- /.container -->

	<!-- Bootstrap core JavaScript -->
	<!-- Placed at the end of the document so the pages load faster -->
	<!-- Make sure to add jQuery - download the most recent version at http://jquery.com/ -->
	<script src="<c:url value="/resources/js/jquery.js" />"></script>
	<script src="<c:url value="/resources/js/bootstrap.js" />"></script>
	<script src="<c:url value="/resources/js/jquery.form.js" />"></script>
	<script
		src="<c:url value="/resources/js/daterangepicker/moment.min.js" />"></script>
	<script
		src="<c:url value="/resources/js/daterangepicker/daterangepicker.js" />"></script>
	<script type="text/javascript">
		$('#reservationtime').daterangepicker({
			timePicker : true,
			timePickerIncrement : 30,
			format : 'MM/DD/YYYY HH:mm'
		});

		$(document).ready(function() {

			var options = {
				url : "Submit", // target element(s) to be updated with server response 
				beforeSubmit : showRequest, // pre-submit callback 
				success : showResponse,
				error : errorResponse,
				type : 'post',
				// post-submit callback 
				// other available options: 
				//url:       url         // override for form's 'action' attribute 
				//type:      type        // 'get' or 'post', override for form's 'method' attribute 
				//dataType:  null        // 'xml', 'script', or 'json' (expected server response type) 
				//clearForm: true        // clear all form fields after successful submit 
				//resetForm: true        // reset the form after successful submit 

				// $.ajax options can be used here too, for example: 
				timeout : 3000
			};

			// bind form using 'ajaxForm' 
			$("#applyForm").ajaxForm(options);
		});
		// pre-submit callback 
		function showRequest(formData, jqForm, options) {

			if (!$("#memberId_input").val()) {
				$("#alertError").css('display', 'block').text(
						"の(⊙o⊙)…  出錯了,請正確填寫【會員ID】");
				return false;
			}
			if (isNaN($('#memberId_input').val())) {
				$("#alertError").css('display', 'block').text(
						"の(⊙o⊙)…  出錯了,請正確填寫【會員ID】");
				return false;
			}
			if (!$("#reservationtime").val()) {
				$("#alertError").css('display', 'block').text(
						"の(⊙o⊙)…  出錯了,請正確選擇【預約日期】");
				return false;
			}

			var queryString = $.param(formData);
			//alert('About to submit: \n\n' + queryString); 

			return true;
		};

		function errorResponse(responseText, statusText, xhr, $form) {
			$("#alertSuccess").css('display', 'none');
			$("#alertError").css('display', 'block').text(
					"の(⊙o⊙)…  出錯了,請不要重複申請~~ > < ！！！");
			;
		}
		// post-submit callback 
		function showResponse(responseText, statusText, xhr, $form) {
			// for normal html responses, the first argument to the success callback 
			// is the XMLHttpRequest object's responseText property 

			// if the ajaxForm method was passed an Options Object with the dataType 
			// property set to 'xml' then the first argument to the success callback 
			// is the XMLHttpRequest object's responseXML property 

			// if the ajaxForm method was passed an Options Object with the dataType 
			// property set to 'json' then the first argument to the success callback 
			// is the json data object returned by the server 

			//alert('status: ' + statusText + '\n\nresponseText: \n' + responseText + 
			//   '\n\nThe output div should have already been updated with the responseText.'); 
			//alert("申請成功");
			$("#alertSuccess").css('display', 'block');
			$("#alertError").css('display', 'none');
		};
	</script>
</body>
</html>