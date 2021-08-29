const fill = (list) => {
    let table = "";

    if(list.length > 0){
        for(let i = 0; i < list.length; i++) {
            table += `
			<tr>
				<td>${ i + 1 }</td>
				<td>${list[i].nombre}</td>
				<td>${list[i].direccion}</td>
				<td>${list[i].fechaDeRegistro}</td>
				<td>${list[i].estado ? "Activo" : "Inactivo"}</td>
				<td>
					<button type="button" class="btn btn-primary" id="btn-modificar">Modificar</button>
					<button type="button" class="btn btn-danger" id="btn-eliminar">Eliminar</button>
				</td>
			</tr>
			`;
        }
    }else{
        table = `
		<tr class="text-center">
			<td colspan="5">No hay registros para mostrar</td>
		</tr>
		`;
    }
    $(`#container > tbody`).html(table);
};

const findAll = () => {
    const contextPath = window.location.origin + window.location.pathname.substring(0, window.location.pathname.indexOf("/",2));

    $.ajax({
        type: 'GET',
        url: contextPath + '/readAparatos',
        data: { }
    }).done(function(res){
        fill(res.listAparatos);
    });
};

const create = () =>{
    let nombreAparato = $("#nombre").val();
    let direccionAparato = $("#direccion option:selected").val;
    let fecha = $("#fechaDeRegistro").val();
    let estatus = 1;

    $.ajax({
        type: 'GET',
        url: contextPath + '/createAparatos',
        nombre: nombreAparato,
        direccion: direccionAparato,
        fechaDeRegistro: fecha,
        estado: estatus
    }).done(function(res){
        fill(res.listAparatos);
    });
};

findAll();
