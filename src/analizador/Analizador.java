/*
 Funciones
 */
package analizador;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eloic
 */
public class Analizador {

    public boolean encontrarRW(String palabra) {
        //Palabras reservadas
        String rw[] = {"int", "double", "while", "switch", "float", "false", "true",
            "boolean", "if", "else", "elif"};
        String palabras;

        //Recorrido del arreglo
        for (int i = 0; i < rw.length; i++) {
            //Verificar si la palabra ingresada es una palabra reservada
            palabras = rw[i];
            if (palabras.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public boolean evaluarER(String palabra) {
        //Expresion Regular
        Pattern expresion = Pattern.compile("((^[_a-zA-Z_]+)(\\w+)?)$");
        //Verifica si la palabra cumple con la expresion regular
        Matcher identificador = expresion.matcher(palabra);
        //Resultado como true o como false
        return identificador.matches();
    }

    public boolean encontrarSimbolo(String palabra) {
        //Simbolos
        String sb[] = {
            "+",";", 
            "-","/", 
            "*", ",",
            ".", "(",
            ")", "{",
            "}", "[",
            "]", "&&",
            "||", "|",
            "&", " ",
            "\\n",
        };
        String simbolo;

        //Recorrido del arreglo
        for (int i = 0; i < sb.length; i++) {
            //Verificar si la palabra ingresada es un simbolo
            simbolo = sb[i];
            if (simbolo.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public boolean encontrarTipoDato(String palabra) {
        //Tipos de datos
        String tipoDato[] = {"int", "double", "boolean", "float", "string", "String", "Boolean"};
        String palabras;
        for (int i = 0; i < tipoDato.length; i++) {
            palabras = tipoDato[i];
            if (palabras.equals(palabra)) {
                return true;
            }
        }
        return false;
    }

    public boolean encontrarIgual(String palabra) {
        String igual[] = {"=", "=="};
        for (int i = 0; i < igual.length; i++) {
            String asig = igual[i];
            if(asig.equals(palabra)){
                return true;
            }
        }
        return false;
        
    }

    public boolean encontrarFin(String palabra) {
        String fin = ";";
        if (fin.equals(palabra)) {
            return true;
        }
        return false;
    }

    public boolean encontrarNum(String palabra) {
        //Expresion Regular
        Pattern expresion = Pattern.compile("(-)?([0-9]+)([.]\\d+)?");
        //Verifica si la palabra cumple con la expresion regular
        Matcher identificador = expresion.matcher(palabra);
        //Resultado como true o como false
        return identificador.matches();
    }

    public boolean encontrarComa(String palabra) {
        String igual = ",";
        if (igual.equals(palabra)) {
            return true;
        }
        return false;
    }
    /*
    public boolean cadena_texto(String palabra){
        Pattern expresion = Pattern.compile("([\"]((\\w+((-)?\\d+([.]))?(\\s+)?(\\w+)?)+)[\"])");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
          //(["]((\w+((-)?\d+([.]))?(\s+)?(\w+)?)+)["])
    }
    */
    public boolean caracter(String palabra){
        Pattern expresion = Pattern.compile("(')\\w(')");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean parentesis(String palabra){        
        Pattern expresion = Pattern.compile("([(])((\\w?)+(((-)?(\\d+)([.])?)+)?([+*/]?(-)?)+\\w+)([)])");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
        
        
    }
    
    public boolean condicion(String palabra){
        String condicion[] = {"if", "else"};
        for (int i = 0; i < condicion.length; i++) {
            String condi = condicion[i];
            if(condi.equals(palabra)){
                return true;
            }
        }
        return false;
    }

    
}
