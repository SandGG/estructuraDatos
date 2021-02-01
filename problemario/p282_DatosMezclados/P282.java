//Datos mezclados, pila y cola
package p282;

import java.util.Scanner;

public class P282 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    }
    
}

class Calculos {
    
    void m_leer() {
        Scanner sc = new Scanner(System.in);
        int opc = sc.nextInt();
        String entrada;
        sc.nextLine();
        
        for (int i = 0; i < opc; i++) {
            entrada = sc.nextLine();
            m_analizar(entrada);
        }
    }

    void m_analizar(String entrada) {
        Pila pila = new Pila();
        Cola cola = new Cola();
        
        int num = 0, conta = 0;
        char digito, digitoAux;
        String resultados[] = new String[100];
        String res = "";
        
        for (int i = 0; i < entrada.length()-1; i++) { 
            digito = entrada.charAt(i);
            digitoAux = entrada.charAt(i + 1);
            
            //Proceso para saber si tenemos una pila o una cola
            if (digito == 80 && digitoAux == 85) {
                num = m_getNum(entrada, i);
                pila.m_PUSH(num);
            } else if (digito == 80 && digitoAux == 79) {
                num = pila.m_POP();
                if (num == 0)
                    resultados[conta] = "##";
                else
                    resultados[conta] = String.valueOf(num);
                conta++;
            } else if (digito == 76 && digitoAux == 76) {
                num = m_getNum(entrada, i);
                cola.m_llegada(num);
            } else if (digito == 83 && digitoAux == 65) {
                num = cola.m_salida();
                if (num == 0)
                    resultados[conta] = "$$";
                else
                    resultados[conta] = String.valueOf(num);
                conta++;
            }
        }
        
        //Liberar estructuras
        while (cola.a_actual != cola.a_conta) {
            resultados[conta] = String.valueOf(cola.m_printSalida());
            conta++;
        }
        
        while (pila.a_tope > 0) {
            resultados[conta] = String.valueOf(pila.m_printPOP());
            conta++;
        }
        
        //Formato de salida
        for (int i = 0; i < conta; i++) 
            if ((i+1) < conta)
                res = res + resultados[i] + ",";
            else
                res = res + resultados[i];  
        
        //Mostrar cadena
        System.out.println(res);
      
    } 
    
    //Obtener datos a evaluar si lo antecede un signo menos
    int m_getNum (String entrada, int i) {
        String dato = "";
        int num = entrada.charAt(i + 2);
        if (num == 45) { //El numero es negativo
            num = entrada.charAt(i + 3) - 48;
            num = num * -1; //Pasar el numero a char
        } else {
            dato = String.valueOf(num - 48);
            num = entrada.charAt(i + 3) - 48;
            dato = dato + String.valueOf(num);
            num = Integer.parseInt(dato);
        }
        return num;
    }
}

class Pila {    
    int a_tope = 0;
    int[] a_pila = new int[100];
    
    int m_POP(){
        a_tope--;        
        if(a_tope > -1)
            return a_pila[a_tope];
        else {
            a_tope++;
            return 0;
        }
    }
    
    void m_PUSH(int dato) {
        if(a_tope < a_pila.length){
            a_pila[a_tope] = dato;
            a_tope++;
        } 
    }
    
    int m_printPOP() {
        int pop = m_POP();
        if (pop != 0)
            return pop;
        return 0;
    }
}

class Cola {
   
    int a_conta = 0;
    int a_actual = 0;
    int[] a_cola = new int[100];
    
    int m_salida(){ 
        int aux = a_actual;
        if(a_actual < a_conta) {
            a_actual++;
            return a_cola[aux];
        } else {
            return 0;
        }
    }
    
    void m_llegada(int dato) {
        if(a_conta < a_cola.length){
            a_cola[a_conta] = dato;
            a_conta++;
        } 
    }
    
    int m_printSalida() {
        int sal = m_salida();
        if (sal != 0)
            return sal;
        return 0;
    }
}
