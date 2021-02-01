//Pila restrictiva
package p269;

import java.util.Scanner;

public class P269 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_leer();
    }
    
}

class Calculos {
    
    int a_tope = 0;
    int[] a_pila = null;
    Scanner sc = new Scanner(System.in);
    
    void m_leer() {
        int tam = sc.nextInt();
        a_pila = new int[tam]; 
        
        m_escribirPila(); 
    }
    
    void m_escribirPila() {
        
        String []datos = new String[2]; //Corresponde a los datos de entrada
        
        for (int i = 0; i < 2; i++) {
            String entrada = sc.next();
            datos[i] = entrada; //Poblar entrada
            if (!(datos[i].equalsIgnoreCase("PUSH"))) //Verificar si se hace un PUSH
                i++;
        }
        
        if (datos[0].equalsIgnoreCase("POP")) {
            m_printPOP();
            m_escribirPila();
        } else if (datos[0].equalsIgnoreCase("FREE")) {
            for (int i = a_tope; i > 0; i--) {
                m_printPOP();
            }
        } else {
            int num = Integer.parseInt(datos[1]); 
            m_PUSH(num); 
            m_escribirPila();
        }  
    }
    
    void m_printPOP() {
        int pop = m_POP();
        if (pop < 0)
            System.out.println("UNDERFLOW");
        else
            System.out.println(pop);
    }
    
    int m_POP(){
        a_tope--;        
        if(a_tope > -1)
            return a_pila[a_tope];
        else {
            a_tope++;
            return -1;
        }
    }
    
    void m_PUSH(int dato){
        if (dato <= 99 && dato >= 1) {
            if(a_tope < a_pila.length){
            a_pila[a_tope] = dato;
            a_tope++;
        } else 
            System.out.println("OVERFLOW "+dato);
        } else {
            System.out.println("PUSH ERRONEO "+dato);
        }
    }
    
}