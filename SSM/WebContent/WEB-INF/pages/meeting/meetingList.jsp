<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<link rel="shortcut icon">
<!-- END SHORTCUT ICON -->
<title>小莱信息化管理系统</title>

<jsp:include page="../base/link.jsp"/>

<body onpageshow='event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();;event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();'>
	<section id="container">
		
<jsp:include page="../base/header.jsp"/>

<jsp:include page="../base/aside.jsp"/>

		<section id="main-content">

<section class="wrapper">
	<div class="row" id="askforleavebar">
		<div class="col-lg-12">
			<section class="panel">
				<div class="panel-body">
<form class="form-inline" role="form" action="meetingList">
	<input name="pageNum" value="1" type="hidden">
	<div class="form-group">
		<label class="sr-only" for="num">标题：</label> 
		<input class="form-control" name="title" placeholder="标题" type="text">
	</div>
	<button type="submit" class="btn btn-round btn-info" id="search_but">检索</button>
	<button type="button" class="btn btn-round btn-default" id="clean_but">清空</button>
	<button type="button" class="btn  btn-info" id="add_but" 
		onclick="location.href='insertPage'" style="margin-left:10px;">添加</button>
	<button type="button" class="btn  btn-info" id="add_but" 
		onclick="updateMeeting()" style="margin-left:10px;">编辑</button>
	<button type="button" class="btn  btn-info" id="add_but" onclick="deleteMeeting()" 
		style="margin-left:10px;">删除</button>
</form>
				</div>
			</section>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12" id="askforleave_main">

<section class="panel">
	<header class="panel-heading">
		<span class="label label-primary">会议列表 </span>
	</header>
	<div class="panel-body">
		<section id="unseen">
<table class="table table-bordered table-striped table-condensed" id="askforleavelist">
	<thead>
		<tr>
			<th style="text-align: center">
			</th>
			<th>序号</th>
			<th>发布人</th>
			<th>开始时间</th>
			<th>结束时间</th>
			<th>标题</th>
			<th>会议内容</th>
			<th>会议地址</th>
		</tr>
	</thead>
	<tbody>
		 <form action="delete" id="deleteForm" method="post">
			<c:forEach items="${ meetingList }" var="meeting" >
				<tr>
					<td style="text-align: center">
						<input name="ids" value="${ meeting.id }" id="sel" type="checkbox">
					</td>
					<td>${ meeting.id }</td>
					<td>${ meeting.account.id }:${ meeting.account.name }</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ meeting.beginTime }"/>
					</td>
					<td>
						<fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${ meeting.endTime }"/>
						<%-- <fmt:formatDate value="${ meeting.endTime }" type="both" dateStyle="medium" timeStyle="medium"/> --%>
					</td>
					<td>${ meeting.title }</td>
					<td>${ meeting.content }</td>
					<td>${ meeting.address }</td>
				</tr>
			</c:forEach>
		</form>
	</tbody>
</table>
<div class="row-fluid">
	<div class="span6">
		<div class="dataTables_info" id="example_info">
			当前共有<span class="number" style="color: red;">${ countMap.totalCount }</span>条记录;
			当前共有<span class="number" style="color: red;">${ countMap.totalPage }</span>页
		</div>
	</div>
	<div class="span6">
		<div class="dataTables_paginate paging_bootstrap pagination">
			<ul>
				<li class="prev">
					<a href="meetingList?pageNum=1">首页</a>
				</li>
				<c:if test="${ pageNum>1 }">
					<li class="prev"><a href="meetingList?pageNum=${ pageNum-1 }">上一页</a></li>
				</c:if>
				<li class="active">
					<a href="">
						<span class="thispage" id="thisPage" style="height: 18px; padding-top: 2px !important;">${ pageNum }</span>
					</a>
				</li>
				<c:if test="${ pageNum<countMap.totalPage }">
			    	<li class="prev"><a href="meetingList?pageNum=${ pageNum+1 }">下一页</a></li>
			    </c:if>
				<li class="prev"><a href="meetingList?pageNum=${ countMap.totalPage }">尾页</a></li>
			</ul>
		</div>
	</div>
</div>
		</section>
	</div>
</section>
</div>
	</div>
</section></section>
		<!-- END MAIN CONTENT -->
		<!-- BEGIN FOOTER -->
		
<jsp:include page="../base/footer.jsp"/>
	</section>
<jsp:include page="../base/js.jsp"/>
	<!-- JQUERY KNOB JS -->
	<script>
      //knob
      $(".knob").knob();
    </script>
<script type="text/javascript">
   function deleteMeeting(){
	   
	   var r=document.getElementsByName("ids"); 
	   var flag=false;
	    for(var i=0;i<r.length;i++){
	         if(r[i].checked){
	     
	        	   flag=true;
	        	   break;
	       }
	    }      
	   if(flag){
			$('#deleteForm').submit();
		  
	   }else{
		   alert("请选择一条数据删除！！！")
	   }
	   
   }
   
 function updateMeeting(){
	   var r=document.getElementsByName("ids"); 
	   var flag=false;
	   var num=0;
	    for(var i=0;i<r.length;i++){
	         if(r[i].checked){
	     
	        	   flag=true;
	               num++;
	       }
	    }
	    if(flag==false){
	    	  alert("请选择一条数据修改！！！");
	    }else if(num>1){
			alert("不能选择多条数据修改！！！");
	   }
	   else{
		   	$("#deleteForm").attr('action',"queryById"); 
		   	$("#deleteForm").attr('method',"GET"); 
			$('#deleteForm').submit();
	   }
	   
   }
 
 
 </script>

</body></html>