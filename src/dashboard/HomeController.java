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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import modeles.User;
import services.ServiceUser;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {

    ServiceUser sU = new ServiceUser();

    @FXML
    private Label label;

    @FXML
    private VBox pnl_scroll;

    @FXML
    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

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

}
