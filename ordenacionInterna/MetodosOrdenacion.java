package metodosordenacion;

import java.util.Arrays;

public class MetodosOrdenacion {

    public static void main(String[] args) throws InterruptedException {
        metodosInternos metodo = new metodosInternos();
        long inicio, fin;
        int vector[] = new int[10000];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = (int)(Math.random() * 500 + 1);
        }
        System.out.println("Datos a ordenar: " +Arrays.toString(vector) +"\n");
        
        inicio = System.currentTimeMillis();
        metodo.burbuja(vector);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        
        inicio = System.currentTimeMillis();
        metodo.seleccion(vector);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        
        inicio = System.currentTimeMillis();
        metodo.insercion(vector);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        
        inicio = System.currentTimeMillis();
        metodo.shell(vector);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        
        inicio = System.currentTimeMillis();
        metodo.heap(vector);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        
        inicio = System.currentTimeMillis();
        metodo.quick(vector, 0, 1);
        fin = System.currentTimeMillis(); 
        System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");      
        
    }

}

class metodosInternos {

    void burbuja(int[] vector) {
        int aux;
        for (int i = 0; i < vector.length; i++) {
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[i] > vector[j]) {
                    aux = vector[i];
                    vector[i] = vector[j];
                    vector[j] = aux;
                }
            }
        }
        System.out.printf("%-10s %s \n", "Burbuja: ", Arrays.toString(vector));
    }  
    
    void insercion(int[] vector) {
        int aux;
        for (int i = 1 ; i < vector.length; i++) {
            aux = vector[i];
            for (int j = i - 1; j >= 0 && vector[j]> aux ; j --) {
                vector[j+1] = vector [j];
                vector[j] = aux;
            }
        }
        System.out.println("Insercion: "+Arrays.toString(vector));
    }
    
    void seleccion(int[] vector) {
        int aux;
        for (int i = 0; i < vector.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < vector.length; j++) {
                if (vector[j] < vector[min])
                    min = j;
            }
            if (i != min) {
                aux = vector[i];
                vector[i] = vector[min];
                vector[min] = aux;
            }
        }
        System.out.println("Selección: "+Arrays.toString(vector));
    }
    
    void heap(int vector[]) {
        int n = vector.length;
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(vector, n, i);
        for (int i = n - 1; i > 0; i--) {
            int temp = vector[0];
            vector[0] = vector[i];
            vector[i] = temp;
            heapify(vector, i, 0);
        }
        System.out.printf("%-10s %s \n", "Heap: ", Arrays.toString(vector));
    }
 
    void heapify(int vector[], int n, int i) {
        int largest = i; 
        int l = 2 * i + 1; 
        int r = 2 * i + 2; 
        if (l < n && vector[l] > vector[largest])
            largest = l;
        if (r < n && vector[r] > vector[largest])
            largest = r;
        if (largest != i) {
            int swap = vector[i];
            vector[i] = vector[largest];
            vector[largest] = swap;
            heapify(vector, n, largest);
        }
    }
    
    void shell(int[] vector) { 
        for ( int increment = vector.length / 2; increment > 0; increment = (increment == 2 ? 1 : (int) Math.round(increment / 2.2))) {
            for (int i = increment; i < vector.length; i++) {
                for (int j = i; j >= increment && vector[j - increment] >vector[j]; j -= increment) {
                    int temp = vector[j];
                    vector[j] = vector[j - increment];
                    vector[j - increment] = temp;
                }
            }
        } 
        System.out.printf("%-10s %s \n", "Shell: ", Arrays.toString(vector));
    }
    
    void quick(int vector[], int izq, int der) {
        int pivote = vector[izq]; 
        int i = izq;         
        int j = der;         
        int aux;

        while(i < j){                                                          
           while(vector[i] <= pivote && i < j) i++; 
           while(vector[j] > pivote) j--;           
           if (i < j) {                                           
               aux = vector[i];                      
               vector[i] = vector[j];
               vector[j] = aux;
           }
         }

         vector[izq] = vector[j];                                         
         vector[j] = pivote;      

         if(izq < j-1)
            quick(vector, izq, j-1);          
         if(j+1 < der)
            quick(vector, j+1, der); 
         System.out.printf("%-10s %s \n", "Quick: ", Arrays.toString(vector));
  }
}
