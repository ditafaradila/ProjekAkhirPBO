package projekakhirpbo;

import java.util.ArrayList;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public abstract class Nasabah {
    protected IntegerProperty id;
    protected StringProperty nama;
    protected StringProperty alamat;
    private IntegerProperty noRek;
    protected ArrayList <Rekening> rekening;

    public Nasabah(IntegerProperty id, StringProperty nama, StringProperty alamat, IntegerProperty rekNum, ArrayList<Rekening> rekening) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        this.noRek = rekNum;
        this.rekening = rekening;
    }
    
    public Nasabah(Integer id, String nama, String alamat, ArrayList<Rekening> rekening) {
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.noRek = new SimpleIntegerProperty(rekening.size());
        this.rekening = rekening;
    }

    public Nasabah(Integer id, String nama, String alamat, Rekening rekenings) {
        rekening = new ArrayList<>();
        this.id = new SimpleIntegerProperty(id);
        this.nama = new SimpleStringProperty(nama);
        this.alamat = new SimpleStringProperty(alamat);
        this.noRek = new SimpleIntegerProperty(rekening.size());
        this.rekening.add(rekenings);
    }

    public IntegerProperty getId() {
        return id;
    }
    
    public IntegerProperty idProperty() {
        return id;
    }

    public void setId(IntegerProperty id) {
        this.id = id;
    }

    public StringProperty getNama() {
        return nama;
    }
    
    public StringProperty namaProperty() {
        return nama;
    }

    public void setNama(StringProperty nama) {
        this.nama = nama;
    }

    public StringProperty getAlamat() {
        return alamat;
    }
    
    public StringProperty alamatProperty() {
        return alamat;
    }

    public void setAlamat(StringProperty alamat) {
        this.alamat = alamat;
    }

    public IntegerProperty getRekNum() {
        return noRek;
    }
    
    public IntegerProperty rekNumProperty() {
        return noRek;
    }

    public void setRekNum(IntegerProperty rekNum) {
        this.noRek = rekNum;
    }

    public ArrayList<Rekening> getRekening() {
        return rekening;
    }

    public void setRekening(ArrayList<Rekening> rekening) {
        this.rekening = rekening;
    }
    
    public void tambahRekening(Rekening rek){
        
    }
    
    abstract public void print();
    
}
