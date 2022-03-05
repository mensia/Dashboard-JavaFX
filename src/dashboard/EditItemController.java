/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import modeles.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;

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
    int type = 0;
    @FXML
    private ImageView img;
    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();
    @FXML
    private TextField psw;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if (type == 1) {
            role.setText("Add");
        }
        if (type == 2) {
            nom.setText(u.getNom());
            phone.setText(String.valueOf(u.getPhone()));
            prenom.setText(u.getPrenom());
            email.setText(u.getEmail());
            carteBancaire.setText(u.getCarte_banq());
            psw.setText(u.getPwd());
            // section.setText(u.get);
            // score.setText(u.get);
        }
    }
    
    @FXML
    private void confirmClicked(ActionEvent event) throws IOException {
        User x = new User();
        x.setNom(nom.getText());
        x.setPrenom(prenom.getText());
        x.setPhone(Integer.parseInt(phone.getText()));
        x.setEmail(email.getText());
        x.setCarte_banq(carteBancaire.getText());
        x.setPwd(psw.getText());
//        System.out.println(x);
        if (type == 1) {
            sU.add(x);
        }
        if (type == 2) {
        x.setId(u.getId());
            sU.update(x);
        }
//        HomeController Close = new HomeController();
//        Close.reload(event);
//        //LOGOUT ***
        final Node source = (Node) event.getSource();
        final Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }
    
}
