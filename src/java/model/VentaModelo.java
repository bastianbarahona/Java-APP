/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entity.Cliente;
import entity.DetalleVenta;
import entity.Venta;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Universidad de Chile
 */
public class VentaModelo {
    
    public boolean generaVenta(Venta v)
    {          
        List<Venta> lst;
        lst = new ArrayList<Venta>();
        int idNum=0;
        
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try {
            s.beginTransaction();

            s.save(v);    
            
            //s.save(v.getDetalleVentas());
            s.getTransaction().commit();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            s.getTransaction().rollback();
            return false;
        }      
    }
    
    public int generaIdVenta(){
       
       List<Venta> lst;
        lst = new ArrayList<Venta>();
        int idNum=0;
        try {
             Session s = HibernateUtil.getSessionFactory().getCurrentSession();
               s.beginTransaction();                     
               lst = s.createCriteria(Venta.class).list();
            for (int i = 0; i < lst.size(); i++) {
                
                if (lst.get(i).getIdVenta() > idNum)
                {
                    idNum = lst.get(i).getIdVenta();
                }        
            }        
            s.getTransaction().commit();
           idNum = idNum+1;          
           return idNum ;
        } catch (Exception e) 
        {
            e.printStackTrace();        
            return 0;
        }
    }
    
    public int sumaTotales( List<DetalleVenta> detalleVentas){
        int suma=0;
        
        
        for (int i = 0; i < detalleVentas.size(); i++) {
            
            suma = suma + detalleVentas.get(i).getValorDetalle();
        }
        
        return suma;
    }
    
    public int generaNeto(int total){
        int neto;
        
        neto = (int) Math.round(total*0.19); 

        neto = total - neto;
        
        return neto;
    }
        
    public int generaIva(int total){
        int iva;
        
        iva = (int) Math.round(total*0.19); 

        
        return iva;
    }
}
