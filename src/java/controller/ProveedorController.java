/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.ProveedorModelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProveedorController {   
        //METODO OBTIENE TODOS LOS Proveedores
    @RequestMapping(value="listaProv",method = RequestMethod.GET)
    public String listaProv(Model m)
    {   
        ProveedorModelo pro= new ProveedorModelo();
        
        m.addAttribute("lst",pro.ListaProveedores());       
        return "listaProveedores";
    }
}
