package ar.com.ada.api.simulacro.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.models.request.RegistrationRequest;
import ar.com.ada.api.simulacro.models.response.RegistrationReponse;
import ar.com.ada.api.simulacro.services.CategoriaService;

/**
 * AuthController
 */
@RestController
public class AuthController {
    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/categorias")
    public RegistrationReponse postRegisterUser(@RequestBody RegistrationRequest req){

        RegistrationReponse r = new RegistrationReponse();
        Categoria c = new Categoria();
        c.setNombre(req.nombre);
        c.setSueldoBase(req.sueldoBase);

        categoriaService.save(c);

        r.isOk = true;
        r.message = "Creaste una categoria con éxito.";
        return r;


    }
}