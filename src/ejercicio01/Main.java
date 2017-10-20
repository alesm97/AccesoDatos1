package ejercicio01;

import java.io.File;

public class Main {

    public static void main(String[] args) {

        //File archivo = new File("C:\\pruebas\\uno.txt");
        File archivo = new File("uno.txt");

        System.out.printf("Nombre del archivo: %s%n¿Es ejecutable?: %b%n¿Está oculto?: %b%nRuta absoluta: %s%nRuta relativa: %s%nTamaño: %d",archivo.getName(),archivo.canExecute(),archivo.isHidden(),archivo.getAbsolutePath(),archivo.getPath(),archivo.length());

    }
}
