package ejercicio04;

import utilidades.Teclado;

import java.io.File;

public class Ejercicio04 {

    public static void main(String[] args) {
       // File file1 = new File("C:\\Users\\alesm97\\Desktop\\Prueba Ejercicio 3");
        String extension,rute;

        System.out.println("Introduzca la ruta:");
        rute = Teclado.leerString();
        File file1 = new File(rute);
        System.out.println("Introduzca la extension:");
        extension = Teclado.leerString();

        Teclado.cerrarTeclado();

        Filter filter = new Filter(extension);

        for(File file:file1.listFiles(filter))
            System.out.println(file);


    }

}
