function onClickAñadir(indice) {
 
    var tipoCliente = $("#tipoCliente").val();
   
    
    var nombreProd = $("#nom_"+indice).text(); // nombre de la card
    var precioProd = $("#precio"+indice).val();
    var id =  $("#productoId_"+indice).val();
    var cantidad = 1;
    var line=[];
    var contador=0;
    
    
    if (tipoCliente=="") {
        swal("Debes estar registrado", "para comprar debes iniciar tu sesión", "error");
        
    }
    if (tipoCliente=="true" ||tipoCliente =="false" ) {
       swal("Agregado", "Producto agregado a tu compra", "success");    
       
       $('#tablaDetalle tr').each(function () {
            line.push($(this).find('[name="lineNum"]').val());
        });
            
            for (var i = 0; i < line.length; i++) {
            
            var nombre = $("#nom"+line[i]).text();// nombre del producto del carro de compra
            
            if (nombre == nombreProd) {
                
                var precio =  $("#pre"+line[i]).text();
                var cant =  $("#cant"+line[i]).text();
               
               precio = parseInt(precio);
               cant = parseInt(cant);
               precioProd = parseInt(precioProd);
               
               
               cant = cantidad+cant;
               precio = precio + precioProd;
               
                $("#pre"+line[i]).text(precio);
                $("#cant"+line[i]).text(cant);
                contador++;
                
               $("#prodId_"+indice).val(id);
               $("#valor_"+indice).val(precio);  
               $("#prodNom"+indice).val(nombreProd);
               $("#pordStock"+indice).val(cant); // no es el stock es la cantidad de productos que se estan comprando
            }
            
        }
        if (contador == 0) {
                       $("#tablaDetalle").append($("<tr id='tr"+i+"'>"+
                                       "<input  id='numLin' name='lineNum'  type='hidden'  value='"+i+"'>"+
                                       "<td id='nom"+i+"'>"+nombreProd+"</td>"+
                                       "<td id='pre"+i+"'>"+precioProd+"</td>"+
                                       "<td id='cant"+i+"'>"+cantidad+"</td>"+   
                                       "<td> <a onclick='onClickEliminaDelCarro("+i+")'> <span class='glyphicon glyphicon-trash'></span></a> </td>"+
                                      
                               "</tr>"));    
               $("#prodId_"+indice).val(id);
               $("#valor_"+indice).val(precioProd);  
               $("#prodNom"+indice).val(nombreProd);
               $("#pordStock"+indice).val(cantidad); // no es el stock es la cantidad de productos que se estan comprando
          
       }
       
    }
       
                     
 
} 
       
    
    


/**
 * Comment
 */
function onClickEliminaDelCarro(i) {
    
    $("#tr"+i).remove();
    
    $("#prodId_"+i).val("0");
    $("#valor_"+i).val("0");
    $("#prodNom"+i).val("");
    $("#pordStock"+i).val("");
    
}