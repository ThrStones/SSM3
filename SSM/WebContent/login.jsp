<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta content="IE=11.0000" http-equiv="X-UA-Compatible">
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Custom Theme">

<title>小莱信息化管理系统登录</title>
<link href="/SSM/css/bootstrap.css" rel="stylesheet">
<link href="/SSM/css/bootstrap-reset.css" rel="stylesheet">
<link href="/SSM/css/font-awesome.css" rel="stylesheet">
<link href="/SSM/css/style.css" rel="stylesheet">
<link href="/SSM/css/style-responsive.css" rel="stylesheet">
</head>
<body class="login-screen">
<!-- BEGIN SECTION -->
<div class="container">
	<form class="form-signin" method="post" action="/SSM/account/login">
		<h2 class="form-signin-heading">小莱信息化管理系统登录</h2>
		<!-- LOGIN WRAPPER  -->
		<div class="login-wrap">
			<input class="form-control" name="name" placeholder="登录用户名" value="admin" autofocus="">
			<input class="form-control" name="password" placeholder="登录密码"  value="admin" type="password">
			<button class="btn btn-lg btn-login btn-block" id="login_but1" type="submit">登录</button>
			<p class="l_message" style="color: red;">${ errorMsg }</p>
		</div>
	</form>
</div>

</body>
</html>