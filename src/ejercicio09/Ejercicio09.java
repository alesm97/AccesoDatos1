package ejercicio09;

import utilidades.Teclado;

import java.io.*;

public class Ejercicio09 {

    public static void main(String[] args) {

        boolean finished = false, newDebtor;
        int menu,contact=0;
        double newDebt;
        File read = new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1\\src\\prueba8\\phonebookA.txt");
        RandomAccessFile random = null;

        try {
            random = new RandomAccessFile(new File("C:\\Users\\alesm97\\IdeaProjects\\AccesoDatos1\\src\\prueba9\\prueba9.txt"), "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.printf("Creando archivo aleatorio a partir del binario.\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            BinToRanConverter.makeFileChar(random,read);
        } catch (IOException e) {
            e.printStackTrace();
        }


        do{
            System.out.printf("¿Qué desea hacer?\n\t" +
                    "1.- Consultar fichero entero.\n\t" +
                    "2.- Consultar contacto por id.\n\t" +
                    "3.- Añadir contacto.\n\t" +
                    "4.- Eliminar contacto\n\t" +
                    "5.- Modificar si debe dinero y la cantidad.\n\t" +
                    "6.- Compactar.\n\t" +
                    "7.- Salir\n");
            menu=Teclado.leerEntre(1,7, Teclado.Incluido.TODOS, Teclado.Tipos.INT);
            switch(menu){
                case 1:
                    showAllContacts(random);
                    break;
                case 2:
                    System.out.printf("Introduzca el identificador del contacto:\n");
                    contact = Teclado.leerNumero(Teclado.Tipos.INT);
                    showContact(random,contact);
                    break;
                case 3:
                    addContact(random);
                    break;
                case 4:
                    System.out.println("Introduce el identificador del contacto a eliminar:");
                    contact = Teclado.leerNumero(Teclado.Tipos.INT);
                    deleteContact(random,contact);
                    break;
                case 5:
                    System.out.printf("Introduzca el identificador del contacto:\n");
                    contact = Teclado.leerNumero(Teclado.Tipos.INT);
                    newDebtor = Teclado.leerBoolean("¿Lo va a poner de deudor?","Si","No");
                    if(newDebtor){
                        System.out.println("¿Qué deuda tiene?:");
                        newDebt=Teclado.leerNumero(Teclado.Tipos.DOUBLE);
                    }else{
                        newDebt=0;
                    }

                    modifyDebt(random,contact,newDebtor,newDebt);
                    break;
                case 6:
                    compact(random);
                    break;
                case 7:
                    finished = true;
                    break;
            }
        }while(!finished);

    }



    private static void showAllContacts(RandomAccessFile random) {
        int id,postal;
        boolean deleted,debtor,finished=false;
        double debt;
        String name, address, birth, number;

        try {
            random.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(!finished){
            try{
                id=random.readInt();
                deleted = random.readBoolean();

                name = readChars(random,15);

                number = readChars(random,9);
                address = readChars(random,30);
                postal = random.readInt();
                birth = readChars(random,10);
                debtor=random.readBoolean();
                debt=random.readDouble();
                if(!deleted){
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("Contacto nº %d\n",id);
                    System.out.printf("Nombre: %s\n",name);
                    System.out.printf("Teléfono: %s\n",number);
                    System.out.printf("Dirección: %s\n",address);
                    System.out.printf("Código Postal: %d\n",postal);
                    System.out.printf("Fecha Nacimiento: %s\n",birth);
                    System.out.printf("¿Es deudor?: %s\n",debtor?"Sí":"No");
                    if(debtor){
                        System.out.printf("Deuda: %.2f\n",debt);
                    }
                    System.out.println(random.getFilePointer());
                }
            }catch (EOFException e){
                finished = true;
                System.out.println("-----------------------------------------------------------------------------------");
            } catch (IOException e) {
                finished = true;
                e.printStackTrace();
            }

        }
    }

    private static void showContact(RandomAccessFile random,int contact) {

        int id,postal;
        boolean deleted,debtor,finished=false,found=false;
        double debt;
        String name, address, birth, number;

        try {
            random. seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!finished){
            try{
                id=random.readInt();
                deleted = random.readBoolean();

                name = readChars(random,15);

                number = readChars(random,9);
                address = readChars(random,30);
                postal = random.readInt();
                birth = readChars(random,10);
                debtor=random.readBoolean();
                debt=random.readDouble();
                if(!deleted && id==contact){
                    found=true;
                    System.out.println("-----------------------------------------------------------------------------------");
                    System.out.printf("Contacto nº %d\n",id);
                    System.out.printf("Nombre: %s\n",name);
                    System.out.printf("Teléfono: %s\n",number);
                    System.out.printf("Dirección: %s\n",address);
                    System.out.printf("Código Postal: %d\n",postal);
                    System.out.printf("Fecha Nacimiento: %s\n",birth);
                    System.out.printf("¿Es deudor?: %s\n",debtor?"Sí":"No");
                    if(debtor){
                        System.out.printf("Deuda: %.2f\n",debt);
                    }
                }
            }catch (EOFException e){
                finished = true;
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("%s",found?"":"\nNo hay ningún contacto con ese id.\n");
                System.out.println("-----------------------------------------------------------------------------------");
            } catch (IOException e) {
                finished = true;
                e.printStackTrace();
            }
        }


    }

    private static void addContact(RandomAccessFile random) {
        int id=0,postal;
        boolean deleted=false,debtor,finished=false,found=false;
        double debt;
        String name, address, birth, number;

        try {
            random.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            if(random.length()%146!=0){
                id = (int) ((random.length()-4)/146) + 1;
            }else{
                id = (int) (random.length()/146) + 1;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Introduzca el nombre:");
        name = Teclado.leerString();
        System.out.println("Introduzca el número de teléfono:");
        number = Teclado.leerString();
        System.out.println("Introduzca la dirección:");
        address = Teclado.leerString();
        System.out.println("Introduzca el código postal:");
        postal = Teclado.leerNumero(Teclado.Tipos.INT);
        System.out.println("Introduzca fecha de nacimiento (AAAA-mm-dd):");
        birth = Teclado.leerString();
        debtor = Teclado.leerBoolean("¿Es deudor?","Sí","No");
        if(debtor){
            System.out.println("¿Cuánto debe?:");
            debt=Teclado.leerNumero(Teclado.Tipos.DOUBLE);
        }else{
            debt=0;
        }


        while(!finished){
            try{

                random.readInt();
                random.readBoolean();
                readChars(random,15);
                readChars(random,9);
                readChars(random,30);
                random.readInt();
                readChars(random,10);
                random.readBoolean();
                random.readDouble();

                System.out.println(random.getFilePointer());

            }catch (EOFException e){

                try {

                    if(random.getFilePointer()%146!=0){
                        random.seek(random.getFilePointer()-4);
                    }

                    random.writeInt(id);
                    System.out.println(random.getFilePointer());

                    random.writeBoolean(deleted);
                    System.out.println(random.getFilePointer());

                    BinToRanConverter.writeString(random,name,15);
                    System.out.println(random.getFilePointer());

                    BinToRanConverter.writeString(random,number,9);
                    System.out.println(random.getFilePointer());

                    BinToRanConverter.writeString(random,address,30);
                    System.out.println(random.getFilePointer());

                    random.writeInt(postal);
                    System.out.println(random.getFilePointer());

                    BinToRanConverter.writeString(random,birth,10);
                    System.out.println(random.getFilePointer());

                    random.writeBoolean(debtor);
                    System.out.println(random.getFilePointer());

                    random.writeDouble(debt);
                    System.out.println(random.getFilePointer());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                finished = true;
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("Contacto añadido correctamente.\n");
                System.out.println("-----------------------------------------------------------------------------------");
            } catch (IOException e) {
                finished = true;
                e.printStackTrace();
            }
        }


    }

    private static void deleteContact(RandomAccessFile random, int contact) {

        int id;
        boolean finished=false,found=false;

        try {
            random.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!finished){
            try{
                id=random.readInt();
                if(id==contact){
                    random.writeBoolean(true);
                    found=true;
                }else{
                    random.readBoolean();
                }
                readChars(random,15);

                readChars(random,9);
                readChars(random,30);
                random.readInt();
                readChars(random,10);
                random.readBoolean();
                random.readDouble();
            }catch (EOFException e){
                finished = true;
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("%s",found?"Contacto eliminado correctamente.\n":"No hay ningún contacto con ese id.\n");
                System.out.println("-----------------------------------------------------------------------------------");
            } catch (IOException e) {
                finished = true;
                e.printStackTrace();
            }
        }

    }

    private static void modifyDebt(RandomAccessFile random, int contact, boolean debtor, double newDebt) {

        int id;
        boolean finished=false,found=false;

        try {
            random.seek(0);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while(!finished){
            try{
                id=random.readInt();
                random.readBoolean();
                readChars(random,15);
                readChars(random,9);
                readChars(random,30);
                random.readInt();
                readChars(random,10);
                if(id==contact) {
                    random.writeBoolean(debtor);
                    random.writeDouble(newDebt);
                    found=true;
                    finished=true;
                }else{
                    random.readBoolean();
                    random.readDouble();
                }

            }catch (EOFException e){
                finished = true;
                System.out.println("-----------------------------------------------------------------------------------");
                System.out.printf("%s",found?"Deudor actualizado.\n":"No hay ningún contacto con ese id.\n");
                System.out.println("-----------------------------------------------------------------------------------");
            } catch (IOException e) {
                finished = true;
                e.printStackTrace();
            }
        }

    }

    private static void compact(RandomAccessFile random) {

        //TODO ni idea de como se hace xd

    }

    private static String readChars(RandomAccessFile random, int length){
        String result = "";

        for(int i = 0 ; i < length ; i++){
            try {
                result = String.format("%s%c",result,random.readChar());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

}
