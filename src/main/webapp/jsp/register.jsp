<%-- 
    Document   : register
    Created on : Oct 6, 2017, 11:45:10 AM
    Author     : akash
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <%@page import="com.tiktok.controller.RegistrationController"%>
        <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
            <title>Registration</title>
            <!-- Bootstrap Core CSS -->
            <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
             <style>
                body{background-color:#f8f8f8;}
                .login-panel{margin-top:25%;}
                .form-control{margin-bottom:5px;}
             </style>
             
             
        </head>
        <body>
        <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Register Here</h3>
                    </div>
                    <div class="panel-body">
                       <form modelAttribute="user" method="POST" action="registerProcess" name="regF">
                            <fieldset>
                                <span id="id"></span>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Username" name="username" id="username" type="text" required>
                                </div>
                                <span id="pass"></span>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" id="password" type="password" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="name" name="name" type="text" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="email" name="email" type="email" required>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="phone" name="phone" type="number" required>
                                </div>
                                <input type="submit" value="Sign up" id="submit_form" class="btn btn-lg btn-success btn-block" />
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
   <!-- script -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
        </body>
        </html>
