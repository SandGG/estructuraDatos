//Suma de un arreglo recursivo
package p258;

import java.util.Scanner;

public class p258 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculos cal = new Calculos();
        
        int n = sc.nextInt();
        int [] numeros = new int [n];
        
        numeros = cal.llenarArreglo(numeros, (n - 1), sc);
        System.out.println(cal.sumarArreglo(numeros, (n - 1)));
    }
    
}

class Calculos {
    
    public int[] llenarArreglo(int [] num, int n, Scanner sc) {
        num[n] = sc.nextInt();
        if(n == 0) {
            return num;
        } else {
            return llenarArreglo(num, n - 1, sc);
        }
    }
    
    public int sumarArreglo(int [] num, int n) {
        if(n == 0) {
            return num[n];
        } else {
            return (num[n] + sumarArreglo(num, n - 1 ));
        }
    }
}