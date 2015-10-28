<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<%@ include file="/common/jsp/meta.jsp"%>
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="${ctx}/common/css/common.css"/>
<link rel="stylesheet" type="text/css" href="${ctx}/css/user/user.css"/>
<script type="text/javascript" src="${ctx}/common/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="${ctx}/js/user/user.js"></script>
</head>
<body>
	<input type="hidden" id="oper_type" value="${oper_type}">
	<div class="page-content">
		<div class="container-fluid">
			<div class="row-fluid">
				<div class="span12">
					<div class="portlet box blue">
						<div class="portlet-title">
							<div class="caption">用户信息修改</div>
						</div>
						<div class="portlet-body form">
							<form class="form-horizontal" name="eform" id="eform" action="${ctx}/web/user/edit" method="post">
								<input type="hidden" name="id" value="${user.id}">
								<div class="control-group">
									<label class="control-label">用户名</label>
									<div class="controls">
										<input class="m-wrap small" id="username" type="text" name="userName" value="${user.userName}">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">邮箱</label>
									<div class="controls">
										<input class="m-wrap large" id="email" type="text" name="email" value="${user.email}">
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">性别</label>
									<div class="controls">
										<select class="chosen-with-diselect span1" id="sex" name="sex">
											<option value="0" <c:if test="${user.sex == 0}">selected</c:if>>男</option>
											<option value="1" <c:if test="${user.sex == 1}">selected</c:if>>女</option>
										</select>
									</div>
								</div>
								<div class="control-group">
									<label class="control-label">年龄</label>
									<div class="controls">
										<input class="m-wrap span1" id="age" type="text" name="age" value="${user.age}">
									</div>
								</div>
								<div class="form-actions">
									<a class="btn blue" id="editUser" href="javascript:void(0)">确定</a>	
									<a class="btn blue" id="cancel" href="${ctx}/web/user/userList">取消</a>
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="mainContent">
		<div class="outside_content">
			<div class="btn_operator">
				<ul class="btn_ul">
					<li>
						<span>
							<a id="editUser" href="javascript:void(0)">确定</a>	
						</span>
					</li>
					<li>
						<span>
							<a id="cancel" href="${ctx}/web/user/userList">取消</a>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>