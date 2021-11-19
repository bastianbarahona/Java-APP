package entity;
// Generated 09-06-2019 21:57:31 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CategoriaProd generated by hbm2java
 */
@Entity
@Table(name="CATEGORIA_PROD"
    ,schema="CON_FERME"
)
public class CategoriaProd  implements java.io.Serializable {


     private int idCategoria;
     private String categoriaProd;
     private String descripCategoria;
     private Set<Producto> productos = new HashSet<Producto>(0);

    public CategoriaProd() {
    }

	
    public CategoriaProd(int idCategoria, String categoriaProd, String descripCategoria) {
        this.idCategoria = idCategoria;
        this.categoriaProd = categoriaProd;
        this.descripCategoria = descripCategoria;
    }
    public CategoriaProd(int idCategoria, String categoriaProd, String descripCategoria, Set<Producto> productos) {
       this.idCategoria = idCategoria;
       this.categoriaProd = categoriaProd;
       this.descripCategoria = descripCategoria;
       this.productos = productos;
    }
   
     @Id 

    
    @Column(name="ID_CATEGORIA", unique=true, nullable=false, precision=8, scale=0)
    public int getIdCategoria() {
        return this.idCategoria;
    }
    
    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    
    @Column(name="CATEGORIA_PROD", nullable=false, length=25)
    public String getCategoriaProd() {
        return this.categoriaProd;
    }
    
    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProd = categoriaProd;
    }

    
    @Column(name="DESCRIP_CATEGORIA", nullable=false, length=50)
    public String getDescripCategoria() {
        return this.descripCategoria;
    }
    
    public void setDescripCategoria(String descripCategoria) {
        this.descripCategoria = descripCategoria;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="categoriaProd")
    public Set<Producto> getProductos() {
        return this.productos;
    }
    
    public void setProductos(Set<Producto> productos) {
        this.productos = productos;
    }




}


