package model;

import entity.Cliente;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ClienteModelo 
{   
    public List<Cliente> getAll() {
        List<Cliente> lst = new ArrayList<>();     
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
    
    public boolean validaLogin(String user, String pass)
    {
        List<Cliente> lst;
        lst = new ArrayList<>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
         
        try {     
            s.beginTransaction();
            lst = s.createCriteria(Cliente.class).list();
            s.getTransaction().commit();
            for (int i = 0; i < lst.size(); i++) {
                if (user.equals(lst.get(i).getUserCli()) && pass.equals(lst.get(i).getPassCli())) {
                  return true;  
                  
                }
            }
            return false;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int generaIdCliente(){    
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        List<Cliente> lst;
        lst = new ArrayList<>();

        int numeroMax=0;
 
         s.beginTransaction();    
         lst = s.createCriteria(Cliente.class).list();

        for (int i = 0; i < lst.size(); i++) {
            
            if (numeroMax < lst.get(i).getIdCliente()) {
                
                numeroMax = lst.get(i).getIdCliente();
            }
            
        }
        numeroMax += 1; 
        
        return numeroMax;
    }
    
    public Cliente buscaUnCliente(String user) {

        List<Cliente> lst = new ArrayList<>();     
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
  
