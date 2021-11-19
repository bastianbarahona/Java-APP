package model;

import entity.Producto;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

public class ProductoModelo {
            
    public List<Producto> ListaProducto() {
               
        List<Producto> lst = new ArrayList<>();
        
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
