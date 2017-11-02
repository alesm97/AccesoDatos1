package ejercicio11;

import com.thoughtworks.xstream.XStream;
import ejercicio08.PhonebookSer;
import ejercicio10.PhoneBookList;

import java.io.*;

public class Main11 {

    public static void main(String[] args) {

        XStream xstream = new XStream();
        PhoneBookList listadoTodas=null;
        DataOutputStream dataOS = null;
        FileInputStream dataIS1 = null;
        FileInputStream dataIS2 = null;
        boolean done=false;
        int num1 = 0,num2 = 0;

        try {
            dataOS = new DataOutputStream(new FileOutputStream("salida11.txt"));
            dataIS1 = new FileInputStream("phonebookA.txt");
            dataIS2 = new FileInputStream("salida11.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        xstream.alias("ListaAgendaTelefonica", PhoneBookList.class);
        xstream.alias( "DatosPersona" , PhonebookSer.class);
        xstream.addImplicitCollection(PhoneBookList.class,"list");

        try {
            listadoTodas = (PhoneBookList) xstream.fromXML(new FileInputStream("prueba10.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        for(PhonebookSer list:listadoTodas.getList() ){
            try {
                dataOS.writeBoolean(list.isDeleted());
                dataOS.writeUTF(list.getName());
                dataOS.writeUTF(list.getPhoneNumber());
                dataOS.writeUTF(list.getAddress());
                dataOS.writeInt(list.getPostalCode());
                dataOS.writeUTF(list.getBirthday().toString());
                dataOS.writeBoolean(list.isDebtor());
                dataOS.writeDouble(list.getDebt());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        while(!done){
            try {
                num1 = dataIS1.read();
                num2 = dataIS2.read();
            } catch (IOException e) {
                System.out.println("Archivos iguales.");
            }

            if( num1 != num2){
                System.out.println("No son iguales.");
                done=true;
            }

        }


    }




}
