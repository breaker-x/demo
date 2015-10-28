<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/jsp/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<%@ include file="/common/jsp/meta.jsp"%>
<title>SACS HOME</title>
</head>
<body>
	<div class="page-content">
		<div class="tiles">
			<a href="${ctx}/web/user/search?userName=">
				<div class="tile bg-green">
					<div class="title-body">
						用户一览
					</div>
				</div>
			</a>
			<%-- <a href="${ctx}/web/user/tsdr">
				<div class="tile bg-yellow">
					<div class="title-body">
						测试redis
					</div>
				</div>
			</a> --%>
		</div>
	</div>
</body>
</html>