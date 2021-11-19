package entity;


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="DETALLE_VENTA"
    ,schema="CON_FERME"
)
public class DetalleVenta  implements java.io.Serializable {

     private DetalleVentaId id;
     private Producto producto;
     private Venta venta;
     private int cantidad;
     private int valorDetalle;
     private Byte descuento;

    public DetalleVenta() {
    }
	
    public DetalleVenta(DetalleVentaId id, Producto producto, Venta venta, int cantidad, int valorDetalle) {
        this.id = id;
        this.producto = producto;
        this.venta = venta;
        this.cantidad = cantidad;
        this.valorDetalle = valorDetalle;
    }
    public DetalleVenta(DetalleVentaId id, Producto producto, Venta venta, int cantidad, int valorDetalle, Byte descuento) {
       this.id = id;
       this.producto = producto;
       this.venta = venta;
       this.cantidad = cantidad;
       this.valorDetalle = valorDetalle;
       this.descuento = descuento;
    }
   
     @EmbeddedId
    @AttributeOverrides( {
        @AttributeOverride(name="ventaIdVenta", column=@Column(name="VENTA_ID_VENTA", nullable=false, precision=8, scale=0) ), 
        @AttributeOverride(name="productoIdProducto", column=@Column(name="PRODUCTO_ID_PRODUCTO", nullable=false, precision=8, scale=0) ) } )
    public DetalleVentaId getId() {
        return this.id;
    }
    
    public void setId(DetalleVentaId id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PRODUCTO_ID_PRODUCTO", nullable=false, insertable=false, updatable=false)
    public Producto getProducto() {
        return this.producto;
    }
    
    public void setProducto(Producto producto) {
        this.producto = producto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="VENTA_ID_VENTA", nullable=false, insertable=false, updatable=false)
    public Venta getVenta() {
        return this.venta;
    }
    
    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    
    @Column(name="CANTIDAD", nullable=false, precision=8, scale=0)
    public int getCantidad() {
        return this.cantidad;
    }
    
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    
    @Column(name="VALOR_DETALLE", nullable=false, precision=8, scale=0)
    public int getValorDetalle() {
        return this.valorDetalle;
    }
    
    public void setValorDetalle(int valorDetalle) {
        this.valorDetalle = valorDetalle;
    }

    
    @Column(name="DESCUENTO", precision=2, scale=0)
    public Byte getDescuento() {
        return this.descuento;
    }
    
    public void setDescuento(Byte descuento) {
        this.descuento = descuento;
    }




}


