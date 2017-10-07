/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

// User name Aailability check
$(document).ready(function(){
    $("#username").keyup(function(){
        var username = $('#username').val();
        if(username.length>=8){
        $.post("userAvailability",
        {
          username: username
        },
        function(data,status){
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

// Profile details