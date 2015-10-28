<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/jsp/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=EmulateIE8" />
<%@ include file="/common/jsp/meta.jsp"%>
<link href="${ctx}/plugin/metronic/css/login.css" rel="stylesheet"
	type="text/css" />
<title>Login</title>
</head>
<body class="login">
	<!-- BEGIN LOGO -->
	<div class="logo">
		<img src="media/image/logo-big.png" alt="" />
	</div>
	<!-- END LOGO -->
	
	<!-- BEGIN LOGIN -->
	<div class="content">
		<!-- BEGIN LOGIN FORM -->
		<form class="form-vertical login-form" action="${ctx}/web/user/checkLogin" method="post">
			<h3 class="form-title">Login to your account</h3>
			<div class="alert alert-error hide">
				<button class="close" data-dismiss="alert"></button>
				<span>Enter any username and password.</span>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i> 
						<input id="userName" class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="userName" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i> 
						<input id="password" class="m-wrap placeholder-no-fix" type="password" placeholder="Password" name="password" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<label class="checkbox"> 
					<input type="checkbox" name="remember" value="1" /> Remember me
				</label>
				<button type="submit" class="btn green pull-right">
					Login <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
			<div class="forget-password">
				<h4>Forgot your password ?</h4>
				<p>
					no worries, click <a href="javascript:;" class=""
						id="forget-password">here</a> to reset your password.
				</p>
			</div>
			<div class="create-account">
				<p>
					Don't have an account yet ?&nbsp; <a href="javascript:;"
						id="register-btn" class="">Create an account</a>
				</p>
			</div>
		</form>
		<!-- END LOGIN FORM -->
		
		<!-- BEGIN FORGOT PASSWORD FORM -->
		<form class="form-vertical forget-form" action="index.html">
			<h3 class="">Forget Password ?</h3>
			<p>Enter your e-mail address below to reset your password.</p>
			<div class="control-group">
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i> 
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Email" name="email" />
					</div>
				</div>
			</div>
			<div class="form-actions">
				<button type="button" id="back-btn" class="btn">
					<i class="m-icon-swapleft"></i> Back
				</button>
				<button type="submit" class="btn green pull-right">
					Submit <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END FORGOT PASSWORD FORM -->

		<!-- BEGIN REGISTRATION FORM -->
		<form class="form-vertical register-form" action="index.html">
			<h3 class="">Sign Up</h3>
			<p>Enter your account details below:</p>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Username</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-user"></i> 
						<input class="m-wrap placeholder-no-fix" type="text" placeholder="Username" name="username" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-lock"></i> 
						<input class="m-wrap placeholder-no-fix" type="password" id="register_password" placeholder="Password"
							name="password" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<label class="control-label visible-ie8 visible-ie9">Re-type
					Your Password</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-ok"></i> <input class="m-wrap placeholder-no-fix"
							type="password" placeholder="Re-type Your Password"
							name="rpassword" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<!--ie8, ie9 does not support html5 placeholder, so we just show field title for that-->
				<label class="control-label visible-ie8 visible-ie9">Email</label>
				<div class="controls">
					<div class="input-icon left">
						<i class="icon-envelope"></i> <input
							class="m-wrap placeholder-no-fix" type="text" placeholder="Email"
							name="email" />
					</div>
				</div>
			</div>
			<div class="control-group">
				<div class="controls">
					<label class="checkbox"> <input type="checkbox" name="tnc" />
						I agree to the <a href="#">Terms of Service</a> and <a href="#">Privacy
							Policy</a>
					</label>
					<div id="register_tnc_error"></div>
				</div>
			</div>
			<div class="form-actions">
				<button id="register-back-btn" type="button" class="btn">
					<i class="m-icon-swapleft"></i> Back
				</button>
				<button type="submit" id="register-submit-btn"
					class="btn green pull-right">
					Sign Up <i class="m-icon-swapright m-icon-white"></i>
				</button>
			</div>
		</form>
		<!-- END REGISTRATION FORM -->
	</div>
	<!-- END LOGIN -->

	<!-- BEGIN COPYRIGHT -->
	<div class="copyright">2013 &copy; Metronic. Admin Dashboard
		Template.</div>
</body>
</html>