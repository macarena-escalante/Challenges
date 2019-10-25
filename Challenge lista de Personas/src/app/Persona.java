package app;

import java.util.ArrayList;
import java.util.List;

/**
 * Persona
 */
public class Persona {

    String nombre;
    long dni;
    int edad;

    public Persona (String nombre, long dni, int edad){
        this.nombre = nombre;
        this.dni = dni;
        this.edad= edad;

    }

    public Persona (){}

    public Persona (String nombre){
        this.nombre= nombre;
    }

    

    
    public static List<Persona> personas = new ArrayList<Persona>();

    public void cargarNombre(String nombre){}

    public void cargarDni(Double dni){}

    public void cargarEdad(int edad){}
    
    public void cargarPersona(){

        Persona p = new Persona();
        Persona m = new Persona();
        Persona s = new Persona();

    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDni(long dni){
        this.dni= dni;
    }
    
    public void setEdad(int edad){
        this.edad= edad;
    }
}