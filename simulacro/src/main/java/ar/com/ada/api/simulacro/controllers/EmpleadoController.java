package ar.com.ada.api.simulacro.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.entities.Empleado;
import ar.com.ada.api.simulacro.models.request.EmpleadoRequest;
import ar.com.ada.api.simulacro.models.response.EmpleadoResponse;
import ar.com.ada.api.simulacro.services.CategoriaService;
import ar.com.ada.api.simulacro.services.EmpleadoService;

/**
 * EmpleadoController
 */
@RestController
public class EmpleadoController {

    @Autowired
    EmpleadoService empleadoService;

    @Autowired
    CategoriaService categoriaService;

    @PostMapping("/empleados")
    public EmpleadoResponse postnewEmpleado(@RequestBody EmpleadoRequest req){

        EmpleadoResponse e = new EmpleadoResponse();

        Categoria cat= categoriaService.buscarPorId(req.categoriaId);
        

        empleadoService.crearEmpleado(req.nombre, cat, req.edad, req.sueldo, req.estado);

        e.isOk = true;
        e.message = "Creaste un empleado con éxito.";
        return e;

    }

    @GetMapping("/empleados")
    public List<Empleado> getEmpleados()
    {
        List<Empleado> empleados = empleadoService.getEmpleados();
        
        return empleados;
    }

    @GetMapping("/empleados/{id}")
    public Empleado getEmpleadoById(@PathVariable int id) {
        Empleado e = empleadoService.buscarPorId(id);

        return e;
    }

    @PutMapping("/empleados/{id}")             //hay path int porque lo necesito en el /empleados/{id}
    public EmpleadoResponse actualizaEmpleado(@PathVariable int id, @RequestBody EmpleadoRequest req){

        EmpleadoResponse e = new EmpleadoResponse();
        Categoria c = categoriaService.buscarPorId(req.categoriaId);
        
        empleadoService.actualizarEmpleado(id, req.nombre, req.edad, c);

        e.isOk = true;
        e.message = "Los datos han sido actualizados.";

        return e;
    }

    @PutMapping("/empleados/{id}/sueldos")
    public EmpleadoResponse actualizaSueldoEmpleado(@PathVariable int id, @RequestBody EmpleadoRequest req){
        EmpleadoResponse e = new EmpleadoResponse();
        empleadoService.actualizaSueldoEmpleado(id, req.sueldo);

        e.isOk = true;
        e.message = "El sueldo ha sido actualizado.";

        return e;
    }

    @DeleteMapping("empleados/{id}")
    public EmpleadoResponse daDeBajaEmpleado(@PathVariable int id){
        EmpleadoResponse e = new EmpleadoResponse();
        empleadoService.daDeBajaEmpleado(id, "baja", new Date());  // para que me de la fecha actual

        e.isOk = true;
        e.message = "El empleado ha sido dado de baja.";

        return e;
    }
}