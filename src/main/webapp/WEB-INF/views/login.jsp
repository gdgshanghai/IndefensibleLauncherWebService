<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link href="<c:url value="/resources/css/signin.css" />" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy this line! -->
    <!--[if lt IE 9]>
    <script src="../../docs-assets/js/ie8-responsive-file-warning.js"></script><![endif]-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form id="loginForm" class="form-signin">
        <h2 class="form-signin-heading">Hello, sign in</h2>
        <input type="text" class="form-control" placeholder="Email address"
               name="email" required autofocus> <input type="password"
                                                       class="form-control" placeholder="Password" name="password"
                                                       required>
        <label class="checkbox"> <input type="checkbox"
                                        value="remember-me"> Remember me
        </label>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign
            in
        </button>
        <p>
        <h4>
            Not a member? <a href="#about">Apply
            here </a> .
        </h4>
        </p>

    </form>

    <div class="alert alert-danger" id="alertError" style="display: none;">Email or Passowrd Error</div>

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
    $(document).ready(function () {

        var options = {
            url: "account/login", // target element(s) to be updated with server response
            beforeSubmit: showRequest, // pre-submit callback
            success: showResponse,
            type: 'post',
            error: errorResponse
            // post-submit callback
            // other available options:
            //url:       url         // override for form's 'action' attribute
            //type:      type        // 'get' or 'post', override for form's 'method' attribute
            //dataType:  null        // 'xml', 'script', or 'json' (expected server response type)
            //clearForm: true        // clear all form fields after successful submit
            //resetForm: true        // reset the form after successful submit

            // $.ajax options can be used here too, for example:
            //timeout:   3000
        };
        // bind form using 'ajaxForm'
        $("#loginForm").ajaxForm(options);
    });
    // pre-submit callback
    function showRequest(formData, jqForm, options) {
        // formData is an array; here we use $.param to convert it to a string to display it
        // but the form plugin does this for you automatically when it submits the data
        var queryString = $.param(formData);

        // jqForm is a jQuery object encapsulating the form element.  To access the
        // DOM element for the form do this:
        // var formElement = jqForm[0];

        //alert('About to submit: \n\n' + queryString);

        // here we could return false to prevent the form from being submitted;
        // returning anything other than false will allow the form submit to continue
        return true;
    }
    ;
    function errorResponse(responseText, statusText, xhr, $form) {
        //alert("Email or Passowrd Error");
        $("#alertError").css('display', 'block');
        // alert('status: ' + statusText + '\n\nresponseText: \n' + responseText +
        //    '\n\nThe output div should have already been updated with the responseText.');
    }
    ;

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
        // '\n\nThe output div should have already been updated with the responseText.');
        //alert("Login Success");
        //$("#alertSuccess").css('display','block');
        //location.href="Approval/Select";
        location.href = "dashboard";
    }
    ;
</script>
</body>
</html>
