package ar.com.ada.api.simulacro.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.entities.Empleado;
import ar.com.ada.api.simulacro.services.CategoriaService;

/**
 * CategoriaController
 */
@RestController
public class CategoriaController {
    @Autowired
    CategoriaService categoriaService;

    @GetMapping("/categorias")
    public List<Categoria> getCategorias()
    {
        List<Categoria> categorias = categoriaService.getCategorias();
        
        return categorias;
    }

    @GetMapping("/empleados/categorias/{catId}")
    public List<Empleado> getEmpleadoByCatId(@PathVariable int catId){
        Categoria c = categoriaService.buscarPorId(catId);
        
        return c.empleados;
        
    }
    
}