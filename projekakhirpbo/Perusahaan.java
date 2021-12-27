package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Perusahaan extends Nasabah{
    private StringProperty nib;

    public Perusahaan(Integer ID, String nama, String alamat, String nib, ArrayList<Rekening> rekening) {
        super(ID, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }

    public Perusahaan(Integer ID, String nama, String alamat,String nib, Rekening rekening) {
        super(ID, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }

    public String getNib() {
        return nib.get();
    }

    public StringProperty nibProperty() {
        return nib;
    }

    public void setNib(String nib) {
        this.nib.set(nib);
    }

    @Override
    public void print(){
        System.out.println("NIB                 : " + getNib());
        System.out.println("Nama Perusahan      : " + getNama());
        System.out.println("Alamat Perusahaan   : " + getAlamat());
        System.out.println("Rekening : ");
        System.out.println();
    }
}
