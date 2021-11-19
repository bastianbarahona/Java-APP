package entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name="PROVEEDOR"
    ,schema="CON_FERME"
    , uniqueConstraints = @UniqueConstraint(columnNames="USUARIO_PROVEEDOR") 
)
public class Proveedor  implements java.io.Serializable {


     private int idProveedor;
     private String nombreProveedor;
     private String procedenciaProveedor;
     private int fonoProveedor;
     private String emailProveedor;
     private String usuarioProveedor;
     private String contrasenaProveedor;
     private Set<Producto> productos = new HashSet<>(0);

    public Proveedor() {
    }

	
    public Proveedor(int idProveedor, String nombreProveedor, String procedenciaProveedor, int fonoProveedor, String emailProveedor, String usuarioProveedor, String contrasenaProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.procedenciaProveedor = procedenciaProveedor;
        this.fonoProveedor = fonoProveedor;
        this.emailProveedor = emailProveedor;
        this.usuarioProveedor = usuarioProveedor;
        this.contrasenaProveedor = contrasenaProveedor;
    }
    public Proveedor(int idProveedor, String nombreProveedor, String procedenciaProveedor, int fonoProveedor, String emailProveedor, String usuarioProveedor, String contrasenaProveedor, Set<Producto> productos) {
       this.idProveedor = idProveedor;
       this.nombreProveedor = nombreProveedor;
       this.procedenciaProveedor = procedenciaProveedor;
       this.fonoProveedor = fonoProveedor;
       this.emailProveedor = emailProveedor;
       this.usuarioProveedor = usuarioProveedor;
       this.contrasenaProveedor = contrasenaProveedor;
       this.productos = productos;
    }
   
     @Id 

    
    @Column(name="ID_PROVEEDOR", unique=true, nullable=false, precision=8, scale=0)
    public int getIdProveedor() {
        return this.idProveedor;
    }
    
    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    
    @Column(name="NOMBRE_PROVEEDOR", nullable=false, length=50)
    public String getNombreProveedor() {
        return this.nombreProveedor;
    }
    
    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    
    @Column(name="PROCEDENCIA_PROVEEDOR", nullable=false, length=50)
    public String getProcedenciaProveedor() {
        return this.procedenciaProveedor;
    }
    
    public void setProcedenciaProveedor(String procedenciaProveedor) {
        this.procedenciaProveedor = procedenciaProveedor;
    }

    
    @Column(name="FONO_PROVEEDOR", nullable=false, precision=8, scale=0)
    public int getFonoProveedor() {
        return this.fonoProveedor;
    }
    
    public void setFonoProveedor(int fonoProveedor) {
        this.fonoProveedor = fonoProveedor;
    }

    
    @Column(name="EMAIL_PROVEEDOR", nullable=false, length=50)
    public String getEmailProveedor() {
        return this.emailProveedor;
    }
    
    public void setEmailProveedor(String emailProveedor) {
        this.emailProveedor = emailProveedor;
    }

    
    @Column(name="USUARIO_PROVEEDOR", unique=true, nullable=false, length=50)
    public String getUsuarioProveedor() {
        return this.usuarioProveedor;
    }
    
    public void setUsuarioProveedor(String usuarioProveedor) {
        this.usuarioProveedor = usuarioProveedor;
    }

    
    @Column(name="CONTRASENA_PROVEEDOR", nullable=false, length=50)
    public String getContrasenaProveedor() {
        return this.contrasenaProveedor;
    }
    
    public void setContrasenaProveedor(String contrasenaProveedor) {
        this.contrasenaProveedor = contrasenaProveedor;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="proveedor")
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }




}


