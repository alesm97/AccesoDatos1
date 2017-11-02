package ejercicio10;

import ejercicio08.PhonebookSer;

import java.util.ArrayList;

public class PhoneBookList {

    ArrayList<PhonebookSer> list = new ArrayList<>();

    public PhoneBookList(){

    }

    public void add(PhonebookSer user){
        list.add(user);
    }

    public ArrayList<PhonebookSer> getList() {
        return list;
    }
}
