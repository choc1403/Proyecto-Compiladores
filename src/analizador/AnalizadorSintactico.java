/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizador;

/**
 *
 * @author eloic
 */
public class AnalizadorSintactico {
    public boolean reglas(String texto){
        String reglas_sintacticas[] = {
            "<Tipo_de_dato><Identificador><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Numero><Fin>",
            "<Identificador><Asignacion><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Suma><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Resta><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Division><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Multiplicacion><Numero><Fin>",            
            "<Tipo_de_dato><Identificador><Asignacion><Identificador><Suma><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Identificador><Resta><Numero><Fin>",
            "<Tipo_de_datoTipo de dato><Identificador><Asignacion><Identificador><Division><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Identificador><Multiplicacion><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Numero><Suma><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Numero><Resta><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Numero><Division><Numero><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Numero><Multiplicacion><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Numero><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Suma><Numero><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Resta><Numero><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Multiplicacion><Numero><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Division><Numero><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Suma><Identificador><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Resta><Identificador><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Multiplicacion><Identificador><Parentesis_derecho><Fin>",
            "<Identificador><Asignacion><Parentesis_izquierdo><Identificador><Division><Identificador><Parentesis_derecho><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Cadena><Fin>",
            "<Tipo_de_dato><Identificador><Asignacion><Caracter><Fin>"
        };
        String palabras;
        
        for (int i = 0; i < reglas_sintacticas.length; i++) {
            palabras = reglas_sintacticas[i];
            if(palabras.equals(texto)){
                return true;
            }
        }
        return false;
    }
        
}
