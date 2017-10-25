package ejercicio09;

import utilidades.Teclado;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio09 {

    public static void main(String[] args) {

        boolean finished = false;
        int menu,contact=0;
        File read = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba8\\phonebookA.txt");
        RandomAccessFile random = null;

        try {
            random = new RandomAccessFile(new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba9\\prueba9.txt"), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.printf("Creando archivo aleatorio a partir del binario.\n");

        try {
            BinToRanConverter.makeFileChar(random,read);
        } catch (IOException e) {
            e.printStackTrace();
        }


        do{
            System.out.printf("¿Qué desea hacer?\n\t1.- Consultar fichero entero.\n\t2.- Consultar contacto por id.\n\t3.- Añadir contacto.\n\t4.- Eliminar contacto\n\t5.- Modificar si debe dinero y la cantidad.\n\t6.- Compactar.\n\t7.- Salir");
            menu=Teclado.leerEntre(1,7, Teclado.Incluido.TODOS, Teclado.Tipos.INT);
            switch(menu){
                case 1:
                    showAllContacts();
                    break;
                case 2:
                    System.out.printf("Introduzca el identificador del contacto:\n");
                    Teclado.leerNumero(Teclado.Tipos.INT);
                    showContact(contact);
                    break;
                case 3:
                    addContact();
                    break;
                case 4:
                    deleteContact(contact);
                    break;
                case 5:
                    modifyDebt(contact);
                    break;
                case 6:
                    finished = true;
            }
        }while(!finished);

    }

    private static void showAllContacts() {
        while(true){

        }
    }

    private static void showContact(int contact) {
    }

    private static void addContact() {
    }

    private static void deleteContact(int contact) {
    }

    private static void modifyDebt(int contact) {


    }

}
