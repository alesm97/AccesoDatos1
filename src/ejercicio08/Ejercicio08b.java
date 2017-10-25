package ejercicio08;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Ejercicio08b {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        boolean deleted1 = false, deleted2 = false, deleted3 = false, deleted4 = false, deleted5 = false;
        PhonebookSer regist1 = new PhonebookSer(deleted1,"Alex","615101488","Vicente Aleixandre",11204,false, LocalDate.of(2014, Month.APRIL,25),0);
        PhonebookSer regist2 = new PhonebookSer(deleted2,"Nano","615584769","Alixandre Vicente",11548,true, LocalDate.of(2014, Month.APRIL,25),14.56);
        PhonebookSer regist3 = new PhonebookSer(deleted3,"Baldo","587964857","Vicendre Alexante",54876,false, LocalDate.of(2014, Month.APRIL,25),0);
        PhonebookSer regist4 = new PhonebookSer(deleted4,"G.G.","789587845","Vixandre Alecinte",89746,true, LocalDate.of(2014, Month.APRIL,25),4587.25);
        PhonebookSer regist5 = new PhonebookSer(deleted5,"Eufrasio","786495216","Puente 1",02541,true, LocalDate.of(2014, Month.APRIL,25),1458967.25);
        File outFile = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba8\\phonebook.txt");
        ObjectOutputStream dataOS;
        ObjectInputStream dataIS = null;

        try {
            dataOS = new ObjectOutputStream(new FileOutputStream(outFile));
            dataOS.writeObject(regist1);
            dataOS.writeObject(regist2);
            dataOS.writeObject(regist3);
            dataOS.writeObject(regist4);
            dataOS.writeObject(regist5);
            dataOS.close();

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
