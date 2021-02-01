//Conteo de llamas recursivas
package p280;

import java.util.Scanner;

public class P280 {
    
    int conta = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        P280 oP280 = new P280();
        int v_opc = 0; 
        int opc = sc.nextInt(); 
        int[] res = new int[opc];
        
        do {
            res[v_opc] = oP280.m_fib(sc.nextInt());
            v_opc++;
        } while (v_opc < opc);
        for (int i = 0; i < res.length; i++)
            System.out.println(res[i]);
    } 
    int m_fib(int n) {
        conta++;
        int aux = conta;
        if (!(n <= 1)) 
            return m_fib(n - 1) + m_fib(n - 2);
        else 
            return m_retornar(aux);  
    }
    
    int m_retornar(int aux) {
        conta = 0;
        return aux;
    } 
}