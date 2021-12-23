package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Perusahaan extends Nasabah{
    protected StringProperty nib;

    public Perusahaan(Integer id, String nama, String alamat, String nib, ArrayList<Rekening> rekening) {
        super(id, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }

    public Perusahaan(Integer id, String nama, String alamat,String nib, Rekening rekening) {
        super(id, nama, alamat, rekening);
        this.nib = new SimpleStringProperty(nib);
    }

    public StringProperty getNib() {
        return nib;
    }
    
    public StringProperty nibProperty(){
        return nib;
    }

    public void setNib(StringProperty nib) {
        this.nib = nib;
    }
    
    @Override
    public void print(){
        System.out.println("Nib             : " + getNib());
        System.out.println("Nama perusahaan : " + getNama());
        System.out.println("Alamat perusahaan : " + getAlamat());
        System.out.println("Rekening : ");
        System.out.printf("No %-10s %s\n", "No Rek", "Saldo");
        int i = 1;
        for (Rekening rek : rekening){
            System.out.printf("%d. %-10d %.2f\n", i, rek.getNoRekening(), rek.getSaldo());
            i++;
        }
        System.out.println();
    }
    
}
