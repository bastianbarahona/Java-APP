package model;

import entity.DetalleVenta;
import org.hibernate.Session;

public class DetalleVentaModelo {

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
