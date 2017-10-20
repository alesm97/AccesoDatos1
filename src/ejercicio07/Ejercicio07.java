package ejercicio07;

import java.io.*;

public class Ejercicio07 {

    public static void main(String[] args) throws IOException {

        String key = "altramuz";
        Ejercicio07 executor = new Ejercicio07();
        File file1 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba7\\prueba.txt");
        File file2 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba7\\pruebaEncr.txt");
        File file3 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba7\\pruebaDesencr.txt");

        executor.encrypt(key,file1,file2);
        executor.desencrypt(key,file2,file3);

    }

    public void encrypt(String key, File fileToEncrypt, File fileEncrypted) throws IOException {

        FileReader reader = new FileReader(fileToEncrypt),readerAux = new FileReader(fileToEncrypt);
        FileWriter writer = new FileWriter(fileEncrypted);
        char[] keyChar;
        int counter = 0;

        keyChar = key.toCharArray();


        while(readerAux.read() != -1){
            writer.write(reader.read()+keyChar[counter]);
            counter++;
            if(counter==keyChar.length-1){
                counter=0;
            }
        }

        reader.close();
        writer.close();

    }

    public void desencrypt(String key, File fileToDesencrypt, File fileDesencrypted) throws IOException {
        FileReader reader = new FileReader(fileToDesencrypt),readerAux = new FileReader(fileToDesencrypt);
        FileWriter writer = new FileWriter(fileDesencrypted);
        char[] keyChar;
        int counter = 0;

        keyChar = key.toCharArray();


        while(readerAux.read() != -1){
            writer.write(reader.read()-keyChar[counter]);
            counter++;
            if(counter==keyChar.length-1){
                counter=0;
            }
        }

        reader.close();
        writer.close();
    }
}
