/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veisick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author DAVID
 */
public class ValidaLineas {
    //String ruta = "C:/Ecuaciones2doGrado-errores.txt";

    public boolean validaLineas(String nombre) throws FileNotFoundException {
        boolean valor = false;
        int nuevaLinea = 0;
        int lineaAnterior = 0;
        // Lee el archivo .veisick
        Scanner leerArchivo = new Scanner(new File(new File(nombre).getAbsolutePath()));
        String reglon = "";
        while (leerArchivo.hasNextLine()) {
            
            try {

                reglon = leerArchivo.nextLine(); // Leo la primer línea del archivo
                Pattern pattern = Pattern.compile("(^[\\d]+)");
                Matcher matcher = pattern.matcher(reglon);
                if (matcher.find()) {
                    nuevaLinea = Integer.parseInt(matcher.group(1));
                }
                if (lineaAnterior < nuevaLinea) {
                    lineaAnterior = nuevaLinea;
                    valor = true;
                } else {
                    valor = false;
                    CrearArchivoDeErrores error = new CrearArchivoDeErrores();
                    error.crearArchivo("Error: la línea " + nuevaLinea+" no es un número de línea consecutivo válido");
                    break;
                }

            } catch (Exception e) {

            }

        }
        return valor;
    }
}
