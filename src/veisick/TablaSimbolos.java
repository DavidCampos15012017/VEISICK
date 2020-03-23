/*
 Resice los Tokens y devuelve el tipo de dato correspondiente
 */
package veisick;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

/**
 *
 * @author DAVID
 */
public class TablaSimbolos {

    ArrayList<Identificadores> Tabla = new ArrayList<Identificadores>();

    // Crea la tabla de símbolos.
    public void TablaSimbolos() {
        // Identificadores(token, lexema, Regex)
        Tabla.add(new Identificadores("PRINT", "PRINT", "^[\\d\\s]+(PRINT)(\\s\".*([A-Za-z0-9-]+).*|)"));
        Tabla.add(new Identificadores("INPUT", "INPUT", "^[\\d\\s]+(INPUT)\\s\".*([A-Za-z0-9-]+).*"));
        Tabla.add(new Identificadores("REM", "REM", "[\\d]\\s+(REM)\\s+.*")); // Valida REM
        //                                                   18 LET M=12
        Tabla.add(new Identificadores("LET", "LET", "[\\d]+(\\s{1}((LET)|)\\s{1})+[A-Z]=\\s?([\\d]+|\".*\")"));// LET
        Tabla.add(new Identificadores("LET", "LET", "[\\d]+\\s{1}([A-Z][0-9]?)[\\s]?=.*"));// LET
        Tabla.add(new Identificadores("LET", "LET", "[\\d]+\\s{1}(([A-Z][0-9])+)[\\s]?=\\s?\\(.*\\)"));// LET X1=
        Tabla.add(new Identificadores("IF", "IF", "^[\\d\\s]+(IF)\\(.*([A-Za-z0-9-]+).*\\).*(THEN).*([A-Za-z0-9-]+)")); // Valida IF
        Tabla.add(new Identificadores("CLS", "CLS", "^[\\d\\s]+(CLS)\\s{0,}.*")); // Valida CLS
        Tabla.add(new Identificadores("STRING", "$", "^[\\d\\s]+([A-Za-z0-9-]+)\\$=\"([A-Za-z0-9-]+)\"")); // Valida Tipo de dato String
        Tabla.add(new Identificadores("INT", "%", "^[\\d\\s]+([A-Za-z0-9-]+)\\%=([\\d])")); // Valida Tipo de dato INT
        Tabla.add(new Identificadores("DOUBLE-PRECISION", "#", "^[\\d\\s]+([A-Za-z0-9-]+)(#=|=#)([\\d]/[\\d])")); // Valida Tipo de dato DOUBLE
        Tabla.add(new Identificadores("SIMPLE-PRECISION", "!", "[\\d]+[\\s]+([A-Za-z]+)(!=|=)([\\d]+!\\/[\\d])")); // Valida Tipo de dato DOUBLE
        Tabla.add(new Identificadores("LOAD", "LOAD", "^[\\d\\s]+(LOAD)\\s\"([A-Za-z0-9-]+)\",R")); // Valida Tipo de LOAD
        Tabla.add(new Identificadores("SAVE", "SAVE", "^[\\d\\s]+(SAVE)\\s\"([A-Za-z0-9-]+)\",(A|P)")); // Valida Tipo de SAVE
        Tabla.add(new Identificadores("AUTO", "AUTO", "[\\d]+\\s{1}(AUTO)\\s?[\\d]+,\\s?[\\d]+")); // Valida Tipo de AUTO
        Tabla.add(new Identificadores("FOR", "FOR", "[\\d]+\\s{1}(FOR)\\s([A-Za-z]%?=\\d+)\\s?(TO)\\s?([A-Z]+)\\s?(STEP\\s?\\d+|)")); // Valida FOR
        Tabla.add(new Identificadores("GOTO", "GOTO", "[\\d]+\\s{1}(GOTO)\\s?\\d*")); // Valida GOTO

    }

    public boolean isSimbolo(String texto) {
        boolean estado = false;
        Datos objDatos = new Datos();

        for (Identificadores id : Tabla) {
            if (texto.matches(id.getRegex())) {
                estado = true;
                
                break;
            }

        }
        
        return estado;
    }

}
