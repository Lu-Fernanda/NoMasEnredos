

function registroUsuario() {

    var nombre = $('#nombre').val();
    var apellido = $('#apellido').val();
    var tipoDocumento = $('#tipoDocumento').val();
    var cc = $('#cc').val();
    var celular = $('#celular').val();
    var telefono = $('#telefono').val();
    var correo = $('#correo').val();
    var estrato = $('#estrato').val();
    var direccion = $('#direccion').val();
    var barrio = $('#barrio').val();
    var tipoCasa = $('#tipoCasa').val();
    var localidad = $('#localidad').val();
    var reciboPublico = "lalala";
    var nHijos = $('#nHijos').val();
    var salud = $('#salud').val();
    var trabajo = "true";
   
    var contactoAdicional = $('#contactoAdicional').val();
    var numTel = $('#numTel').val();
    var notificacion = "true";
    var estado = "1";


if(trabajo==true){
     var nPersonas = $('#nPersonas').val();
    var tipoTrabajo = $('#tipoTrabajo').val();
    var ingresos = $('#ingresos').val();
}
    var sendInfo = {
        cc:cc,
        nombre:nombre,
        apellido: apellido,
        tipoDocumento: tipoDocumento,
        celular: celular,
        telefono: telefono,
        correo: correo,
        estrato: estrato,
        direccion: direccion,
        barrio: barrio,
        tipoCasa: tipoCasa,
        localidad: localidad,
        reciboPublico: reciboPublico,
        nHijos: nHijos,
        salud: salud,
        trabajo:trabajo,
        nPersonas: nPersonas,
        tipoTrabajo: tipoTrabajo,
        ingresos: ingresos,
        contactoAdicional: contactoAdicional,
        numTel: numTel,
        notificacion: notificacion,
        estado: estado
    };   
    
    console.log(sendInfo);

    $.ajax({
        url: "http://localhost:8083/holaMundo/rest/inscripcion",
        data: JSON.stringify(sendInfo),
        type: "POST",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        
        success: function (result) {
            console.log(result);
            alert("REGISTRO EXITOSO!");
            window.location = "index.html";

        }
    });


}

function buscarUsuario(){
    
    var idUsuario = $('#idUsuario').val();
    var tipoUsu="beneficiario";
    
    if (tipoUsu == "beneficiario") {
        var tipo = "inscripcion";
    } else {
        var tipo = "abogado";
    }

    $.ajax({
        url: "http://localhost:8083/holaMundo/rest/"+tipo+"/"+idUsuario,
        data: {},
        type: "GET",
        dataType: "json",
        contentType: "application/json; charset=utf-8",
        async: false,
        success: function (result) {
            console.log(result);

        }
    });

}


