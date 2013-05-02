
$(document).ready(function(){
     
    // evento para cerrar alert
    $("#closeAlert").click(function(){
        $("#error").fadeOut("slow");
    });
    
    $(".elimina").click(function(){
        var fila = $(this).parent().parent()[0];
        console.log(fila);
        var nombre = fila.cells[0].innerText;
        console.log(nombre);
        var apellidos = fila.cells[1].innerText;
        var dni = fila.cells[2].innerText;
        $("#nombreUsuarioElimina").html(nombre+" "+apellidos);
        $("#confirmaElimina").attr("href", "/autoescuela/usuarios/elimina?id="+dni);
        $("#modalElimina").show();
    });
});