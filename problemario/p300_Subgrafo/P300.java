//Subgrafos
package p300;

import java.util.Scanner;

public class P300 {

    public static void main(String[] args) {
        Calculos oCal = new Calculos();
        oCal.m_llenarMatriz();
    }
}

class Calculos {    
    Scanner sc = new Scanner(System.in);
    int[][] matriz = null;  
    
    void m_llenarMatriz() {
        int tam = sc.nextInt();
        matriz = new int[tam][tam]; 
        for (int x=0; x < matriz.length; x++) {
            for (int y=0; y < matriz[x].length; y++) {
                matriz[x][y] = sc.nextInt(); //Poblar matriz
            }
        }
        sc.nextLine();

        m_leer("null"); //Primera vez que se llama el metodo 
    }
    
    //Leer cada linea
    void m_leer(String str) {
        try {
            str = sc.nextLine();
            System.out.println(m_analizar(str));
            m_leer(str);
        } catch (Exception e) {
        }
    }
    
    String m_analizar (String p_cad) {
        String str = "";
        String[] datos = p_cad.split(" "); //Separar por espacios
        String inicio = datos[0];
        String fin = datos[datos.length-1];
        boolean ban = m_buscRuta(datos); //Validar si la ruta existe
        
        if (ban)
            if (inicio.equalsIgnoreCase(fin)) //Si inicio es igual a fin
                str = "CIRCUITO";
            else 
                str = "CAMINO";
        else
            str = "NO SUBGRAFO";
        return str;
    }
    
    boolean m_buscRuta (String[] datos) {
        boolean ban = true;
        char c;
        String str;
        int[] num = new int[datos.length];
        
        //Proceso para pasar las letras a numeros
        for (int i = 0; i < datos.length; i++) {
            str = datos[i].toUpperCase();
            c = str.charAt(0);
            num[i] = c - 65; //Se le resta el valor que tiene 'A'
            if (num[i] >= matriz.length)
                return false; //No es subgrafo
        } 
        for (int j = 0; j < num.length - 1; j++) {
            if (!((matriz[num[j]][num[j + 1]] != 0))) {
                ban = false; //No hay ruta
            }
        }      
        return ban;
    }

}
