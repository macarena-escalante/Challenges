package ar.com.ada.api.challenge.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

/**
 * Pais
 */
@Entity
@Table(name = "pais")
public class Pais {
    @Id
    @Column(name = "codigo_pais")
    public int codigoPais;
    public String nombre;

    @OneToMany(mappedBy = "pais", cascade = CascadeType.ALL)  // con el nombre de la columna que esta en el contrario 
    @LazyCollection(LazyCollectionOption.FALSE)                                 // Pais pais;
    @JsonIgnore
    public List<Temperatura> temperaturas = new ArrayList<Temperatura>();

    public int getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(int codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

   
}