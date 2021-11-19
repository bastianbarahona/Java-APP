package entity;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIA_PROD"
    ,schema="CON_FERME"
)
public class CategoriaProd  implements java.io.Serializable {


     private int idCategoria;
     private String categoriaProdu;
     private String descripCategoria;
     private Set<Producto> productos = new HashSet<>(0);

    public CategoriaProd() {
    }

	
    public CategoriaProd(int idCategoria, String categoriaProd, String descripCategoria) {
        this.idCategoria = idCategoria;
        this.categoriaProdu = categoriaProd;
        this.descripCategoria = descripCategoria;
    }
    public CategoriaProd(int idCategoria, String categoriaProd, String descripCategoria, Set<Producto> productos) {
       this.idCategoria = idCategoria;
       this.categoriaProdu = categoriaProd;
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
        return this.categoriaProdu;
    }
    
    public void setCategoriaProd(String categoriaProd) {
        this.categoriaProdu = categoriaProd;
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


