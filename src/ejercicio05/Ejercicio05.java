package ejercicio05;

import utilidades.Teclado;

import java.io.*;

public class Ejercicio05 {


    public static void main(String[] args) throws IOException {

        String startPath="",finishPath="";
        Boolean overwrite;

        do {
            System.out.println("Enter the origin rute (must be a file): ");
            startPath = Teclado.leerString();
        }while ((new File (startPath)).isDirectory());

        System.out.println("Enter the final rute(dir or file): ");
        finishPath = Teclado.leerString();

        overwrite=Teclado.leerBoolean("Enable overwrite mode? ","Yes","No");

        File file1 = new File(startPath);
        File file2 = new File(finishPath);

        copyFile(file1,file2,overwrite);
    }

    public static void copyFile(File file1, File file2, Boolean overwrite) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file1.getAbsolutePath()));
        BufferedWriter writer = null;
        File fileCreated;
        String line;


        //First we checked if the destination path is a dir or a file
        if(file2.isDirectory()) {

            //If it's a dir, we try to create a new file with the original file path in the destination path
            try {
                fileCreated = new File(String.format("%s\\%s",file2.getPath(),file1.getName()));

                fileCreated.createNewFile();

                //We initialize the writer with the file created previously
                writer = new BufferedWriter(new FileWriter(fileCreated));

            } catch (IOException e) {
                e.printStackTrace();
            }

            //read and copy line per line until there won't be one more line
            while(reader.read()!=-1) {
                writer.write(reader.readLine());
                writer.newLine();
            }
            System.out.println("File copied succesfully.");

        }else{
            //if it isn't a dir,
            writer = new BufferedWriter(new FileWriter(file2));
            if (file2.exists()) {
                if(overwrite){
                    while(reader.read()!=-1) {
                        writer.write(reader.readLine());
                        writer.newLine();
                    }
                    System.out.println("File overwrited succesfully.");
                }else{
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }else{
                if(overwrite){
                    try {
                        throw new Exception();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        reader.close();
        writer.close();

    }
}
