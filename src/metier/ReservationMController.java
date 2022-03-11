/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import component.SendEmail;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import modeles.Chambre;
import modeles.Hotel;
import modeles.Reservation;
import services.ServiceChambre;
import services.ServiceHotel;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class ReservationMController implements Initializable {

    @FXML
    private TableView<Hotel> tableH;
    @FXML
    private TableView<Chambre> tableC;
    @FXML
    private Text hotelLabel;
    @FXML
    private Text chambreLabel;
    @FXML
    private Text prix_totaleLabel;
    @FXML
    private DatePicker entreeDate;
    @FXML
    private DatePicker sortieDate;
    // Reservation res = new Reservation();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initHotel();
        updateHotel();
    }

    ServiceHotel sH = new ServiceHotel();
    ServiceChambre sC = new ServiceChambre();

    void mohemayaser() {

        initHotel();
        updateHotel();
        //
        Hotel h = (Hotel) tableH.getSelectionModel().getSelectedItem();
        h.setChambres();
        // **disponibilite */

        // AFFICHAGE
        if (h.isDispo()) {

            initChambre();
            updateChambre(h);

            Chambre c = tableC.getSelectionModel().getSelectedItem();

            // res.setId_hotel(h.getId());
            int id_user = 0;
            Period daysBetween = Period.between(entreeDate.getValue(), sortieDate.getValue());

            Reservation res = new Reservation(id_user, h.getId(), daysBetween.getDays() * c.getPrix(),
                    entreeDate.getValue(), sortieDate.getValue(),
                    c.getNumber(), "");

            ServiceReservation sR = new ServiceReservation();
            sR.add(res);
            c.reserve();
            sC.update(c);
        } else {
            System.out.println("Hotel complet");
        }
    }

    boolean niv = true;
    Reservation res = new Reservation();
    Chambre c = new Chambre();

    Hotel h = new Hotel();

    @FXML
    private void chooseClicked(ActionEvent event) {
        if (niv) {

            h = tableH.getSelectionModel().getSelectedItem();
            hotelLabel.setText(h.getNom());
            h.setChambres();
            // **disponibilite */

            // AFFICHAGE
//            if (h.isDispo()) {
            initChambre();
            updateChambre(h);
//            } else {

//            }
            niv = !niv;
        } else {
//            initChambre();
//            updateChambre(h);

//            c = tableC.getSelectionModel().getSelectedItem();
//            chambreLabel.setText(String.valueOf(c.getNumber()));
//
//            // res.setId_hotel(h.getId());
//            int id_user = 0;
//            Period daysBetween = Period.between(entreeDate.getValue(), sortieDate.getValue());
//
//            Reservation res = new Reservation(id_user, h.getId(), daysBetween.getDays() * c.getPrix(),
//                    entreeDate.getValue(), sortieDate.getValue(),
//                    c.getNumber(), "");
//
//            ServiceReservation sR = new ServiceReservation();
//            sR.add(res);
//            c.reserve();
//            sC.update(c);
        }

    }

    @FXML
    private void confirmClicked(ActionEvent event) {
//        ServiceReservation sR = new ServiceReservation();
        ServiceReservation sR = new ServiceReservation();
        int id_user = 0;
        Period daysBetween = Period.between(entreeDate.getValue(), sortieDate.getValue());

        chambreLabel.setText(String.valueOf(c.getNumber()));
        prix_totaleLabel.setText(String.valueOf(daysBetween.getDays() * c.getPrix()));
        Reservation res = new Reservation(id_user, h.getId(), daysBetween.getDays() * c.getPrix(),
                entreeDate.getValue(), sortieDate.getValue(),
                c.getNumber(), "");

        sR.add(res);
        c.reserve();
        sC.update(c);
//        SendEmail s = new SendEmail("hana.mensia@esprit.tn", "Reservation", "Confirmation de reservation  ");

    }

    void initHotel() {

        TableColumn id_responsableColHotel = new TableColumn("id_responsable");
        id_responsableColHotel.setMinWidth(100);
        id_responsableColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("id_responsable"));

        TableColumn nomColHotel = new TableColumn("nom");
        nomColHotel.setMinWidth(100);
        nomColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("nom"));

        TableColumn addressColHotel = new TableColumn("address");
        addressColHotel.setMinWidth(100);
        addressColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("address"));

        TableColumn nb_etoileColHotel = new TableColumn("nb_etoile");
        nb_etoileColHotel.setMinWidth(100);
        nb_etoileColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("nb_etoile"));

        TableColumn phoneColHotel = new TableColumn("phone");
        phoneColHotel.setMinWidth(100);
        phoneColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("phone"));

        TableColumn capaciteColHotel = new TableColumn("capacite");
        capaciteColHotel.setMinWidth(100);
        capaciteColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("capacite"));

        tableH.getColumns().addAll(id_responsableColHotel, nomColHotel, addressColHotel, nb_etoileColHotel, phoneColHotel, capaciteColHotel);

        updateHotel();
    }

    void initChambre() {

        TableColumn id_userColReservation = new TableColumn("id");
        id_userColReservation.setMinWidth(100);
        id_userColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id"));

        TableColumn id_hotelColReservation = new TableColumn("id_hotel");
        id_hotelColReservation.setMinWidth(100);
        id_hotelColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_hotel"));

        TableColumn prixColReservation = new TableColumn("Number");
        prixColReservation.setMinWidth(100);
        prixColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("number"));

        TableColumn entreeColReservation = new TableColumn("disp");
        entreeColReservation.setMinWidth(100);
        entreeColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("disp"));
        tableC.getColumns().addAll(id_userColReservation, id_hotelColReservation, prixColReservation,
                entreeColReservation);
        tableC.toFront();
        System.out.println("tesst");
        // updateChambre();
    }

    public void updateReservation() {
        ServiceReservation sR = new ServiceReservation();
        List list = sR.getAll();
        ObservableList<Reservation> dataRes = FXCollections.observableArrayList(sR.getAll());

        // table.setItems(dataRes);
    }

    public void updateHotel() {
        ServiceHotel sh = new ServiceHotel();
        List list = sh.getAll();
        ObservableList<Hotel> listO = FXCollections.observableArrayList(list);

        System.out.println(list);
        tableH.setItems(listO);

    }

    public void updateChambre(Hotel h) {
        ServiceChambre sh = new ServiceChambre();
        List list = sh.getHotel(h);
        System.out.println("Hotel = " + list);
//        System.out.println(list);
        ObservableList<Chambre> listO = FXCollections.observableArrayList(list);

        tableC.setItems(listO);

    }
}
