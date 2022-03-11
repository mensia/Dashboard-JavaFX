/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class VolMController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private Text agenceLabel;
    @FXML
    private Text volLabel;
    @FXML
    private Text prix_totaleLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chooseClicked(ActionEvent event) {
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
    }
    
}
