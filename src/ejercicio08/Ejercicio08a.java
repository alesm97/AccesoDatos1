package ejercicio08;

import java.io.*;
import java.time.LocalDate;
import java.time.Month;

public class Ejercicio08a {

    public static void main(String[] args) throws IOException {

        String name1 = "Alex", name2 = "Pepe", name3 = "Juan", name4 = "Antonio", name5 = "Francisco",
                phoneNumber1 = "123456", phonenumber2 = "654321", phonenumber3 = "21344898", phonenumber4 = "45778976", phonenumber5 = "789547668",
                address1 = "calle 1", address2 = "calle 2", address3 = "calle 3", address4 = "calle 4", address5 = "calle 5";
        int postalCode1 = 11204, postalCode2 = 40211, postalCode3 = 58746, postalCode4 = 87965, postalCode5 = 85214;
        boolean debtor1 = true, debtor2 = false, debtor3 = true, debtor4 = false, debtor5 = false;
        LocalDate birthday1 = LocalDate.of(2015, Month.AUGUST, 25), birthday2 = LocalDate.of(2019, Month.AUGUST, 18), birthday3 = LocalDate.of(2005, Month.JANUARY, 18), birthday4 = LocalDate.of(1987, Month.FEBRUARY, 5), birthday5 = LocalDate.of(1874, Month.APRIL, 18);
        double debt1 = 0, debt2 = 15.35, debt3 = 8754.45, debt4 = 0, debt5 = 0;
        boolean deleted1 = false, deleted2 = false, deleted3 = false, deleted4 = false, deleted5 = false;

        File fileToWrite = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1erTrimestre\\src\\prueba8\\phonebookA.txt");
        DataOutputStream dataOS = null;
        DataInputStream dataIS = null;


        try {
            dataIS = new DataInputStream(new FileInputStream(fileToWrite));
            dataOS = new DataOutputStream(new FileOutputStream(fileToWrite));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        dataOS.writeBoolean(deleted1);
        dataOS.writeUTF(name1);
        dataOS.writeUTF(phoneNumber1);
        dataOS.writeUTF(address1);
        dataOS.writeInt(postalCode1);
        dataOS.writeUTF(birthday1.toString());
        dataOS.writeBoolean(debtor1);
        dataOS.writeDouble(debt1);

        dataOS.writeBoolean(deleted2);
        dataOS.writeUTF(name2);
        dataOS.writeUTF(phonenumber2);
        dataOS.writeUTF(address2);
        dataOS.writeInt(postalCode2);
        dataOS.writeUTF(birthday2.toString());
        dataOS.writeBoolean(debtor2);
        dataOS.writeDouble(debt2);

        dataOS.writeBoolean(deleted3);
        dataOS.writeUTF(name3);
        dataOS.writeUTF(phonenumber3);
        dataOS.writeUTF(address3);
        dataOS.writeInt(postalCode3);
        dataOS.writeUTF(birthday3.toString());
        dataOS.writeBoolean(debtor3);
        dataOS.writeDouble(debt3);

        dataOS.writeBoolean(deleted4);
        dataOS.writeUTF(name4);
        dataOS.writeUTF(phonenumber4);
        dataOS.writeUTF(address4);
        dataOS.writeInt(postalCode4);
        dataOS.writeUTF(birthday4.toString());
        dataOS.writeBoolean(debtor4);
        dataOS.writeDouble(debt4);

        dataOS.writeBoolean(deleted5);
        dataOS.writeUTF(name5);
        dataOS.writeUTF(phonenumber5);
        dataOS.writeUTF(address5);
        dataOS.writeInt(postalCode5);
        dataOS.writeUTF(birthday5.toString());
        dataOS.writeBoolean(debtor5);
        dataOS.writeDouble(debt5);

        dataOS.close();

        dataIS.readBoolean();
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readInt());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readDouble());

        System.out.println("-----------------");

        dataIS.readBoolean();
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readInt());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readDouble());

        System.out.println("-----------------");

        dataIS.readBoolean();
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readInt());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readDouble());

        System.out.println("-----------------");

        dataIS.readBoolean();
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readInt());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readDouble());

        System.out.println("-----------------");

        dataIS.readBoolean();
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readInt());
        System.out.println(dataIS.readUTF());
        System.out.println(dataIS.readBoolean());
        System.out.println(dataIS.readDouble());

        dataIS.close();
    }


}
