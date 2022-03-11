/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

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

    boolean niv = false;

    @FXML
    private void chooseClicked(ActionEvent event) {
        Hotel h = new Hotel();
        if (niv) {

            h = (Hotel) tableH.getSelectionModel().getSelectedItem();
            h.setChambres();
            // **disponibilite */

            // AFFICHAGE
            if (h.isDispo()) {

                initChambre();
                updateChambre(h);
            } else {

            }
            niv = !niv;
        } else {
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

        }

    }

    @FXML
    private void confirmClicked(ActionEvent event) {
    }

    void initHotel() {

        TableColumn id_userColReservation = new TableColumn("id_user");
        id_userColReservation.setMinWidth(100);
        id_userColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_user"));

        TableColumn id_hotelColReservation = new TableColumn("id_hotel");
        id_hotelColReservation.setMinWidth(100);
        id_hotelColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_hotel"));

        TableColumn prixColReservation = new TableColumn("prix");
        prixColReservation.setMinWidth(100);
        prixColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("prix"));

        TableColumn entreeColReservation = new TableColumn("entree");
        entreeColReservation.setMinWidth(100);
        entreeColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("entree"));

        TableColumn sortieColReservation = new TableColumn("sortie");
        sortieColReservation.setMinWidth(100);
        sortieColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("sortie"));

        TableColumn num_chambreColReservation = new TableColumn("num_chambre");
        num_chambreColReservation.setMinWidth(100);
        num_chambreColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("num_chambre"));

        TableColumn descriptionColReservation = new TableColumn("description");
        descriptionColReservation.setMinWidth(100);
        descriptionColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("description"));

        tableH.getColumns().addAll(id_userColReservation, id_hotelColReservation, prixColReservation,
                entreeColReservation, sortieColReservation, num_chambreColReservation, descriptionColReservation);
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
                new PropertyValueFactory<Reservation, String>("Number"));

        TableColumn entreeColReservation = new TableColumn("disp");
        entreeColReservation.setMinWidth(100);
        entreeColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("disp"));
        tableC.getColumns().addAll(id_userColReservation, id_hotelColReservation, prixColReservation,
                entreeColReservation);
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
        System.out.println(list);
        ObservableList<Hotel> listO = FXCollections.observableArrayList(list);

        tableH.setItems(listO);

    }

    public void updateChambre(Hotel h) {
        ServiceChambre sh = new ServiceChambre();
        List list = sh.getHotel(h);
        System.out.println(list);
        ObservableList<Chambre> listO = FXCollections.observableArrayList(list);

        tableC.setItems(listO);

    }
}
