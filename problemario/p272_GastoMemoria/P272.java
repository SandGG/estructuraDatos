//Gasto de memoria
package p272;

import java.util.Scanner;

public class P272 {

    public static void main(String[] args) {
       Calculos oCal = new Calculos();
        oCal.m_leer();
    } 
}

class Calculos {
    
    Scanner sc = new Scanner(System.in);
    
    void m_leer() {
        boolean ban = true;
        int num;
        
        do {
            num = sc.nextInt(); //Casos de prueba
            if (num > 0 && num < 10)
                ban = false;
        } while (ban);
        
        for (int i = num; i > 0; i--) {
            System.out.println(m_ingresar());
        }
    }
    
    String m_ingresar() {
        int opc, suma = 0, auxNum = 0, conta = 1;
        String cad;
        char c;
        boolean ban = true;
        
        do {
            opc = sc.nextInt(); //Opciones dentro de casos de prueba
            if (opc > 0 && opc < 5)
                ban = false;
        } while (ban);
        
        int[][] numeros = new int[opc][3];

        for (int i = 0; i < opc; i++) {
            cad = sc.next();
            suma = m_suma(cad.charAt(0)); //Leer primer caracter para saber tipo de dato (primera vez)
            for(int j = 0; j < cad.length(); j++) {
                c = cad.charAt(j); 
                if (c == 44) { //Si es igual a ',' leer inicial en la posicion j+1 
                    if (j+i < (cad.length() - 1)){ //Verificar para evitar un error
                        conta++;
                        c = cad.charAt(j+1); //Asignar valor
                        suma = suma + m_suma(c); 
                    }             
                } 
            } 
            numeros[i][0] = i+1;
            numeros[i][1] = suma;
            numeros[i][2] = conta;
            
            conta = 1;
        } 
        
        //Verificar gasto
        auxNum = numeros[0][0];
        suma = numeros[0][1];
        conta = numeros[0][2];
        
        for (int m = 0; m < numeros.length - 1; m++) {
            if (suma > numeros[m + 1][1]) {
                auxNum = numeros[m + 1][0];
                suma = numeros[m + 1][1];
                conta = numeros[m + 1][2];
            } 
        }
            
        return "Algoritmo "+auxNum+" => "+suma+" bytes";
    }
    
    int m_suma(char c) {
        int suma = 0;
        switch (c) {
            case 'b': //byte/boolean
                suma = suma + 1;
            break;
            case 'c': //char
                suma = suma + 2;
            break;
            case 's': //short
                suma = suma + 2;
            break;
            case 'i': //int
                suma = suma + 4;
            break;
            case 'f': //float
                suma = suma + 4;
            break;
            case 'd': //double
                suma = suma + 8;
            break;
            case 'l': //long
                suma = suma + 8;
            break;
            case 'S': //String ¿16?
                suma = suma + 16;
            break;
        }
        return suma;
    }
  
}
