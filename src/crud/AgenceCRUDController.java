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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modeles.Agence;
import services.ServiceAgence;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class AgenceCRUDController implements Initializable {

    boolean update = false;

    @FXML
    private TableView<Agence> tableAgence;
    @FXML
    private TextField id_prop;
    @FXML
    private TextField nom;
    @FXML
    private TextField numero;
    @FXML
    private TextField nb_etoile;
    @FXML
    private TextField address;

    Agence a = new Agence();

    void initPage() {

        TableColumn idColAgence = new TableColumn("id");
        idColAgence.setMinWidth(100);
        idColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("id"));

        TableColumn id_propColAgence = new TableColumn("id_prop");
        id_propColAgence.setMinWidth(100);
        id_propColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("id_prop"));

        TableColumn nomColAgence = new TableColumn("nom");
        nomColAgence.setMinWidth(100);
        nomColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("nom"));

        TableColumn numeroColAgence = new TableColumn("numero");
        numeroColAgence.setMinWidth(100);
        numeroColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("numero"));

        TableColumn nb_etoileColAgence = new TableColumn("nb_etoile");
        nb_etoileColAgence.setMinWidth(100);
        nb_etoileColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("nb_etoile"));

        TableColumn addressColAgence = new TableColumn("address");
        addressColAgence.setMinWidth(100);
        addressColAgence.setCellValueFactory(
                new PropertyValueFactory<Agence, String>("address"));

        tableAgence.getColumns().addAll(idColAgence, id_propColAgence, nomColAgence, numeroColAgence, nb_etoileColAgence, addressColAgence);
//        tableAgence.setItems(dataAgence);
        updateList();
    }

    public void updateList() {
        ServiceAgence sA = new ServiceAgence();

        List list = sA.getAll();
        System.out.println(list);
        ObservableList<Agence> listO = FXCollections.observableArrayList(list);

        tableAgence.setItems(listO);

    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initPage();

    }

    @FXML
    private void AddAgenceClicked(ActionEvent event) {

        ServiceAgence sA = new ServiceAgence();
//        if (!update) {
//            Agence a = new Agence();
//        }
//        int index = tableAgence.getSelectionModel().getSelectedIndex();

        a.setId_prop(Integer.parseInt(id_prop.getText()));
        a.setNom(nom.getText());
        a.setNumero(Integer.parseInt(numero.getText()));
        a.setNb_etoile(Integer.parseInt(nb_etoile.getText()));
        a.setAddress(address.getText());

        if (update) {
            sA.update(a);
            id_prop.setText("");
            nom.setText("");
            numero.setText("");
            nb_etoile.setText("");
            address.setText("");
//            System.out.println("in update clicked");
//        System.out.println(a);
        } else {
            sA.add(a);
        }
//        initPage();
        updateList();
        Empty();
    }

    @FXML
    private void UpdateAgenceClicked(ActionEvent event) {

        a = (Agence) tableAgence.getSelectionModel().getSelectedItem();
        System.out.println(a);
        id_prop.setText(String.valueOf(a.getId_prop()));
        nom.setText(a.getNom());
        numero.setText(String.valueOf(a.getNumero()));
        nb_etoile.setText(String.valueOf(a.getNb_etoile()));
        address.setText(String.valueOf(a.getAddress()));

//        ServiceAgence sA = new ServiceAgence();
//        Agence a = new Agence();
//        int index = tableAgence.getSelectionModel().getSelectedIndex();
//
//        a.setId_prop(Integer.parseInt(id_prop.getText()));
//        a.setNom(nom.getText());
//        a.setNumero(Integer.parseInt(numero.getText()));
//        a.setNb_etoile(Integer.parseInt(nb_etoile.getText()));
//        a.setAddress(address.getText());
        update = true;
        System.out.println("in update");
        System.out.println(a);
//        sA.update(a);
//        initPage();
//        updateList();
//        Empty();

    }

    @FXML
    private void DeleteAgenceClicked(ActionEvent event) {
        a = (Agence) tableAgence.getSelectionModel().getSelectedItem();
        ServiceAgence sA = new ServiceAgence();

        sA.delete(a);
        initPage();
    }

    private void Empty() {
        id_prop.setText("");
        nom.setText("");
        numero.setText("");
        nb_etoile.setText("");
        address.setText("");
    }

}
