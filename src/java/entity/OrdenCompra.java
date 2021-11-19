package entity;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ORDEN_COMPRA"
    ,schema="CON_FERME"
)
public class OrdenCompra  implements java.io.Serializable {


     private int idOrdenCompra;
     private Empleado empleado;
     private Date fecha;
     private String estado;
     private int unidades;
     private int precioCompra;
     private int neto;
     private int total;

    public OrdenCompra() {
    }

    public OrdenCompra(int idOrdenCompra, Empleado empleado, Date fecha, String estado, int unidades, int precioCompra, int neto, int total) {
       this.idOrdenCompra = idOrdenCompra;
       this.empleado = empleado;
       this.fecha = fecha;
       this.estado = estado;
       this.unidades = unidades;
       this.precioCompra = precioCompra;
       this.neto = neto;
       this.total = total;
    }
   
     @Id 

    
    @Column(name="ID_ORDEN_COMPRA", unique=true, nullable=false, precision=8, scale=0)
    public int getIdOrdenCompra() {
        return this.idOrdenCompra;
    }
    
    public void setIdOrdenCompra(int idOrdenCompra) {
        this.idOrdenCompra = idOrdenCompra;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLEADO_ID_EMPLEADO", nullable=false)
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=7)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="ESTADO", nullable=false, length=50)
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }

    
    @Column(name="UNIDADES", nullable=false, precision=8, scale=0)
    public int getUnidades() {
        return this.unidades;
    }
    
    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    
    @Column(name="PRECIO_COMPRA", nullable=false, precision=8, scale=0)
    public int getPrecioCompra() {
        return this.precioCompra;
    }
    
    public void setPrecioCompra(int precioCompra) {
        this.precioCompra = precioCompra;
    }

    
    @Column(name="NETO", nullable=false, precision=8, scale=0)
    public int getNeto() {
        return this.neto;
    }
    
    public void setNeto(int neto) {
        this.neto = neto;
    }

    
    @Column(name="TOTAL", nullable=false, precision=8, scale=0)
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }




}


