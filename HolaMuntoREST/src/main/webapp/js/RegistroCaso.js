

function crearCaso() {

    var tipoCaso = "NO CLASIFICADO";
    var abogadoAnterior = "false";
    var informacionCaso = $('#informacionCaso').val();
    var archivoAdicional = "NINGUNO";
    var estado = "false";
    var idUsuario = "1031";


    var sendInfo = {
        tipoCaso: tipoCaso,
        abogadoAnterior: abogadoAnterior,
        informacionCaso: informacionCaso,
        archivoAdicional: archivoAdicional,
        estado: estado,
        idUsuario:idUsuario 
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
