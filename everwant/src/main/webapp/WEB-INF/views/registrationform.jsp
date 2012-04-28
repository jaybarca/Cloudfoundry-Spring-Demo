<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ page session="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Everwant</title>
<link rel="stylesheet" href="resources/css/main.css" type="text/css"></link>
<link rel="stylesheet" href="resources/css/colors.css" type="text/css"></link>
<link rel="stylesheet" href="resources/css/local.css" type="text/css"></link>
<link rel="stylesheet" href="resources/css/form.css" type="text/css"></link>
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
				<h1>Registration</h1>
				<form:form id="form" method="post" modelAttribute="registration"
					cssClass="cleanform">
					<div class="header">
						<h2>Form</h2>
						<c:if test="${not empty message}">
							<div id="message" class="success">${message}</div>
						</c:if>
						<s:bind path="*">
							<c:if test="${status.error}">
								<div id="message" class="error">Form has errors</div>
							</c:if>
						</s:bind>
					</div>
					<fieldset>
						<legend>Registration Info</legend>
						<form:errors path="userName" cssClass="error" />
						<form:label path="userName">
		  					User Name 
						</form:label>
						<form:input path="userName" />

						<form:errors path="password" cssClass="error" />
						<form:label path="password">
		  					Password 
						</form:label>
						<form:password path="password" />

						<form:errors path="confirmPassword" cssClass="error" />
						<form:label path="confirmPassword">
		  					Confirm Password 
						</form:label>
						<form:password path="confirmPassword" />

						<form:errors path="email" cssClass="error" />
						<form:label path="email">
		  					Email 
						</form:label>
						<form:input path="email" />
					</fieldset>


					<p>
						<button type="submit">Submit</button>
					</p>
				</form:form>

			</div>
		</div>
	</div>

</body>
</html>

