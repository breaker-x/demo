<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/springMVCdemo/web/user/checkLogin" method="post">
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