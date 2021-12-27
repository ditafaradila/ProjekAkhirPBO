package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;

public class Individu extends Nasabah{
    private LongProperty nik;
    private LongProperty npwp;

    public Individu(Integer ID, String nama, String alamat, Long nik, Long npwp, ArrayList<Rekening> rekening) {
        super(ID, nama, alamat,rekening);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public Individu(Integer ID, String nama, String alamat, Long nik, Long npwp, Rekening rekenings) {
        super(ID, nama, alamat, rekenings);
        this.nik = new SimpleLongProperty(nik);
        this.npwp = new SimpleLongProperty(npwp);
    }

    public Long getNik() {
        return nik.get();
    }

    public LongProperty nikProperty() {
        return nik;
    }

    public void setNik(long nik) {
        this.nik.set(nik);
    }

    public Long getNpwp() {
        return npwp.get();
    }

    public LongProperty npwpProperty() {
        return npwp;
    }

    public void setNpwp(long npwp) {
        this.npwp.set(npwp);
    }

    @Override
    public void print(){
        System.out.println("NIK      : " + getNik());
        System.out.println("NPWP     : " + getNpwp());
        System.out.println("Nama     : " + getNama());
        System.out.println("Alamat   : " + getAlamat());
        System.out.println("Rekening : ");
        System.out.println();
    }
}
