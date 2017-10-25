package ejercicio09;


import java.io.*;

public class BinToRanConverter {

    public static void makeFileChar(RandomAccessFile random, File readFile) throws IOException {

        String string;
        File fileAux = new File(readFile.toURI());
        boolean finished = false;
        int count=0;

        DataInputStream dataIS = new DataInputStream(new FileInputStream(readFile));

        while(!finished){
            random.write(++count);

            string = dataIS.readUTF();

            for(int i = 0; i <string.length(); i++){
                random.writeChar(string.charAt(i));
            }

            string = dataIS.readUTF();
            for(int i = 0; i <string.length(); i++){
                random.writeChar(string.charAt(i));
            }

            random.write(dataIS.read());
            random.writeBoolean(dataIS.readBoolean());

            string = dataIS.readUTF();
            for(int i = 0; i <string.length(); i++){
                random.writeChar(string.charAt(i));
            }

            random.writeDouble(dataIS.readDouble());
        }





    }
}
