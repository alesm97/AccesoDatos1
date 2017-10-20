package ejercicio03;

import java.io.File;

public class Ejercicio03 {

    public static void main(String[] args) {
        File file1 = new File("C:\\Users\\alesm97\\Google Drive\\Desarrollo de aplicaciones\\Segundo");

        showContent(file1);
    }

    public static void showContent(File file) {
        if (file.isDirectory()) {
            if (file.listFiles().length == 0) {
                System.out.printf("Nombre: %s | Tipo: %s%n", file.getName(), file.isDirectory() ? "directorio" : "fichero");
            } else {
                System.out.printf("Nombre: %s | Tipo: %s%n", file.getName(), file.isDirectory() ? "directorio" : "fichero");
                for (File fil : file.listFiles()) {
                    showContent(fil);
                }
            }
        } else {
            System.out.printf("Nombre: %s | Tipo: %s%n", file.getName(), file.isDirectory() ? "directorio" : "fichero");
        }
    }

}
