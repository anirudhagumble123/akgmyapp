<%-- <%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
 --%>
 
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page session="false"%>



<!DOCTYPE html>
<html>
  <head>
      <meta charset="utf-8">
      
		<title><spring:message code="label.title" /></title>
      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

 <div style="text-align: right;padding:5px;margin:5px 0px;background:#ccc;">
       <a href="${pageContext.request.contextPath}/login?lang=en">Login (English)</a>
       &nbsp;|&nbsp;
       <a href="${pageContext.request.contextPath}/login?lang=fr">Login (French)</a>
       &nbsp;|&nbsp;
       <a href="${pageContext.request.contextPath}/login?lang=vi">Login (Vietnamese)</a>
    </div>

    <div class="container">
      <form method="POST" action="${contextPath}/login" class="form-signin">
        <h2 class="form-heading">Log in</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <span>${message}</span>
            
            <spring:message code="label.userName" />
            <input name="username" type="text" class="form-control" placeholder="Username"
                   autofocus="true"/>
                   
            <spring:message code="label.password" />
            <input name="password" type="password" class="form-control" placeholder="Password"/>
            <span>${error}</span>
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			
			<spring:message code="label.submit" var="labelSubmit"></spring:message>
            <button class="btn btn-lg btn-primary btn-block" type="submit" >Log In</button>
            <h4 class="text-center"><a href="${contextPath}/registration">Create an account</a></h4>
        </div>   
      </form>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  </body>
</html>
