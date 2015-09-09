<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
<link rel="stylesheet" type="text/css" href="/springMVCdemo/common/css/common.css"/>
<link rel="stylesheet" type="text/css" href="/springMVCdemo/css/user/user.css"/>
<script type="text/javascript" src="/springMVCdemo/common/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/springMVCdemo/js/user/user.js"></script>
</head>
<body>
	<input type="hidden" id="oper_type" value="${oper_type}">
	<div class="mainContent">
		<div class="outside_content">
			<ul class="outside_content_ul">
				<li class="lli_top">
					<div class="tit_top_left">用户信息一览</div>
				</li>
				<li class="rli_top">
					<div class="tit_top_rights">
						
					</div>
				</li>
			</ul>
			<div class="list_content">
				<form name="eform" id="eform" action="/springMVCdemo/web/user/edit" method="post">
					<input type="hidden" name="id" value="${user.id}">
					<table class="content_table" border="1" width="100%" height="100%">
						<tr>
							<th>
								用户名
							</th>
							<td>
								<input id="username" type="text" name="username" value="${user.username}">
							</td>
						</tr>
						<tr>
							<th>
								邮箱
							</th>
							<td>
								<input id="email" type="text" name="email" value="${user.email}">
							</td>
						</tr>
						<tr>
							<th>
								性别${user.sex}
							</th>
							<td>
								<select id="sex" name="sex">
									<option value="0" <c:if test="${user.sex == 0}">selected</c:if>>男</option>
									<option value="1" <c:if test="${user.sex == 1}">selected</c:if>>女</option>
								</select>
							</td>
						</tr>
						<tr>
							<th>
								年龄
							</th>
							<td>
								<input id="age" type="text" name="age" value="${user.age}">
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="btn_operator">
				<ul class="btn_ul">
					<li>
						<span>
							<a id="editUser" href="javascript:void(0)">确定</a>	
						</span>
					</li>
					<li>
						<span>
							<a id="cancel" href="/springMVCdemo/web/user/userList">取消</a>
						</span>
					</li>
				</ul>
			</div>
		</div>
	</div>
</body>
</html>