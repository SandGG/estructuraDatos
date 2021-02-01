//Maximo comun divisor
package p257;

import java.util.Scanner;

public class P257 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Calculos cal = new Calculos();
        
        int n = sc.nextInt(),a,b;
        
        while (n > 0) {
            a = sc.nextInt();
            b = sc.nextInt();
            System.out.println(cal.mcd(a, b));
            n--;
        }
    }
}

class Calculos {
    
    public int mcd(int a, int b) {
        System.out.println("modulo es "+a%b);
        if (a % b == 0) {
            return b;
        } else {
            return mcd(b,a % b);
        }
    }
}
