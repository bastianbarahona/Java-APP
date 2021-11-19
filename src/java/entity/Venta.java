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

@Entity
@Table(name="VENTA"
    ,schema="CON_FERME"
)
public class Venta implements java.io.Serializable {


     private int idVenta;
     private Cliente cliente;
     private Empleado empleado;
     private String nomEmpresa;
     private String rutEmpresa;
     private String rubroEmpresa;
     private String dirEmpresa;
     private long fonoEmpresa;
     private String localidadEmpresa;
     private Date fecha;
     private boolean tipoVenta;
     private Integer neto;
     private Byte iva;
     private int total;
     private Set<DetalleVenta> detalleVentas = new HashSet<>(0);

    public Venta() {
 
        empleado = new Empleado();      
        empleado.setIdEmpleado(1);
        
        nomEmpresa = "Ferreteria Ferme";
        rutEmpresa = "9000000-9";
        rubroEmpresa = "Ferreteria";
        dirEmpresa = "Esquina Blanca #500";
        fonoEmpresa = 56555555;
        localidadEmpresa = "Maipú";
        fecha = new Date();
        tipoVenta = true;
        iva = 19;
    }

	
    public Venta(int idVenta, Cliente cliente, Empleado empleado, String nomEmpresa, String rutEmpresa, String rubroEmpresa, String dirEmpresa, long fonoEmpresa, String localidadEmpresa, Date fecha, boolean tipoVenta, int total) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.empleado = empleado;
        this.nomEmpresa = nomEmpresa;
        this.rutEmpresa = rutEmpresa;
        this.rubroEmpresa = rubroEmpresa;
        this.dirEmpresa = dirEmpresa;
        this.fonoEmpresa = fonoEmpresa;
        this.localidadEmpresa = localidadEmpresa;
        this.fecha = fecha;
        this.tipoVenta = tipoVenta;
        this.total = total;
    }
    public Venta(int idVenta, Cliente cliente, Empleado empleado, String nomEmpresa, String rutEmpresa, String rubroEmpresa, String dirEmpresa, long fonoEmpresa, String localidadEmpresa, Date fecha, boolean tipoVenta, Integer neto, Byte iva, int total, Set<DetalleVenta> detalleVentas) {
       this.idVenta = idVenta;
       this.cliente = cliente;
       this.empleado = empleado;
       this.nomEmpresa = nomEmpresa;
       this.rutEmpresa = rutEmpresa;
       this.rubroEmpresa = rubroEmpresa;
       this.dirEmpresa = dirEmpresa;
       this.fonoEmpresa = fonoEmpresa;
       this.localidadEmpresa = localidadEmpresa;
       this.fecha = fecha;
       this.tipoVenta = tipoVenta;
       this.neto = neto;
       this.iva = iva;
       this.total = total;
       this.detalleVentas = detalleVentas;
    }
   
     @Id 

    
    @Column(name="ID_VENTA", unique=true, nullable=false, precision=8, scale=0)
    public int getIdVenta() {
        return this.idVenta;
    }
    
    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CLIENTE_ID_CLIENTE", nullable=false)
    public Cliente getCliente() {
        return this.cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="EMPLEADO_ID_EMPLEADO", nullable=false)
    public Empleado getEmpleado() {
        return this.empleado;
    }
    
    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    
    @Column(name="NOM_EMPRESA", nullable=false, length=50)
    public String getNomEmpresa() {
        return this.nomEmpresa;
    }
    
    public void setNomEmpresa(String nomEmpresa) {
        this.nomEmpresa = nomEmpresa;
    }

    
    @Column(name="RUT_EMPRESA", nullable=false, length=10)
    public String getRutEmpresa() {
        return this.rutEmpresa;
    }
    
    public void setRutEmpresa(String rutEmpresa) {
        this.rutEmpresa = rutEmpresa;
    }

    
    @Column(name="RUBRO_EMPRESA", nullable=false, length=50)
    public String getRubroEmpresa() {
        return this.rubroEmpresa;
    }
    
    public void setRubroEmpresa(String rubroEmpresa) {
        this.rubroEmpresa = rubroEmpresa;
    }

    
    @Column(name="DIR_EMPRESA", nullable=false, length=50)
    public String getDirEmpresa() {
        return this.dirEmpresa;
    }
    
    public void setDirEmpresa(String dirEmpresa) {
        this.dirEmpresa = dirEmpresa;
    }

    
    @Column(name="FONO_EMPRESA", nullable=false, precision=10, scale=0)
    public long getFonoEmpresa() {
        return this.fonoEmpresa;
    }
    
    public void setFonoEmpresa(long fonoEmpresa) {
        this.fonoEmpresa = fonoEmpresa;
    }

    
    @Column(name="LOCALIDAD_EMPRESA", nullable=false, length=50)
    public String getLocalidadEmpresa() {
        return this.localidadEmpresa;
    }
    
    public void setLocalidadEmpresa(String localidadEmpresa) {
        this.localidadEmpresa = localidadEmpresa;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="FECHA", nullable=false, length=7)
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
    @Column(name="TIPO_VENTA", nullable=false, precision=1, scale=0)
    public boolean isTipoVenta() {
        return this.tipoVenta;
    }
    
    public void setTipoVenta(boolean tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    
    @Column(name="NETO", precision=8, scale=0)
    public Integer getNeto() {
        return this.neto;
    }
    
    public void setNeto(Integer neto) {
        this.neto = neto;
    }

    
    @Column(name="IVA", precision=2, scale=0)
    public Byte getIva() {
        return this.iva;
    }
    
    public void setIva(Byte iva) {
        this.iva = iva;
    }

    
    @Column(name="TOTAL", nullable=false, precision=8, scale=0)
    public int getTotal() {
        return this.total;
    }
    
    public void setTotal(int total) {
        this.total = total;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="venta")
    public Set<DetalleVenta> getDetalleVentas() {
        return this.detalleVentas;
    }
    
    public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
        this.detalleVentas = detalleVentas;
    }




}


