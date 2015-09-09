<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户一览</title>
<link rel="stylesheet" type="text/css" href="/springMVCdemo/common/css/common.css"/>
<link rel="stylesheet" type="text/css" href="/springMVCdemo/css/user/user.css"/>
<script type="text/javascript" src="/springMVCdemo/common/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="/springMVCdemo/js/user/user.js"></script>
</head>
<body>
	<div class="mainContent">
		<div class="search_content">
			<form name="sform" id="sform" action="/springMVCdemo/web/user/search" method="post">
				<ul class="search_ul">
					<li>
						用户名:
					</li>
					<li>
						<input type="text" id="uname" name="userName">
					</li>
					<li>
						<a id="searchUser" href="javascript:void(0)">检索</a>
					</li>
				</ul>
			</form>
		</div>
		<div class="outside_content">
			<ul class="outside_content_ul">
				<li class="lli_top">
					<div class="tit_top_left">用户信息一览</div>
				</li>
				<li class="rli_top">
					<div class="tit_top_rights">
						<a href="/springMVCdemo/web/user/toEdit?id=">添加</a>
					</div>
				</li>
			</ul>
			<div class="list_content">
				<table class="content_table" border="1" width="100%" height="100%">
					<tr class="title_tr">
						<th>
							用户名
						</th>
						<th>
							邮箱
						</th>
						<th>
							性别
						</th>
						<th>
							年龄
						</th>
						<th>
							操作
						</th>
					</tr>
					<c:forEach items="${userList}" var="users">
						<tr>
							<td>
								${users.username}
							</td>
							<td>
								${users.email}
							</td>
							<td>
								${users.sex}
							</td>
							<td>
								${users.age}
							</td>
							<td>
								<a href="/springMVCdemo/web/user/toEdit?id=${users.id}">变更</a>
								<a href="/springMVCdemo/web/user/delete?id=${users.id}" style="margin-left: 10px;">删除</a>
							</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>