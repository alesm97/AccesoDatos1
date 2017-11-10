package ejercicio16;

import ejercicio15.Main15;
import utilidades.Teclado;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main16 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("prueba14.json"));
        String jsonString = reader.readLine(), nombre;
        Pattern patron;
        Matcher matcher;

        System.out.println("¿Qué nombre desea buscar?:");
        nombre = Teclado.leerString();

        patron = Pattern.compile("\"name\":\"(" + nombre + ")\",\"phoneNumber\":\"(.*?)\",\"address\":\"(.*?)\",\"postalCode\":(.*?),\"debtor\":(.*?),\"deleted\":(.*?),\"birthday\":[{]\"year\":(.*?),\"month\":(.*?),\"day\":(.*?)[}],\"debt\":(.*?)");

        matcher = patron.matcher(jsonString);

        while (matcher.find()) {
            Main15.printLine();
            System.out.printf("Nombre:  %s\n", matcher.group(1));
            System.out.printf("Teléfono: %s\n", matcher.group(2));
            System.out.printf("Dirección: %s\n", matcher.group(3));
            System.out.printf("Cód Postal: %s\n", matcher.group(4));
            System.out.printf("¿Es deudor?: %s\n", matcher.group(5).equals("true") ? "Sí." : "No");
            System.out.printf("Deuda: %s\n", matcher.group(10));
            System.out.printf("Fecha Nacimiento: %s\n", matcher.group(7), matcher.group(8), matcher.group(9));
        }
    }
}
