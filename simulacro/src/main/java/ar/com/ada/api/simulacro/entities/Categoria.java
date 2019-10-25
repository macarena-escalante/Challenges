package ar.com.ada.api.simulacro.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Categoria
 */
@Entity
@Table (name= "categoria")
public class Categoria {

    @Id
    @Column (name = "categoria_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int categoriaId;
    public String nombre;
    @Column (name= "sueldo_base")
    public double sueldoBase;
    
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JsonIgnore
    public List<Empleado> empleados = new ArrayList<Empleado>();

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }
    public void agregarEmpleado (Empleado empleado){
        empleado.setCategoria(this);
        this.empleados.add(empleado);
        
    }


}