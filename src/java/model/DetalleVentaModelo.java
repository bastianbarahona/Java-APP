/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.DetalleVenta;
import org.hibernate.Session;

/**
 *
 * @author Universidad de Chile
 */
public class DetalleVentaModelo {
    
    // Metodo que guarda el detalle
    public boolean creaDetalleVenta(DetalleVenta detalle)
    {          
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();
            s.save(detalle);           
            s.getTransaction().commit();
            return true;

        } catch (Exception e) {

            e.printStackTrace();
            s.getTransaction().rollback();
            return false;
        }      
    }   
}
