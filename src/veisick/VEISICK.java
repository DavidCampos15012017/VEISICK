package veisick;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VEISICK {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here args[0]

        try {
            if(args[0].endsWith(".veisick")) { //(args[0].endsWith(".veisick")) {

               //System.out.print(args[0]);
                if (args[0].matches("([A-Za-z]+[0-9-_]*)+\\.(veisick)")) {
                    // Lee el archivo .veisick
                    File archivo = new File(args[0]);//(args[0]);
                    Scanner leerArchivo = new Scanner(new File(archivo.getAbsolutePath()));
                    // Crea el analizador léxico.
                    AnalizadorLexico objAnalizadorLexico = new AnalizadorLexico();
                    // Creo el analizador de líneas para el archivo .veisick
                    ValidaLineas objLineas = new ValidaLineas();
                    // Comienzo la lectura del archivo
                    boolean esValido = false;
                    CrearArchivoBas objBas = new CrearArchivoBas();
                    if (objLineas.validaLineas(args[0])) {
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
                            esValido = objAnalizadorLexico.setTexto(line); // Envía el reglón.
                            if (esValido == false) {
                                break;
                            }
                        }

                    }
                    if (esValido) {
                        objBas.abrirArchivo();
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }

    }

}
