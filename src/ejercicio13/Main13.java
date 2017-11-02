package ejercicio13;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class Main13 {

    public static void main(String[] args) throws IOException, TransformerException {

        FileOutputStream os = new FileOutputStream("prueba13.html");
        Source estilos = new StreamSource("PhoneBookSheet.xsl");
        Source datos = new StreamSource("prueba10.xml");

        Result result = new StreamResult(os);

        Transformer transformer = TransformerFactory.newInstance().newTransformer(estilos);
        transformer.transform(datos,result);


        os.close();

    }


}
