package ejercicio08;

import java.io.Serializable;
import java.time.LocalDate;

public class PhonebookSer implements Serializable {

    private String name,phoneNumber,address;
    private int postalCode;
    private boolean debtor,deleted;
    private LocalDate birthday;
    private double debt;

    public PhonebookSer(boolean deleted, String name, String phoneNumber, String address, int postalCode, boolean debtor, LocalDate birthday, double debt){
        this.deleted=deleted;
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.address=address;
        this.postalCode=postalCode;
        this.debtor=debtor;
        this.birthday=birthday;
        this.debt=debt;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s\nTel: %s\nDireccion: %s\nFecha Nac: %s\n¿Es deudor?: %b\n%s",name,phoneNumber,address,birthday.toString(),debtor,debtor?String.format("Deuda: %.2f\n\n",debt):"\n");
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public boolean isDebtor() {
        return debtor;
    }

    public void setDebtor(boolean debtor) {
        this.debtor = debtor;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public double getDebt() {
        return debt;
    }

    public void setDebt(float debt) {
        this.debt = debt;
    }
}
