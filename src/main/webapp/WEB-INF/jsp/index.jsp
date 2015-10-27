<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/common/jsp/taglibs.jsp" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<%@ include file="/pub/common/jsp/meta.jsp"%>
<title>Insert title here</title>
</head>
<body>
	welcome: ${userName}
	<a href="${ctx}/web/user/search?userName=">用户一览</a>
	<a href="${ctx}/web/user/tsdr">testsdr</a>
</body>
</html>