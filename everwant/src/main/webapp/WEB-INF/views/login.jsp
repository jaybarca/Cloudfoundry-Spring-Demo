<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Everwant</title>
<link rel="stylesheet" href="resources/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="resources/css/colors.css" type="text/css"></link>
<link rel="stylesheet" href="resources/css/local.css" type="text/css"></link>
</head>
<body>
	<div id="page">
		<div id="header">
			<div id="main-title">
				<div id='site-name'>
					<a href="/" title="Cloudfoundry Spring Demo">This is a demo of
						Cloudfoundry Spring with MongoDB</a>
				</div>
				<div id='company-name'>
					<a href="http://www.springsource.com" title="SpringSource">SpringSource
						Home</a>
				</div>
			</div>
		</div>
		<!-- /header -->
		<div id="container">
			<div id="content" class="no-side-nav">
				<h1>
					Login or <a href="/register">Register</a>
				</h1>

				<form action="${ctx}/j_security_check" id="loginForm" method="post"
					autocomplete="off">
					<p>
						<c:if test="${param.error == 'true'}">
							<div class="error">Login Failed.
								${sessionScope.SPRING_SECURITY_LAST_EXCEPTION.message}</div>
						</c:if>

						<label for="username" id="username-label">Username</label><br />
						<input id="username" type="text" name="j_username" /><br /> <label
							for="password">Password</label><br /> <input id="password"
							type="password" name="j_password" /><br /> <input
							type="checkbox" name="_spring_security_remember_me"
							id="rememberMe" /> <label for="rememberMe"
							style="vertical-align: top">Remember Me</label><br /> <input
							type="submit" id="login" class="button" value="Login" /> <input
							type="reset" id="reset" class="button" value="Clear" />
					</p>
				</form>

			</div>
		</div>
	</div>

</body>
</html>

