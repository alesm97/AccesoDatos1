package ejercicio06;

import java.io.*;

public class Ejercicio06 {

    public static void main(String[] args) throws IOException {

        File read = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba6\\read.txt");
        File out1 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba6\\out1.txt");
        File out2 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba6\\out2.txt");
        File out3 = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba6\\out3.txt");
        File finalFile = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba6\\final.txt");

        decompose(read,out1,out2,out3);
        recompose(out1,out2,out3,finalFile);
        System.out.println(checkEquality(read,finalFile));


    }

    public static void decompose(File read, File out1, File out2, File out3) throws IOException {

        char[] characters = new char[15];
        BufferedWriter[] writers = {new BufferedWriter(new FileWriter(out1)),new BufferedWriter(new FileWriter(out2)),new BufferedWriter(new FileWriter(out3))};
        BufferedReader reader = new BufferedReader(new FileReader(read));
        int charCountRead, charCountWrite, aux;
        boolean finished=false;

        //While remain chars to read
        while (!finished) {

            charCountRead = 0;

            //Copy 15 chars into the buffer from the file
            try {
                charCountRead = reader.read(characters, charCountRead, 15);
            } catch (IOException e) {
                e.printStackTrace();
            }

            charCountWrite = 0;

            for (int i = 0; i < 3; i++) {
                aux = 0;

                //Check if can copy 5 chars to avoid copying old chars
                if (charCountRead > 5) {
                    charCountRead -= 5;
                    aux = 5;
                } else {
                    aux = charCountRead;
                    charCountRead = 0;
                }

                try {
                    writers[i].write(characters, charCountWrite, aux);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                charCountWrite += aux;

            }

            //If it copy less than 5 chars, it means that the file copy has finished.
            if (charCountWrite < characters.length) finished = true;
        }

        reader.close();
        for(BufferedWriter writer:writers){
            writer.close();
        }

    }

    public static void recompose(File read1, File read2, File read3, File finalFile) {
        char[] characters = new char[15];
        boolean finished = false;
        int charCountRead,charCountWrite,aux;
        BufferedReader[] readers = null;

        try {
            readers = new BufferedReader[]{new BufferedReader(new FileReader(read1)),new BufferedReader(new FileReader(read2)),new BufferedReader(new FileReader(read3))};
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedWriter writer = null;

        try {
            writer = new BufferedWriter(new FileWriter(finalFile));
        } catch (IOException e) {
            e.printStackTrace();
        }

        //While remain chars to read
        while (!finished) {

            charCountRead = 0;

            //Copy 5 chars to each buff (3)
            try {
                charCountRead += readers[0].read(characters, charCountRead, 5);
                charCountRead += readers[1].read(characters, charCountRead, 5);
                charCountRead += readers[2].read(characters, charCountRead, 5);
            } catch (IOException e) {
                e.printStackTrace();
            }

            charCountWrite = 0;

            for (int i = 0; i < 3; i++) {
                aux = 0;

                //Check if can copy 5 chars to avoid copying old chars
                if (charCountRead > 5) {
                    charCountRead -= 5;
                    aux = 5;
                } else {
                    aux = charCountRead;
                    charCountRead = 0;
                }

                try {
                    writer.write(characters, charCountWrite, aux);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                charCountWrite += aux;

            }

            //If it copy less than 5 chars, it means that the file copy has finished.
            if (charCountWrite < characters.length) finished = true;
        }

        try {
            writer.close();
            for(BufferedReader reader:readers) {
                reader.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static boolean checkEquality(File file1, File file2) throws IOException {
        boolean equal = false;
        BufferedReader reader1 = null, readerAux = null, reader2 = null;

        try {
            reader1 = new BufferedReader(new FileReader(file1));
            readerAux = new BufferedReader(new FileReader(file1));
            reader2 = new BufferedReader(new FileReader(file2));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //Check line per line if a line from origin file is equals to the line from the other file.
        while(readerAux.readLine() != null){
            equal=reader1.readLine().equals(reader2.readLine());
            if(equal==false){
                return equal;
            }
        }

        return equal;
    }

}
