package pruebaarchivos;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class PruebaArchivos {
    
    public static void main(String[] args) {
        MezclaDirecta v_obj = new MezclaDirecta();
        v_obj.crearArchivo();
        v_obj.escribirArchivo("test.txt");
    }
}

class MezclaDirecta {
    
    Scanner a_tec = new Scanner(System.in);
    
    void crearArchivo() {
        String name = "test.txt";
        File file = null;
        try {
            file = new File(name);
            file.createNewFile();
            escribirArchivo(name);
            leerArchivo(name);
        } catch (Exception ex) {
            System.out.println("Error al crear archivo "+ ex.getMessage());
        }
    }

    void escribirArchivo(String name) {
        File file = null;
        PrintStream write = null;
        try {
            file = new File(name);
            write = new PrintStream(file);
            write.println(55);
            write.println(11);
            write.println(66);
        } catch (Exception ex) {
            System.out.println("Error al escribir "+ ex.getMessage());
        } finally {
            write.close();
        }
    }
    
    void leerArchivo(String name) {
        File file = null;
        Scanner read = null;
        try {
            file = new File(name);
            read = new Scanner(file);
            while(read.hasNextInt()){
                System.out.println(read.nextInt());
            }      
        } catch(Exception e) {
            System.out.println("Error al leer: "+ e.getMessage());
        } finally {
            read.close();
        }
    }
}
