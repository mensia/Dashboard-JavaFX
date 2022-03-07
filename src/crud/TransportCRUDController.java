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
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddTransportClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateTransportClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteTransportClicked(ActionEvent event) {
    }
    
}
