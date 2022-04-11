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
            "<Tipo de dato><Identificador><Fin>",
            "<Tipo de dato><Identificador><Asignacion><Numero><Fin>",
            "<Identificador><Asignacion><Numero><Fin>",
            "<Identificador><Asignacion><Identificador><Suma><Numero><Fin>",
            "<Tipo de dato><Identificador><Asignacion><Identificador><Suma><Numero><Fin>"
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
