package ejercicio02;

import java.io.File;
import java.io.IOException;

public class Ejercicio02 {

    public static void main(String[] args) throws IOException {
        File file1 = new File(".//TestDir");
        File file2 = new File(file1,"text1.txt");
        File file3 = new File(file1,"text2.txt");
        File file4 = new File(file1,"text3.txt");
        File file5 = new File(file1,"InternDir");
        File file6 = new File(".//TestDir//InternDir//text4.txt");
        File[] files;


        file1.mkdir();
        file2.createNewFile();
        file3.createNewFile();
        file4.createNewFile();
        file5.mkdir();
        file5.createNewFile();
        file6.createNewFile();

        files=file1.listFiles();

        files[1].renameTo(new File (file1,"nuevoNombre.txt"));
        files[2].delete();

        System.out.println(file1.getAbsolutePath());

        for(String string:file1.list()){
            System.out.println(string);
        }

        for (String string:file5.list()){
            System.out.println(string);
        }



    }

}
