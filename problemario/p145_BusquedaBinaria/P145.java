//Busqueda binaria
package p145;

import java.util.Scanner;

public class P145 {
    
    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    }
}

class Calculos {

    int a_buscar = 0;
    
    void m_leer() {
        Scanner sc = new Scanner(System.in);
        boolean ban = true;
        int []entrada = new int[3];
        int conta = 0;
        int[]res = new int[100];
        
        do {      
            for (int i = 0; i < 3; i++) {
                int dato = Integer.parseInt(sc.next()); //Aprovechar next para separar por datos por espacio
                entrada[i] = dato; //Guardar datos
            }
            
            //Asignar datos
            int inf = entrada[0];
            int sup = entrada[1];
            a_buscar = entrada[2];
            
            //Si es 0 0 0 sale del programa
            if (inf == 0 || sup == 0 || a_buscar == 0)
                ban = false;
            else 
                res[conta] = m_escribirArreglo(inf, sup);       
            conta++;
        } while (ban);     
        for (int i = 0; i < conta - 1; i++)
            System.out.println(res[i]);
    }
    
    //Escribir arreglo auxiliar para evitar problemas con numeros negativos
    int m_escribirArreglo(int inf, int sup) {
        int tam = (sup - inf) + 1;
        int[] rango = new int[tam];    
        sup = rango.length;
        int con = 0;
        do {
            rango[con] = inf;
            inf++;
            con++;
        } while (con < sup);
        inf = 1;
        return m_busquedaBinaria(inf, sup, rango);      
    }
    
    //Proceso de busqueda binaria
    int m_busquedaBinaria(int inf, int sup, int[] rango){ 
        int vC = 0, conta = 0;
        boolean ban = false;
        do {
            conta++;
            vC = (sup + inf) / 2; //Asignar valor central

            if (inf == sup) {
                ban = true;
                if (rango[inf - 1] != a_buscar)
                    return -1; // No se encontro
            } else
            if(a_buscar > rango[vC - 1])
                inf = vC + 1; //Redefinir valor inferior
            else 
                sup = vC; //Redefinir valor superior
        } while (!((a_buscar == rango[vC - 1]) && ban));
        return conta;
    }
}