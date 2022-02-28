package funciones;

import analizador.Analizador;

/**
 *
 * @author eloic
 */
public class Tokens {

    //Funciones funcion = new Funciones();
    Analizador analiza = new Analizador();

    
    
    public String generarTokens(String palabra){
        String resultado;
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
            resultado = "Tipo de dato";
            //System.out.print("TIPO DE DATO");

        } else if (encontrarER) {         //Encuentra los identificadores
            resultado = "Identificador";

            //System.out.print("IDENTIFICADOR");

        } else if (encontrarFin) {
            resultado = "Fin";
            //System.out.print("FIN");
        } else if (encontrarComa) {
            resultado = "Coma";
            //System.out.print("COMA");
        } else if (encontrarSB) {         //Encuentra los simbolos
            resultado = "Simbolo";
            //System.out.print("SIMBOLO");

        } else if (encontrarNum) {        //Encuentra los numeros
            resultado = "Numero";
            //System.out.print("NUMERO");

        } else if (encontrarAsignacion) {
            resultado = "Asignacion";
            //System.out.print("ASIGNACION");

        } /*Escribir otra condicion*/ else {
            resultado = "Lexema no encontrado";
            //System.out.print("LEXEMA NO ENCONTRADO");
        }
        
        return resultado;
    }
   
    

}
