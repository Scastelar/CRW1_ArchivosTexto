package Archivos;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;


public class MiFile {
    private File mf = null;
    
    public void setFile(String dir) {
        mf = new File(dir);
        System.out.println("SetFile: Path absoluto = " + mf.getAbsolutePath());
    }
    
    public void Info() {
        if (mf != null && mf.exists()) {
            System.out.println("\nSI EXISTE:\n----------------");
            System.out.println("Nombre: " + mf.getName());
            System.out.println("Path: " + mf.getPath());
            System.out.println("Absoluta: " + mf.getAbsolutePath());
            System.out.println("Padre: " + mf.getAbsoluteFile().getParentFile().getName());
            System.out.println("Bytes: "+ mf.length());
            if (mf.isFile()){
                System.out.println("ES UN ARCHIVO");
            if (mf.isDirectory()){
                System.out.println("ES UN FOLDER");
            System.out.println("Ultima modificacion: " + new Date(mf.lastModified()));
                    }
            }
        } else {
            System.out.println("Aun no existe o el path es incorrecto.");
        }
    }     
            
    public void crearFile () throws IOException {
        if (mf != null && mf.createNewFile()) {
            System.out.println("Creado exitosamente: " + mf.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear o ya existe: " + mf.getAbsolutePath());
        }
    }
    
    public void crearFolder() {
        if (mf != null && mf.mkdirs()) {
            System.out.println("Creado exitosamente: " + mf.getAbsolutePath());
        } else {
            System.out.println("No se pudo crear o ya existe: " + mf.getAbsolutePath());
        }
    }
    
    private boolean antidoto(File file) {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                antidoto(child);
            }
        }
        return file.delete();
    }
    
    public void borrar() {
         if (mf != null && antidoto(mf)) {
             System.out.println("SE BORRO: " + mf.getAbsolutePath());
         } else {
             System.out.println("NO SE BORRO: " + mf.getAbsolutePath());              
         }
    }
    
    public void dir() {
        if (mf != null && mf.isDirectory()) {
            System.out.println("Directorio de: " + mf.getAbsolutePath());
            System.out.println("");
            int cfiles=0, cdirs=0, tbytes=0;
            
            for (File child : mf.listFiles()) {
                if (!child.isHidden()) {
                    Date ultima = new Date(child.lastModified());
                    System.out.print(ultima + "\t");
                    
                    if (child.isDirectory()) {
                        cdirs++;
                        System.out.print("<DIR>\t\t");
                    } else {
                        cfiles++;
                        tbytes += child.length();
                        System.out.print("     \t" + child.length() + "\t");
                    }
                    System.out.println(child.getName());
                }
            }
            System.out.println(cfiles + " archivos\t" + tbytes + " bytes" + "\n" + cdirs + " dirs");
        }
    }
    
    public void tree() {
        if (mf != null) {
            tree(mf, "-");
        }
    }
    
    private void tree(File dir, String tab) {
        if (dir.isDirectory()) {
            System.out.println(tab + dir.getName());
            for (File child : dir.listFiles()) {
                if (!child.isHidden()) {
                    tree(child, tab + "--");
                }
            }
        }
    }
    
    public void escribirReemplazar(String dir, String msg){
        FileWriter wr = null;
    }
    
    
}
