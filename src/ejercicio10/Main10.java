package ejercicio10;

import com.thoughtworks.xstream.XStream;
import ejercicio08.PhonebookSer;

import java.io.*;

public class Main10 {

    public static void main(String[] args) {

        ObjectInputStream dataIS=null;
        boolean done=false;
        XStream xstream = new XStream();
        PhoneBookList list = new PhoneBookList();

        try {
            dataIS = new ObjectInputStream(new FileInputStream(new File("phonebook.txt")));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        while (!done){
            try {
                PhonebookSer user = (PhonebookSer) dataIS.readObject();
                list.add(user);
            } catch (EOFException eo) {
                done=true;
            } catch (IOException e) {
                e.printStackTrace();
                done=true;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                done=true;
            }
        }

        try {
            dataIS.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        xstream.alias("ListaAgendaTelefonica", PhoneBookList.class);
        xstream.alias( "DatosPersona" , PhonebookSer.class);
        xstream.addImplicitCollection(PhoneBookList.class,"list");

        try {
            xstream.toXML(list,new FileOutputStream("prueba10.xml"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("Creado fichero XML .... ");

    }





    }
