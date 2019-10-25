package ar.com.ada.api.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.entities.Pais;
import ar.com.ada.api.challenge.entities.Temperatura;
import ar.com.ada.api.challenge.repo.TemperaturaRepository;

/**
 * TemperatraService
 */
@Service
public class TemperatraService {

    @Autowired
    TemperaturaRepository repo;

    @Autowired
    PaisService paisService;

    public List<Temperatura> getTemperaturas() {

        return repo.findAll();
    }

    public List<Temperatura> buscarPorAnio(int anio) {

        return repo.findByAnio(anio);
    }

    public List<Temperatura> buscarPorGrados(double grados) {
        return repo.findByGrados(grados);
    }

    public Temperatura buscarPorId(int id) {

        return repo.findById(id);
    }

    public void save(Temperatura t) {
        repo.save(t);
    }

    public Temperatura crearNuevosDatos(int id, int anio, double grados) {

        Temperatura t = new Temperatura();
        Pais p = new Pais();
        p.setCodigoPais(id);

        t.setPais(p);
        t.setAnioTemperatura(anio);
        t.setGrados(grados);

        Temperatura entity = repo.save(t);

        return entity;

    }

    public Temperatura darDeBajaAnioDeTemp(int id, int anio) {

        Temperatura t = buscarPorId(id);

        t.setAnioTemperatura(anio);

        repo.save(t);
        return t;
    }

     
}