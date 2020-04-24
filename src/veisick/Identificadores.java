package veisick;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author DAVID
 */
public class Identificadores<token, lexema, Regex> {
    
    public  final String token;
    public  final String lexema;
    public  final String Regex;
    //public  final String mensaje;
    
    public  Identificadores(String token, String lexema, String Regex)
    {
        this.token = token;
        this.lexema = lexema;
        this.Regex = Regex;
    }

    public String getToken() {
        return token;
    }

    public String getLexema() {
        return lexema;
    }

    public String getRegex() {
        return Regex;
    }
  
    
}
