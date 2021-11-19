package entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="PRODUCTO"
    ,schema="CON_FERME"
    , uniqueConstraints = @UniqueConstraint(columnNames="CODIGO_PRODUCTO") 
)
public class Producto  implements java.io.Serializable {


     private int idProducto;
     private CategoriaProd categoriaProd;
     private Proveedor proveedor;
     private String nombreProd;
     private String descProd;
     private int precioVenta;
     private int stock;
     private int stockCritico;
     private Date fechaVenc;
     private String estadoProd;
     private String codigoProducto;
     private Set<DetalleVenta> detalleVentas = new HashSet<>(0);

    public Producto() {
    }

	
    public Producto(int idProducto, CategoriaProd categoriaProd, Proveedor proveedor, String nombreProd, int precioVenta, int stock, int stockCritico, String estadoProd) {
        this.idProducto = idProducto;
        this.categoriaProd = categoriaProd;
        this.proveedor = proveedor;
        this.nombreProd = nombreProd;
        this.precioVenta = precioVenta;
        this.stock = stock;
        this.stockCritico = stockCritico;
        this.estadoProd = estadoProd;
    }
    public Producto(int idProducto, CategoriaProd categoriaProd, Proveedor proveedor, String nombreProd, String descProd, int precioVenta, int stock, int stockCritico, Date fechaVenc, String estadoProd, String codigoProducto, Set<DetalleVenta> detalleVentas) {
       this.idProducto = idProducto;
       this.categoriaProd = categoriaProd;
       this.proveedor = proveedor;
       this.nombreProd = nombreProd;
       this.descProd = descProd;
       this.precioVenta = precioVenta;
       this.stock = stock;
       this.stockCritico = stockCritico;
       this.fechaVenc = fechaVenc;
       this.estadoProd = estadoProd;
       this.codigoProducto = codigoProducto;
       this.detalleVentas = detalleVentas;
    }
   
     @Id 

    
    @Column(name="ID_PRODUCTO", unique=true, nullable=false, precision=8, scale=0)
    public int getIdProducto() {
        return this.idProducto;
    }
    
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CATEGORIA_PROD_ID_CATEGORIA", nullable=false)
    public CategoriaProd getCategoriaProd() {
        return this.categoriaProd;
    }
    
    public void setCategoriaProd(CategoriaProd categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PROVEEDOR_ID_PROVEEDOR", nullable=false)
    public Proveedor getProveedor() {
        return this.proveedor;
    }
    
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }

    
    @Column(name="NOMBRE_PROD", nullable=false, length=50)
    public String getNombreProd() {
        return this.nombreProd;
    }
    
    public void setNombreProd(String nombreProd) {
        this.nombreProd = nombreProd;
    }

    
    @Column(name="DESC_PROD", length=75)
    public String getDescProd() {
        return this.descProd;
    }
    
    public void setDescProd(String descProd) {
        this.descProd = descProd;
    }

    
    @Column(name="PRECIO_VENTA", nullable=false, precision=8, scale=0)
    public int getPrecioVenta() {
        return this.precioVenta;
    }
    
    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    
    @Column(name="STOCK", nullable=false, precision=8, scale=0)
    public int getStock() {
        return this.stock;
    }
    
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    @Column(name="STOCK_CRITICO", nullable=false, precision=8, scale=0)
    public int getStockCritico() {
        return this.stockCritico;
    }
    
    public void setStockCritico(int stockCritico) {
        this.stockCritico = stockCritico;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA_VENC", length=7)
    public Date getFechaVenc() {
        return this.fechaVenc;
    }
    
    public void setFechaVenc(Date fechaVenc) {
        this.fechaVenc = fechaVenc;
    }

    
    @Column(name="ESTADO_PROD", nullable=false, length=50)
    public String getEstadoProd() {
        return this.estadoProd;
    }
    
    public void setEstadoProd(String estadoProd) {
        this.estadoProd = estadoProd;
    }

    
    @Column(name="CODIGO_PRODUCTO", unique=true, length=250)
    public String getCodigoProducto() {
        return this.codigoProducto;
    }
    
    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="producto")
    public Set<DetalleVenta> getDetalleVentas() {
        return this.detalleVentas;
    }
    
    public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }


}


