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
public class ReservationCRUDController implements Initializable {

    @FXML
    private TableView<?> tableReservation;
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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddReservationClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateReservationClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteReservation(ActionEvent event) {
    }
    
}
