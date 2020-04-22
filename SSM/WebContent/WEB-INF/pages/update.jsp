<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>测试回显+修改</h1>
<form action="update" method="post" >
    <input type="hidden" name="id" value="${testBean.id}">
    用户名：<input name="name" value="${testBean.name}"/><br/>
    <input type="submit" value="update"/>
</form>
</body>
</html>