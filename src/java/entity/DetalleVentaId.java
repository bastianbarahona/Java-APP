package entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class DetalleVentaId  implements java.io.Serializable {


     private int ventaIdVenta;
     private int productoIdProducto;

    public DetalleVentaId() {
    }

    public DetalleVentaId(int ventaIdVenta, int productoIdProducto) {
       this.ventaIdVenta = ventaIdVenta;
       this.productoIdProducto = productoIdProducto;
    }
   

    @Column(name="VENTA_ID_VENTA", nullable=false, precision=8, scale=0)
    public int getVentaIdVenta() {
        return this.ventaIdVenta;
    }
    
    public void setVentaIdVenta(int ventaIdVenta) {
        this.ventaIdVenta = ventaIdVenta;
    }


    @Column(name="PRODUCTO_ID_PRODUCTO", nullable=false, precision=8, scale=0)
    public int getProductoIdProducto() {
        return this.productoIdProducto;
    }
    
    public void setProductoIdProducto(int productoIdProducto) {
        this.productoIdProducto = productoIdProducto;
    }


     @Override
   public boolean equals(Object other) {
         if ( (this == other ) ) return true;
		 if ( (other == null ) ) return false;
		 if ( !(other instanceof DetalleVentaId) ) return false;
		 DetalleVentaId castOther = ( DetalleVentaId ) other; 
         
		 return (this.getVentaIdVenta()==castOther.getVentaIdVenta())
 && (this.getProductoIdProducto()==castOther.getProductoIdProducto());
   }
   
     @Override
   public int hashCode() {
         int result = 17;
         
         result = 37 * result + this.getVentaIdVenta();
         result = 37 * result + this.getProductoIdProducto();
         return result;
   }   


}


