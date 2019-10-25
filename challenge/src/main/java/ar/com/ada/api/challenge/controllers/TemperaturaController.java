package ar.com.ada.api.challenge.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.challenge.entities.Pais;
import ar.com.ada.api.challenge.entities.Temperatura;
import ar.com.ada.api.challenge.models.request.RegisterTempRequest;
import ar.com.ada.api.challenge.models.response.BonusPaisTempResponse;
import ar.com.ada.api.challenge.models.response.BonusTempMaxResponse;
import ar.com.ada.api.challenge.models.response.PaisResponse;
import ar.com.ada.api.challenge.models.response.RegisterTempResponse;
import ar.com.ada.api.challenge.services.PaisService;
import ar.com.ada.api.challenge.services.TemperatraService;

/**
 * TemperaturaController
 */
@RestController
public class TemperaturaController {

    @Autowired
    TemperatraService temperaturaService;

    @Autowired
    PaisService paisService;

    @PostMapping("/temperaturas")
    public PaisResponse postNewTemperatura(@RequestBody RegisterTempRequest req) {
        RegisterTempResponse response = new RegisterTempResponse();
        PaisResponse p = new PaisResponse();

        for (Temperatura t : temperaturaService.getTemperaturas()) {
            if (t.getPais().getCodigoPais() == req.codigoPais && t.anioTemperatura == req.anio) {
                p.isOk = false;
                p.message = "Ya existe una temperatura para ese año";

                return p;
            }
        }

        // RegisterTempResponse extiende de PaisResponse asi puedo usar ambos (uno con
        // más atributos que el otro)
        Temperatura s = temperaturaService.crearNuevosDatos(req.codigoPais, req.anio, req.grados);

        response.isOk = true;
        response.message = "Creaste la temperatura con éxito.";
        response.id = s.temperaturaId;

        return response;

    }

    @GetMapping("/temperaturas/paises/{codigoPais}")
    public List<Temperatura> getTemperaturaByCodPais(@PathVariable int codigoPais) {
        Pais p = paisService.buscarPorCodPais(codigoPais);

        return p.temperaturas;

    }

    @DeleteMapping("/temperturas/{id}")
    public PaisResponse daDeBajaAnioDeTemp(@PathVariable int id) {
        PaisResponse p = new PaisResponse();
        temperaturaService.darDeBajaAnioDeTemp(id, 0);

        p.isOk = true;
        p.message = "La temperatura ha sido dada de baja.";

        return p;
    }

    @GetMapping("/temperaturas")
    public List<Temperatura> getTemperaturas() {
        List<Temperatura> temperaturas = temperaturaService.getTemperaturas();

        return temperaturas;
    }

    @GetMapping("/temperaturas/anios/{anio}")
    public List<BonusPaisTempResponse> buscarPorAnio(@PathVariable int anio) {
        List<Temperatura> temperaturas = temperaturaService.buscarPorAnio(anio);
        List<BonusPaisTempResponse> bonus = new ArrayList<BonusPaisTempResponse>();

        for (Temperatura t : temperaturas) {
            BonusPaisTempResponse b = new BonusPaisTempResponse();
            b.nombre = t.pais.getNombre();
            b.grados = t.grados;

            bonus.add(b);
        }

        return bonus;
    }

    @GetMapping("/temperaturas/maximas/{codigoPais}")
    public BonusTempMaxResponse getByCodigoPais(@PathVariable int codigoPais) {
        Pais p = paisService.buscarPorCodPais(codigoPais);
        BonusTempMaxResponse bonus = new BonusTempMaxResponse();

        Temperatura maxTemp = null;
        double maxGrado;
        maxGrado = 0;
        for (Temperatura t : p.temperaturas) {
            BonusTempMaxResponse b = new BonusTempMaxResponse();
            if (t.grados > maxGrado) {
                maxGrado = t.grados;
                maxTemp = t;

                b.nombre = p.nombre;
                b.temperaturaMaxima = maxGrado;
                b.anio = t.anioTemperatura;

                bonus= b;
            }

        }
        return bonus;

    }
}