/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veisick;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author DAVID
 */
public class VEISICK {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Formatter formato = new Formatter();
        try {
            // Carga el archivo:
            Scanner leerArchivo = new Scanner( new File(new File ("Ecuaciones2doGrado.veisick").getAbsolutePath ())); //new File("c:/Ecuaciones2doGrado.veisick"));

            String[] lista;
            String palabra = "";
            int contador =1;
            String texto=""; 
            String textoBas="";
            CrearArchivoVeisick crear = new CrearArchivoVeisick();
            CrearArchivoBas pcBasic = new CrearArchivoBas();
            while (leerArchivo.hasNextLine())
            {
                String line = leerArchivo.nextLine();
                line = line.replaceFirst("\\s{2,}"," ");
                line = line.replaceFirst("PRINT\\s{1,}", "PRINT");
                line = line.replaceFirst("INPUT\\s{1,}", "INPUT");
                line = line.replaceFirst(" = ","=").replaceFirst(" - ", "-");
                line=line.replace(" ^ ","^").replace(" * ", "*").replace(" / ", "/");
                line = line.replace(" ( ", "(").replace(" ) ", ")").replace("B + ", "B+").replace(" <= ", "<=");
                line= line.replace(", A",",A").replace(", B",",B").replace(", C",",C");
                textoBas +=line+"\n";
                texto +=contador+++" "+line+"\n";
                //System.out.println(line);

            }
            crear.crearArchivo(texto);
            pcBasic.crearArchivoPcBasic(textoBas);

        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }

    }

}
