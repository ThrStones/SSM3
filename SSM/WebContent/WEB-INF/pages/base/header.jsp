<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header class="header white-bg">
	<div class="sidebar-toggle-box">
		<div title="" data-original-title="" data-placement="right"
			class="fa fa-bars tooltips"></div>
	</div>
	<a href="javascript:void(0)" class="logo">小莱信息化管理系统<span><span
			style="color: white; font-weight: bold;">[人事部]&nbsp;&nbsp;&nbsp;</span></span>
	</a>
	<div class="top-nav ">
		<ul class="nav pull-right top-menu">
			<li class="dropdown"><a data-toggle="dropdown"
				class="dropdown-toggle" href="#"> <img alt=""
					src="images/avatar1_small.jpg"> <span class="username">${ sessionScope.employee.name }</span>
					<b class="caret"> </b>
			</a>
				<ul class="dropdown-menu extended logout">
					<li class="log-arrow-up"></li>
					<li><a href="javascript:void(0)" id="configP"> <i
							class=" fa fa-suitcase"> </i> 个人信息
					</a></li>
					<li>
						<a href="/Spring_Project/logout" id="logout"> 
							<i class="fa fa-key"> </i>注销
						</a>
					</li>
				</ul></li>
		</ul>
	</div>
</header>


<script type="text/javascript">
	function show(id) {
		for (var i = 0; i <= 5; i++) {
			if (id == i) {
				if (document.getElementById("sub_" + id).style.display == "none") {
					document.getElementById("sub_" + id).style.display = "block";

				} else {
					document.getElementById("sub_" + id).style.display = "none";

				}
			} else {
				document.getElementById("sub_" + i).style.display = "none";

			}
		}

	}
</script>