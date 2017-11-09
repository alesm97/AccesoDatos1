package ejercicio15;

import com.google.gson.Gson;
import ejercicio08.PhonebookSer;
import ejercicio10.PhoneBookList;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Main15 {

    public static void main(String[] args) throws FileNotFoundException {
        Gson gson = new Gson();
        PhoneBookList list = gson.fromJson(new FileReader("prueba14.json"),PhoneBookList.class);

        printResult(list);

    }

    private static void printResult(PhoneBookList list) {

        printHeader();

        printUsers(list);

        printFooter();
    }

    private static void printUsers(PhoneBookList list) {
        for(PhonebookSer user:list.getList()){
            System.out.printf("\t\t%-20s %s\n","Nombre:",user.getName());
            System.out.printf("\t\t%-20s %s\n","Teléfono:",user.getPhoneNumber());
            System.out.printf("\t\t%-20s %s\n","Dirección:",user.getAddress());
            System.out.printf("\t\t%-20s %s\n","Código Postal:",user.getPostalCode());
            System.out.printf("\t\t%-20s %s\n","¿Es deudor?:",user.isDebtor());
            System.out.printf("\t\t%-20s %s\n","Fecha de nacimiento:",user.getBirthday());
            System.out.printf("\t\t%-20s %s\n","Deuda:",user.getDebt());

            printLine();
        }
    }

    private static void printHeader() {
        printLine();

        System.out.printf("%32s\n","AGENDA TELEFÓNICA");

        printLine();
    }

    private static void printFooter(){
        System.out.printf("%37s\n","FIN DE LA AGENDA TELEFÓNICA");
        printLine();
    }

    private static void printLine() {
        for (int i=0;i<50;i++){
            if(i!=49)
                System.out.printf("*");
            else
                System.out.println("*");
        }
    }
}
