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
public class TablaSimbolosGWBasic {

    ArrayList<Identificadores> Tabla = new ArrayList<Identificadores>();

    // Crea la tabla de símbolos.
    public void TablaSimbolos() {
        // Identificadores(token, lexema, Regex)
        Tabla.add(new Identificadores("LOAD", "LOAD", "^[\\d\\s]+(LOAD)\\s\"([A-Za-z0-9-]+)\",R")); // Valida Tipo de LOAD
        Tabla.add(new Identificadores("BEEP", "BEEP", "[\\d]+\\s+(IF)\\s+([A-Z]+\\s*[(+|-|>|<|=)]\\s*[\\d]+)\\s+(THEN)\\s+(BEEP)"));
        Tabla.add(new Identificadores("PRINT", "PRINT", "^[\\d]+\\s+(PRINT)\\s*(\\\"([A-Za-z0-9-+=\\s]+)\\\"\\;*\\s*([A-Z0-9]+)*\\s*)?$"));
        Tabla.add(new Identificadores("INPUT", "INPUT", "^[\\d\\s]+(INPUT)\\s\".*([A-Za-z0-9-]+).*"));
        Tabla.add(new Identificadores("REM", "REM", "[\\d]+\\s+(REM)\\s+.*")); // Valida REM
        Tabla.add(new Identificadores("LET", "LET", "[\\d]+\\s+(LET)*\\s*((([A-Z])([0-9])*){1,20})\\s*\\=\\s*\\\"*([\\(\\)A-Za-z0-9-+\\/^\\*\\s]*)\\\"*"));// LET
        Tabla.add(new Identificadores("IF", "IF", "([\\d])*\\s*(IF)\\s*\\((\\s*(|\\+|\\-)[A-Z0-9]\\s*(<|>|<=|=>|=)\\s*[A-Z0-9]\\s*)*(\\|\\|)*(\\s*(|\\+|\\-)[A-Z0-9]\\s*(<|>|<=|=>)\\s*[A-Z0-9]\\s*)*\\)\\s*(THEN)\\s+([A-z0-9])+\\s*")); // Valida IF
        Tabla.add(new Identificadores("CLS", "CLS", "^[\\d\\s]+(CLS)\\s*")); // Valida CLS
        Tabla.add(new Identificadores("STRING", "STRING", "^[\\d\\s]+([A-Za-z0-9-]+)\\$=\"([A-Za-z0-9-]+)\"")); // Valida Tipo de dato String
        Tabla.add(new Identificadores("INT", "%", "^[\\d\\s]+([A-Za-z0-9-]+)\\%=([\\d])")); // Valida Tipo de dato INT
        Tabla.add(new Identificadores("DOUBLE-PRECISION", "#", "^[\\d\\s]+([A-Za-z0-9-]+)(#=|=#)([\\d]/[\\d])")); // Valida Tipo de dato DOUBLE
        Tabla.add(new Identificadores("SIMPLE-PRECISION", "!", "[\\d]+[\\s]+([A-Za-z]+)(!=|=)([\\d]+!\\/[\\d])")); // Valida Tipo de dato DOUBLE
        Tabla.add(new Identificadores("SAVE", "SAVE", "^[\\d\\s]+(SAVE)\\s\"([A-Za-z0-9-]+)\",(A|P)")); // Valida Tipo de SAVE
        Tabla.add(new Identificadores("AUTO", "AUTO", "[\\d]+\\s{1}(AUTO)\\s?[\\d]+,\\s?[\\d]+")); // Valida Tipo de AUTO
        Tabla.add(new Identificadores("FOR", "FOR", "[\\d]+\\s{1}(FOR)\\s([A-Za-z]%?=\\d+)\\s?(TO)\\s?([A-Z]+)\\s?(STEP\\s?\\d+|)")); // Valida FOR
        Tabla.add(new Identificadores("GOTO", "GOTO", "^[\\d]+\\s+(GOTO)\\s*[\\d]*$")); // Valida GOTO 
        Tabla.add(new Identificadores("END", "END", "^[\\d]+\\s+(END)\\s?$")); // Valida END
        Tabla.add(new Identificadores("ABD", "ABS", "[\\d]+\\s{1}(ABS)\\(([A-Za-z0-9-\\s\\+\\-\\*\\\\\\^]+)+\\)"));
        Tabla.add(new Identificadores("ASC", "ASC", "[\\d]+\\s+([A-Za-z0-9]+)\\s+(ASC)\\((X\\$)\\)"));
        Tabla.add(new Identificadores("AUTO", "AUTO", "[\\d]+\\s+(AUTO)*\\s+([\\d]|\\.)+\\,\\s*[\\d]+"));
        Tabla.add(new Identificadores("BLOAD", "BLOAD", "[\\d]+\\s+(BLOAD)\\s*\\\"(PICTURE)\\\"\\,\\s*[\\d]+"));
        Tabla.add(new Identificadores("BSAVE", "BSAVE", "[\\d]+\\s+(BSAVE)\\s*\\\"(PICTURE)\\\"\\,\\s*[\\d]+\\,\\s+[\\d]+"));
        Tabla.add(new Identificadores("CALL", "CALL", "[\\d]+\\s+(CALL)\\s+((([A-Z])([0-9])*){1,20})\\(((([A-Z])([0-9$%¡#])*){1,20})\\,\\s*((([A-Z])([0-9$%¡#])*){1,20})\\s*\\,\\s*((([A-Z])([0-9$%¡#])*){1,20})\\)"));
        Tabla.add(new Identificadores("CDBL", "CDBL", "\\s+(CDBL)\\s*\\(((([A-Z])([0-9$%¡#])*){1,20})\\)"));
        Tabla.add(new Identificadores("CHAIN", "CHAIN", "[\\d]+\\s+(CHAIN)*\\s+\\\"((([A-Z])([0-9$%¡#])*){1,20})\\\"\\,\\s+[\\d]+"));
        Tabla.add(new Identificadores("CHDIR", "CHDIR", "(CHDIR)\\s*\\\"([A-Z0-9$%¡#:]*)\\\""));
        Tabla.add(new Identificadores("CHR", "CHR", "(CHR\\$)\\([\\d]+\\)\\;"));
        Tabla.add(new Identificadores("CINT", "CINT", "(CINT\\([\\d]+\\.*[\\d]*)"));
        Tabla.add(new Identificadores("CLOSE", "CLOSE", "[\\d]+\\s(CLOSE)"));
        Tabla.add(new Identificadores("CLS", "CLS", "[\\d]+\\s(CLS)\\s*(0|1|2|)"));
        Tabla.add(new Identificadores("COLOR", "COLOR", "\\s*(COLOR)\\s*1,\\s*2\\,\\s3\\s+\\'[A-Za-z0-9=\\,\\s]*"));
        Tabla.add(new Identificadores("COM", "COM", "(COM)\\((1|2)\\)\\s+(ON)"));
        Tabla.add(new Identificadores("CONT", "CONT", "(CONT)"));
        Tabla.add(new Identificadores("COS", "COS", "(COS)\\(((([A-Z0-9.$%¡#])*){1,20})\\)"));
        Tabla.add(new Identificadores("CSNG", "CSNG", "(CSNG)\\s*\\(((([A-Z])([0-9$%¡#])*){1,20})\\)"));
        Tabla.add(new Identificadores("CVS", "CVS", "(CVS)\\(((([A-Z])([0-9$%¡#])*))\\)"));
        Tabla.add(new Identificadores("CVI", "CVI", "(CVI)\\(((([A-Z])([0-9$%¡#])*))\\)"));
        Tabla.add(new Identificadores("CVD", "CVD", "(CVD)\\(((([A-Z])([0-9$%¡#])*))\\)"));
        Tabla.add(new Identificadores("DATA", "DATA", "[\\d]+\\s(DATA)\\s*([\\d]+\\.[\\d]*\\,*)+"));
        Tabla.add(new Identificadores("DATE", "DATE", "((DATE\\$)|v\\$)\\=(v\\$|(DATE\\$))"));
        Tabla.add(new Identificadores("DEF", "DEF", "([\\d]+)\\s+(DEF)\\s+(FN)((([A-Z])([0-9$%¡#])*){1,20})\\(((([A-Z])([0-9$%¡#])*){1,20})\\,\\s+((([A-Z])([0-9$%¡#])*){1,20})\\)\\=\\s*((([A-Z])([0-9$%¡#^/\\*\\+\\-])*){1,20})"));
        Tabla.add(new Identificadores("DBL", "DBL", "[\\d]+\\s+(DEF)(DBL|INT|SNG|STR)\\s+"));
        Tabla.add(new Identificadores("DELETE", "DELETE", "(DELETE)\\s+((|-)[\\d]+(-|))+"));
        Tabla.add(new Identificadores("DIM", "DIM", "[\\d]+\\s+(DIM)\\s+(\\s*((([A-Z])([0-9$%¡#])*){1,20})\\([\\d]+\\)\\,*)+"));
        Tabla.add(new Identificadores("DRAW", "DRAW", "[\\d]+\\s+(DRAW)\\s+\\\"([A-Z0-9;\\s]+)+\\\""));
        Tabla.add(new Identificadores("EDIT", "EDIT", "\\s*(EDIT)\\s+[\\d]+"));
        Tabla.add(new Identificadores("ENVIRON", "ENVIRON", "(ENVIRON)\\s+\\\"(([A-Z0-9:\\\\;=\\s]+))*"));
        Tabla.add(new Identificadores("EOF", "EOF", "(EOF)\\([\\d]+\\)"));
        Tabla.add(new Identificadores("ERASE", "ERASE", "[\\d]+\\s+(ERASE)\\s(((([A-Z])([0-9$%¡#])*){1,20})\\,*\\s*)+"));
        Tabla.add(new Identificadores("ERASE", "ERASE", "(ERDEV)(\\$|)"));
        Tabla.add(new Identificadores("ERL", "ERL", "((ERR)|(ERL))\\s*\\=\\s*((([A-Za-z])([0-9$%¡#])*){1,20})"));
        Tabla.add(new Identificadores("ERROR", "ERROR", "\\s+(ERROR)\\s+"));
        Tabla.add(new Identificadores("EXTERR", "EXTERR", "\\s+(EXTERR)(0|1|2|3)\\s+"));
        Tabla.add(new Identificadores("FIELD", "FIELD", "(FIELD)\\s+([\\d]*\\,\\s+)*(\\s*[\\d]+\\s+(AS)\\s+([A-Z$\\,*]+))*"));/**/ 
    }

    public boolean isSimbolo(String texto) {
        boolean estado = false;
        for (Identificadores id : Tabla) {
            
            if (texto.matches(id.getRegex())) {
                estado = true;
                break;
            }
           
        }
        
        return estado;
    }

}
