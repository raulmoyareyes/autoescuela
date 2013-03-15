
$(document).ready(function(){
    // evento para entrar
    $("#btnEnter").click(function(){
        
        // no sabemos si se pueden usar varios en el mismo ()
        
        $("#btnEnter").attr("disabled","disable");
        $("input").attr("readonly", "readonly");        
        
        if($("#user").val()==="user" && $("#pass").val()==="123456"){
            window.location="user/index.html";
        }else if($("#user").val()==="admin" && $("#pass").val()==="123456"){
            window.location="admin/index.html";
        }else{
            $("#error").fadeIn("slow");
            $("#btnEnter").button("enable");
            $("input").removeAttr("readonly");
        }
    });
    
    // evento para cerrar alert
    $("#closeAlert").click(function(){
        $("#error").fadeOut("slow");
    });
});