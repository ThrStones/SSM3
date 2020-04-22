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
	
	<div class="row">
		<div class="col-lg-12" id="department_main">

<div class="col-md-12">
	<section class="panel">
		<header class="panel-heading">
			<span class="label label-primary">添加部门</span> <span class="tools pull-right"> </span>
		</header>
		<div class="panel-body">
			<p class="l_message" style="color: red;">${ errorMsg }</p>
			<form novalidate="novalidate" class="form-horizontal tasi-form" method="post" id="addForm" 
			action="insert">
				<div class="form-group">
					<label class="control-label col-md-3">部门编号</label>
					<div class="col-md-3 col-xs-11">
<input name="departNo" value="${ dept.departNo }" id="departNo" class="form-control form-control-inline input-medium " style="width:230px;" type="text">
						<span class="help-block" style="color: red;"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">部门名称</label>
					<div class="col-md-3 col-xs-11">
<input name="name" value="${ dept.name }" id="name" class="form-control form-control-inline input-medium " style="width:230px;" type="text">
						<span class="help-block" style="color: red;"></span>
					</div>
				</div>
				<div class="form-group">
					<label class="control-label col-md-3">部门描述</label>
					<div class="col-md-9">
					
<textarea name="description" cols="" rows="5" id="department_comment" class="wysihtml5 form-control">${ dept.description }</textarea>

						<span class="help-block" style="color: red;"></span>
					</div>
				</div>
				<div class="form-actions">
					<input value="添加" class="btn btn-success" id="add_b111" type="submit"> &nbsp;&nbsp;&nbsp; 
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
<jsp:include page="../base/js.jsp"/>
	<!-- JQUERY KNOB JS -->
	<script>
      //knob
      $(".knob").knob();
    </script>

</body></html>