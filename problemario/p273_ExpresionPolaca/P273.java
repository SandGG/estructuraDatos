//Polaca
package p273;

import java.util.Scanner;

public class P273 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    } 
}

class Calculos {
    
    void m_leer() {
        Scanner sc = new Scanner (System.in);
        String str = "";
        boolean ban = true;
        
        //Forma de leer para que no se espere linea
        while (ban) {
            try {
                str = sc.nextLine();
                System.out.println(m_analizar(str));
            } catch (Exception e) {
                ban = false; //Sale del ciclo porque no encontro linea para leer
            }
        } 
    }
    
    String m_analizar (String p_cad) {
        char c;
        String str = "";
        int conta = 0;
        c = p_cad.charAt(conta); 
        while (c == 32) { //Para evitar leer un 'espacio'
            conta++;
            c = c = p_cad.charAt(conta); 
        }
        
        //Solo es necesario leer si empieza con un numero o letra
        if ((c >= 48 && c <= 57) || (c >= 65 && c <= 90) || (c >= 97 && c <= 122))
            str = "POSTFIJA";
        else
            str = "PREFIJA";
        return str;
    }
}
