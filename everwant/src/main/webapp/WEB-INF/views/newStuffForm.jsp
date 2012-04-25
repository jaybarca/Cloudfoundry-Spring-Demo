<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
<title>Add New Stuff</title>
	<link href="<c:url value="/resources/css/form.css" />" rel="stylesheet"  type="text/css" />		
	<script type="text/javascript" src="<c:url value="/resources/jquery/1.6/jquery.js" />"></script>
	<script type="text/javascript" src="<c:url value="/resources/jqueryform/2.8/jquery.form.js" />"></script>	
</head>
<body>
	<h1>Add New Stuff</h1>

    <div id="container">
        <div id="content" class="no-side-nav">
            <div id="customerForm">
                <div>
                    <h3>New Stuff</h3>
                </div>
                <div>
                    <spring:hasBindErrors name="stuff">
                        <div class="error">
                            <spring:bind path="stuff.*">
                                <c:forEach items="${status.errorMessages}" var="error">
                                    <c:out value="${error}"/><br/>
                                </c:forEach>
                            </spring:bind>
                        </div>
                    </spring:hasBindErrors>
                    <form:form modelAttribute="stuff">
                        <fieldset>
                            <legend>Add new stuff</legend>
                            <div>
                                <div>
                                    <label for="name">Name</label>
                                </div>
                                <div>
                                    <p><form:input path="name"/></p>
                                </div>
                            </div>
                            <div>
                                <div>
                                    <label for="tags">tags</label>
                                </div>
                                <div>
                                    <p><form:input path="tags"/></p>
                                </div>
                            </div>
                            <div>
                                <p>
                                    <button type="submit" id="submit">Submit</button>
                                </p>
                            </div>
                        </fieldset>
                    </form:form>
                </div>
                
                	<div id="fileuploadContent">
						<h2>Image Upload</h2>
						<form id="fileuploadForm" action="/fileupload" method="POST" enctype="multipart/form-data" class="cleanform">
							<div class="header">
						  		<h2>Form</h2>
						  		<c:if test="${not empty message}">
									<div id="message" class="success">${message}</div>	  		
						  		</c:if>
							</div>
							<label for="file">File</label>
							<input id="file" type="file" name="file" />
							<p><button type="submit">Upload</button></p>		
						</form>
						
    
    					<div id="imageContent"></div>
						<script type="text/javascript">
							$(document).ready(function() {
								$('<input type="hidden" name="ajaxUpload" value="true" />').insertAfter($("#file"));
								
								var imageContent = $('#imageContent');
								   
								$('form').ajaxForm({
									complete: function(xhr) {
										if(xhr.responseText){
											imageContent.empty();
											imageContent.append("<img src = '/image/" + xhr.responseText +".jpg'/>");
											
										}
									}
								}); 

							});
						</script>	
					</div>
            </div>
            <div>
                <hr/>
                <a href="/">Home</a> 
            </div>
        </div>
    </div>
</body>
</html>
