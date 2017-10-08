<%-- 
    Document   : test2
    Created on : Oct 8, 2017, 9:47:43 PM
    Author     : akash
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <button onclick="testForm()">Try me</button>
        
        <!-- script -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/test.js"></script>
    </body>
</html>
