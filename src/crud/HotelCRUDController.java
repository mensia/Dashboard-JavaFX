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
public class HotelCRUDController implements Initializable {

    @FXML
    private TableView<?> tableHotel;
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
    private TextField type;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddHotelClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateHotelClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteHotelClicked(ActionEvent event) {
    }
    
}
