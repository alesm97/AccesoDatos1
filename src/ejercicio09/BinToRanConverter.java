package ejercicio09;

import java.io.*;

public class BinToRanConverter {

    public static void makeFileChar(RandomAccessFile random, File readFile) throws IOException {

        String string;
        int count=0;
        boolean finished = false;

        DataInputStream dataIS = new DataInputStream(new FileInputStream(readFile));

        while(!finished){

            try{
                //write the id
                random.writeInt(++count);
                //System.out.println(random.getFilePointer());

                //write if its deleted
                random.writeBoolean(dataIS.readBoolean());
                //System.out.println(random.getFilePointer());

                //write the name
                string = dataIS.readUTF();
                writeString(random, string, 15);
                //System.out.println(random.getFilePointer());

                //write the phonenumber
                string = dataIS.readUTF();
                writeString(random,string,9);
                //System.out.println(random.getFilePointer());

                //write the address
                string = dataIS.readUTF();
                writeString(random,string,30);
                //System.out.println(random.getFilePointer());

                //write postal code
                random.writeInt(dataIS.readInt());
                //System.out.println(random.getFilePointer());

                //write birthday
                string = dataIS.readUTF();
                writeString(random,string,10);
                //System.out.println(random.getFilePointer());

                //write if it's a debtor
                random.writeBoolean(dataIS.readBoolean());
                //System.out.println(random.getFilePointer());

                //write the debt
                random.writeDouble(dataIS.readDouble());
                //System.out.println(random.getFilePointer());

                //System.out.println("Contacto leído.");

                System.out.println(random.getFilePointer());

            }catch(EOFException e){
                System.out.println("Escritura terminada.");
                finished = true;
            }

        }

        dataIS.close();

    }

    protected static void writeString(RandomAccessFile random, String string, int max) throws IOException {
        if(string.length()<max){
            for(int i = 0; i < string.length(); i++){
                random.writeChar(string.charAt(i));
            }

            for(int i = 0; i < max-string.length(); i++){
                random.writeChar(' ');
            }

        }else{
            for(int i = 0; i < string.length(); i++){
                random.writeChar(string.charAt(i));
            }
        }
    }
}
