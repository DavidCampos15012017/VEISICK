/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veisick;

import java.util.Scanner;
import java.io.File;
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
    public static void main(String[] args) {
        // TODO code application logic here

        try {
            Scanner leerArchivo = new Scanner(new File("c:/Ecuaciones2doGrado.veisick"));

            String[] lista;
            String palabra = "";
            int j = 0;
            while (leerArchivo.hasNextLine()) {
                String line = leerArchivo.nextLine();
                // Cuando No Tenga PRINT

                // Cuando tenga PRINT:
                /* String regexPrint = "PRINT\\s{1,}";
                Pattern patPrint = Pattern.compile(regexPrint);
                Matcher matcherPrint = patPrint.matcher(line);*/
                line = line.replaceFirst("PRINT\\s{0,}", "PRINT");
                line = line.replaceFirst("INPUT\\s{0,}", "INPUT");
                line = line.replaceFirst(" = ","=").replaceFirst(" - ", "-");
                line=line.replace(" ^ ","^").replace(" * ", "*").replace(" / ", "/");
                                    
// lista = line.split("\\(([^()][^()]*)?\\)");    //,"----------------");
                System.out.println(line);
//                for (int m = 0; m < lista.length; m++) {
//                    System.out.println(lista[m]);
//                }
                /* String regexPrint = "\\(([^()][^()]*)?\\)";
               Pattern patPrint = Pattern.compile(regexPrint);
               Matcher match = patPrint.matcher(line);
                 */

                //System.out.println(line);//(line.replaceFirst("PRINT\\s{0,}", "PRINT").replaceFirst("INPUT\\s{0,}", "INPUT"));
                //  System.out.println(line.replaceFirst("INPUT\\s{0,}", "INPUT"));
                //
//                       // palabra = line.trim().replaceAll("\\s{1,}", "");
            }
        } //            for(int i =0; i<lista.length; i++)
        //                System.out.print(lista[i]);
        catch (Exception e) {
            System.out.println("Error: " + e.toString());
        }

    }

}
