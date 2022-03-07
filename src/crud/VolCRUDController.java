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
public class VolCRUDController implements Initializable {

    @FXML
    private TableView<?> tableVol;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddVolClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateVolClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteVolClicked(ActionEvent event) {
    }
    
}
