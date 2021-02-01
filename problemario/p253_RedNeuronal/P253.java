//red neuronal
package p253;

import java.util.Scanner;

public class P253 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    }
    
}

class Calculos {
    
    void m_leer() {
        Scanner sc = new Scanner(System.in);
        
        int num = sc.nextInt(); 
        double []entrada = new double[num];
        double dato;
        double []aux = new double[num];
        double sumatoria;
        
        for (int i = 0; i < entrada.length; i++) {
            dato = Double.parseDouble(sc.next()); 
            entrada[i] = dato; //Asignar valores al arreglo según valores de entrada
        }
        
        int casos = sc.nextInt();
        
        //Evaluar por numero de casos
        for (int i = 0; i < casos; i++) {
            for (int j = 0; j < aux.length; j++) {
                dato = Double.parseDouble(sc.next());
                aux[j] = dato; //Asignar valores al arreglo auxiliar
            }
            sumatoria = m_sumatoria(entrada, aux);
            
            //Redondeo a 2 decimas
            System.out.printf("%.2f %s\n",sumatoria, m_activacion(sumatoria , num));
        } 
    }
    
    double m_sumatoria(double[] entrada, double[] aux) {
        double sum = 0;
        for (int i = 0; i < entrada.length; i++) {
            sum += entrada[i] * aux[i];
        }
        return sum;
    }
    
    String m_activacion(double sumatoria, int num) {
        String str = "PASIVA";
        long numAct = Math.round(Math.abs(Math.sin(sumatoria * num))); // Obtener numero de activacion
        if (numAct > 0)
            str = "ACTIVA";
        return str;
    }
}
