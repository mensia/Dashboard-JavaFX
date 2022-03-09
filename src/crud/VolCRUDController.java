/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.sql.Date;
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
import modeles.Vol;
import services.ServiceVol;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class VolCRUDController implements Initializable {

    @FXML
    private TableView<Vol> tableVol;
    @FXML
    private TextField id_agence;
    @FXML
    private TextField capacity;
    @FXML
    private TextField prix;
    @FXML
    private TextField company;
    @FXML
    private TextField depart;
    @FXML
    private TextField destination;
    @FXML
    private TextField date;

    /**
     * Initializes the controller class.
     */
    
    
        boolean update = false;
        Vol v = new Vol() ; 
        
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
                initPage();

    }    
    void initPage(){
     ServiceVol sv = new ServiceVol();

        List list = sv.getAll();
        System.out.println(list);
        ObservableList<Vol> listO = FXCollections.observableArrayList(list);
        
        TableColumn id_agenceColVol = new TableColumn("id_agence");
        id_agenceColVol.setMinWidth(100);
        id_agenceColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("id_agence"));

        TableColumn capacityColVol = new TableColumn("capacity");
        capacityColVol.setMinWidth(100);
        capacityColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("capacity"));

        TableColumn prixColVol = new TableColumn("prix");
        prixColVol.setMinWidth(100);
        prixColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("prix"));

        TableColumn companyColVol = new TableColumn("company");
        companyColVol.setMinWidth(100);
        companyColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("company"));

        TableColumn departColVol = new TableColumn("depart");
        departColVol.setMinWidth(100);
        departColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("depart"));

        TableColumn destinationColVol = new TableColumn("destination");
        destinationColVol.setMinWidth(100);
        destinationColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("destination"));

        TableColumn dateColVol = new TableColumn("date");
        dateColVol.setMinWidth(100);
        dateColVol.setCellValueFactory(
                new PropertyValueFactory<Vol, String>("date"));

        tableVol.getColumns().addAll(id_agenceColVol, capacityColVol, prixColVol, companyColVol, departColVol, destinationColVol, dateColVol);
        
       

        tableVol.setItems(listO);
    }

    @FXML
    private void AddVolClicked(ActionEvent event) {
          ServiceVol sv = new ServiceVol();

        v.setId_agence(Integer.parseInt(id_agence.getText()));
        v.setCapacity(Integer.parseInt(capacity.getText()));
        v.setPrix(Integer.parseInt(prix.getText()));
        v.setDestination(destination.getText());
        v.setDepart(depart.getText());
        v.setCompany(company.getText());
        v.setDate(Date.valueOf(date.getText()));

        if (update) {
            sv.update(v);
            date.setText("");
             company.setText("");
             depart.setText(""); 
             destination.setText(""); 
             prix.setText(""); 
             capacity.setText(""); 
             id_agence.setText("");
            
//            System.out.println("in update clicked");
//        System.out.println(a);
        } else {
            sv.add(v);
        }
        initPage();
    }

    @FXML
    private void UpdateVolClicked(ActionEvent event) {
         v = (Vol) tableVol.getSelectionModel().getSelectedItem();

        id_agence.setText(String.valueOf(v.getId_agence()));
        capacity.setText(String.valueOf(v.getCapacity()));
        prix.setText(String.valueOf(v.getPrix()));
        destination.setText(String.valueOf(v.getDestination()));
        depart.setText(String.valueOf(v.getDepart()));
        date.setText(String.valueOf(v.getDate()));
        company.setText(String.valueOf(v.getCompany()));

        update = true;
        System.out.println("in update");
        System.out.println(v);

        initPage();

    }

    @FXML
    private void DeleteVolClicked(ActionEvent event) {
          v = (Vol) tableVol.getSelectionModel().getSelectedItem();
        ServiceVol sv = new ServiceVol();

        sv.delete(v);
        initPage();
    }
    
}
