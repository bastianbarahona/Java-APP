package controller;

import model.ProveedorModelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ProveedorController {   
    @RequestMapping(value="listaProv",method = RequestMethod.GET)
    public String listaProv(Model m)
    {   
        ProveedorModelo pro= new ProveedorModelo();
        
        m.addAttribute("lst",pro.ListaProveedores());       
        return "listaProveedores";
    }
}
