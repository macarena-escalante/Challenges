package ar.com.ada.api.simulacro.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.simulacro.entities.Categoria;
import ar.com.ada.api.simulacro.entities.Empleado;
import ar.com.ada.api.simulacro.repo.EmpleadoRepository;

/**
 * EmpleadoService
 */
@Service
public class EmpleadoService {

    @Autowired
    EmpleadoRepository repo;

    @Autowired
    CategoriaService categoriaService;

    @Autowired
    EmpleadoService empleadoService;

    public Empleado buscarPorId(int id) {

        return repo.findById(id);
    }

    public void save(Empleado e) {
        repo.save(e);
    }

    public Empleado crearEmpleado(String nombre, Categoria cat, int edad, double sueldo, String estado) {
        Empleado empleado = new Empleado();

        empleado.setNombre(nombre);
        cat.agregarEmpleado(empleado);
        empleado.setEdad(edad);
        empleado.setSueldo(sueldo);
        empleado.setEstado(estado);
        empleado.setFechaAlta(new Date());

        repo.save(empleado);
        return empleado;
    }

    public List<Empleado> getEmpleados() {

        return repo.findAll();
    }

    public Empleado actualizarEmpleado(int id, String nombre, int edad, Categoria c) {

        Empleado empleado = empleadoService.buscarPorId(id);

        c.agregarEmpleado(empleado); // vinculo el id de categoria con la categoria del empleado
        empleado.setNombre(nombre);
        empleado.setEdad(edad);
        empleado.setCategoria(c);

        repo.save(empleado);
        return empleado;

    }

    public Empleado actualizaSueldoEmpleado(int id, double sueldo) {

        Empleado empleado = empleadoService.buscarPorId(id);

        empleado.setSueldo(sueldo);

        repo.save(empleado);
        return empleado;
    }

    public Empleado daDeBajaEmpleado(int id, String estado, Date fechaBaja) {

        Empleado empleado = empleadoService.buscarPorId(id);
        empleado.setEstado(estado);
        empleado.setFechaBaja(fechaBaja);

        repo.save(empleado);
        return empleado;
    }
}