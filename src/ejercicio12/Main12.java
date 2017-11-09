package ejercicio12;

import java.io.*;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import org.xml.sax.helpers.DefaultHandler;


public class Main12 {

    public static void main(String[] args) throws SAXException, IOException, jdk.internal.org.xml.sax.SAXException {

        XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
        FileWriter writer = new FileWriter(new File("prueba12.txt"));
        GestorContenido gestor = new GestorContenido(writer);
        procesadorXML.setContentHandler(gestor);

        InputSource fileXML = new InputSource("prueba10.xml");

        procesadorXML.parse(fileXML);
        writer.close();

    }

    static class GestorContenido extends DefaultHandler {

        FileWriter writer;

        public GestorContenido(FileWriter writer) {
            super();
            this.writer = writer;
        }

        public void startDocument() {
            try {
                writer.write(String.format("Comienzo del Documento XML\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void endDocument() {
            try {
                writer.write("Final del Documento XML");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
            try {
                if (nombre.equals("ListaAgendaTelefonica")) {
                    writer.write(String.format("%s\n", nombre));
                } else if (nombre.equals("DatosPersona")) {
                    writer.write("Contacto ->");
                } else {
                    writer.write(String.format(" | %s: ", nombre));
                }
                for (int i = 0; i < atts.getLength(); i++) {
                    writer.write(String.format("(%s %s) ", atts.getQName(i), atts.getValue(i)));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void endElement(String uri, String nombre, String nombreC) {
            if (nombre.equals("debt")) {
                try {
                    writer.write(String.format("\n"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        public void characters(char[] ch, int inicio, int longitud) throws SAXException {
            String car = new String(ch, inicio, longitud);
            car = car.replaceAll("[\n\t\\s]", "");
            try {
                writer.write(String.format("%s", car));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
