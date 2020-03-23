package veisick;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class VEISICK {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        try {
            // Lee el archivo .veisick
            Scanner leerArchivo = new Scanner(new File(new File("Ecuaciones2doGrado.veisick").getAbsolutePath()));
            // Crea el analizador léxico.
            AnalizadorLexico objLexico = new AnalizadorLexico();
            // Creo el analizador de líneas para el archivo .veisick
            ValidaLineas objLineas = new ValidaLineas();
            // Comienzo la lectura del archivo
            boolean esValido=false;
            CrearArchivoBas objBas = new CrearArchivoBas();
            if (objLineas.validaLineas()) {
                while (leerArchivo.hasNextLine()) {
                    String line = "";

                    line = leerArchivo.nextLine(); // Leo la primer línea del archivo
                    line = line.replaceFirst("\\s{2,}", " ");
                    line = line.replaceFirst("PRINT\\s{1,}", "PRINT ");
                    line = line.replaceFirst("INPUT\\s{0,}", "INPUT ");
                    line = line.replaceFirst(" = ", "=").replaceFirst(" - ", "-");
                    line = line.replace(" ^ ", "^").replace(" * ", "*").replace(" / ", "/");
                    line = line.replace(" ( ", "(").replace(" ) ", ")").replace("B + ", "B+").replace(" <= ", "<=");
                    line = line.replace(", A", ",A").replace(", B", ",B").replace(", C", ",C");
                    esValido = objLexico.setTexto(line); // Envía el reglón.
                    if(esValido==false)
                        break;
                }
                
            }
            if(esValido)
            {
                objBas.abrirArchivo();
            }
            //System.out.print("\"([A-Za-z0-9-]+).{1,}\"");
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }

    }

}
