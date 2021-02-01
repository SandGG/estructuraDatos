//Polimonio de Hermite
package p292;

import java.util.Scanner;

public class P292 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    }
    
}

class Calculos {
    
    Scanner sc = new Scanner(System.in);
    
    void m_leer(){	
        int num = sc.nextInt();
        sc.nextLine();
        m_printHermite(num);
    }
    
    void m_printHermite(int num){
        if (num > 0) {
            //n debe ser entero, proceso para evitar una exception
            try {
                String cad = sc.nextLine();
                String[] datos = cad.split(" ");
                int n = Integer.parseInt(datos[0]);
                double x = Double.parseDouble(datos[1]);
                
                //n no puede ser negativo
                if (n > 0) {
                    double res = m_calHermite(x, n);
                    System.out.println(imprimirdecimales1x1(res));
                } else {
                    System.out.println("null");
                }
            } catch (Exception e) {
                System.out.println("null");
            }        
            num--;
            m_printHermite(num);
        }
    }
    
    double m_calHermite(double x, int n){
	if (n == 0) 
            return 1;
	if (n == 1) 
            return 2 * x;
	return 2 * x * m_calHermite(x, n - 1) - 2 * (n - 1) * m_calHermite(x, n - 2);
    }
    
    //Decimales sin redondeo
    String  imprimirdecimales1x1(double resHermite) {
        String res = String.valueOf(resHermite);
        int dIndex = res.indexOf(".");
        String decimalString = res.substring(dIndex + 1);
        if (decimalString.length() > 2) 
            res = res.substring(0, dIndex + 3);
        else if (decimalString.length() == 1) 
            res = String.valueOf(res) + "0";           
        return res;
    }
}
