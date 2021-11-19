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
@Table(name="TIPO_EMPLEADO"
    ,schema="CON_FERME"
)
public class TipoEmpleado  implements java.io.Serializable {


     private int idTipoEmpleado;
     private String cargoEmp;
     private String descripcionEmp;
     private Set<Empleado> empleados = new HashSet<>(0);

    public TipoEmpleado() {
    }

	
    public TipoEmpleado(int idTipoEmpleado, String cargoEmp) {
        this.idTipoEmpleado = idTipoEmpleado;
        this.cargoEmp = cargoEmp;
    }
    public TipoEmpleado(int idTipoEmpleado, String cargoEmp, String descripcionEmp, Set<Empleado> empleados) {
       this.idTipoEmpleado = idTipoEmpleado;
       this.cargoEmp = cargoEmp;
       this.descripcionEmp = descripcionEmp;
       this.empleados = empleados;
    }
   
     @Id 

    
    @Column(name="ID_TIPO_EMPLEADO", unique=true, nullable=false, precision=8, scale=0)
    public int getIdTipoEmpleado() {
        return this.idTipoEmpleado;
    }
    
    public void setIdTipoEmpleado(int idTipoEmpleado) {
        this.idTipoEmpleado = idTipoEmpleado;
    }

    
    @Column(name="CARGO_EMP", nullable=false, length=50)
    public String getCargoEmp() {
        return this.cargoEmp;
    }
    
    public void setCargoEmp(String cargoEmp) {
        this.cargoEmp = cargoEmp;
    }

    
    @Column(name="DESCRIPCION_EMP", length=50)
    public String getDescripcionEmp() {
        return this.descripcionEmp;
    }
    
    public void setDescripcionEmp(String descripcionEmp) {
        this.descripcionEmp = descripcionEmp;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="tipoEmpleado")
    public Set<Empleado> getEmpleados() {
        return this.empleados;
    }
    
    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }




}


