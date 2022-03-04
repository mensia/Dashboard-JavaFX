/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modeles.User;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class EditItemController implements Initializable {

    @FXML
    private Label role;
    @FXML
    private Label labelsection;
    @FXML
    private Label labelscore;
    User u;
    @FXML
    private TextField nom;
    @FXML
    private TextField phone;
    @FXML
    private TextField prenom;
    @FXML
    private TextField email;
    @FXML
    private TextField carteBancaire;
    @FXML
    private TextField section;
    @FXML
    private TextField score;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nom.setText(u.getNom());
        phone.setText(String.valueOf(u.getPhone()));
        prenom.setText(u.getPrenom());
        email.setText(u.getEmail());
        carteBancaire.setText(u.getCarte_banq());
        // section.setText(u.get);
        // score.setText(u.get);
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
        User x = null;
        x.setNom(nom.getText());
        x.setPrenom(prenom.getText());
        x.setPhone(Integer.parseInt(phone.getText()));
        x.setEmail(email.getText());
        x.setCarte_banq(carteBancaire.getText());

    }

}
