/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
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
    private TableView<Transport> tableTransport;
    @FXML
    private ComboBox<String> type;
    @FXML
    private CheckBox dispo;
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

        updateList();

        ObservableList value = FXCollections.observableArrayList("Mini bus", "voiture", "moto");
        type.setItems(value);
    }
    boolean DISPO = false;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initPage();

        dispo.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
//                dispo.setSelected(!newValue);

                DISPO = !DISPO;
                System.out.println("Changed, dispo = " + dispo.isPressed());
            }
        });

    }

    @FXML
    private void AddTransportClicked(ActionEvent event) {
        TransportCRUD sL = new TransportCRUD();

        t.setNum(Integer.parseInt(num.getText()));
        if (DISPO) {
            t.setDispo(1);
        } else {
            t.setDispo(0);
        }
        t.setType(type.getSelectionModel().getSelectedItem().toString());
        t.setId_prop(Integer.parseInt(id_prop.getText()));
        if (update) {
//            sL.modifierTransport(t);
//            num.setText("");
//            dispo.setSelected(true);
//            type.getSelectionModel().getSelectedItem().toString();
//            id_prop.setText("");
//            Transport trans = new Transport();
//            trans = t;
//
//            trans.setNum(Integer.parseInt(num.getText().toString()));
//            trans.setDispo(Boolean.compare(dispo.isPressed(), true));
//            trans.setType(type.getSelectionModel().getSelectedItem().toString());
//            trans.setId_prop(Integer.parseInt(id_prop.getText()));

            System.out.println("TRANS = " + t);

            sL.modifierTransport(t);

        } else {
            sL.ajouterTransport(t);
        }
        updateList();
        Empty();

    }

    @FXML
    private void UpdateTransportClicked(ActionEvent event) {
        Transport trans = new Transport();

        trans = tableTransport.getSelectionModel().getSelectedItem();

        t = trans;
        System.out.println(trans);

        num.setText(String.valueOf(trans.getNum()));
        boolean d = trans.getDispo() == 1;
        dispo.setSelected(d);
        type.setValue(trans.getType());
        id_prop.setText(String.valueOf(trans.getId_prop()));

        update = true;
        System.out.println("in update");
//        System.out.println(trans);

//        initPage();
    }

    @FXML
    private void DeleteTransportClicked(ActionEvent event) {

        t = tableTransport.getSelectionModel().getSelectedItem();
        TransportCRUD sT = new TransportCRUD();
        System.out.println(t);
        sT.supprimerTransport(t.getId());
//        initPage();
        Empty();
        updateList();

    }

    public void updateList() {
        TransportCRUD sT = new TransportCRUD();
        List list = sT.affichageTransport();
        ObservableList<Transport> data = FXCollections.observableArrayList(sT.affichageTransport());
        tableTransport.setItems(data);

    }

    private void Empty() {
        id_prop.setText("");
        num.setText("");
        dispo.setSelected(false);
//            type.setSelectionModel();
        id_prop.setText("");
    }

}
