<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<div style="display: none;" class="row" id="userbar">
		<div class="col-lg-12">
			<section class="panel">
				<div class="panel-body">
					<form class="form-inline" role="form">
						<div class="form-group">
							<label class="sr-only" for="username">登录用户名</label> <input class="form-control" id="username" placeholder="登录用户名" type="text">
						</div>
						<div class="form-group">
							<label class="sr-only" for="name">姓名</label>
							<input class="form-control" id="name" placeholder="姓名" type="text">
						</div>
						<button type="button" class="btn btn-round btn-info" id="search_but">检索</button>
						<button type="button" class="btn btn-round btn-default" id="clean_but">清空</button>
						<button type="button" class="btn  btn-info" id="add_but" style="margin-left:50px;"><i class="fa fa-plus"></i>添加员工</button>
						<button type="button" class="btn  btn-success" id="edit_but"><i class="fa fa-wrench"></i>编辑员工</button>
					</form>
				</div>
			</section>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-12" id="user_main">

<div class="col-md-12">
	<section class="panel">
		<header class="panel-heading">
			<span class="label label-primary">修改员工信息</span> <span class="tools pull-right"> </span>
		</header>
		<div class="panel-body">
<form novalidate="novalidate" class="form-horizontal tasi-form" 
	method="post" id="addForm" action="/Spring_Project/employee_update">
	<input type="hidden" name="id" value="${employee.id}"/>
	<div class="form-group">
		<label class="control-label col-md-3">员工姓名</label>
		<div class="col-md-3 col-xs-11">
			<input name="name" id="name" value="${employee.name}"
			class="form-control form-control-inline input-medium default-date-picker" 
			style="width:80px;" type="text">
			<span class="help-block" style="color: red;"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">性别</label>
		<div class="col-md-3 col-xs-11">
			<input name="sex" value="男" type="radio">
			<label for="user_sex男">男</label>
			<input name="sex" value="女" type="radio">
			<label for="user_sex女">女</label>

			<span class="help-block" style="color: red;"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">联系电话</label>
		<div class="col-md-3 col-xs-11">
			<input name="phone" id="phone" value="${employee.phone}"
			class="form-control form-control-inline input-medium default-date-picker" 
			style="width:120px;" type="text">
			<span class="help-block" style="color: red;"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">所属部门</label>
		<div class="col-md-3 col-xs-11">
			<select name="department" id="department" 
			class="form-control form-control-inline input-medium default-date-picker" 
			style="width:240px;">
              <option value="人事部">人事部</option>
              <option value="研发部">研发部</option>
			</select>
			<span class="help-block" style="color: red;"></span>
		</div>
	</div>
	<div class="form-group">
		<label class="control-label col-md-3">角色权限</label>
		<div class="col-md-3 col-xs-11">
			<select name="role" id="authority" 
			class="form-control form-control-inline input-medium default-date-picker" 
			style="width:180px;">
			    <option value="普通员工">普通员工</option>
			    <option value="部门经理">部门经理</option>
			    <option value="总经理">总经理</option>
			    <option value="管理员">管理员</option>
			</select>
			<span class="help-block" style="color: red;"></span>
		</div>
	</div>
	<div class="form-actions">
		<input value="提交" class="btn btn-success" type="submit"> &nbsp;&nbsp;&nbsp; 
		<input value="取消" class="btn" id="cancel_b" type="button">
	</div>
</form>		
		</div>
	</section>
</div></div>
	</div>
</section></section>
		<!-- END MAIN CONTENT -->
		<!-- BEGIN FOOTER -->
		
	
<jsp:include page="../base/footer.jsp"/>

	</section>
	<!-- END SECTION -->
<jsp:include page="../base/js.jsp"/>
	<!-- JQUERY KNOB JS -->
	<script>
      //knob
      $(".knob").knob();
      
      window.onload=function(){
    	  $("#authority").find("option[value='${employee.role}']").attr("selected","selected");
    	  $("#department").find("option[value='${employee.department}']").attr("selected","selected");
    	  $("input[value='${employee.sex}']").attr("checked","checked");
      }
    </script>

</body></html>