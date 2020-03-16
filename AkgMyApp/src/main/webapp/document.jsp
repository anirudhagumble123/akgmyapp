<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<%@ page import="java.sql.*" %> 
<%@ page import="java.io.*" %> 


<!DOCTYPE html>
<html lang="en">
  <head>
      <meta charset="utf-8">
      <title>Create a document</title>

      <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
      <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
  </head>

  <body>

    <div class="container">

        <form:form method="POST" modelAttribute="documentForm" class="form-signin" enctype="multipart/form-data">
            <h2 class="form-signin-heading">Create a document</h2>
         
            <spring:bind path="documentname">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="documentname" class="form-control" placeholder="documentname"></form:input>
                    <form:errors path="documentname"></form:errors>
                </div>
            </spring:bind>
            
            

            <spring:bind path="documenttype">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="documenttype" class="form-control"
                                placeholder="documenttype"></form:input>
                    <form:errors path="documenttype"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="country">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="country" class="form-control" placeholder="country"
                                autofocus="true"></form:input>
                    <form:errors path="country"></form:errors>
                </div>
            </spring:bind>
            
            <spring:bind path="documentdate">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="text" path="documentdate" class="form-control" placeholder="documentdate"
                                autofocus="true"></form:input>
                    <form:errors path="documentdate"></form:errors>
                </div>
            </spring:bind>
            
            
             <spring:bind path="data">
                <div class="form-group ${status.error ? 'has-error' : ''}">
                    <form:input type="file" path="data" class="form-input" placeholder="upload a file"
                                autofocus="true"></form:input>
                    <form:errors path="data"></form:errors>
                </div>
            </spring:bind>
           
         
            <br><br><br>
         
            <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        </form:form>
   
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script src="${contextPath}/resources/js/bootstrap.min.js"></script>
  
</body>
</html>

