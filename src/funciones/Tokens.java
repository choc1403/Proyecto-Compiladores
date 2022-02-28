package funciones;

import analizador.Analizador;

/**
 *
 * @author eloic
 */
public class Tokens {

    //Funciones funcion = new Funciones();
    Analizador analiza = new Analizador();

    public void generarTokens(String palabra) {

        boolean encontrarRW, encontrarER, encontrarSB;
        boolean encontrarNum, encontrarAsignacion, encontrarFin, encontrarComa;

        encontrarRW = analiza.encontrarTipoDato(palabra);
        encontrarER = analiza.evaluarER(palabra);
        encontrarSB = analiza.encontrarSimbolo(palabra);
        encontrarNum = analiza.encontrarNum(palabra);
        encontrarAsignacion = analiza.encontrarIgual(palabra);
        encontrarFin = analiza.encontrarFin(palabra);
        encontrarComa = analiza.encontrarComa(palabra);

        if (encontrarRW) {
            System.out.print("TIPO DE DATO");

        } else if (encontrarER) {         //Encuentra los identificadores

            System.out.print("IDENTIFICADOR");

        } else if (encontrarFin) {
            System.out.print("FIN");
        } else if (encontrarComa) {
            System.out.print("COMA");
        } else if (encontrarSB) {         //Encuentra los simbolos
            System.out.print("SIMBOLO");

        } else if (encontrarNum) {        //Encuentra los numeros

            System.out.print("NUMERO");

        } else if (encontrarAsignacion) {
            System.out.print("ASIGNACION");

        } /*Escribir otra condicion*/ else {
            System.out.print("LEXEMA NO ENCONTRADO");
        }

    }
   
    

}
