package projekakhirpbo;

import database.datamodel;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class FXMLDocumentController implements Initializable {
    @FXML
    private TextField tfIDIndividual;
    @FXML
    private TextField tfNamaIndividual;
    @FXML
    private TextField tfAlamatIndividual;
    @FXML
    private TextField tfNIKIndividual;
    @FXML
    private TextField tfNPWPIndividual;
    @FXML
    private TextField tfNoRekIndividual;
    @FXML
    private TextField tfSaldoRekIndividual;
    @FXML
    private Button btnAddIndividual;
    @FXML
    private Button btnPerbaruiIndividual;
    @FXML
    private Button btnHapusIndividual;
    @FXML
    private Label lblAddStatusindividual;
    @FXML
    private TableView<Individu> tblDataIndividu;
    @FXML
    private TableColumn<Individu, Integer> colIDIndividu;
    @FXML
    private TableColumn<Individu, String> colNamaIndividu;
    @FXML
    private TableColumn<Individu, String> colAlamatIndividu;
    @FXML
    private TableColumn<Individu, Long> colNIK;
    @FXML
    private TableColumn<Individu, Long> colNPWP;
    @FXML
    private TableColumn<Individu, Integer> colJumAkunIndividu;
    @FXML
    private TableView<Rekening> tblRekeningIndividu;
    @FXML
    private TableColumn<Rekening, Integer> colNumRekIndividu;
    @FXML
    private TableColumn<Rekening, Double> colSaldoIndividu;
    @FXML
    private TextField tfIDNasabahBaruIndividual;
    @FXML
    private TextField tfNoRekBaruIndividual;
    @FXML
    private TextField tfSaldoRekBaruIndividual;
    @FXML
    private Button btnTambahRekBaruIndividual;
    @FXML
    private TextField tfRekeningDipilihIndividual;
    @FXML
    private TextField tfNominalIndividual;
    @FXML
    private Button btnTarikTunaiIndividual;
    @FXML
    private Button btnTambahSaldoIndividual;

    @FXML
    private TextField tfIDPerusahaan;
    @FXML
    private TextField tfNamaPerusahaan;
    @FXML
    private TextField tfAlamatPerusahaan;
    @FXML
    private TextField tfNIBPerusahaan;
    @FXML
    private TextField tfNoRekPerusahaan;
    @FXML
    private TextField tfSaldoPerusahaan;
    @FXML
    private Button btnAddPerusahaan;
    @FXML
    private Button btnPerbaruiPerusahaan;
    @FXML
    private Button btnHapusPerusahaan;
    @FXML
    private Label lblAddStatusPerusahaan;
    @FXML
    private TableView<Perusahaan> tblDataPerusahaan;
    @FXML
    private TableColumn<Perusahaan, Integer> colIDPerusahaan;
    @FXML
    private TableColumn<Perusahaan, String> colNamaPerusahaan;
    @FXML
    private TableColumn<Perusahaan, String> colAlamatPerusahaan;
    @FXML
    private TableColumn<Perusahaan, String> colNIB;
    @FXML
    private TableColumn<Perusahaan, Integer> colJumAkunPerusahaan;
    @FXML
    private TableView<Rekening> tblRekeningPerusahaan;
    @FXML
    private TableColumn<Rekening, Integer> colNumRekPerusahaan;
    @FXML
    private TableColumn<Rekening, Double> colSaldoPerusahaan;
    @FXML
    private TextField tfIDNasabahBaruPerusahaan;
    @FXML
    private TextField tfNoRekBaruPerusahaan;
    @FXML
    private TextField tfSaldoRekBaruPerusahaan;
    @FXML
    private Button btnTambahRekBaruPerusahaan;
    @FXML
    private TextField tfRekeningDipilihPerusahaan;
    @FXML
    private TextField tfNominalPerusahaan;
    @FXML
    private Button btnTarikTunaiPerusahaan;
    @FXML
    private Button btnTambahSaldoPerusahaan;
    
    @FXML
    private Label lblDBStatus;
    @FXML
    private Label lblTarikTambahIndividu;
    @FXML
    private Label lblTambahTarikPerusahaan;

    private datamodel db;

    private Rekening globrek;

    @FXML
    void handleTambahNasabahIndividual(ActionEvent event) {
        Individu individu = new Individu(
                Integer.parseInt(tfIDIndividual.getText()),
                tfNamaIndividual.getText(),
                tfAlamatIndividual.getText(),
                Long.parseLong(tfNIKIndividual.getText()),
                Long.parseLong(tfNPWPIndividual.getText()),
                new Rekening(Integer.parseInt(tfNoRekIndividual.getText()),
                        Double.parseDouble(tfSaldoRekIndividual.getText()))
        );

        try {
            db.addIndvidual(individu);
            btnPerbaruiIndividual.fire();
            btnHapusIndividual.fire();
            lblAddStatusindividual.setText("Berhasil Dibuat!");
        } catch (Exception e) {
            lblAddStatusindividual.setText("Gagal Dibuat!");
        }
    }

    @FXML
    void handleTambahNasabahPerusahaan(ActionEvent event) {
        Perusahaan perusahaan = new Perusahaan(
                Integer.parseInt(tfIDPerusahaan.getText()),
                tfNamaPerusahaan.getText(),
                tfAlamatPerusahaan.getText(),
                tfNIBPerusahaan.getText(),
                new Rekening(Integer.parseInt(tfNoRekPerusahaan.getText()),
                        Double.parseDouble(tfSaldoPerusahaan.getText()))
        );

        try {
            db.addPerusahaan(perusahaan);
            btnPerbaruiPerusahaan.fire();
            btnHapusPerusahaan.fire();
            lblAddStatusPerusahaan.setText("Berhasil Dibuat!");
        } catch (Exception e) {
            lblAddStatusPerusahaan.setText("Gagal Dibuat!");
        }
    }
    
    @FXML
    void handlePerbaruiTabelIndividual(ActionEvent event) {
        ObservableList<Individu> data = db.getIndividu();
        colIDIndividu.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaIndividu.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatIndividu.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNIK.setCellValueFactory(new PropertyValueFactory<>("nik"));
        colNPWP.setCellValueFactory(new PropertyValueFactory<>("npwp"));
        colJumAkunIndividu.setCellValueFactory(new PropertyValueFactory<>("rekNum"));
        tblDataIndividu.setItems(null);
        tblDataIndividu.setItems(data);
        btnTambahRekBaruIndividual.setDisable(true);
        btnTambahSaldoIndividual.setDisable(true);
        btnTarikTunaiIndividual.setDisable(true);
        tfNominalIndividual.setDisable(true);
        tfSaldoRekBaruIndividual.setDisable(true);
        lblAddStatusindividual.setText("");
        tblRekeningIndividu.setItems(null);
        lblTarikTambahIndividu.setText("");
        btnHapusIndividual.fire();
    }

    @FXML
    void handlePerbaruiTabelPerusahaan(ActionEvent event) {
        ObservableList<Perusahaan> data = db.getPerusahaan();
        colIDPerusahaan.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNamaPerusahaan.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colAlamatPerusahaan.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        colNIB.setCellValueFactory(new PropertyValueFactory<>("nib"));
        colJumAkunPerusahaan.setCellValueFactory(new PropertyValueFactory<>("rekNum"));
        tblDataPerusahaan.setItems(null);
        tblDataPerusahaan.setItems(data);
        btnTambahRekBaruPerusahaan.setDisable(true);
        btnTambahSaldoPerusahaan.setDisable(true);
        btnTarikTunaiPerusahaan.setDisable(true);
        tfSaldoRekBaruPerusahaan.setDisable(true);
        tfNominalPerusahaan.setDisable(true);
        lblAddStatusPerusahaan.setText("");
        tblRekeningPerusahaan.setItems(null);
        lblTambahTarikPerusahaan.setText("");
        btnHapusPerusahaan.fire();
    }
    
    @FXML
    void handleHapusIndividual(ActionEvent event) throws SQLException {
        tfIDIndividual.setText("" + db.nextNasabahID());
        tfNoRekIndividual.setText(tfIDIndividual.getText() + "01");
        tfNamaIndividual.setText("");
        tfAlamatIndividual.setText("");
        tfNIKIndividual.setText("");
        tfNPWPIndividual.setText("");
        tfSaldoRekIndividual.setText("");
        tfSaldoRekBaruIndividual.setText("");
        tfNominalIndividual.setText("");
    }

    @FXML
    void handleHapusPerusahaan(ActionEvent event) throws SQLException {
        tfIDPerusahaan.setText("" + db.nextNasabahID());
        tfNoRekPerusahaan.setText(tfIDIndividual.getText() + "01");
        tfNamaPerusahaan.setText("");
        tfAlamatPerusahaan.setText("");
        tfNIBPerusahaan.setText("");
        tfSaldoPerusahaan.setText("");
        tfSaldoRekBaruPerusahaan.setText("");
        tfNominalPerusahaan.setText("");
    }

    @FXML
    void handleTambahRekBaruIndividual(ActionEvent event) throws SQLException{
        Rekening rekening = new Rekening(Integer.parseInt(tfNoRekBaruIndividual.getText()),
                Double.parseDouble(tfSaldoRekBaruIndividual.getText()));
        db.addRekening(Integer.parseInt(tfIDNasabahBaruIndividual.getText()), rekening);
        btnPerbaruiIndividual.fire();
        tfSaldoRekBaruIndividual.setText("");
        lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
    }

    @FXML
    void handleTambahRekBaruPerusahaan(ActionEvent event) throws SQLException{
        Rekening rekening = new Rekening(Integer.parseInt(tfNoRekBaruPerusahaan.getText()),
                Double.parseDouble(tfSaldoRekBaruPerusahaan.getText()));
        db.addRekening(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()), rekening);
        btnPerbaruiPerusahaan.fire();
        tfSaldoRekBaruPerusahaan.setText("");
        lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
    }

    @FXML
    void handleTambahSaldoIndividual(ActionEvent event) throws SQLException {
        globrek.tambahSaldo(Double.parseDouble(tfNominalIndividual.getText()));
        String tambahSaldo = "UPDATE Rekening SET saldo = " + globrek.getSaldo()
                + " WHERE noRekening = " + globrek.getNoRekening();
        PreparedStatement preparedSaldoBaru = db.connection.prepareStatement(tambahSaldo);
        preparedSaldoBaru.execute();
        preparedSaldoBaru.close();
        btnPerbaruiIndividual.fire();
        btnHapusIndividual.fire();
        lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
        lblTarikTambahIndividu.setText("Berhasil!");
    }
    
    @FXML
    void handleTambahSaldoPerusahaan(ActionEvent event) throws SQLException{
        globrek.tambahSaldo(Double.parseDouble(tfNominalPerusahaan.getText()));
        String tambahSaldo = "UPDATE Rekening SET saldo = " + globrek.getSaldo()
                + " WHERE noRekening = " + globrek.getNoRekening();
        PreparedStatement preparedSaldoBaru = db.connection.prepareStatement(tambahSaldo);
        preparedSaldoBaru.execute();
        preparedSaldoBaru.close();
        btnPerbaruiPerusahaan.fire();
        btnHapusPerusahaan.fire();
        lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
        lblTambahTarikPerusahaan.setText("Berhasil!");
    }

    @FXML
    void handleTarikTunaiIndividual(ActionEvent event) throws SQLException {
        if (globrek.getSaldo() < Double.parseDouble(tfNominalIndividual.getText())) {
            lblTarikTambahIndividu.setText("Saldo Rekening Kurang");
        } else {
            globrek.tarikTunai(Double.parseDouble(tfNominalIndividual.getText()));
            String tarikTunai = "UPDATE Rekening SET saldo = " + globrek.getSaldo()
                    + " WHERE noRekening = " + globrek.getNoRekening();
            PreparedStatement preparedSaldoBaru = db.connection.prepareStatement(tarikTunai);
            preparedSaldoBaru.execute();
            preparedSaldoBaru.close();
            btnPerbaruiIndividual.fire();
            btnHapusIndividual.fire();
            lihatDataRekeningIndividu(Integer.parseInt(tfIDNasabahBaruIndividual.getText()));
            lblTarikTambahIndividu.setText("Berhasil!");
        }
    }
    
    @FXML
    void handleTarikTunaiPerusahaan(ActionEvent event) throws SQLException{
        if (globrek.getSaldo() < Double.parseDouble(tfNominalPerusahaan.getText())) {
            lblTarikTambahIndividu.setText("Saldo Rekening Kurang");
        } else {
            globrek.tarikTunai(Double.parseDouble(tfNominalPerusahaan.getText()));
            String tarikTunai = "UPDATE Rekening SET saldo = " + globrek.getSaldo()
                    + " WHERE noRekening = " + globrek.getNoRekening();
            PreparedStatement preparedSaldoBaru = db.connection.prepareStatement(tarikTunai);
            preparedSaldoBaru.execute();
            preparedSaldoBaru.close();
            btnPerbaruiPerusahaan.fire();
            btnHapusPerusahaan.fire();
            lihatDataRekeningPerusahaan(Integer.parseInt(tfIDNasabahBaruPerusahaan.getText()));
            lblTambahTarikPerusahaan.setText("Berhasil!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            db = new datamodel();
            lblDBStatus.setText(db.connection == null ? "Not Connected" : "Connected");
            btnHapusIndividual.fire();
            btnPerbaruiIndividual.fire();
            btnHapusPerusahaan.fire();
            btnPerbaruiPerusahaan.fire();
        } catch (Exception es) {
            System.out.println("Error");
        }

        tblDataIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblDataIndividu.getSelectionModel().getSelectedItem() != null) {
                Individu individu =tblDataIndividu.getSelectionModel().getSelectedItem();
                individu.print();
                lihatDataRekeningIndividu(individu.getID());
                btnTambahRekBaruIndividual.setDisable(false);
                tfSaldoRekBaruIndividual.setDisable(false);
                tfIDNasabahBaruIndividual.setText("" + individu.getID());
                try {
                    tfNoRekBaruIndividual.setText("" + db.nextNoRekening(individu.getID()));
                } catch (Exception ex) {
                    System.out.println("Gagal!");
                }
            }
        });

        tblDataPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblDataPerusahaan.getSelectionModel().getSelectedItem() != null) {
                Perusahaan perusahaan = tblDataPerusahaan.getSelectionModel().getSelectedItem();
                perusahaan.print();
                lihatDataRekeningPerusahaan(perusahaan.getID());
                btnTambahRekBaruPerusahaan.setDisable(false);
                tfSaldoRekBaruPerusahaan.setDisable(false);
                tfIDNasabahBaruPerusahaan.setText("" + perusahaan.getID());
                try {
                    tfNoRekBaruPerusahaan.setText("" + db.nextNoRekening(perusahaan.getID()));
                } catch (Exception ex) {
                    System.out.println("Gagal!");
                }
            }
        });

        tblRekeningIndividu.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblRekeningIndividu.getSelectionModel().getSelectedItem() != null) {
                globrek = tblRekeningIndividu.getSelectionModel().getSelectedItem();
                btnTarikTunaiIndividual.setDisable(false);
                btnTambahSaldoIndividual.setDisable(false);
                tfNominalIndividual.setDisable(false);
                tfRekeningDipilihIndividual.setText("" + globrek.getNoRekening());
            }
        });

        tblRekeningPerusahaan.getSelectionModel().selectedIndexProperty().addListener(listener -> {
            if (tblRekeningPerusahaan.getSelectionModel().getSelectedItem() != null) {
                globrek = tblRekeningPerusahaan.getSelectionModel().getSelectedItem();
                btnTarikTunaiPerusahaan.setDisable(false);
                btnTambahSaldoPerusahaan.setDisable(false);
                tfNominalPerusahaan.setDisable(false);
                tfRekeningDipilihPerusahaan.setText("" + globrek.getNoRekening());
            }
        });
    }

    public void lihatDataRekeningIndividu(int id) {
        ObservableList<Rekening> data = db.getRekening(id);
        colNumRekIndividu.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoIndividu.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekeningIndividu.setItems(null);
        tblRekeningIndividu.setItems(data);
    }

    public void lihatDataRekeningPerusahaan(int id) {
        ObservableList<Rekening> data = db.getRekening(id);
        colNumRekPerusahaan.setCellValueFactory(new PropertyValueFactory<>("noRekening"));
        colSaldoPerusahaan.setCellValueFactory(new PropertyValueFactory<>("saldo"));
        tblRekeningPerusahaan.setItems(null);
        tblRekeningPerusahaan.setItems(data);
    }
}
