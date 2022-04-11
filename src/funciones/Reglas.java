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
    public boolean suma(String palabra){
        String expre = "(([a-zA-Z]+(\\d+)?)(\\s)?[+](\\s)?([a-zA-Z]+(\\d+)?))(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean resta(String palabra){
        String expre = "(([a-zA-Z]+(\\d+)?)(\\s)?[-](\\s)?([a-zA-Z]+(\\d+)?))(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean multiplicacion(String palabra){
        String expre = "(([a-zA-Z]+(\\d+)?)(\\s)?[*](\\s)?([a-zA-Z]+(\\d+)?))(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean divicion(String palabra){
        String expre = "(([a-zA-Z]+(\\d+)?)(\\s)?[/](\\s)?([a-zA-Z]+(\\d+)?))(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean sumaNumero(String palabra){
        String expre = "((\\d+)?)(\\s)?[+](\\s)?((\\d+)?)(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean restaNumero(String palabra){
        String expre = "((\\d+)?)(\\s)?[-](\\s)?((\\d+)?)(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean multiplicacionNumero(String palabra){
        String expre = "((\\d+)?)(\\s)?[*](\\s)?((\\d+)?)(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean divicionNumero(String palabra){
        String expre = "((\\d+)?)(\\s)?[/](\\s)?((\\d+)?)(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean caracter(String palabra){
        String expre = "(')\\w(')(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean cadena_texto(String palabra){
        String expre = "([\"]((\\w+(\\s+)?(\\w+)?)+)[\"])(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
    public boolean parentesis(String palabra){
        String expre = "([(])?((\\w+((\\s)?[+*/]?(\\s)?(-?)\\w+)?))?([)])(;)?";
        Pattern expresion = Pattern.compile(expre);
        Matcher identificador = expresion.matcher(palabra);
        return identificador.matches();
    }
}
