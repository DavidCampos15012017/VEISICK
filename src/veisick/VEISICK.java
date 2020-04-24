package veisick;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class VEISICK {

    public static void main(String[] args) throws IOException {
        // TODO code application logic here

        try {
            // Lee el archivo .veisick
            // muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
            JFileChooser selectorArchivos = new JFileChooser();
            FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo Veisick", "veisick");
            selectorArchivos.setFileFilter(filtro);
            selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

            int resultado = selectorArchivos.showOpenDialog(selectorArchivos);
            if (!filtro.accept(selectorArchivos.getSelectedFile())) {
                JOptionPane.showConfirmDialog(null, "¡ Error al abrir archivo !", "Error !", JOptionPane.PLAIN_MESSAGE);
            } else {
                File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

                if ((archivo == null) || (archivo.getName().equals(""))) {

                }

                Scanner leerArchivo = new Scanner(archivo);//new File(new File("Ecuaciones2doGrado.veisick").getAbsolutePath()));
                // Crea el analizador léxico.
                AnalizadorLexico objLexico = new AnalizadorLexico();
                // Creo el analizador de líneas para el archivo .veisick
                ValidaLineas objLineas = new ValidaLineas();
                // Comienzo la lectura del archivo
                boolean esValido = false;
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
                        if (esValido == false) {
                            break;
                        }
                    }

                }
                if (esValido) {
                    objBas.abrirArchivo();
                }
                //System.out.print("\"([A-Za-z0-9-]+).{1,}\"");
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: " + e.toString());
        }

    }

}
