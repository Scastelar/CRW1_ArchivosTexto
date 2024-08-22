
package Archivos;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TestMiFile {
    static MiFile mf = new MiFile();
    static Scanner lea = new Scanner(System.in);
    
    public static void main(String[] args) {
        int opcion = 0;
        do {
        System.out.println("\nMENU\n");
        System.out.println("1. Set el archivo / folder.");
        System.out.println("2. Ver informacion.");
        System.out.println("3. Crear un archivo.");
        System.out.println("4. Crear un folder.");
        System.out.println("5. Borrar.");
        System.out.println("6. CMD - DIR");
        System.out.println("7. Tree");
        System.out.println("8. Escribir & Reemplazar");
        System.out.println("9. Escribir &/o Agregar");
        System.out.println("10. Salir.");
        System.out.println("Escoja una opcion: ");
        
        try{
        opcion = lea.nextInt();
        switch(opcion){
            case 1:
                set();
                break;
            case 2:
                mf.Info();
                break;
            case 3:
                mf.crearFile();
                break;
            case 4:
                mf.crearFolder();
                break;
            case 5:
                mf.borrar();
                break;
            case 6:
                mf.dir();
                break;
            case 7:
                mf.tree();
                break;
            case 8:
                
                break;
            case 9:
                
                break;
        } 
          
        } catch (InputMismatchException e){
            lea.nextLine();
            System.out.println("Porfavor ingrese una opcion correcta.");
        } catch (NullPointerException e){
            System.out.println("Debe seleccionar la opcion 1 por lo menos una vez.");
        } catch (IOException e){
            System.out.println("Error: " + e.getMessage());
        }
        
        } while (opcion != 10);
    }
        
    private static void set(){
        System.out.println("Direccion: ");
        mf.setFile(lea.next());
    }
}
