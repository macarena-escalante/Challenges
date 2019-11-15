package ar.com.ada.api.simulacro;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import ar.com.ada.api.simulacro.entities.Empleado;
import ar.com.ada.api.simulacro.services.EmpleadoService;
import ar.com.ada.api.simulacro.services.EmpleadoService.EmpleadoValidationType;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	EmpleadoService empleadoService;

	@Test
	public void verificarEmpleado() {

		Empleado e = new Empleado();

		e.setNombre("Marcossss");
		e.setEdad(23);
		e.setEstado("activo");
		e.setFechaAlta(new Date(15 / 01 / 2010));
		e.setSueldo(25000);
		e.setDni(411227895);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(e);

		assertEquals(EmpleadoValidationType.EMPLEADO_OK, empleadoValidationType);
	}

	@Test
	public void verificarNombreEmpleado() {

		Empleado f = new Empleado();

		f.setEdad(27);
		f.setEstado("activo");
		f.setFechaAlta(new Date(18 / 01 / 2010));
		f.setSueldo(28000);
		f.setDni(441100326);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(f);

		assertEquals(EmpleadoValidationType.NOMBRE_INVALIDO, empleadoValidationType);

	}

	@Test
	public void verificarEdadEmpleado() {

		Empleado f = new Empleado();
		f.setNombre("Matias");
		f.setEdad(0);
		f.setEstado("activo");
		f.setFechaAlta(new Date(18 / 01 / 2010));
		f.setSueldo(28000);
		f.setDni(66854725);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(f);

		assertEquals(EmpleadoValidationType.EDAD_INVALIDA, empleadoValidationType);
	}

	@Test
	public void verificarSueldoEmpleado() {

		Empleado f = new Empleado();

		f.setNombre("Miguel");
		f.setEdad(27);
		f.setEstado("activo");
		f.setFechaAlta(new Date(18 / 01 / 2010));
		f.setSueldo(0);
		f.setDni(444477124);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(f);

		assertEquals(EmpleadoValidationType.SUELDO_NULO, empleadoValidationType);
	}

	@Test
	public void verificarDniEmpleado() {

		Empleado e = new Empleado();

		e.setNombre("José");
		e.setEdad(23);
		e.setEstado("activo");
		e.setFechaAlta(new Date(15 / 01 / 2010));
		e.setSueldo(32000);
		e.setDni(1222);
		e.setEmpleadoId(1);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(e);

		assertEquals(EmpleadoValidationType.EMPLEADO_DUPLICADO, empleadoValidationType);
	}

	@Test
	public void verificarDniEmpleadoNulo() {

		Empleado e = new Empleado();

		e.setNombre("Marcossss");
		e.setEdad(23);
		e.setEstado("activo");
		e.setFechaAlta(new Date(15 / 01 / 2010));
		e.setSueldo(25000);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(e);

		assertEquals(EmpleadoValidationType.EMPLEADO_INVALIDO, empleadoValidationType);

	}

	@Test
	public void verificarEstado() {

		Empleado e = new Empleado();

		e.setNombre("Marcossss");
		e.setEdad(23);
		e.setFechaAlta(new Date(15 / 01 / 2010));
		e.setSueldo(25000);
		e.setDni(411227895);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(e);

		assertEquals(EmpleadoValidationType.EMPLEADO_DATOS_INVALIDOS, empleadoValidationType);

	}

	@Test
	public void verificarFechaAlta() {

		Empleado e = new Empleado();

		e.setNombre("Marcossss");
		e.setEdad(23);
		e.setEstado("activo");
		e.setSueldo(25000);
		e.setDni(411227895);

		EmpleadoValidationType empleadoValidationType = empleadoService.verificarEmpleado(e);

		assertEquals(EmpleadoValidationType.EMPLEADO_DATOS_INVALIDOS, empleadoValidationType);
	}
}
