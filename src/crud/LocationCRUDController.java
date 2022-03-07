/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class LocationCRUDController implements Initializable {

    @FXML
    private TableView<?> tableLocation;
    @FXML
    private TextField prix;
    @FXML
    private TextField date;
    @FXML
    private TextField destination;
    @FXML
    private TextField duree;
    @FXML
    private TextField prix_total;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddLocationClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateLocationClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteLocationClicked(ActionEvent event) {
    }
    
}
