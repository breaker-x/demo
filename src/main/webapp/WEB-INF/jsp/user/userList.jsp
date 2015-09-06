<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户一览</title>
<style>
	.content_table{
		border-collapse: collapse;
	}
	.search_content{
		height: 30px;
		width: 500px;
		margin-left: auto;
		margin-right: auto;
	}
	ul{
		list-style: none;
		margin: 0;
		padding: 0;
	}
	.search_ul li{
		float: left;
	}
	.search_content{
		border: 1px solid #9cf;
	}
	.outside_content{
		width: 500px;
		margin-left: auto;
		margin-right: auto;
		margin-top: 10px;
		clear: both;
	}
	.outside_content_ul{
		font-size:14px;
		color:#000;
		height:32px;
		background:#9cf;
	}
	.lli_top{
		line-height:25px;
		float:left;
	}
	.tit_top_left{
		background:url(../images/tit_top_left25.png) no-repeat;
		padding-left:10px;
		height:25px;
	}
	.rli_top{
		float:right;
		margin-right:5px;
		text-align:center;
	}
</style>
<script>
	function sub(){
		document.getElementById("sform").submit();
	}
</script>
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
						<a id="searchUser" href="javascript:void(0)" onclick="sub()">检索</a>
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
						<a id="addUser" href="/springMVCdemo/web/user/addUser">添加</a>
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
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>