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
        TablaSimbolos tabla = new TablaSimbolos();
        tabla.TablaSimbolos();
        try {
            if (tabla.isSimbolo(texto)) // Valida si es una palabra reservada.
            {

                objBas.crearArchivoPcBasic(texto);
                esValido = true;
                //System.out.println(texto);
            } 
            else {
                // Si no lo es, lo manda al archivo de error.
                System.out.println(texto);
                Pattern pt = Pattern.compile("(^[\\d]+)");
                Matcher mc = pt.matcher(texto);
                if (mc.find()) {
                    mensaje = "Error: En la línea " + mc.group(1) + ".";
                }
                archivodeError.crearArchivo(mensaje);
                esValido = false;
            }
        } catch (Exception e) {
        }
        return esValido;

    }

} //0136290
