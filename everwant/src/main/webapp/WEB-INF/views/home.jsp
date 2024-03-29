<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
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
					<security:authorize ifAnyGranted="ROLE_USER">
   						Welcome <%=request.getUserPrincipal().getName()%>
						<a href="<c:url value="/logout"/>">Logout</a>
					</security:authorize>
					<security:authorize ifNotGranted="ROLE_USER">
						<a href="/login" title="Login">Please Login</a>
					</security:authorize>
				</h1>


				<h2>User List</h2>

				<ul>
					<c:forEach var="user" items="${users}">
						<li>${user.name}</li>
					</c:forEach>
				</ul>


			</div>
		</div>
	</div>

</body>
</html>

