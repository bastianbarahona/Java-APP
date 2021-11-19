
//Funcion Jquery que se dispara al abrir una vista
$(document).ready(function () {

    ingresaFecha();
    CargaColoresStock();
    asignaTipoCliente();
});

// Funcion que colorea el "stock critico" segun su "stock actual"
function CargaColoresStock() {
    // el indice nos dice el largo de la lista de productos
    var indice = $("#indice").val();

    for (var i = 0; i < indice; i++) {
        
        // Trae elementos del con Jquery  
        var stock = $("#stock_" + i).text().trim();
        var critico = $("#critico_" + i).text().trim();

        // Parciamos los textos a enteros     
        stock = parseInt(stock);
        critico = parseInt(critico);

        // creamos condicion 
        if (stock > critico)
        {
            // asignamos el color con javascript
            document.getElementById("stock_" + i).style.color = "MediumSeaGreen";
            
        } else if (stock < critico) {
            // asignamos el color con javascript
            document.getElementById("stock_" + i).style.color = "red";

        } else if (stock == critico) {

            // asignamos el color con javascript
            document.getElementById("stock_" + i).style.color = "Orange";
        }

    }

}
/**
 * Funcion que ingresa "No Aplica" a la fecha
 * Sin Fecha de Vencimiento
 */
function ingresaFecha() {

    
    var indice = $("#indice").val();

     for (var i = 0; i < indice; i++) {
         
         var fecha = $("#fecha_"+i).text().trim();
           
        if (fecha=="") {
            
            $("#fecha_"+i).text("No Aplica");
        }   
     }  
}

function asignaTipoCliente() {
   
    var indice = $("#indiceC").val();

     for (var i = 0; i < indice; i++) {
         
         var tipo = $("#type_"+i).text().trim();
           
        if (tipo=="true") {
            
            $("#type_"+i).text("Empresa");
        }
        else{
             $("#type_"+i).text("Natural");
        }
     }  
}