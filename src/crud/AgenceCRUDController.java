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
public class AgenceCRUDController implements Initializable {

    @FXML
    private TableView<?> tableAgence;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddAgenceClicked(ActionEvent event) {
    }

    @FXML
    private void UpdateAgenceClicked(ActionEvent event) {
    }

    @FXML
    private void DeleteAgenceClicked(ActionEvent event) {
    }
    
}
