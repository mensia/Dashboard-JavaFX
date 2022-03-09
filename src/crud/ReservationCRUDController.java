/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    @FXML
    private TextField entree;
    @FXML
    private TextField sortie;

    /**
     * Initializes the controller class.
     */
    
    boolean update = false;
    Reservation r = new Reservation(); 
    
     void initPage() {
    ServiceReservation sR = new ServiceReservation();
        ObservableList<Reservation> dataRes = FXCollections.observableArrayList(sR.getAll());

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
       tableReservation.setItems(dataRes);
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
       
             Date d = (Date.valueOf(entree.getText()));
             Date d1 = (Date.valueOf(sortie.getText()));
             ZoneId defaultZoneId = ZoneId.systemDefault();
             Instant ins = d.toInstant() ; 
             Instant ins2 = d1.toInstant() ;
             LocalDate Local = ins.atZone(defaultZoneId).toLocalDate(); 
             LocalDate Local2 = ins2.atZone(defaultZoneId).toLocalDate(); 
             r.setEntree(Local);
             r.setSortie(Local2);
      
        r.setNum_chambre(Integer.parseInt(num_chambre.getText()));
        r.setDescription(description.getText());
       

        if (update) {
            sr.update(r);
            description.setText("");
            num_chambre.setText("");
            entree.setText("");
            sortie.setText("");
            prix.setText("");
            id_hotel.setText("");
            id_user.setText("");
//            System.out.println("in update clicked");
//        System.out.println(a);
        } else {
            sr.add(r);
        }
        initPage();
        
    }

    @FXML
    private void UpdateReservationClicked(ActionEvent event) {
        r = (Reservation) tableReservation.getSelectionModel().getSelectedItem();

         ServiceReservation sr = new ServiceReservation();
        r.setId_user(Integer.parseInt(id_user.getText()));
        r.setId_hotel(Integer.parseInt(id_hotel.getText()));
        r.setPrix(Integer.parseInt(prix.getText()));
       
             Date d = (Date.valueOf(entree.getText()));
             Date d1 = (Date.valueOf(sortie.getText()));
             ZoneId defaultZoneId = ZoneId.systemDefault();
             Instant ins = d.toInstant() ; 
             Instant ins2 = d1.toInstant() ;
             LocalDate Local = ins.atZone(defaultZoneId).toLocalDate(); 
             LocalDate Local2 = ins2.atZone(defaultZoneId).toLocalDate(); 
             r.setEntree(Local);
             r.setSortie(Local2);
      
        r.setNum_chambre(Integer.parseInt(num_chambre.getText()));
        r.setDescription(description.getText());

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
    
}
