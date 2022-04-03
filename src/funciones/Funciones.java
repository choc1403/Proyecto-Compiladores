package funciones;

import analizador.Analizador;
import analizador.AnalizadorSintactico;
import java.util.ArrayList;

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

    

    public void separador(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[ ]");
        
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);            
        }

    }
    
    void finaliza(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[;]");
        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            evaluar(contador,";");
        }
    }

    void coma(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[,]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals(",")) {
                evaluar(contador,",");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
        }
    }

    void igual(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[=]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("=")) {
                evaluar(contador,"=");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);

        }

    }

    void suma(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[+]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("+")) {
                evaluar(contador,"+");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);

        }
    }

    void resta(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[-]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("-")) {
                evaluar(contador,"-");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);

        }
    }

    void multiplicacion(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[*]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("*")) {
                evaluar(contador,"*");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);

        }
    }

    void division(int contador,String palabra) {
        String[] cadenaTexto = palabra.split("[/]");
        char[] cadenaSeparada = palabra.toCharArray();

        for (int i = 0; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);
            break;

        }

        for (int i = 0; i < cadenaSeparada.length; i++) {
            char caracter = cadenaSeparada[i];
            String cadena = Character.toString(caracter);
            if (cadena.equals("/")) {
                evaluar(contador,"/");
                break;
            }
        }

        for (int i = 1; i < cadenaTexto.length; i++) {
            String palabras = cadenaTexto[i];
            evaluar(contador,palabras);

        }
    }


    void mensajeError() {
        System.out.println("\nLOS DATOS INGRESADOS NO CUMPLEN CON LAS"
                + " REGLAS DE:");
        System.out.println("PALABRA RESERVADA");
        System.out.println("IDENTIFICADOR");
        System.out.println("SIMBOLO\n");
    }

    public void evaluar(int contador, String palabra) {     
        contar++;
        System.out.println("La lina "+ contador+") fue analizada "+contar+" veces \n");
        
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
        } else if (encontrarFinalizado) {
            //Encuentrar los ; al final            
            finaliza(contador,palabra);

        } else if (encontrarAsignacion) {
            cadena.add(palabra);

            //System.out.println("Asignacion: " + encontrarAsignacion);
        } else if (asignacion) {
            igual(contador,palabra);
        } else if (encontrarDecimal) {
            finaliza(contador,palabra);
        } else if (encontrarFin) {
            cadena.add(palabra);

            //System.out.println("Fin: " + encontrarFin);
        } else if (encontrarComa) {
            coma(contador,palabra);
        } else if (encontrarComa1) {
            coma(contador,palabra);
        } else if (encontrarComaSinFin) {
            coma(contador,palabra);
        } else if (encontrarSuma) {
            suma(contador,palabra);
        } else if (encontrarResta) {
            resta(contador,palabra);
        } else if (encontrarMulti) {
            multiplicacion(contador,palabra);
        } else if (encontrarDivi) {
            division(contador,palabra);
        } else if (encontrarSumaN) {
            suma(contador,palabra);
        } else if (encontrarRestaN) {
            resta(contador,palabra);
        } else if (encontrarMultiN) {          
            multiplicacion(contador,palabra);
        } else if (encontrarDiviN) {
            division(contador,palabra);
        } /*Escribir otra condicion*/ else {
            mensajeError();
        }

    }

    public void recorridoArreglo() {
        int total = cadena.size();
        String texto = "";
        String textoGeneral = "";

        for (int i = 0; i < total; i++) {
            String tokens = info(i);

            System.out.print("" + info(i));
            //System.out.print(""+ ar(i));
            //textoGeneral += info(i) + " ";
            texto += ar(i);

            System.out.print(" ");

            if (tokens.equals("<;,Fin>")) {
                System.out.println("");
                //textoGeneral += "\n";

            }

            if (cadena.get(i) == ";") {
                if (i == (total - 1)) {
                    String[] fsa = texto.split("<Fin>");
                    for (int j = 0; j < fsa.length; j++) {
                        String palabras = fsa[j];
                        palabras += "<Fin>";
                        //System.out.println(""+palabras);

                        cadena_regla.add(palabras);

                    }
                }

            } else {
                if (i == (total - 1)) {
                    System.out.println("CADENA NO ACEPTADA");
                }

            }

        }

        System.out.println("");
        //textoGeneral += "\n";
        //System.out.println(""+textoGeneral);
    }

    public void recorrido_de_reglas() {
        for (int i = 0; i < cadena_regla.size(); i++) {

            boolean resultado = analizador_reglas.reglas(cadena_regla.get(i));
            if (!resultado) {
                System.out.println("" + cadena_regla.get(i) + " CADENA NO ACEPTADA");
            } else {
                System.out.println("" + cadena_regla.get(i) + " CADENA ACEPTADA");
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

    public void mostrarArreglo() {
        
        System.out.print("-----------------------");
        System.out.print("TOKENS GENERADOS");
        System.out.print("-----------------------\n");
        recorridoArreglo();
        System.out.println("");
        System.out.println("");
        
        System.out.print("-----------------------");
        System.out.print("Reglas GENERADOS");
        System.out.print("-----------------------\n");
        recorrido_de_reglas();
        contar = 0;
        
         

       

    }
}
