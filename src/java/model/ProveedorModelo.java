/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Proveedor;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ProveedorModelo {   
        

        public List<Proveedor> ListaProveedores() {
            
        List<Proveedor> lst = new ArrayList<Proveedor>();
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();       
            lst = s.createCriteria(Proveedor.class).list();
            s.getTransaction().commit();

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        return lst;
    }
    
    public void crearProveedores(Proveedor c)
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
    

}
