package ejercicio09;

import java.io.*;

public class BinToRanConverter {

    public static void makeFileChar(RandomAccessFile random, File readFile) throws IOException {

        String string;
        File fileAux = new File(readFile.toURI());
        boolean finished = false;
        int count=0;

        DataInputStream dataIS = new DataInputStream(new FileInputStream(readFile));

        while(true){

            try{
                //write the id
                random.write(++count);

                //write if its deleted
                random.writeBoolean(dataIS.readBoolean());

                //write the name
                string = dataIS.readUTF();
                writeString(random, string, 15);

                //write the phonenumber
                string = dataIS.readUTF();
                writeString(random,string,9);

                //write the address
                string = dataIS.readUTF();
                writeString(random,string,30);

                //write postal code
                random.write(dataIS.read());

                //write birthday
                string = dataIS.readUTF();
                writeString(random,string,10);

                //write if it's a debtor
                random.writeBoolean(dataIS.readBoolean());

                //write the debt
                random.writeDouble(dataIS.readDouble());

            }catch(EOFException e){
            }

        }





    }

    private static void writeString(RandomAccessFile random, String string, int max) throws IOException {
        if(string.length()<max){
            for(int i = 0; i < string.length(); i++){
                random.writeChar(string.charAt(i));
            }

            for(int i = max-string.length(); i < max; i++){
                random.writeChar(' ');
            }

        }else if(string.length()==max){
            for(int i = 0; i < string.length(); i++){
                random.writeChar(string.charAt(i));
            }
        }else{
            for(int i = 0; i < max; i++){
                random.writeChar(string.charAt(i));
            }
        }
    }
}
