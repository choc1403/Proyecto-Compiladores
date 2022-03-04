package funciones;

import analizador.Analizador;
import java.util.ArrayList;

import javax.swing.JOptionPane;
//import test.*;

/**
 *
 * @author JUAN CARLOS CHOC XOL
 */
public class Funciones {

    Analizador analiza = new Analizador();
    Reglas regla = new Reglas();
    Tokens token = new Tokens();

    public ArrayList<String> cadena = new ArrayList<String>();

    public void separador(String palabra) {
        String[] cadenaTexto = palabra.split("[ \\n]");
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
        }
    }

    void finaliza(String palabra) {
        String[] cadenaTexto = palabra.split("[;\\n]");
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
            evaluar(";");
        }
    }

    void coma(String palabra) {
        String[] cadenaTexto = palabra.split("[,]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
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

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
        }
    }

    void igual(String palabra) {
        String[] cadenaTexto = palabra.split("[=]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
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

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);

        }

    }
    void suma(String palabra){
        String[] cadenaTexto = palabra.split("[+]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("+")) {
                evaluar("+");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);

        }
    }
    void resta(String palabra){
        String[] cadenaTexto = palabra.split("[-]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("-")) {
                evaluar("-");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);

        }
    }
    void multiplicacion(String palabra){
        String[] cadenaTexto = palabra.split("[*]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("*")) {
                evaluar("*");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);

        }
    }
    void division(String palabra){
        String[] cadenaTexto = palabra.split("[/]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("/")) {
                evaluar("/");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);

        }
    }

    void mensajeError() {
        System.out.println("\nLOS DATOS INGRESADOS NO CUMPLEN CON LAS"
                + " REGLAS DE:");
        System.out.println("PALABRA RESERVADA");
        System.out.println("IDENTIFICADOR");
        System.out.println("SIMBOLO\n");
    }

    public void evaluar(String palabra) {

        boolean encontrarRW, encontrarER, encontrarSB, encontrarFinalizado;
        boolean encontrarNum, encontrarAsignacion, asignacion, encontrarDecimal;
        boolean encontrarFin, encontrarComa, encontrarComa1, encontrarComaSinFin;
        boolean encontrarSuma, encontrarResta, encontrarMulti, encontrarDivi;
        boolean encontrarSumaN, encontrarRestaN, encontrarMultiN, encontrarDiviN;

        encontrarRW = analiza.encontrarRW(palabra);
        encontrarER = analiza.evaluarER(palabra);
        encontrarSB = analiza.encontrarSimbolo(palabra);
        encontrarNum = analiza.encontrarNum(palabra);
        
        encontrarAsignacion = analiza.encontrarIgual(palabra);
        encontrarFin = analiza.encontrarFin(palabra);

        encontrarFinalizado = regla.finalizacion(palabra);
        asignacion = regla.asignar(palabra);
        encontrarDecimal = regla.decimal(palabra);
        encontrarComa = regla.separado(palabra);
        encontrarComa1 = regla.separadoor(palabra);
        encontrarComaSinFin = regla.separadorSinFin(palabra);
        encontrarSuma = regla.suma(palabra);
        encontrarResta = regla.resta(palabra);
        encontrarMulti = regla.multiplicacion(palabra);
        encontrarDivi = regla.divicion(palabra);
        
        encontrarSumaN = regla.sumaNumero(palabra);
        encontrarRestaN = regla.restaNumero(palabra);
        encontrarMultiN = regla.multiplicacionNumero(palabra);
        encontrarDiviN = regla.divicionNumero(palabra);

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
        } else if (encontrarComa) {
            coma(palabra);
        } else if (encontrarComa1) {
            coma(palabra);
        } else if (encontrarComaSinFin) {
            coma(palabra);
        } else if(encontrarSuma){
            suma(palabra);
        } else if(encontrarResta){
            resta(palabra);
        } else if(encontrarMulti){
            multiplicacion(palabra);
        } else if(encontrarDivi){
            division(palabra);
        } else if(encontrarSumaN){
            suma(palabra);
        } else if(encontrarRestaN){
            resta(palabra);
        } else if(encontrarMultiN){
            multiplicacion(palabra);
        } else if(encontrarDiviN){
            division(palabra);
        }
        /*Escribir otra condicion*/ else {
            mensajeError();
        }

    }

    public void recorridoArreglo() {
        int total = cadena.size();

        for (int i = 0; i < total; i++) {
            String tokens = info(i);

            System.out.print("" + info(i));

            System.out.print(" ");

            if (tokens.equals("<;,Fin>")) {
                System.out.println("");
            }
        }
        System.out.println("");
    }

    void recorridoEnForm() {
        int total = cadena.size();

        for (int i = 0; i < total; i++) {
            String texto = info(i);

            JOptionPane.showMessageDialog(null, texto);
        }
    }

    public String info(int i) {
        String resultado, texto;

        String tokens = cadena.get(i);
        texto = "<" + cadena.get(i) + "," + token.generarTokens(cadena.get(i)) + ">";

        resultado = texto;

        return resultado;
    }

    public void mostrarArreglo() {
        System.out.print("-----------------------");
        System.out.print("TOKENS GENERADOS");
        System.out.print("-----------------------\n");
        recorridoArreglo();
        //recorridoEnForm();

    }
}
