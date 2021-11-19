package controller;

import entity.Cliente;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.ClienteModelo;
import model.ProductoModelo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

@Controller
public class ClienteController
{
   
    @RequestMapping("index")
    public ModelAndView redireccion()
    {      
        ModelAndView MV = new ModelAndView();
        MV.setView("index");        
        return MV;
    }     
    
    @RequestMapping(value="crearCli",method = RequestMethod.GET)
    public String crearCli(Model m)
    {
  
        Cliente cli = new Cliente();   
        m.addAttribute("c",cli);  
        return "vistaRegistroClientes";
    }
    
    @RequestMapping(value="login",method = RequestMethod.GET)
    public String login(Model m)
    {
  
        Cliente cli = new Cliente();   
        m.addAttribute("c",cli);        
        return "login";
    }

    @RequestMapping(value = "ValidaLogin", method = RequestMethod.POST)
    public String ValidaLogin(@RequestParam("username") String usr,
                              @RequestParam("pwd") String pwd,
                               Model m){        
        
        Cliente cli = new Cliente();   
        ClienteModelo cliModel = new ClienteModelo();
        
        ProductoModelo pro= new ProductoModelo();
        
        
        cli.setUserCli(usr);
        cli.setPassCli(pwd);

        boolean valida;
        
        
        valida = cliModel.validaLogin(cli.getUserCli(),cli.getPassCli());
  
       if (valida) 
        {
    
            if (cli.getUserCli().equals("admin") && cli.getPassCli().equals("admin")) {
               
                m.addAttribute("lstProducto",pro.ListaProducto());      
                m.addAttribute("lstCliente",cliModel.getAll());
                
                return "vistaAdmin";
            }else
           
            {                
                cli = cliModel.buscaUnCliente(cli.getUserCli());                     
                
                m.addAttribute("tipo",cli);                    
                m.addAttribute("lst",pro.ListaProducto());              
                return "vistaCatalogo2";
            }                      
        }       
        return "login";
    }

    @RequestMapping(value="getAll",method = RequestMethod.GET)
    public String getAll(Model m)
    {   
        ClienteModelo cli= new ClienteModelo();
         m.addAttribute("lst",cli.getAll());
               
        return "clientes";
    }

    @RequestMapping(value="crearCliente",method = RequestMethod.POST)
    public String crearCliente(@RequestParam("rutCliente") String rut,
                              @RequestParam("nombreCliente") String nom,
                              @RequestParam("Apellido") String ape,
                              @RequestParam("fonoCliente") int fono,
                              @RequestParam("TipoCliente") String tipo,
                              @RequestParam("RazonSocial") String razon,
                              @RequestParam("Direccion") String direc,
                              @RequestParam("email") String email,
                              @RequestParam("user") String usr,
                              @RequestParam("pas") String pass)
    {
        Cliente cli = new Cliente(); 
        
        ClienteModelo cliModel = new ClienteModelo();

        try {

            cli.setIdCliente(cliModel.generaIdCliente());
            cli.setRutCli(rut);
            cli.setNomCli(nom);
            cli.setApellCli(ape);
            cli.setFonoCli(fono);

        if (tipo.equals("Empresa")) {
            cli.setTipoCli(true);
        }

        else if(tipo.equals("Persona")){
            cli.setTipoCli(false);
        }
            cli.setRazonSocial(razon);
            cli.setDirecCli(direc);
            cli.setEmailCli(email);
            cli.setUserCli(usr);
            cli.setPassCli(pass);

            cliModel.crearCliente(cli);
        
        return "redirect:index.htm";   
            
        } catch (Exception e) {
          
            return "redirect:crearCli.htm";
        }     
            
    }   
    
    @RequestMapping(value = "validaIngreso", method = RequestMethod.POST)
    public @ResponseBody
    boolean validaIngreso(HttpServletRequest request, HttpServletResponse response) throws Exception {
        
        Cliente cliente = new Cliente();
        
        String nombre = request.getParameter("userCli");
        String clave = request.getParameter("pwd");
        
        cliente.setUserCli(nombre);
        cliente.setPassCli(clave);
        boolean valida;
        
        ClienteModelo cliModel = new ClienteModelo();
        valida = cliModel.validaLogin(cliente.getUserCli(),cliente.getPassCli());
       
        if (valida) {
        
            return true;
        }

        return false;  
    }
}
