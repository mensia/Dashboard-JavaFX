/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modeles.Enseignant;
import modeles.Etudiant;
import modeles.Recruteur;
import static modeles.Role.Recruteur;
import modeles.User;
import services.ServiceEns;
import services.ServiceEtudiant;
import services.ServiceRecruteur;
import services.ServiceUser;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    ServiceUser sU = new ServiceUser();
    ServiceEtudiant sE = new ServiceEtudiant();
    ServiceEns sEn = new ServiceEns();
    ServiceRecruteur sR = new ServiceRecruteur();


    @FXML
    private VBox pnl_scroll;
    @FXML
    private Label lbl_currentprojects;
    @FXML
    private Label lbl_pending;
    @FXML
    private Label lbl_completed;
    @FXML
    private ScrollPane Scrollepane;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        Scrollepane.gets
        refreshNodes();
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

        List<User> listU = sU.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (User each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void listUserClicked(ActionEvent event) {
        refreshNodes();
    }

    @FXML
    private void ListEtudiantClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Etudiant> listU = sE.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Etudiant each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void ListEnseignantClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Enseignant> listU = sEn.getAll();
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Enseignant each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

    @FXML
    private void ListRecruteurClicked(ActionEvent event) {
        pnl_scroll.getChildren().clear();

        List<Recruteur> listU = sR.getAll();
        System.out.println(listU);
        Node[] nodes = new Node[listU.size()];
        int i = 0;

        for (Recruteur each : listU) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
            ItemController cont = new ItemController();
            try {
                cont.U = each;
                loader.setController(cont);

                nodes[i] = (Node) loader.load();

                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
                pnl_scroll.getChildren().add(nodes[i]);

            } catch (IOException ex) {
                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;
        }
    }

}
