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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
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
    @FXML
    private ImageView Img;
    @FXML
    private Label id;
    @FXML
    private AnchorPane mainAnchor;

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
        if (U.getRole() == Role.etudiant) {
            Etudiant e = (Etudiant) U;
            section.setText(e.getSection());
            score.setText(String.valueOf(e.getScore()));

        } else {

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
    private void DeleteClicked(ActionEvent event) throws IOException {
        sU.delete(U);

        HomeController Close = new HomeController();
        Close.reload(event);

    }

    @FXML
    private void UpdateClicked(ActionEvent event) throws IOException {

//        ItemController cont = new ItemController();
//        cont.U = this.U;
//        HomeController home = new HomeController();
//        home.updateUser(this.U);
        EditItemController cont = new EditItemController();
        cont.type = 2;
        cont.u = this.U;

        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
        loader.setController(cont);
//        mainAnchor = loader.load();

        Stage stage = new Stage();
        stage.setTitle("My New Stage Title");
        stage.setScene(new Scene(loader.load()));
        stage.show();
        HomeController Close = new HomeController();
        Close.reload(event);
//        Parent root = FXMLLoader.load(getClass().getResource("EditItem.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//
//        stage.setScene(scene);
//        stage.show();
    }

}
