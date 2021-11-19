/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProductoModelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ProductoController {
          
    
    // listamos a la vista del catalago
    @RequestMapping(value="listaProducCatalogo",method = RequestMethod.GET)
    public String listaProducCatalogo(Model m)
    {   
        ProductoModelo pro= new ProductoModelo();
        m.addAttribute("lst",pro.ListaProducto());       
        return "vistaCatalago";
    }
    
}
