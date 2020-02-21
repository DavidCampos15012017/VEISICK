package veisick;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author DAVID
 */
public class CrearArchivoVeisick 
{
    //String ruta = "C:/Ecuaciones2doGrado-errores.txt";
    File file = new File( new File ("Ecuaciones2doGrado-errores.txt").getAbsolutePath ()); //new File(ruta);
    BufferedWriter write;
    public void crearArchivo(String texto) throws IOException
    {
        if(file.exists())
        {
            write = new BufferedWriter(new FileWriter(file));
            write.write(texto);
            write.close();
        }
        else
        {
            write = new BufferedWriter(new FileWriter(file));
            write.write(texto);
            write.close();
        }
    }
    
}
