<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html style="overflow: hidden;" lang="en"><head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="Olive Enterprise">
<!-- END SHORTCUT ICON -->
<title>小莱信息化管理系统</title>
<jsp:include page="../base/link.jsp"/>
<body onpageshow='event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();;event.persisted&amp;&amp;(function(){var x=CKEDITOR.instances,d,i;for(i in x){d=x[i].document;if(d){d.$.designMode="off";d.$.designMode="on";}}})();'>
	<section id="container">
	
<jsp:include page="../base/header.jsp"/>

<jsp:include page="../base/aside.jsp"/>
		

	<section id="main-content">

<section class="wrapper">
	<div class="row" id="departmentbar">
		<div class="col-lg-12">
			<section class="panel">
				<div class="panel-body">
					<form class="form-inline" role="form" method="get" action="deptList">
						<div class="form-group">
							<label class="sr-only" for="name">部门名称</label>
							<input class="form-control" id="name" name="name" placeholder="部门名称" type="text">
							<input class="form-control" name="pageNum"value="${ pageNum }" type="hidden">
						</div>
						<button type="submit" class="btn btn-round btn-info" id="search_but">检索</button>
						<button type="button" class="btn btn-round btn-default" id="clean_but">清空</button>
						<button type="button" class="btn  btn-info" onclick="location.href='insertPage'" 
							id="add_but" style="margin-left:50px;">添加部门</button>
						<button type="button" class="btn  btn-success" onclick="updateDepartment()" id="edit_but">编辑部门</button>
                        <button type="button" class="btn  btn-success" onclick="deleteDepartment()">删除部门</button>
					</form>
				</div>
			</section>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12" id="department_main">

<section class="panel">
	<header class="panel-heading">
		<span class="label label-primary">部门信息列表 </span>
	</header>
	<div class="panel-body">
		<section id="unseen">
			<table class="table table-bordered table-striped table-condensed" id="departmentlist">
				<thead>
					<tr>
						<th style="text-align: center"><input name="all" value="true" id="selectAll" style="display:none;" type="checkbox"><input id="__checkbox_selectAll" name="__checkbox_all" value="true" type="hidden"></th>
						<th>序号</th>
						<th>部门编号</th>
						<th>部门名称</th>
						<th>部门描述</th>
					</tr>
				</thead>
				<tbody>
				   <form action="delete" id="deleteForm" method="post">
					   <c:forEach items="${ deptList }" var="dept">
							<tr>
								<td style="text-align: center">
									<input name="ids" value="${ dept.id }" id="sel" type="checkbox">
								</td>
								<td>${ dept.id }</td>
								<td>${ dept.departNo }</td>
								<td>${ dept.name }</td>
								<td>${ dept.description }<br></td>
							</tr>
						</c:forEach>
					</form>
				</tbody>
			</table>
			
		</section>
	</div>



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
					<a href="deptList?pageNum=1">首页</a>
				</li>
				<c:if test="${ pageNum>1 }">
					<li class="prev"><a href="deptList?pageNum=${ pageNum-1 }">上一页</a></li>
				</c:if>
				<li class="active">
					<a href="">
						<span class="thispage" id="thisPage" style="height: 18px; padding-top: 2px !important;">${ pageNum }</span>
					</a>
				</li>
				<c:if test="${ pageNum<countMap.totalPage }">
			    	<li class="prev"><a href="deptList?pageNum=${ pageNum+1 }">下一页</a></li>
			    </c:if>
				<li class="prev"><a href="deptList?pageNum=${ countMap.totalPage }">尾页</a></li>
			</ul>
		</div>
	</div>
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
   function deleteDepartment(){
	   
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
   
 function updateDepartment(){
	   
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
	    	  alert("请选择一条数据修改！！！")
	    }else if(num>1){

			alert("不能选择多条数据修改！！！")
	   }
	   else{
		   	$("#deleteForm").attr('action',"queryById"); 
		   	$("#deleteForm").attr('method',"GET"); 
			$('#deleteForm').submit();
	   }
	   
   }
 
 </script>

</body></html>