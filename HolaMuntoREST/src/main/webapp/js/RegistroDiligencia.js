

function crearDiligencia() {

    
    var diligencia = $('#diligencia').val();
    var descripcion = $('#descripcion').val();
    var fechaLimite = $('#fechaLimite').val();
    var idProceso = "1";


    var sendInfo = {
        diligencia: diligencia,
        descripcion: descripcion,
        fechaLimite: fechaLimite,
        idProceso: idProceso
    };

    console.log(sendInfo);
    
    $.ajax({
        url: "http://localhost:8083/holaMundo/rest/datos/",
        data: JSON.stringify(sendInfo),
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (result) {
            console.log(result);
            alert("Por favor realice la verificacion de su correo electronico");
            window.location = "beneficiario.html";

        }
    });


}
