//Sumar a + b
package pkg1_suma;

import java.util.Scanner;

public class p1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculo cal = new Calculo();    
        int a = sc.nextInt(), b = sc.nextInt();       
        System.out.println(cal.suma(a,b));
    } 
}

class Calculo {
    
     public int suma(int num1, int num2){
        if(num2 > 0) {
            return suma(num1+1,num2-1);
        }
        return num1;
    }  
}
