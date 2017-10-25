package ejercicio08;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Ejercicio08c {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean deleted1 = false, deleted2 = false, deleted3 = false, deleted4 = false, deleted5 = false;
        PhonebookSer regist1 = new PhonebookSer(deleted1,"Alex","615101488","Vicente Aleixandre",11204,false, LocalDate.of(2014, Month.APRIL,25),0);
        PhonebookSer regist2 = new PhonebookSer(deleted2,"Nano","615584769","Vicente Aleixandre",11548,false, LocalDate.of(2014, Month.APRIL,25),0);
        File outFile = new File("C:\\Users\\alesm97\\IdeaProjects\\Unidad 1\\src\\AccesoDatos\\prueba8\\phonebook.txt");
        ObjectOutputStream dataOS1 = null;
        ObjectOutputStreamWout dataOS2 = null;
        ObjectInputStream dataIS = null;

        try {
            dataOS1 = new ObjectOutputStream(new FileOutputStream(outFile));
            dataOS1.writeObject(regist1);
            dataOS1.close();

            dataOS2 = new ObjectOutputStreamWout(new FileOutputStream(outFile,true));
            dataOS2.writeObject(regist2);
            dataOS2.close();

            dataIS = new ObjectInputStream(new FileInputStream(outFile));

        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            while(true){
                System.out.println(dataIS.readObject());
            }
        }catch(EOFException e){
            System.out.println("Lectura finalizada.");
        }



    }


}
