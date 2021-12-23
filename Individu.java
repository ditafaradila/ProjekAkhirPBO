package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Individu extends Nasabah{
    private LongProperty nik;
    private LongProperty npwp;

    public Individu(Integer id, String nama, String alamat, Long nik, Long npwp, ArrayList<Rekening> rekening) {
        super(id, nama, alamat,rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public Individu(Integer id, String nama, String alamat, Long nik, Long npwp, Rekening rekenings) {
        super(id, nama, alamat, rekenings);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public LongProperty getNik() {
        return nik;
    }
    
    public LongProperty nikProperty(){
        return nik;
    }
    
    public void setNik(LongProperty nik) {
        this.nik = nik;
    }
    
    public LongProperty npwpProperty(){
        return npwp;
    }

    public LongProperty getNpwp() {
        return npwp;
    }

    public void setNpwp(LongProperty npwp) {
        this.npwp = npwp;
    }
    
    @Override
    public void print(){
        System.out.println("NIK     : " + getNik());
        System.out.println("NPWP    : " + getNpwp());
        System.out.println("Nama    : " + getNama());
        System.out.println("Alamat  : " + getAlamat());
        System.out.println("Rekening: ");
        System.out.printf("No %-10s %s\n", "No Rek", "Saldo");
        int i = 1;
        for (Rekening rek : rekening){
            System.out.printf("%d. %-10d %.2f\n", i, rek.getNoRekening(), rek.getSaldo());
            i++;
        }
        System.out.println();
    }
    
    
    
}
