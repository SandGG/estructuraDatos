//Numeros complejos
package p291;

import java.text.DecimalFormat;
import java.util.Scanner;
public class P291 {
    public static void main(String[] args) { 
        Calculos oCal=  new Calculos();
        oCal.m_leer();
    }
}

class Calculos {  
    Scanner sc = new Scanner(System.in);  
    DecimalFormat df = new DecimalFormat("0.0");
    double entero = 0;
    double ima = 0;
    String res = "";

    void m_leer() {
        String str = "";
        boolean ban = true;
        //Leer hasta que no se reciba una linea
        while (ban) {
            try {
                str = sc.nextLine();
                m_analizar(str);
            } catch (Exception e) {
                ban = false;
            }
        }
    }   
    void m_analizar(String str) {
        String[] datos = str.split(" "); //Separar datos por espacio
        String[] datosAux = new String[4];
        int conta = 0;
        
        for (int i = 0; i < datos.length-1; i++) 
            if (!(datos[i].equalsIgnoreCase(""))) {
                datosAux[conta] = datos[i]; //Poblar arreglo auxiliar
                conta++;
            }
       
        //Parte real para numero 1
        double numReal1 = Double.parseDouble(datosAux[0]);
        
        //Parte imaginaria para numero 2
        String cadena = datosAux[1];
        String[] cad = cadena.split("i");
        double numIma1 = Double.parseDouble(cad[0]); //Obtener numero sin 'i'
        
        //Parte real para numero 1
        double numReal2 = Double.parseDouble(datosAux[2]);
        
        //Parte imaginaria para numero 2
        cadena = datosAux[3];
        cad = cadena.split("i");
        double numIma2 = Double.parseDouble(cad[0]);
        
        char c = str.charAt(str.length()-1);  
  
        if (c == 43) //Verificar si es '+'
            m_suma(numReal1, numIma1, numReal2, numIma2);
        else if (c == 45) //Verificar si es '-'
            m_resta(numReal1, numIma1, numReal2, numIma2);
        else if (c == 47) //Verificar si es '/'
            m_divi(numReal1, numIma1, numReal2, numIma2);
        else //Verificar si es '*'
            m_multi(numReal1, numIma1, numReal2, numIma2);
        
        System.out.println(m_imprimir());
    }
        
    void m_suma(double real1, double ima1, double real2, double ima2) {
        entero = real1 + real2;
        ima = ima1 + ima2;
    }
    
    void m_resta(double real1, double ima1, double real2, double ima2) { 
        entero = real1 - real2;
        ima = ima1 - ima2;
    }
    
    //Proceso para multiplicacion de numeros complejos
    void m_multi(double real1, double ima1, double real2, double ima2) {
        entero = real1 * real2 - ima1 * ima2;
        ima = real1 * ima2 + ima1 * real2;
    }
    
    //Proceso para division de numeros complejos
    void m_divi(double real1, double ima1, double real2, double ima2) {
        double numReal = real1 * real2 + ima1 * ima2;
        double numIma = ima1 * real2 - real1 * ima2;
        double denominador = Math.pow(real2, 2) + Math.pow(ima2, 2);
        entero = numReal / denominador;
        ima = numIma / denominador;
    }
    
    String m_imprimir() {
        String cadEntero = "";
        String cadIma = "";     
        
        //Aplicar formato de salida
        if(entero != (int)entero)
            cadEntero = Double.toString(Double.parseDouble(df.format(entero)));
        else
            cadEntero = String.valueOf((int)entero);
        if (ima != (int)ima)
            cadIma = Double.toString(Double.parseDouble(df.format(ima)));
        else
            cadIma = String.valueOf((int)ima);
        
        if (ima > 0)          
            res = cadEntero+" +"+cadIma+"i";
        else
            res = cadEntero+" "+cadIma+"i";         
        return res;
    }
}
