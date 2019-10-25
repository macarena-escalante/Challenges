package ar.com.ada.api.challenge.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.ada.api.challenge.entities.Temperatura;

/**
 * TemperaturaRepository
 */
@Repository
public interface TemperaturaRepository extends JpaRepository<Temperatura, Integer>{

    Temperatura findById (int id);

    @Query ("FROM Temperatura WHERE grados = ?1")
    List <Temperatura> findByGrados (double grados);

    @Query ("FROM Temperatura WHERE anioTemperatura = ?1")
    List <Temperatura> findByAnio (int anio);

    
}