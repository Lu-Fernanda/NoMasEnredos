

function registrarAbogado() {

    var entidad = $('#entidad').val();

    if (entidad == "1" || entidad == "3") {
        var nombreEntidad = $('#nombreEntidad').val();
        var tarjetaProfesional = $('#tarjetaProfesional').val();
        var areaEspecializacion = $('#areaEspecializacion').val();
        var nombre = $('#nombre').val();
        var cc = $('#cc').val();
        var correo = $('#correo').val();
    } else {        
        var tarjetaProfesional = "0";
        var areaEspecializacion = "NA";
        var nombreEntidad = $('#nombreEntidad').val();
        var nombre = $('#nombre').val();
        var cc = $('#cc').val();
        var correo = $('#correo').val();
    }

    var sendInfo = {
        entidad: entidad,
        nombreEntidad: nombreEntidad,
        tarjetaProfesional: tarjetaProfesional,
        areaEspecializacion: areaEspecializacion,
        nombre: nombre,
        cc: cc,
        correo: correo
    }
    $.ajax({
        url: "http://localhost:8083/holaMundo/rest/abogado",
        data: JSON.stringify(sendInfo),
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        success: function (result) {
            console.log(result);
            alert("Por favor realice la verificacion de su correo electronico");
        }
    });
}



