/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
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

import modeles.Transport;
import services.LocationsCRUD;
import services.TransportCRUD;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class TransportCRUDController implements Initializable {

    @FXML
    private TableView<?> tableTransport;
    @FXML
    private TextField type;
    @FXML
    private TextField dispo;
    @FXML
    private TextField num;

    /**
     * Initializes the controller class.
     */
    boolean update = false;
    Transport t = new Transport();
    @FXML
    private TextField id_prop;

    void initPage() {

        TransportCRUD sT = new TransportCRUD();
        ObservableList<Transport> data = FXCollections.observableArrayList(sT.affichageTransport());

        TableColumn idCol = new TableColumn("id");
        idCol.setMinWidth(100);
        idCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id"));

        TableColumn typeCol = new TableColumn("type");
        typeCol.setMinWidth(100);
        typeCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("type"));

        TableColumn dispoCol = new TableColumn("dispo");
        dispoCol.setMinWidth(100);
        dispoCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("dispo"));

        TableColumn numCol = new TableColumn("num");
        numCol.setMinWidth(100);
        numCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("num"));
        
        TableColumn idPropCol = new TableColumn("id_prop");
        idPropCol.setMinWidth(100);
        idPropCol.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_prop"));
        

        tableTransport.getColumns().addAll(idCol, typeCol, dispoCol, numCol, idPropCol);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void AddTransportClicked(ActionEvent event) {
        TransportCRUD sL = new TransportCRUD();

        t.setNum(Integer.parseInt(num.getText()));
        t.setDispo(Integer.parseInt(dispo.getText()));
        t.setType(type.getText());
        t.setId_prop(Integer.parseInt(id_prop.getText()));
 if (update) {
            sL.modifierTransport(t);
            num.setText("");
            dispo.setText("");
            type.setText("");
            id_prop.setText("");
           

        } else {
            sL.ajouterTransport(t);
        }
        initPage();

    }

    @FXML
    private void UpdateTransportClicked(ActionEvent event) {
    
    t = (Transport) tableTransport.getSelectionModel().getSelectedItem();

        t.setNum(Integer.parseInt(num.getText()));
        t.setDispo(Integer.parseInt(dispo.getText()));
        t.setType(type.getText()) ; 
        t.setId_prop(Integer.parseInt(id_prop.getText()));
        update = true;
        System.out.println("in update");
        System.out.println(t);

        initPage();
    }

    @FXML
    private void DeleteTransportClicked(ActionEvent event) {
        
         t = (Transport) tableTransport.getSelectionModel().getSelectedItem();
        LocationsCRUD sA = new LocationsCRUD();

        sA.supprimerLocations(t.getId());
        initPage();
        
    }

}
