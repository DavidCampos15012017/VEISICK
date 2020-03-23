/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veisick;

/**
 *
 * @author DAVID
 */
public class Datos {
    /* Propiedades: 
    *esSimbolo= True si está en la tabla de símbolos.
    *palabra: Extrae la palabra reservada.
    *Descripción: Detalle del error.
        
    */
    private boolean EsSimbolo;
    private String Palabra;
    private String Descripcion;

    public boolean isEsSimbolo() {
        return EsSimbolo;
    }

    public void setEsSimbolo(boolean EsSimbolo) {
        this.EsSimbolo = EsSimbolo;
    }

    public String getPalabra() {
        return Palabra;
    }

    public void setPalabra(String Palabra) {
        this.Palabra = Palabra;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
}
