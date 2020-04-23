<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
		<div class="col-lg-12" id="files_main">

<div class="col-md-12">
	<section class="panel">
		<header class="panel-heading">
			<span class="label label-primary">修改会议</span> <span class="tools pull-right"> </span>
		</header>
		<div class="panel-body">
<form novalidate="novalidate" class="form-horizontal tasi-form" method="post" id="addForm" 
action="update">
	<input name="id" value="${ meeting.id }" type="hidden">

	<div class="form-group">
		<label class="control-label col-md-3">开始时间：</label>
		<div class="col-md-3 col-xs-11">
			<input name="beginTime" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value='${ meeting.beginTime }'/>" readonly="readonly" onclick="display()" 
			class="form-control form-control-inline input-medium default-date-picker"
			 style="width:230px;" id="startTime" type="text">

	</div>
</div>
<div class="form-group">
	<label class="control-label col-md-3">结束时间：</label>
	<div class="col-md-3 col-xs-11">
		<input name="endTime" value="<fmt:formatDate pattern='yyyy-MM-dd HH:mm:ss' value='${ meeting.endTime }'/>" readonly="readonly" onclick="display()" 
		class="form-control form-control-inline input-medium default-date-picker"
		 style="width:230px;" id="endTime" type="text">
	
	</div>
</div>
<div class="form-group">
	<label class="control-label col-md-3">标题：</label>
	<div class="col-md-3 col-xs-11">
		<input name="title" value="${ meeting.title }" class="form-control form-control-inline input-medium default-date-picker" style="width:130px;" type="text">	
	</div>
</div>
<div class="form-group">
	<label class="control-label col-md-3">内容：</label>
	<div class="col-md-3 col-xs-11">
	 	<textarea rows="5" name="content" class="wysihtml5 form-control">${ meeting.content }</textarea>
	</div>
</div>

<div class="form-group">
	<label class="control-label col-md-3">会议地址：</label>
	<div class="col-md-3 col-xs-11">
		<input name="address" value="${ meeting.address }" class="form-control form-control-inline input-medium default-date-picker" style="width:130px;" type="text">	
		</div>
	</div>
	
	<div class="form-actions">
		<input value="修改" class="btn btn-success" id="add_b111" type="submit"> &nbsp;&nbsp;&nbsp; <input value="取消" class="btn" id="cancel_b" type="button">
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
<script type="text/javascript">
		function display(){       
			WdatePicker({dateFmt:"yyyy-MM-dd HH:mm:ss"});  
		}
</script>

</body></html>