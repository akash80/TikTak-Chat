/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var theNewScript = document.createElement("script");
theNewScript.type = "text/javascript";
theNewScript.src = "https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js";
document.getElementsByTagName("head")[0].appendChild(theNewScript);
// jQuery MAY OR MAY NOT be loaded at this stage
var waitForLoad = function () {
    if (typeof jQuery != "undefined") {
        $.get("myfile.php");
    } else {
        window.setTimeout(waitForLoad, 1000);
    }
};
window.setTimeout(waitForLoad, 1000);

// Group Chat using Web Socket
var ws=null;
var wsUri = "ws://" + document.location.host+"/TikTok/wschat";
ws = new WebSocket(wsUri);
ws.onmessage = function(message){
    document.getElementById("chatlog").textContent += message.data + "\n";
};
function postToServer(name){
    ws.send(name+">>>"+document.getElementById("groupMsg").value);
    document.getElementById("groupMsg").value = "";
};
function closeConnect(){
    ws.close();
};


//Update Messages 
var myVar;
var s;
var r;
function myFunction() {
    myVar = setInterval(submitdata, 100, s, r);
}


// User name Aailability check
$(document).ready(function(){
    $("#username").keyup(function(){
        var username = $('#username').val();
        if(username.length>=8){
        $.post("userAvailability",
        {
          username: username
        },
        function(data){
            var response = $.trim(data.replace(/[\t\n]+/g,' '));
            if(response!=="Pass"){ 
                $("#id").text(response);
                $("#id").css('color', 'red');
                lock();
            }else {
                $("#id").text('');
                unlock();
            }
        });
    }else{
        $("#id").text("Minimum 8 Character");
        $("#id").css('color', 'red');
        lock();
    }
    });
    
});

//Password length
$(document).ready(function(){
    $("#password").keyup(function(){
        var password = $('#password').val();
        if(password.length>=8){
            $("#pass").text("");
            unlock();
        }else {
            $("#pass").text("Minimum 8 Character");
            $("#pass").css('color', 'red');
            lock();
        }
    });
    
});

// Manage sing up button
function lock(){
   $("input[type=submit]").attr("disabled", "disabled");
}
function unlock(){
    var password = $('#password').val();
    var username = $('#username').val();
        if(password.length>=8 && username.length>=8){
            $("input[type=submit]").removeAttr("disabled");
        }
}

// Profile Switching for messanging 
function chat(s,r){
    clearInterval(myVar);
    this.s=s;
    this.r=r;
    myFunction();
   return false;
}
function submitdata(s, r)
{
 $.ajax({
  type: 'post',
  url: 'profile',
  data: {
   sender:s,
   receiver:r
  },
  success: function (response) {
      $('#groupButton')[0].style.display = "block";
      $('#groupchat')[0].style.display = "none";
     var obj = JSON.parse(response);
   $('#profile_username')[0].innerHTML = r;
   $("#profile_icon").attr("src", "/TikTok/resources/images/ic.jpg");
   $('#textbox')[0].style.display = "block";
   $('#chatList').html('');
   for(i=0; i<obj.count*3;i=i+3){
       if(s===obj.data[i]){
           $("#chatList").append(" <li class='left clearfix'> <span class='chat-img pull-left'>"+
        "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span>"+
   "<div class='chat-body clearfix'>"+
        "<div class='header'>"+
            "<strong class='primary-font'>"+obj.data[i]+"</strong>"+
            "<small class='pull-right text-muted'>time here</small>"+
        "</div><span>"+obj.data[i+2]+"</span></div>");   
       }else{
           $("#chatList").append("<li class='right clearfix'>"+
                                    "<span class='chat-img pull-right'>"+
                                        "<img src='http://placehold.it/50/FA6F57/fff' alt='User Avatar' class='img-circle' />"+
                                    "</span><div class='chat-body clearfix'>"+
                                        "<div class='header'><small class=' text-muted'>"+
                                                "time here</small>"+
                                            "<strong class='pull-right primary-font'>"+obj.data[i]+"</strong>"+
                                        "</div>"+
                                        "<span>"+obj.data[i+2]+"</span></div></li>");  
       }
     
   }
  }
 });
	
}

// send message and update 
function sendMessage() {
    var dt = new Date();
    var time = dt.getHours() + ":" + dt.getMinutes() + ":" + dt.getSeconds();
    $('#msg').submit(function(event) {
        var formData = {
            'sender'     : $('#sender').val(),
            'receiver'   : $('#profile_username')[0].innerHTML,
            'message'    : $('#message').val()
        };
        $.ajax({
            type        : 'POST', 
            url         : 'sendMessage',
            data        : formData
        })
          .done(function(response) {
               $('#message').val('');
               $("#chatList").append("<li class='left clearfix'> <span class='chat-img pull-left'>"+
                                        "<img src='http://placehold.it/50/55C1E7/fff' alt='User Avatar' class='img-circle' /></span>"+
                                   "<div class='chat-body clearfix'>"+
                                        "<div class='header'>"+
                                            "<strong class='primary-font'>"+$('#sender').val()+"</strong>"+
                                            "<small class='pull-right text-muted'>"+
                                               " <i class='fa fa-clock-o fa-fw'>"+time+"</small>"+
                                        "</div><span>"+response+"</span></div></li>")
            });
        event.preventDefault();
    });

}
//Back to group chat
function groupChat(){
    $('#groupButton')[0].style.display = "none";
    $('#groupchat')[0].style.display = "block";
    $('#textbox')[0].style.display = "none"; 
    $('#profile_username')[0].innerHTML="Group Chat Using web Socket";
    $("#profile_icon").attr("src", "");
    clearInterval(myVar);
}