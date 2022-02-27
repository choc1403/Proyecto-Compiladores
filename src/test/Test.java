/*
Analizador
 */
package test;

import funciones.Funciones;
import java.util.Scanner;

/**
 *
 * @author Juan Carlos Choc Xol
 */
public class Test {

    public static void main(String[] args) {
        Funciones funcion = new Funciones();

        Scanner dato = new Scanner(System.in);

        String palabra;
        mensaje();

        palabra = dato.nextLine();

        funcion.separador(palabra);
        funcion.mostrarArreglo();
    }

    static void mensaje() {
        System.out.print("----------------------");
        System.out.print("Bienvenido");
        System.out.print("----------------------\n");
        System.out.println("Por favor digite su cadena de texto");

    }

}
