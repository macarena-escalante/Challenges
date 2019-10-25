package app;

import java.util.Scanner;

public class App {
    public static Scanner Teclado = new Scanner (System.in);
    public static void main(String[] args) {

        String nombre1;
        double dni1;
        int edad1;

        Persona nuevaPersona = new Persona();
       
        System.out.println("Ingrese su nombre");
        
        nombre1 = Teclado.nextLine();
        nuevaPersona.cargarNombre(nombre1);

        System.out.println("Ingrese su dni");

        dni1 = Teclado.nextDouble();
        nuevaPersona.cargarDni(dni1);

        System.out.println("Ingrese su edad");

        edad1 = Teclado.nextInt();
        nuevaPersona.cargarEdad(edad1);

        

        

        








    }
}