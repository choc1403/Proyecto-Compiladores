package funciones;

import analizador.Analizador;

/**
 *
 * @author eloic
 */
public class Tokens {

    //Funciones funcion = new Funciones();
    Analizador analiza = new Analizador();

    public String generarTokens(String palabra) {
        String resultado;
        boolean encontrarRW, encontrarER, encontrarSB;
        boolean encontrarNum, encontrarAsignacion, encontrarFin, encontrarComa;
        boolean encontrarCadena, encontrarCaracter;
        boolean encontrarCondi;

        encontrarRW = analiza.encontrarTipoDato(palabra);
        encontrarER = analiza.evaluarER(palabra);
        encontrarSB = analiza.encontrarSimbolo(palabra);
        encontrarNum = analiza.encontrarNum(palabra);
        encontrarAsignacion = analiza.encontrarIgual(palabra);
        encontrarFin = analiza.encontrarFin(palabra);
        encontrarComa = analiza.encontrarComa(palabra);
        //encontrarCadena = analiza.cadena_texto(palabra);
        encontrarCaracter = analiza.caracter(palabra);
        encontrarCondi = analiza.condicion(palabra);
        

        if (encontrarRW) {
            resultado = "Tipo_de_dato";
            //System.out.print("TIPO DE DATO");

        }else if(encontrarCondi){
            resultado = "Condicion";
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
            resultado = operadores(palabra);
            //System.out.print("SIMBOLO");

        } else if (encontrarNum) {        //Encuentra los numeros
            resultado = "Numero";
            //System.out.print("NUMERO");

        } else if (encontrarAsignacion) {
            resultado = "Asignacion";
            //System.out.print("ASIGNACION");

        } else if (palabra.equals("\n")){
            resultado = " ";
        } /*else if (encontrarCadena){
            resultado = "Cadena";
        } */else if(encontrarCaracter){
            resultado = "Caracter";
        } /*Escribir otra condicion*/ else {
            resultado = "Lexema no encontrado";
            //System.out.print("LEXEMA NO ENCONTRADO");
        }

        return resultado;
    }
    String operadores(String palabra){
        String resultado;
        String multi = "*";
        String resta = "-";
        String divi = "/";
        String suma = "+";
        String parentesis_izquierdo = "(";
        String parentesis_derecho = ")";
        String or = "|";
        String and = "&";
        
        
        if(multi.equals(palabra)){
            resultado = "Multiplicacion";
        } else if(resta.equals(palabra)){
            resultado = "Resta";
        } else if (suma.equals(palabra)){
            resultado = "Suma";
        } else if (divi.equals(palabra)){
            resultado = "Division";
        } else if(parentesis_izquierdo.equals(palabra)){
            resultado = "Parentesis_izquierdo";
        } else if(parentesis_derecho.equals(palabra)){
            resultado = "Parentesis_derecho";
        } else if(or.equals(palabra)){
            resultado = "or";
        } else if(and.equals(palabra)){
            resultado = "and";
        }
        else{
            resultado = "Simbolo";
        }     

        return resultado;
    }
    

}
