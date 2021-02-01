package deepsearch;

import java.util.Scanner;

public class DeepSearch {
    int [][] a_matriz; 
    String a_pila[];
    int a_tope;
    int []a_ruta;
    
    public static void main(String[] args) {
        DeepSearch  busqueda = new DeepSearch();
        busqueda.m_llenMatriz();
        busqueda.m_pideDatos();
    }
    
    String m_buscRuta (int p_Vi, int p_Vf) {
        a_ruta = new int [a_matriz.length];
        int v_cont, v_nivel, v_vActual;
        String v_arreglo[];
        String v_temporal;

        m_PUSH (p_Vi, 0);
        
        if (p_Vi > a_matriz.length || p_Vf > a_matriz.length)
            return " No hay ruta";
        
        do {
            v_temporal = m_POP();
            v_arreglo = v_temporal.split(" ");
            v_nivel = Integer.parseInt(v_arreglo[1]);
            v_vActual = Integer.parseInt(v_arreglo[0]);
            a_ruta[v_nivel] = v_vActual;
            if (v_vActual != p_Vf) 
                m_expaNodo(v_vActual, v_nivel);
        } while (v_vActual != p_Vf && a_tope > -1);
        
        for (v_cont = 0, v_temporal = ""; v_cont < a_matriz.length; v_cont++)
            v_temporal = v_temporal+" "+a_ruta[v_cont];
        if (v_temporal.equals(" 0 0 0 0 0 0 0"))
            v_temporal = " No hay ruta";
        return v_temporal;
    }
       
    void m_expaNodo(int p_nodoActual, int p_nivel) {
        int v_nodoColumna;
        for (v_nodoColumna = 0; v_nodoColumna < a_matriz.length; v_nodoColumna++)
        if (a_matriz[p_nodoActual][v_nodoColumna] > 0 && !m_enRuta(v_nodoColumna, p_nivel))
            m_PUSH(v_nodoColumna, p_nivel+1);
    }
    
    boolean m_enRuta(int p_nodoBuscado, int p_nivel) {
        while (p_nodoBuscado != a_ruta[p_nivel] && p_nivel > 0)
            p_nivel--;
        if (p_nodoBuscado == a_ruta[p_nivel]) return true;
        else return false;
    }
    
    String m_POP(){
        a_tope--;
        if(a_tope > -1)
            return a_pila[a_tope];
        else return "";
    }
    
    void m_PUSH(int dato, int nivel){
        if(a_tope < a_pila.length){
            a_pila[a_tope] = dato+" "+nivel;
            a_tope++;
        }
    }
    
    void m_pideDatos(){
        int Vi,Vf;
        Scanner v_teclado=new Scanner(System.in);
        System.out.print("Ingresa el vertice de inicio ");
        Vi=v_teclado.nextInt();
        System.out.print("Ingresa el vertice de Final ");
        Vf=v_teclado.nextInt();
        System.out.println("La ruta es :"+m_buscRuta(Vi,Vf)); 
    }
    
    void m_llenMatriz(){
        int temp[][]={{0,1,1,1,1,1,0,0,0,0,0,0},
                      {1,0,0,0,1,0,0,1,0,0,0,0},
                      {1,0,0,1,0,0,1,0,0,1,0,0},
                      {1,0,1,0,0,1,1,0,0,0,0,0},
                      {1,1,0,0,0,1,0,1,0,0,0,0},
                      {1,0,0,1,1,0,1,0,1,0,0,0},
                      {0,0,1,1,0,1,0,0,1,1,0,0},
                      {0,1,0,0,1,0,0,0,1,0,1,0},
                      {0,0,0,0,1,1,1,1,0,1,1,1},
                      {0,0,1,0,0,0,1,0,1,0,0,1},
                      {0,0,0,0,0,0,0,1,1,0,0,1},
                      {0,0,0,0,0,0,0,0,1,1,1,0}
        };
        a_tope=0;
        a_matriz=temp;
        a_pila = new String[a_matriz.length*a_matriz.length];
    }
  
}