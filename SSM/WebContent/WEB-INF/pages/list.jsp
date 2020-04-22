<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>欢迎：${ sessionScope.loginAccount.name }</h1>
<h1><a href="../account/logout">注销</a></h1>

<h3><a href="insertPage">跳转新增页面</a></h3>
<h1>list</h1>
<c:forEach items="${ testBeanList }" var="testBean">
    ${ testBean.id }---${ testBean.name }--<a href="delete?id=${ testBean.id }">删除</a>--<a href="queryById?id=${ testBean.id }">修改</a><br/>
</c:forEach>
<c:if test="${pageNum>1}">
    <a href="queryAllByPage?pageNum=${pageNum-1}">上一页</a>
</c:if>
<c:if test="${pageNum<totalPage}">
    <a href="queryAllByPage?pageNum=${pageNum+1}">下一页</a>
</c:if>
共${totalPage}页
</body>
</html>