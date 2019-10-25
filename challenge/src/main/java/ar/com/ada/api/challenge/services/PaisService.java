package ar.com.ada.api.challenge.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.challenge.entities.Pais;
import ar.com.ada.api.challenge.entities.Temperatura;
import ar.com.ada.api.challenge.repo.PaisRepository;

/**
 * PaisService
 */
@Service
public class PaisService {

    @Autowired
    PaisRepository repo;

    @Autowired
    PaisService paisService;
    

    public Pais buscarPorCodPais(int id) {

        return repo.findById(id);
    }

    public void save(Pais p) {
        repo.save(p);
    }

    public List<Pais> getPaises() {

        return repo.findAll();
    }

    public Pais crearPais (int codPais, String nombre){
        Pais p = new Pais();
        p.setCodigoPais(codPais);
        p.setNombre(nombre);

        repo.save(p);
        return p;
    }

    public Pais actualizaPais (int id, String nombre){
        Pais p= paisService.buscarPorCodPais(id);
        p.setNombre(nombre);

        repo.save(p);
        return p;
    }

    
    
}
