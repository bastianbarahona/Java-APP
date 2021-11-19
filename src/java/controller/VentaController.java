/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;


import entity.Cliente;
import entity.DetalleVenta;
import entity.DetalleVentaId;
import entity.Producto;
import entity.Venta;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DetalleVentaModelo;
import model.VentaModelo;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Universidad de Chile
 */
@Controller
public class VentaController {
    
    // METODO QUE GENERA UNA VENTA
    @RequestMapping(value="agregaDetalle",method = RequestMethod.POST)
    public String agregaDetalle(@RequestParam("prodId0") int idPro0,
                                @RequestParam("valor0") int precio0,
                                @RequestParam("prodNom0") String nom0,
                                @RequestParam("pordStock0") int prodStock0, // producto stock es la candidad de unidades
                                
                                @RequestParam("prodId1") int idPro1,
                                @RequestParam("valor1") int precio1,
                                @RequestParam("prodNom1") String nom1,
                                @RequestParam("pordStock1") int prodStock1,
                                
                                @RequestParam("prodId2") int idPro2,
                                @RequestParam("valor2") int precio2,                               
                                @RequestParam("prodNom2") String nom2,
                                @RequestParam("pordStock2") int prodStock2,
                                
                                @RequestParam("tipoCli") boolean tipoCli,
                                @RequestParam("idCliente") int idCliente,
                                Model m)                         
    {
        // variable local 
        boolean respuesta=false;
        
        // creamos la lista de los detalles
         List<DetalleVenta> detalles = new ArrayList<DetalleVenta>();
         List<Producto> productos = new ArrayList<Producto>();
         
         Cliente cli = new Cliente();
         cli.setIdCliente(idCliente);
         
         //Instanciamos el modelo que tiene nuestros metodos
        VentaModelo ventaModel = new VentaModelo();
        DetalleVentaModelo detalleModel = new DetalleVentaModelo();    
        
                
        Venta ventaMstr = new Venta();
               
        
        ventaMstr.setCliente(cli);
        
        ventaMstr.setIdVenta(ventaModel.generaIdVenta());
 
             
        if (idPro0 !=0) {
    
             
            // Generamos el id de la venta
            DetalleVentaId idVenta = new DetalleVentaId();             
            idVenta.setProductoIdProducto(idPro0);
            
            idVenta.setVentaIdVenta(ventaMstr.getIdVenta());          
            // creamos un producto y le setamos el id que llega por parametro
            Producto pro0 = new Producto();   
            pro0.setIdProducto(idPro0); 
            
            pro0.setNombreProd(nom0);
      
            
            DetalleVenta detalle0 = new DetalleVenta();  
            detalle0.setDescuento(null);
            detalle0.setProducto(pro0); 
            detalle0.setValorDetalle(precio0);
            detalle0.setId(idVenta);
            detalle0.setCantidad(prodStock0); 
            
            productos.add(pro0);
            detalles.add(detalle0);
            
            
            ventaMstr.getDetalleVentas().add(detalle0);
        }          
  
        if (idPro1 !=0) {
            
            // Generamos el id de la venta
            DetalleVentaId idVenta = new DetalleVentaId();             
            idVenta.setProductoIdProducto(idPro1);
            
            idVenta.setVentaIdVenta(ventaMstr.getIdVenta());          
            // creamos un producto y le setamos el id que llega por parametro
            Producto pro1 = new Producto();   
            pro1.setIdProducto(idPro1); 
            
            pro1.setNombreProd(nom1);
           
            
            
            DetalleVenta detalle1 = new DetalleVenta();  
            detalle1.setDescuento(null);
            detalle1.setProducto(pro1); 
            detalle1.setValorDetalle(precio1);
            detalle1.setId(idVenta);
            detalle1.setCantidad(prodStock1);            
            detalles.add(detalle1);
            
            productos.add(pro1);
            ventaMstr.getDetalleVentas().add(detalle1);           
        }
        
        if (idPro2 !=0) {
            
            // Generamos el id de la venta
            DetalleVentaId idVenta = new DetalleVentaId();             
            idVenta.setProductoIdProducto(idPro2);
            
            idVenta.setVentaIdVenta(ventaMstr.getIdVenta());          
            // creamos un producto y le setamos el id que llega por parametro
            Producto pro2 = new Producto();   
            pro2.setIdProducto(idPro2); 
            pro2.setNombreProd(nom2);
     
            
            DetalleVenta detalle2 = new DetalleVenta();  
            detalle2.setDescuento(null);
            detalle2.setProducto(pro2); 
            detalle2.setValorDetalle(precio2);
            detalle2.setId(idVenta);
            detalle2.setCantidad(prodStock2);    
            
            detalles.add(detalle2);
            productos.add(pro2);
            
            ventaMstr.getDetalleVentas().add(detalle2);           
        }
         
        ventaMstr.setTotal(ventaModel.sumaTotales(detalles));
        
        ventaMstr.setNeto(ventaModel.generaNeto(ventaMstr.getTotal()));
        
        int iva = ventaModel.generaIva(ventaMstr.getTotal());
        
        // Generamo una venta
        respuesta = ventaModel.generaVenta(ventaMstr);  
        
        // guardamos los detalles
        if (respuesta) 
        {        
            for (int i = 0; i < detalles.size(); i++) {
                
                respuesta =  detalleModel.creaDetalleVenta(detalles.get(i));
            }
           
        }
            
        if (tipoCli) {
            
                   m.addAttribute("venta",ventaMstr);    
                   m.addAttribute("iva",iva);
                   return "vistaFactura";
        }
        else{
            m.addAttribute("venta",ventaMstr);   
            m.addAttribute("productos",productos);
            return "vistaBoleta";
        }


    }   
    
    
    
    //funcion ajax error: the server responded with a status of 406 (Not Acceptable)
    @RequestMapping(value="ajax",method = RequestMethod.POST)
    public @ResponseBody JSONObject listaProv(HttpServletRequest request, HttpServletResponse response)
    {      
        JSONObject ob = new JSONObject();
        ob.put("respuesta", "true");
         
        return ob;
    }
    
}
