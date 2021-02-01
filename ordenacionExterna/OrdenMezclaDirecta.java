package ordenmezcladirecta;

import java.io.File;
import java.io.PrintStream;
import java.util.Scanner;

public class OrdenMezclaDirecta {
    
    public static void main(String[] args) {
        MezclaDirecta v_obj = new MezclaDirecta();
        File file = v_obj.crearArchivo("MainFile.txt");
        v_obj.escribirArchivoMain(file);
    }
}

class MezclaDirecta {
    
    File crearArchivo(String name) {
        File file = null;
        try {
            file = new File(name);
            file.createNewFile();
        } catch (Exception ex) {
            System.out.println("Error al crear archivo "+ ex.getMessage());
        }
        return file;
    }

    void escribirArchivoMain(File file) {
        PrintStream write = null;
        Scanner sc = new Scanner (System.in);
        long inicio = 0, fin = 0;
        int num;
        
        System.out.println("Ingrese la cantidad de datos a evaluar: ");
        num = sc.nextInt();
        try {
            write = new PrintStream(file);
            for (int i = 0; i < num; i++) {
                write.println((int) Math.floor(Math.random() * (1000 - 0 + 1) + 0));
            }
        } catch (Exception ex) {
            System.out.println("Error al escribir "+ ex.getMessage());
        } finally {
            write.close();
            inicio = System.currentTimeMillis();
            sort(file, num);
            fin = System.currentTimeMillis();
            System.out.println("Tiempo: "+ (fin - inicio) +" milisegundos\n");
        }
    }
    
    void sort(File file, int size) {
        File aux1 = crearArchivo("FileAux1.txt");
        File aux2 = crearArchivo("FileAux2.txt");
        for (int pass = 1; pass < size; pass *= 2) {
            merge(file, aux1, aux2, pass, size); 
            System.out.println("pass "+pass);
        }
        System.out.println("main");
        leerArchivoMain(file);
    }
    
    //Metodo sin terminar
    void merge(File file, File aux1, File aux2, int pass, int size) {
        //Poblar Archivos Aux 
        PrintStream writeAux1 = null;
        PrintStream writeAux2 = null;
        Scanner read = null;
        int conta = 0, tamAux1 = 0, tamAux2 = 0;
        try {
            writeAux1 = new PrintStream(aux1);
            writeAux2 = new PrintStream(aux2);
            read = new Scanner(file);

            while(read.hasNextInt()) {
                while (conta < pass && read.hasNextInt()) {
                    writeAux1.println(read.nextInt());
                    tamAux1++;
                    conta++;
                }
                conta = 0;
                while (conta < pass && read.hasNextInt()) {
                    writeAux2.println(read.nextInt());
                    tamAux2++;
                    conta++;
                }
                conta = 0;
            }
            System.out.println("aux1");
            leerArchivoMain(aux1);
            System.out.println("aux2");
            leerArchivoMain(aux2);
        } catch (Exception ex) {
            System.out.println("Error al escribir "+ ex.getMessage());
        } finally {
            writeAux1.close();
            writeAux2.close();
            read.close();
        }
        
        //Comparar y escribir
        Scanner readAux1 = null;
        Scanner readAux2 = null;
        int valor1 = 0, valor2 = 0;
        int contaAux1 = 0, contaAux2 = 0; //Para controlar las pasadas
        int cA1 = 0, cA2 = 0; //Para comparar con tamAux1 y tamAux2
        try {
            readAux1 = new Scanner(aux1);
            readAux2 = new Scanner(aux2);
            String str = "";
            
            //Leer datos iniciales
            valor1 = readAux1.nextInt();
            valor2 = readAux2.nextInt();
                    
            System.out.println("i: "+ tamAux1 + " j: " +tamAux2);
            while (tamAux2 > conta) {
                conta++;
                //Comparación inicial
                if (valor1 < valor2) {
                    str += valor1 + " "; //Escribir
                    contaAux1++; //Aumentar contaAux
                    cA1++; //Aumentar conta del archivo aux
                    if (readAux1.hasNextInt())
                        valor1 = readAux1.nextInt(); //Preparar el dato en la proxima posición
                } else {
                    str += valor2 + " ";
                    contaAux2++;
                    cA2++;
                    if (readAux2.hasNextInt()) {
                        valor2 = readAux2.nextInt();
                    }
                }
                
                //Sacar el resto cuando un contaAux alcanza a pass
                if (contaAux1 == pass) {
                    while (contaAux2 < pass) {
                        str += valor2 + " "; //Saca el dato
                        contaAux2++;
                        cA2++;
                        if (cA2 < tamAux2)
                            valor2 = readAux2.nextInt();//Preparar el dato en la proxima posición
                    }
                }
                
                if (contaAux2 == pass) {
                    while (contaAux1 < pass) {
                        str += valor1 + " "; //Saca el dato
                        contaAux1++;
                        cA1++;
                        if (cA2 < tamAux2)
                            valor1 = readAux1.nextInt();//Preparar el dato en la proxima posición
                    }
                }
                
                
                //Sacar restante de i y j
                
            }
            System.out.println("str final " + str);
        } catch(Exception e) {
            System.out.println("Error al leer: "+ e.getMessage());
        } finally {
            readAux1.close();
            readAux2.close();
        }
    }
    
    void leerArchivoMain(File file) {
        Scanner read = null;
        try {
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