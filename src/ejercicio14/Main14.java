package ejercicio14;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import ejercicio08.PhonebookSer;
import ejercicio10.PhoneBookList;
import org.xml.sax.SAXException;

import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Main14 {

    public static void main(String[] args) throws SAXException, IOException {
        XStream xstream = new XStream();
        PhoneBookList listadoTodas = null;
        Gson gson = new Gson();
        String gsonResult;
        FileWriter writer = new FileWriter("prueba14.json");

        xstream.alias("ListaAgendaTelefonica", PhoneBookList.class);
        xstream.alias( "DatosPersona" , PhonebookSer.class);
        xstream.addImplicitCollection(PhoneBookList.class,"list");

        listadoTodas = (PhoneBookList) xstream.fromXML(new FileInputStream("prueba10.xml"));

        gsonResult = gson.toJson(listadoTodas);

        System.out.println(gsonResult);

        writer.write(gsonResult);

        writer.close();
    }

}
