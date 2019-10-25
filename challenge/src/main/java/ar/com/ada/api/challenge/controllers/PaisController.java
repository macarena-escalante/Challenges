package ar.com.ada.api.challenge.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.entities.Pais;
import ar.com.ada.api.challenge.models.request.ActualizaPaisRequest;
import ar.com.ada.api.challenge.models.request.PaisRequest;
import ar.com.ada.api.challenge.models.response.PaisResponse;
import ar.com.ada.api.challenge.services.PaisService;
import ar.com.ada.api.challenge.services.TemperatraService;

/**
 * PaisController
 */
@RestController
public class PaisController {

    @Autowired
    PaisService paisService;

    @Autowired
    TemperatraService temperaturaService;

    @PostMapping("/paises")
    public PaisResponse postnewPais(@RequestBody PaisRequest req){

        PaisResponse p = new PaisResponse();
    

        paisService.crearPais(req.codigoPais, req.nombre);

        p.isOk = true;
        p.message = "Creaste un pais con éxito.";
        return p;

    }

    @GetMapping("paises")
    public List<Pais> getPaises()
    {
        List<Pais> paises = paisService.getPaises();
        
        return paises;
    }

    @GetMapping("/paises/{id}")
    public Pais getPaisById(@PathVariable int id) {
        Pais p = paisService.buscarPorCodPais(id);

        return p;
    }

    @PutMapping("/paises/{id}")
    public PaisResponse putActualizaPais (@PathVariable int id, @RequestBody ActualizaPaisRequest req){
    
    PaisResponse p = new PaisResponse();

    paisService.actualizaPais(id, req.nombre);

    p.isOk = true;
    p.message = "Actualizaste el pais con éxito.";
    return p;
    
   
}
}