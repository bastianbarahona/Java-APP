package entity;
// Generated 09-06-2019 21:57:31 by Hibernate Tools 4.3.1


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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="EMPLEADO"
    ,schema="CON_FERME"
    , uniqueConstraints = @UniqueConstraint(columnNames="RUT_EMP") 
)
public class Empleado  implements java.io.Serializable {


     private int idEmpleado;
     private TipoEmpleado tipoEmpleado;
     private String rutEmp;
     private String nombreEmp;
     private String apellidoEmp;
     private long fonoEmp;
     private String usuario;
     private String contrasena;
     private String email;
     private Set<Venta> ventas = new HashSet<>(0);
     private Set<OrdenCompra> ordenCompras = new HashSet<>(0);

    public Empleado() {
    }

	
    public Empleado(int idEmpleado, TipoEmpleado tipoEmpleado, String rutEmp, String nombreEmp, String apellidoEmp, long fonoEmp, String usuario, String contrasena, String email) {
        this.idEmpleado = idEmpleado;
        this.tipoEmpleado = tipoEmpleado;
        this.rutEmp = rutEmp;
        this.nombreEmp = nombreEmp;
        this.apellidoEmp = apellidoEmp;
        this.fonoEmp = fonoEmp;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.email = email;
    }
    public Empleado(int idEmpleado, TipoEmpleado tipoEmpleado, String rutEmp, String nombreEmp, String apellidoEmp, long fonoEmp, String usuario, String contrasena, String email, Set<Venta> ventas, Set<OrdenCompra> ordenCompras) {
       this.idEmpleado = idEmpleado;
       this.tipoEmpleado = tipoEmpleado;
       this.rutEmp = rutEmp;
       this.nombreEmp = nombreEmp;
       this.apellidoEmp = apellidoEmp;
       this.fonoEmp = fonoEmp;
       this.usuario = usuario;
       this.contrasena = contrasena;
       this.email = email;
       this.ventas = ventas;
       this.ordenCompras = ordenCompras;
    }
   
     @Id 

    
    @Column(name="ID_EMPLEADO", unique=true, nullable=false, precision=8, scale=0)
    public int getIdEmpleado() {
        return this.idEmpleado;
    }
    
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TIPO_EMPLEADO_ID_TIPO_EMPLEADO", nullable=false)
    public TipoEmpleado getTipoEmpleado() {
        return this.tipoEmpleado;
    }
    
    public void setTipoEmpleado(TipoEmpleado tipoEmpleado) {
        this.tipoEmpleado = tipoEmpleado;
    }

    
    @Column(name="RUT_EMP", unique=true, nullable=false, length=12)
    public String getRutEmp() {
        return this.rutEmp;
    }
    
    public void setRutEmp(String rutEmp) {
        this.rutEmp = rutEmp;
    }

    
    @Column(name="NOMBRE_EMP", nullable=false, length=50)
    public String getNombreEmp() {
        return this.nombreEmp;
    }
    
    public void setNombreEmp(String nombreEmp) {
        this.nombreEmp = nombreEmp;
    }

    
    @Column(name="APELLIDO_EMP", nullable=false, length=50)
    public String getApellidoEmp() {
        return this.apellidoEmp;
    }
    
    public void setApellidoEmp(String apellidoEmp) {
        this.apellidoEmp = apellidoEmp;
    }

    
    @Column(name="FONO_EMP", nullable=false, precision=12, scale=0)
    public long getFonoEmp() {
        return this.fonoEmp;
    }
    
    public void setFonoEmp(long fonoEmp) {
        this.fonoEmp = fonoEmp;
    }

    
    @Column(name="USUARIO", nullable=false, length=20)
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    @Column(name="CONTRASENA", nullable=false, length=20)
    public String getContrasena() {
        return this.contrasena;
    }
    
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    
    @Column(name="EMAIL", nullable=false, length=50)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<Venta> getVentas() {
        return this.ventas;
    }
    
    public void setVentas(Set<Venta> ventas) {
        this.ventas = ventas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="empleado")
    public Set<OrdenCompra> getOrdenCompras() {
        return this.ordenCompras;
    }
    
    public void setOrdenCompras(Set<OrdenCompra> ordenCompras) {
        this.ordenCompras = ordenCompras;
    }




}


