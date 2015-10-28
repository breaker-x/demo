<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8"/>
<%@ include file="/common/jsp/meta.jsp"%>
<title>用户一览</title>
<script type="text/javascript" src="${ctx}/js/user/user.js"></script>
</head>
<body>
	<div class="page-content">
		<div class="container-fluid">
			<div class="row-fluid">
				<h3 class="page-title"></h3>
				<div class="span12">
					<form class="form-horizontal" name="sform" id="sform" action="${ctx}/web/user/search" method="post">
						<div class="control-group">
							<label class="control-label">用户名</label>
							<div class="controls">
								<input type="text" class="m-wrap small" id="uname" name="userName">
								<a id="searchUser" href="javascript:void(0)" class="btn blue">检索</a>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row-fluid">
				<div class="span12">
					<div class="portlet box yellow">
						<div class="portlet-title">
							<div class="caption">
								用户信息一览
							</div>
							<div class="actions">
								<a class="btn green" href="${ctx}/web/user/toEdit?id=">添加</a>
							</div>
						</div>
						<div class="portlet-body">
							<table class="table table-bordered table-hover"">
								<thead>
									<tr>
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
								</thead>
								<tbody>
									<c:forEach items="${userList}" var="users">
										<tr>
											<td>
												${users.userName}
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
												<a class="btn blue" href="${ctx}/web/user/toEdit?id=${users.id}">变更</a>
												<a class="btn red" href="${ctx}/web/user/delete?id=${users.id}" style="margin-left: 10px;">删除</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							<!-- 分页  -->
							<div style="text-align: right;">
								<div class="pagination" style="display:inline-block">
									<div class="totalpage">共${total}条记录</div> 
									<ul style="font-size: 13px;padding:0px;margin:0px;">
									<!--上一页 -->
										<li>
											<c:if test="${page<=1}">
												<a id="fno" href="javascript:void(0)"> 
													<font color="#DDDDDD">上一页</font>
												</a>
											</c:if> 
											<c:if test="${page>1}">
												<a class="no pagebar" style="border-left-width: 1px;"
													href="${ctx}/web/user/search?pageNo=${page-1}&userName=${userName}">
													<font style="color: #369BD7">上一页</font>
												</a>
											</c:if>
										</li>
						
										<c:if test="${begin != null}">
											<li >
												<a class="no pagebar"
												href="${ctx}/web/user/search?pageNo=1&userName=${userName}">
												1
												</a>
											</li>
											<li style="border:0px">
												<a id="fno" href="javascript:void(0)"> ...</a>
											</li>
										</c:if>
										<!--页码显示 -->
										<c:forEach items="${numList}" var="num">
											<li>
												<c:if test="${page==num}">
													<a style="background-color: #F5F5F5" class="pagebar"
														href="${ctx}/web/user/search?pageNo=${num}&userName=${userName}">
														${num}
													</a>
												</c:if> 
												<c:if test="${page!=num}">
													<a class="no pagebar"
														href="${ctx}/web/user/search?pageNo=${num}&userName=${userName}">
														${num}
													</a>
												</c:if>
											</li>
										</c:forEach>
										<c:if test="${end != null}">
											<li style="border:0px">
												<a id="lno" href="javascript:void(0)" style="cursor: default;">
													...
												</a>
											</li>
											<li>
												<a class="no pagebar"
													href="${ctx}/web/user/search?pageNo=${end}&userName=${userName}">
													${end}
												</a>
										
											</li>
										</c:if>
						
										<!--下一页 -->
										<li>
											<c:if test="${page>=totalPages}">
												<a id="lno" href="javascript:void(0)" style="cursor: default;">
													<font style="color: #DDDDDD">下一页</font>
												</a>
											</c:if> 
											<c:if test="${page<totalPages}">
												<a class="no pagebar"
													href="${ctx}/web/user/search?pageNo=${page+1}&userName=${userName}">
													<font style="color: #369BD7">下一页</font>
												</a>
											</c:if>
										</li>
									</ul>
								</div>
							</div> 
							<!-- 结束分页 --> 
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>