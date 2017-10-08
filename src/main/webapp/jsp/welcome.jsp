<%-- 
    Document   : welcome
    Created on : Oct 6, 2017, 10:46:07 PM
    Author     : akash
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <!-- If tried to access direct without login using url -->
    <%if(session.getAttribute("UserName")==null){response.sendRedirect("home.jsp");}%>
    <title>Welcome</title>
    
    <!--Style Sheets -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
    
   </head>

<body>
    <header><img src="${pageContext.request.contextPath}/resources/images/logo.png" width="100px;" class="logo"/><div style="float: right; margin-right: 35%;"><h4>****Please click on username for refresh chat****</h4></div></header>
      <div id="wrapper">
        <nav class="navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <a class="navbar-brand" href="#">${username} </a>
              
            </div>
            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        <li class="sidebar-search">
                            <div class="input-group custom-search-form">
                                <input type="text" class="form-control" placeholder="Search...">
                                <span class="input-group-btn">
                                    <button class="btn btn-default" type="button" >
                                        <img src="${pageContext.request.contextPath}/resources/images/search.png" />
                                </button>
                            </span>
                            </div>
                        </li>
                        <div class="scroll list">
                            
                     <!-- List of all users. change image url for retrieve image from database or disk -->
                       <c:forEach items="${list}" var="list">
                        <li>
                            <div class="image"><img src="http://placehold.it/50/FA6F57/fff" width="80%" alt="" class="img"></div>
                            <h5><a href="#" onclick="submitdata('${username}','${list.username}');">${list.username}</a></h5>
                            <h6>${list.name}</h6>
                        </li>
                      </c:forEach>
                        </div>
                          </ul>
                </div>
            </div>
        </nav>
            <div id="page-wrapper">
            <div class="row">
                
                <div class="chat-box">
                    <div class="chat-box-boarder"><img src="" id="profile_icon"><p id="profile_username"></p></div>
                    <!-- /.panel -->
                    <div class="chat-panel panel panel-default" id="textbox">
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <ul class="chat" id='chatList'>
                            </ul>
                        </div>
                        <!-- /.panel-body -->
                        <div class="panel-footer">
                            <div class="input-group">
                                <form id="msg">
                                    <input type="text" id="sender" value="${username}" hidden />   
                                    <input id="message" type="text" class="form-control input-sm" placeholder="Type your message here..." />
                                    <span class="input-group-btn">
                                        <button class="btn btn-warning btn-sm" id="btn-chat">
                                            Send
                                        </button>
                                    </span>
                                    </form>
                            </div>
                        </div>
                        <!-- /.panel-footer -->
                    </div>
                    <!-- /.panel .chat-panel -->
                </div>
                <div class="scroll detail-bar">
                   <img src="http://placehold.it/50/55C1E7/fff" width="40%" height="30%" alt="" style="margin-top: 10px;" class="img">
<!--                   <form action="uploadImage" enctype="multipart/form-data" method="post" >
                        <input type="file" name="file" accept="image/*"/> 
                        <input type="submit" value="Update" class="btn btn-default"/>
                    </form>-->
                   <hr>
                   <p>Welcome</p>
                   <p>Name: ${name}</p>
                   <p>Email: ${email}</p>
                   <p>Phone: ${phone}</p>    
                   <hr>
                   <form method="post" action="logoutSession"><input class="btn btn-default" type="submit" value="Logout" ></form>
                </div>
                
            </div>
     </div>
</div>
<footer></footer>
<!-- script -->
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
   <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
   <script src="${pageContext.request.contextPath}/resources/js/custom.js"></script>
</body>
</html>
