/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.hibernate.Session;

/**
 *
 * @author Universidad de Chile
 */
//Controller
public class ClienteModelo 
{   
 
    // Metodo para listar todos los clientes
    public List<Cliente> getAll() {
        List<Cliente> lst = new ArrayList<Cliente>();     
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            lst = s.createCriteria(Cliente.class).list();
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        return lst;
    }
    
    //Metodo Que crea Un Cliente
    public void crearCliente(Cliente c)
    {  
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
       
        try {
            
            s.beginTransaction();
            s.save(c);
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
            s.getTransaction().rollback();
        }
    }
    
    //valida si son correcto el usuario y contraseña
    public boolean validaLogin(String user, String pass)
    {
        List<Cliente> lst;
        lst = new ArrayList<Cliente>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
         
        try {     
            s.beginTransaction();
            lst = s.createCriteria(Cliente.class).list();
            s.getTransaction().commit();
            for (int i = 0; i < lst.size(); i++) {
                if (user.equals(lst.get(i).getUserCli()) && pass.equals(lst.get(i).getPassCli())) {
                  // True singnifica que todo salio bien 
                  return true;  
                  
                }
            }
            // false significa que ocurrio un error
            return false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // false significa que ocurrio un error
        return false;
    }
    
    // Metodo para obtener el id mayor
    public int generaIdCliente(){    
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        List<Cliente> lst;
        lst = new ArrayList<Cliente>();
        
        //Variable local
        // Esta variable nos guardara el id del cliente mas alto
        int numeroMax=0;
        
          // obtenemos todos los clientes
         s.beginTransaction();    
         lst = s.createCriteria(Cliente.class).list();
         
        // recorremos la lista
        for (int i = 0; i < lst.size(); i++) {
            
            if (numeroMax < lst.get(i).getIdCliente()) {
                
                numeroMax = lst.get(i).getIdCliente();
            }
            
        }
        //le sumamos uno al id mayor 
        numeroMax += 1; 
        
        return numeroMax;
    }
    
    public Cliente buscaUnCliente(String user) {

        List<Cliente> lst = new ArrayList<Cliente>();     
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();

        try {
            s.beginTransaction();
            lst = s.createCriteria(Cliente.class).list();
            s.getTransaction().commit();

            for (int i = 0; i < lst.size(); i++) {
                if (user.equals(lst.get(i).getUserCli())) {
                    return lst.get(i);
                }
            }
       

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        Cliente cli = new Cliente();
        return cli;
    }

}
  
