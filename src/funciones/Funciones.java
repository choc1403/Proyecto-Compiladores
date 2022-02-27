package funciones;

import analizador.Analizador;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author JUAN CARLOS CHOC XOL
 */
public class Funciones {

    Analizador analiza = new Analizador();

    public ArrayList<String> cadena = new ArrayList<String>();

    /*
    Funcion que separa la cadena de texto por palabras separadas
     */
    public void separador(String palabra) {
        //Regla para separa palabras
        String[] cadenaTexto = palabra.split("[ \\n]");

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador
            evaluar(palabras);
        }
    }

    //Evalua si la palabra separada tiene un ; al final
    boolean finalizacion(String palabra) {
        //Expresion Regular
        Pattern expresion = Pattern.compile("(([_a-zA-Z_]+)?(\\w+)?([;]))$");
        //Verifica si la palabra cumple con la expresion regular
        Matcher identificador = expresion.matcher(palabra);
        //Resultado como true o como false
        return identificador.matches();
    }

    /*Evalua si la palabra separada tiene una asignacion, numero y al final contiene
    un ;*/
    boolean asignar(String palabra) {
        Pattern expresion = Pattern.compile("(([_a-zA-Z_]+)?([=])(\\d+)([.]\\d+)?([;]))$");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }

    /*Evalua si la palabra separada tiene una asignacion, numero o decimal y al final contiene
    un ;*/
    boolean decimal(String palabra) {
        Pattern expresion = Pattern.compile("((\\w+)?([=])?([0-9]+)([.])(\\d+)([;]))$");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();

    }
    
    boolean separado(String palabra){
        String expre = "((([a-zA-Z]+)?)([,]?)([a-zA-Z]+)?[=]?(\\d+)([.]?(\\d)+)?([;]?))";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    
    boolean separadoor(String palabra){
        String expre = "([_a-zA-Z_]+(\\d+)?[,][_a-zA-Z_]+(\\d+)?([;]?))";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    boolean separadorSinFin(String palabra){
        String expre = "([_a-zA-Z_]+(\\d+)?([,])([_a-zA-Z_])(\\d+)?)";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }

    /*Hace la separacion de la palabra que contiene el ; y la manda a la funcion
    de evaular */
    void finaliza(String palabra) {
        //Regla para separa palabras
        String[] cadenaTexto = palabra.split("[;\\n]");

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador
            evaluar(palabras);
            evaluar(";");
        }
    }
    
    void coma(String palabra){
        String[] cadenaTexto = palabra.split("[,]");

        char[] cadenaSeparada = palabra.toCharArray();

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador

            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals(",")) {
                evaluar(",");
                break;
            }
        }

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador

            evaluar(palabras);

        }
    }

    void igual(String palabra) {

        String[] cadenaTexto = palabra.split("[=]");

        char[] cadenaSeparada = palabra.toCharArray();

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador

            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("=")) {
                evaluar("=");
                break;
            }
        }

        //Recorrido de la cadena de texto digitado por el usuario
        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            //Evalua si es una palabra reservada o un identificador

            evaluar(palabras);

        }

    }

    /*
    MENSAJE DE ERROR POR SI EL CODIGO DIGITADO POR EL USUARIO NO PUEDE SER 
    EVALUADO
     */
    void mensajeError() {
        System.out.println("\nLOS DATOS INGRESADOS NO CUMPLEN CON LAS"
                + " REGLAS DE:");
        System.out.println("PALABRA RESERVADA");
        System.out.println("IDENTIFICADOR");
        System.out.println("SIMBOLO\n");
    }


    /*
    Funcion que manda el codigo digitado por el usuario a ser evaluada a la 
    clase analizador para identificar si es:
        *Palabra Reservada
        *Identificador
        *Simbolo
        *Numero
        *Asignacion
        *Fin
     */
    public void evaluar(String palabra) {
        //Declaracion de variables
        boolean encontrarRW, encontrarER, encontrarSB, encontrarFinalizado;
        boolean encontrarNum, encontrarAsignacion, asignacion, encontrarDecimal;
        boolean encontrarFin, encontrarComa,encontrarComa1,encontrarComaSinFin;

        /*Manda la palabra digitada por el usuario para evaluar si es una 
        palabra reservada*/
        encontrarRW = analiza.encontrarRW(palabra);
        encontrarER = analiza.evaluarER(palabra);
        encontrarSB = analiza.encontrarSimbolo(palabra);
        encontrarNum = analiza.encontrarNum(palabra);
        encontrarAsignacion = analiza.encontrarIgual(palabra);
        encontrarFin = analiza.encontrarFin(palabra);

        encontrarFinalizado = finalizacion(palabra);
        asignacion = asignar(palabra);
        encontrarDecimal = decimal(palabra);
        encontrarComa = separado(palabra);
        encontrarComa1 = separadoor(palabra);
        encontrarComaSinFin = separadorSinFin(palabra);

//Encuentra las palabras reservadas
        if (encontrarRW) {
            cadena.add(palabra);
            //System.out.println("Palabra Reservada: " + encontrarRW);

        } else if (encontrarER) {         //Encuentra los identificadores

            cadena.add(palabra);
            //System.out.println("Identificador: " + encontrarER);

        } else if (encontrarSB) {         //Encuentra los simbolos

            cadena.add(palabra);
            //System.out.println("Simbolo: " + encontrarSB);

        } else if (encontrarNum) {        //Encuentra los numeros

            cadena.add(palabra);
            //System.out.println("Numero: " + encontrarNum);

        } else if (encontrarFinalizado) {     //Encuentrar los ; al final            

            finaliza(palabra);

        } else if (encontrarAsignacion) {
            cadena.add(palabra);
            //System.out.println("Asignacion: " + encontrarAsignacion);

        } else if (asignacion) {
            igual(palabra);
        } else if (encontrarDecimal) {
            finaliza(palabra);
        } else if (encontrarFin) {
            cadena.add(palabra);
            //System.out.println("Fin: " + encontrarFin);
        } else if(encontrarComa){
            coma(palabra);
        } else if(encontrarComa1){
            coma(palabra);
        } else if(encontrarComaSinFin){
            coma(palabra);
        }
        /*Escribir otra condicion*/ else {
            mensajeError();
        }

    }

    /*
    GENERA LOS TOKENS DEL CODIGO EVALUADO E INDICA EL VALOR DEL TOKEN
     */
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
        } else if(encontrarComa){
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

    /*
    RECORRE EL ARREGLO QUE CONTIENE LOS TOKENS GENERADOS
     */
    void recorridoArreglo() {
        for (int i = 0; i < cadena.size(); i++) {
            String tokens = cadena.get(i);
            System.out.print("<" + cadena.get(i));
            System.out.print(",");
            generarTokens(cadena.get(i));
            System.out.print(">");
            System.out.println("");
            //SEPERA CUANDO YA LA LINEA HAYA FINALIZADO
            if (tokens.equals(";")) {
                System.out.println("");
            }
        }
    }

    /*
    MUESTRA EL RECORRIDO DEL ARREGLO
     */
    public void mostrarArreglo() {
        System.out.print("-----------------------");
        System.out.print("TOKENS GENERADOS");
        System.out.print("-----------------------\n");
        recorridoArreglo();
    }
}
