/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Producto;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Universidad de Chile
 */
public class ProductoModelo {
            
    public List<Producto> ListaProducto() {
            
       
        
        List<Producto> lst = new ArrayList<Producto>();
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        
        try {
            s.beginTransaction();       
            lst = s.createCriteria(Producto.class).list();
            s.getTransaction().commit();
           

        } catch (Exception e) {

            e.printStackTrace();
        }
        
        return lst;
    }
}
