package veisick;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.*;

/**
 *
 * @author DAVID
 */
public class CrearArchivoDeErrores {

    //String ruta = "C:/Ecuaciones2doGrado-errores.txt";
    File file = new File(new File("Ecuaciones2doGrado-errores.txt").getAbsolutePath()); //new File(ruta);
    BufferedWriter write;

    FileWriter fw;
    FileReader fr;
    int linea = 1;

    public void crearArchivo(String texto) throws IOException {
        try {
            // EL ARCHIVO EXISTE
            if (file.exists()) {

                // Escribir en el archivo:
                fw = new FileWriter(file.getAbsoluteFile(), true);
                fr = new FileReader(file);
                linea = extraeNumero()+1;
                write = new BufferedWriter(fw);
                write.write("\n" + linea+ " " + texto);
                write.close();

            } // EL ARCHIVO NO EXISTE (PRIMER INGRESO)
            else {
                write = new BufferedWriter(new FileWriter(file));
                write.write(linea + " " + texto);
                write.close();
            }
        } catch (IOException e) {
            System.err.println("ERROR");
        }
    }

    private int extraeNumero() {

        try {
            fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String reglon = "";
            while ((reglon = br.readLine()) != null) {
                //System.out.println(lines);
                Pattern pt = Pattern.compile("(^[\\d]+)");
                Matcher mt = pt.matcher(reglon);
                if (mt.find()) {
                    linea = Integer.parseInt(mt.group(1));
                }

                //System.out.println(lines);
            }
        } catch (Exception e) {
        }
        return linea;
    }
}
