<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<%@ include file="/pub/common/jsp/meta.jsp"%>
<title>Insert title here</title>
</head>
<body>
	<form action="${ctx}/web/user/checkLogin" method="post">
		<ul>
			<li>
				username:
			</li>
			<li>
				<input type="text" name="userName" id="userName">
			</li>
			<li>
				passowrd:
			</li>
			<li>
				<input type="password" name="password" id="password">
			</li>
		</ul>
		<div>
			<input type="submit" value="submit">
		</div>
	</form>
</body>
</html>