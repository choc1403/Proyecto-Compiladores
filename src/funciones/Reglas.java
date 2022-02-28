package funciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author eloic
 */
public class Reglas {
    public boolean finalizacion(String palabra) {
        //Expresion Regular
        Pattern expresion = Pattern.compile("(([_a-zA-Z_]+)?(\\w+)?([;]))$");
        //Verifica si la palabra cumple con la expresion regular
        Matcher identificador = expresion.matcher(palabra);
        //Resultado como true o como false
        return identificador.matches();
    }

    /*Evalua si la palabra separada tiene una asignacion, numero y al final contiene
    un ;*/
    public boolean asignar(String palabra) {
        Pattern expresion = Pattern.compile("(([_a-zA-Z_]+)?([=])(\\d+)([.]\\d+)?([;]))$");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }

    /*Evalua si la palabra separada tiene una asignacion, numero o decimal y al final contiene
    un ;*/
    public boolean decimal(String palabra) {
        Pattern expresion = Pattern.compile("((\\w+)?([=])?([0-9]+)([.])(\\d+)([;]))$");
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();

    }
    
    public boolean separado(String palabra){
        String expre = "((([a-zA-Z]+)?)([,]?)([a-zA-Z]+)?[=]?(\\d+)([.]?(\\d)+)?([;]?))";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    
    public boolean separadoor(String palabra){
        String expre = "([_a-zA-Z_]+(\\d+)?[,][_a-zA-Z_]+(\\d+)?([;]?))";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean separadorSinFin(String palabra){
        String expre = "([_a-zA-Z_]+(\\d+)?([,])([_a-zA-Z_])(\\d+)?)";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    
}
