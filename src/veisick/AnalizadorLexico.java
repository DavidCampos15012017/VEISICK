package veisick;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.*;

public class AnalizadorLexico {

    String mensaje = "";

    CrearArchivoDeErrores archivodeError = new CrearArchivoDeErrores();
    CrearArchivoBas objBas = new CrearArchivoBas();

    public boolean setTexto(String texto) {
        boolean esValido = false;
        String mensaje = "";
        TablaSimbolos tablaVesicik = new TablaSimbolos();
        tablaVesicik.TablaSimbolos();
        TablaSimbolosGWBasic tablaGwBasic = new TablaSimbolosGWBasic();
        tablaGwBasic.TablaSimbolos();
        try {
            Pattern pt = Pattern.compile("(^[\\d]+)");
            Matcher mc = pt.matcher(texto);
            if (mc.find()) {
                if (tablaVesicik.isSimbolo(texto)) // Valida si es una palabra reservada de Veisick
                {

                    objBas.crearArchivoPcBasic(texto);
                    esValido = true;
                    // System.out.println(texto);
                } else {
                    if (tablaGwBasic.isSimbolo(texto)) // Valida si es reservada de GW-Basic
                    {
                        mensaje = "Advertencia (línea " + mc.group(1) + "): instrucción <" + texto + "> no es soportada por esta versión.";
                        archivodeError.crearArchivo(mensaje);
                        esValido = false;

                    } else {
                        mensaje = "ERROR (línea" + mc.group(1) + "): <" + texto + "> no es una instrucción válida de VEISICK ni de GW-BASIC.";
                        archivodeError.crearArchivo(mensaje);
                        esValido = false;
                    }

                }
            }
            
        } catch (Exception e) {
        }
        return esValido;

    }

} 
