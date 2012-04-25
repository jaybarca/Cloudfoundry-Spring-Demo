<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Home</title>
</head>
<body>
	<h1>Hello world!</h1>
	<p>
		<c:forEach items="${stuffs}" var="stuff">
		${stuff}
		<br />
		</c:forEach>
	</p>
                <h2>Stuff List:</h2>
                <div id='new-company-link'>
                    <a href="stuff/new" title="Add a new stuff">Add a new stuff</a>
                </div>
</body>
</html>
