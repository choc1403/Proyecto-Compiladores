package funciones;

import analizador.Analizador;
import analizador.AnalizadorSintactico;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
//import test.*;

/**
 *
 * @author JUAN CARLOS CHOC XOL
 */
public class Funciones {

    Analizador analiza = new Analizador();
    AnalizadorSintactico analizador_reglas = new AnalizadorSintactico();
    Reglas regla = new Reglas();
    Tokens token = new Tokens();
    int contar = 0;

    public ArrayList<String> cadena = new ArrayList<String>();
    public ArrayList<String> cadena_regla = new ArrayList<String>();
   

    public void separador(String palabra) {
        String[] cadenaTexto = palabra.split("[ ]");

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(palabras);
        }

    }

    void finaliza(String palabra) {
        String[] cadenaTexto = palabra.split("[;]");
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

    void suma(String palabra) {
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

    void resta(String palabra) {
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

    void multiplicacion(String palabra) {
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

    void division(String palabra) {
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
    
    void parente(String palabra){
        char[] cadenaSeparada = palabra.toCharArray();
        int length = cadenaSeparada.length;
        
        for (int i = 0; i < length; i++) {
            char paren = cadenaSeparada[i];
            String pa = Character.toString(paren);
            evaluar(pa);
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
        boolean encontrarCadena, encontrarCaracter;
        boolean encontrarCad, encontrarCar, encontrarParentesis, encontrarPa;

        encontrarRW = analiza.encontrarRW(palabra);
        encontrarER = analiza.evaluarER(palabra);
        encontrarSB = analiza.encontrarSimbolo(palabra);
        encontrarNum = analiza.encontrarNum(palabra);

        encontrarAsignacion = analiza.encontrarIgual(palabra);
        encontrarFin = analiza.encontrarFin(palabra);
        
        encontrarCadena = analiza.cadena_texto(palabra);
        encontrarCaracter = analiza.caracter(palabra);
        encontrarPa = analiza.parentesis(palabra);

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
        
        encontrarCad = regla.cadena_texto(palabra);
        encontrarCar = regla.caracter(palabra);
        encontrarParentesis = regla.parentesis(palabra);
        

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
        } else if (encontrarFinalizado) {
            //Encuentrar los ; al final            
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
        } else if (encontrarSuma) {
            suma(palabra);
        } else if (encontrarResta) {
            resta(palabra);
        } else if (encontrarMulti) {
            multiplicacion(palabra);
        } else if (encontrarDivi) {
            division(palabra);
        } else if (encontrarSumaN) {
            suma(palabra);
        } else if (encontrarRestaN) {
            resta(palabra);
        } else if (encontrarMultiN) {
            multiplicacion(palabra);
        } else if (encontrarDiviN) {
            division(palabra);
        } else if (encontrarCadena){
            cadena.add(palabra);
        } else if(encontrarCaracter){
            cadena.add(palabra);
        } else if(encontrarCad){
            finaliza(palabra);
        } else if(encontrarCar){
            finaliza(palabra);
        } else if(encontrarParentesis){
            parente(palabra);
        } else if(encontrarPa){
            cadena.add(palabra);
        }
        //Escribir otra condicion 
        else {
            System.out.println(""+palabra);
            mensajeError();
        }
    }

    public void recorridoArreglo() {
        int total = cadena.size();
        String texto = "";
        String textoGeneral = "";

        for (int i = 0; i < total; i++) {
            String tokens = info(i);

            if (info(i).equals("<\n, >")) {                
                textoGeneral += "\n";
                texto += "\n";
            } else {
                textoGeneral += info(i);
                texto += ar(i);
                //System.out.print("" + info(i));
            }

        }

       
        System.out.println(textoGeneral);
        String[] det = texto.split("[\\n]");
        System.out.println("");

        for (int i = 0; i < det.length; i++) {
            String detalle = det[i];
            Pattern expresion = Pattern.compile("([<][a-zA-Z_]+[>])+(<Fin>)$");
            Matcher identificador = expresion.matcher(detalle);
            boolean resultado = identificador.matches();
            if (resultado){
                cadena_regla.add("\n");
                cadena_regla.add(detalle);
            }else{
                cadena_regla.add("\n");
                cadena_regla.add(detalle);
            }

        }
    }

    public void recorrido_de_reglas() {
        for (int i = 0; i < cadena_regla.size(); i++) {

            if (cadena_regla.get(i).equals("\n")) {
                System.out.println("");

            } else {
                boolean resultado = analizador_reglas.reglas(cadena_regla.get(i));
                if (!resultado) {
                    System.out.println("" + cadena_regla.get(i) + " CADENA NO ACEPTADA");
                } else {
                    System.out.println("" + cadena_regla.get(i) + " CADENA ACEPTADA");
                }
            }

        }
    }

    public String info(int i) {
        String resultado, texto;

        String tokens = cadena.get(i);

        texto = "<" + cadena.get(i) + "," + token.generarTokens(cadena.get(i)) + ">";

        resultado = texto;

        return resultado;
    }

    public String ar(int i) {
        String resultado, texto;
        String tokens = cadena.get(i);
        texto = "<" + token.generarTokens(cadena.get(i)) + ">";
        resultado = texto;
        return resultado;

    }
    public final static void limpiar() {
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")){
                Runtime.getRuntime().exec("clear ");
            }else{
                Runtime.getRuntime().exec("clear");
            }
        } catch (Exception e) {
            /*No hacer nada*/
        }
    }

    public void mostrarArreglo() {
        limpiar();

        System.out.print("-----------------------");
        System.out.print("TOKENS GENERADOS");
        System.out.print("-----------------------\n");
        recorridoArreglo();
        System.out.println("\n\n");

        System.out.print("-----------------------");
        System.out.print("Reglas GENERADOS");
        System.out.print("-----------------------\n");
        recorrido_de_reglas();
////        contar = 0;
    }
}
