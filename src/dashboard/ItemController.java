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
import modeles.Etudiant;
import modeles.Role;
import modeles.User;
import services.ServiceUser;

/**
 * FXML Controller class
 *
 * @author mrram
 */
public class ItemController implements Initializable {
    ServiceUser sU = new ServiceUser();

    private Label Username;

    String test;
    User U;
    @FXML
    private Label prenom;
    @FXML
    private Label phone;
    @FXML
    private Label section;
    @FXML
    private Label score;
    @FXML
    private Label role;
    @FXML
    private Label nom;
    @FXML
    private Label mail;
    @FXML
    private Label cartbanq;

//    public ItemController(String haja) {
//        this.test = haja;
//    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Username.setText("ahmeddd");
//        nom.setText(U.getNom());

        nom.setText(U.getNom());
        prenom.setText(U.getPrenom());
        phone.setText(String.valueOf(U.getPhone()));
        if (U.getRole()==Role.etudiant) {
            Etudiant e = (Etudiant) U;
        section.setText(e.getSection());
        score.setText(String.valueOf(e.getScore()));
            
        }else{
            
        section.setText("");
        score.setText("");
        }
        role.setText(U.getRole().toString());
        mail.setText(U.getEmail());
        cartbanq.setText(U.getCarte_banq());

    }

    void initData(String u) {
        Username.setText(u);
    }

    @FXML
    private void DeleteClicked(ActionEvent event) {
        sU.delete(U);
    }

}
