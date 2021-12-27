package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public abstract class Nasabah {
    protected IntegerProperty ID;
    protected StringProperty nama;
    protected StringProperty alamat;
    private IntegerProperty rekNum;
    protected ArrayList <Rekening> rekening;

    public Nasabah(Integer ID, String nama, String alamat, ArrayList<Rekening> rekening) {
        this.ID = new SimpleIntegerProperty(ID);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekNum = new SimpleIntegerProperty(rekening.size());
        this.rekening = rekening;
    }

    public Nasabah(Integer ID, String nama, String alamat, Rekening rekenings) {
        rekening = new ArrayList<>();
        this.ID = new SimpleIntegerProperty(ID);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.rekNum = new SimpleIntegerProperty(rekening.size());
        this.rekening.add(rekenings);
    }

    public Integer getID() {
        return ID.get();
    }

    public IntegerProperty idProperty() {
        return ID;
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getNama() {
        return nama.get();
    }

    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama.set(nama);
    }

    public String getAlamat() {
        return alamat.get();
    }

    public StringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat.set(alamat);
    }

    public Integer getRekNum() {
        return rekNum.get();
    }

    public IntegerProperty rekNumProperty() {
        return rekNum;
    }

    public void setRekNum(int rekNum) {
        this.rekNum.set(rekNum);
    }

    public ArrayList<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }

    abstract public void print();
    
}
