TikTok Chat

// Short Description 

Description: TikTok Chat is a java web application use to chat with the people's around the world. You can talk to strangers and of course your friends. I used ajax to update messages all you have to do just click your friend username so you can update messages. Auto update is under development.

// Application Design. 

I used 4 pages here the first page is home.jsp which contain the details about the application and brief description. You can see two options there Login and Register. If you are new choose register. It will redirect you to the register.jsp page where you can register yourself. Make sure your username and password length must be 8 or more.Once you registered you will be redirect to the  login.jsp page which contain username and password two text fields and one submit button. Once you entered username and password click on submit button. System will verify your username and password and responds to them. If your details are correct you will be redirect to the welcome.jsp page. For your safety we used AES encryption and HttpSession for login process. 

//Implementation of application

I used SpringMVC model With maven in implementation. Where web.xml receive the request and then send all request to front controllers. SpringMVC is very flexible. You can switch database and frameworks easily by SpringMVC model. It provides you scalability too. Less dependency.
Implementation Summery:
Framework: SpringMVC with maven 
Language: Java
IDE: Netbeans.
Front-End: HTML, CSS, Jquery, JavaScript, Ajax, JSTL.
Back-End: Servlet, JSP, MySql, XML,JSON 

//Tools i used 
Bootstrap.css and Bootstrap.js for styling my work. 

// Features of applicaiton

1. Easy to use.
2. No verification required.
3. Secure password by AES.
4. send personal messages.
5. click on username to refresh page.

//Code structure

Client send the request to the server. All the request send to the web.xml. Here i configured web.xml so then all the request web.xml will pass to the dispatcher servlet. Now dispatcher work is to find the suitable controller and send the request. We use @Controller annotation to tell front controller also know as dispatcher servlet that this this servlet is controller. So when controller get the request it start to work on it like any MVC model. Once the work is done controller send response to view or we can say to the jsp file because we used jsp as a view here. 
