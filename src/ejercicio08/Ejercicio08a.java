package ejercicio08;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Ejercicio08a {

    public static void main(String[] args) throws IOException {

        String name1="Alex",name2="Pepe",phoneNumber1="123456",phonenumber2="654321",address1="calle 1",address2="calle 2";
        int postalCode1=11204,postalCode2=40211;
        boolean debtor1=true,debtor2=false;
        LocalDate birthday1=LocalDate.of(2015, Month.AUGUST,25),birthday2=LocalDate.of(2019, Month.AUGUST,18);
        float debt1 = 0, debt2 = (float) 15.35;

        File fileToWrite = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba8\\phonebookA.txt");
        File fileToRead = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba8\\phonebook.txt");
        DataOutputStream dataOS = null;
        DataInputStream dataIS = null, dataIS2 = null;


        try {
            dataIS = new DataInputStream(new FileInputStream(fileToWrite));
            dataOS = new DataOutputStream(new FileOutputStream(fileToWrite));
            dataIS2 = new DataInputStream(new FileInputStream(fileToRead));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        dataOS.writeUTF(name1);
        dataOS.writeUTF(phoneNumber1);
        dataOS.writeUTF(address1);
        dataOS.write(postalCode1);
        dataOS.writeUTF(birthday1.toString());
        dataOS.writeBoolean(debtor1);
        dataOS.writeFloat(debt1);

        dataOS.writeUTF(name2);
        dataOS.writeUTF(phonenumber2);
        dataOS.writeUTF(address2);
        dataOS.write(postalCode2);
        dataOS.writeUTF(birthday2.toString());
        dataOS.writeBoolean(debtor2);
        dataOS.writeFloat(debt2);

        dataOS.close();

        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.read());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readFloat());

        System.out.println("-----------------");

        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.read());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readFloat());

        dataIS.close();
    }


}
