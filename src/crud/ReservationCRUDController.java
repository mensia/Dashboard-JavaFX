/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.ZoneId;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modeles.Reservation;
import services.ServiceReservation;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class ReservationCRUDController implements Initializable {

    @FXML
    private TableView<Reservation> tableReservation;
    @FXML
    private TextField id_user;
    @FXML
    private TextField id_hotel;
    @FXML
    private TextField prix;
    @FXML
    private TextField num_chambre;
    @FXML
    private TextField description;
    private TextField entree;
    private TextField sortie;

    /**
     * Initializes the controller class.
     */
    boolean update = false;
    Reservation r = new Reservation();
    @FXML
    private DatePicker dateentre;
    @FXML
    private DatePicker datesortie;

    void initPage() {

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

        tableReservation.getColumns().addAll(id_userColReservation, id_hotelColReservation, prixColReservation, entreeColReservation, sortieColReservation, num_chambreColReservation, descriptionColReservation);
        updateList();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initPage();

    }

    @FXML
    private void AddReservationClicked(ActionEvent event) {
        ServiceReservation sr = new ServiceReservation();
        r.setId_user(Integer.parseInt(id_user.getText()));
        r.setId_hotel(Integer.parseInt(id_hotel.getText()));
        r.setPrix(Integer.parseInt(prix.getText()));

        r.setEntree(dateentre.getValue());
        r.setSortie(datesortie.getValue());

        r.setNum_chambre(Integer.parseInt(num_chambre.getText()));
        r.setDescription(description.getText());

//       
        System.out.println("res= " + r);
//             Date d = (dateentre.getValue());
//             Date d1 = (Date.valueOf(sortie.getText()));
//             ZoneId defaultZoneId = ZoneId.systemDefault();
//             Instant ins = d.toInstant() ; 
//             Instant ins2 = d1.toInstant() ;
//             LocalDate Local = ins.atZone(defaultZoneId).toLocalDate(); 
//             LocalDate Local2 = ins2.atZone(defaultZoneId).toLocalDate(); 
//             r.setEntree(Local);
//             r.setSortie(Local2);
        if (update) {
            sr.update(r);
            description.setText("");
            num_chambre.setText("");

            prix.setText("");
            id_hotel.setText("");
            id_user.setText("");
//            System.out.println("in update clicked");
//        System.out.println(a);
        } else {
            sr.add(r);
        }
        updateList();
        Empty();

    }

    @FXML
    private void UpdateReservationClicked(ActionEvent event) {
        r = (Reservation) tableReservation.getSelectionModel().getSelectedItem();

        ServiceReservation sr = new ServiceReservation();
      
        id_user.setText(String.valueOf(r.getId_user()));
        id_hotel.setText(String.valueOf(r.getId_hotel()));
        prix.setText(String.valueOf(r.getPrix()));
        
        dateentre.setValue(r.getEntree());
        datesortie.setValue(r.getSortie());
        
        num_chambre.setText(String.valueOf(r.getNum_chambre()));
        description.setText(String.valueOf(r.getDescription()));
        
        
                
        
//        r.setNum_chambre(Integer.parseInt(num_chambre.getText()));
//        r.setDescription(description.getText());

        update = true;
        System.out.println("in update");
        System.out.println(r);
//        sA.update(a);
        initPage();
    }

    @FXML
    private void DeleteReservation(ActionEvent event) {
        r = (Reservation) tableReservation.getSelectionModel().getSelectedItem();
        ServiceReservation sr = new ServiceReservation();

        sr.delete(r);
        initPage();
    }

    private void Empty() {
        description.setText("");
        num_chambre.setText("");
//        entree.setText("");
//        sortie.setText("");
        prix.setText("");
        id_hotel.setText("");
        id_user.setText("");
    }

    public void updateList() {
        ServiceReservation sR = new ServiceReservation();
        List list = sR.getAll();
        ObservableList<Reservation> dataRes = FXCollections.observableArrayList(sR.getAll());

        tableReservation.setItems(dataRes);
    }

}
