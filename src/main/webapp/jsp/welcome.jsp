<%-- 
    Document   : welcome
    Created on : Oct 6, 2017, 10:46:07 PM
    Author     : akash
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <%if(session.getAttribute("UserName")==null){response.sendRedirect("home.jsp");}%>
    <title>Welcome</title>
    
    <!--Style Sheets -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/custom.css" rel="stylesheet">
    
   </head>

<body>
    <header><img src="${pageContext.request.contextPath}/resources/images/logo.png" width="100px;" class="logo"/></header>
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
                        <li>
                            <div class="image"><img src="https://scontent.fmaa1-1.fna.fbcdn.net/v/t1.0-1/p50x50/22196315_712833015579856_9221029692253817530_n.jpg?oh=d88fec9cd8e2e32a34afe5beac3d76be&amp;oe=5A7A68E8" width="100%" height="100%" alt="" class="img"></div><h5>Name</h5><h6>Description</h6>
                        </li>
                      
                        </div>
                          </ul>
                </div>
            </div>
        </nav>
            <div id="page-wrapper">
            <div class="row">
                <div class="scroll message-box">
                </div>
                <div class="scroll detail-bar">
                   <img src="https://scontent.fmaa1-1.fna.fbcdn.net/v/t1.0-1/p50x50/22196315_712833015579856_9221029692253817530_n.jpg?oh=d88fec9cd8e2e32a34afe5beac3d76be&amp;oe=5A7A68E8" width="35%" height="30%" alt="" style="margin-top: 10px;" class="img">
                   <hr>
                   <p>Name: </p>
                   <p>Email: </p>
                   <p>Phone: </p>
                   <p>Sign up Date: </p>     
                   <hr>
                   <form method="post" action="logoutSession"><input class="btn btn-default" type="submit" value="Logout" ></form>
                </div>
                <div class="scroll text-box" >
                    <textarea></textarea> 
                    <input type="submit" value="Send" class="send-button">
                </div>
            </div>
     </div>
</div>
<footer></footer>
</body>
</html>
