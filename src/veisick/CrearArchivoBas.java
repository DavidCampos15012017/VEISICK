/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veisick;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author DAVID
 */
public class CrearArchivoBas 
{

    //String ruta = "C:/Ejemplo.bas";
    File file = new File( new File ("Ejemplo.bas").getAbsolutePath ());// Obtengo la ruta donde está el archivo .bas que es donde está el compilado
    BufferedWriter write;

    public void crearArchivoPcBasic(String texto) throws IOException {

        if (file.exists()) {
            write = new BufferedWriter(new FileWriter(file));
            write.write(texto);
            write.close();
        } else {
            write = new BufferedWriter(new FileWriter(file));
            write.write(texto);
            write.close();
        }
        
        String cmd ="C:\\Program Files (x86)\\PC-BASIC-1.2\\pcbasic.exe " + new File ("Ejemplo.bas").getAbsolutePath ();
        Runtime run = Runtime.getRuntime();
        Process proc = run.exec(cmd);

    }

}
