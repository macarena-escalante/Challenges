package ar.com.ada.api.challenge.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Temperatura
 */
@Entity
@Table (name= "temperatura")
public class Temperatura {
    @Id
    @Column (name= "temperatura_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int temperaturaId;

    @Column (name= "anio_temperatura")
    public int anioTemperatura;
    public double grados;

    @ManyToOne
    @JoinColumn(name = "codigo_pais", referencedColumnName = "codigo_pais")  //pasar siempre las pk de la contraria
    // @MapsId
    public Pais pais;

    public int getTemperaturaId() {
        return temperaturaId;
    }

    public void setTemperaturaId(int temperaturaId) {
        this.temperaturaId = temperaturaId;
    }

    public int getAnioTemperatura() {
        return anioTemperatura;
    }

    public void setAnioTemperatura(int anioTemperatura) {
        this.anioTemperatura = anioTemperatura;
    }

    public double getGrados() {
        return grados;
    }

    public void setGrados(double grados) {
        this.grados = grados;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    
}