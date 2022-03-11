/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import modeles.Hotel;
import modeles.Type;

import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class HotelCRUDController implements Initializable {

    boolean update = false;

    @FXML
    private TableView<Hotel> tableHotel;
    @FXML
    private TextField id_prop;
    @FXML
    private TextField nom;
    @FXML
    private TextField address;
    @FXML
    private TextField nb_etoile;
    @FXML
    private TextField phone;
    @FXML
    private TextField capacite;
    @FXML
    private ComboBox<String> type;

    /**
     * Initializes the controller class.
     */
    Hotel h = new Hotel();

    public void updateList() {
        ServiceHotel sh = new ServiceHotel();
        List list = sh.getAll();
        System.out.println(list);
        ObservableList<Hotel> listO = FXCollections.observableArrayList(list);

        tableHotel.setItems(listO);

    }

    void initPage() {

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

        tableHotel.getColumns().addAll(id_responsableColHotel, nomColHotel, addressColHotel, nb_etoileColHotel, phoneColHotel, capaciteColHotel);
        updateList();

        ObservableList value = FXCollections.observableArrayList("Hotel", "Maison D'hut", "Appartement", "Lounge");
        type.setItems(value);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPage();
        updateList();
    }

    private void Empty() {
        id_prop.setText("");
        nom.setText("");
        phone.setText("");
        nb_etoile.setText("");
        address.setText("");
        capacite.setText("");
    }

    @FXML
    private void AddHotelClicked(ActionEvent event) {

        ServiceHotel sh = new ServiceHotel();
        h = new Hotel();
        h.setId_responsable(Integer.parseInt(id_prop.getText()));
        h.setNom(nom.getText());
        h.setAddress(address.getText());

        h.setNb_etoile(Integer.parseInt(nb_etoile.getText()));
        h.setPhone(Integer.parseInt(phone.getText()));
        h.setCapacite(Integer.parseInt(capacite.getText()));

        h.setType("empty");
        h.setType(type.getSelectionModel().getSelectedItem().toString());
        System.out.println(h);
        System.out.println(Type.type(type.getSelectionModel().getSelectedItem()));

        if (update) {
            sh.update(h);
//            id_prop.setText("");
//            nom.setText("");
//            phone.setText("");
//            nb_etoile.setText("");
//            address.setText("");
//            capacite.setText("");

        } else {
            sh.add(h);
        }
        updateList();
        Empty();
    }

    @FXML
    private void UpdateHotelClicked(ActionEvent event) {

        h = (Hotel) tableHotel.getSelectionModel().getSelectedItem();

        id_prop.setText(String.valueOf(h.getId_responsable()));
        nom.setText(h.getNom());
        phone.setText(String.valueOf(h.getPhone()));
        nb_etoile.setText(String.valueOf(h.getNb_etoile()));
        address.setText(String.valueOf(h.getAddress()));
        capacite.setText(String.valueOf(h.getCapacite()));

        type.setValue(h.getType().toString());

        update = true;
        System.out.println("in update");
        System.out.println(h);

    }

    @FXML
    private void DeleteHotelClicked(ActionEvent event) {

        h = (Hotel) tableHotel.getSelectionModel().getSelectedItem();
        ServiceHotel sA = new ServiceHotel();

        sA.delete(h);
        initPage();
    }

}
