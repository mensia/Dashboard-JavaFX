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
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.NodeOrientation;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author oXCToo
 */
public class HomeController implements Initializable {


    @FXML
    private VBox pnl_scroll;
    @FXML
    private ScrollPane Scrollepane;

    private void handleButtonAction(MouseEvent event) {
        refreshNodes();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/HotelCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshNodes() {
        pnl_scroll.getChildren().clear();

//        List<User> listU = sU.getAll();
//        Node[] nodes = new Node[listU.size()];
//        int i = 0;
//
//        for (User each : listU) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
//            ItemController cont = new ItemController();
//            try {
//                cont.U = each;
//                loader.setController(cont);
//
//                nodes[i] = (Node) loader.load();
//
//                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
//                pnl_scroll.getChildren().add(nodes[i]);
//
//            } catch (IOException ex) {
//                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            i++;
//        }
    }

    @FXML
    private void listUserClicked(ActionEvent event) {
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
        pnl_scroll.getChildren().clear();

            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/AgenceCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void ListEtudiantClicked(ActionEvent event) {
//        boxifyVBoxes();
//        pnl_scroll.getChildren().clear();
//
//        List<Etudiant> listU = sE.getAll();
//        Node[] nodes = new Node[listU.size()];
//        int i = 0;
//
//        for (Etudiant each : listU) {
//            FXMLLoader loader = new FXMLLoader(getClass().getResource("Item.fxml"));
//            ItemController cont = new ItemController();
//            try {
//                cont.U = each;
//                loader.setController(cont);
//
//                nodes[i] = (Node) loader.load();
//
//                // nodes[i] = (Node)FXMLLoader.load(getClass().getResource("Item.fxml"));
//                pnl_scroll.getChildren().add(nodes[i]);
//
//            } catch (IOException ex) {
//                Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            i++;
//        }
    }

    public void AddClicked(ActionEvent event) throws IOException {
//        pnl_scroll.getChildren().clear();
//        EditItemController cont = new EditItemController();
//        cont.type = 1;
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
//        pnl_scroll.getChildren().add(loader.load());

//        EditItemController cont = new EditItemController();
//        cont.type = 1;
////        cont.u = this.U;
//
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("EditItem.fxml"));
//        loader.setController(cont);
////        mainAnchor = loader.load();
//
//        Stage stage = new Stage();
//        stage.setTitle("My New Stage Title");
//        stage.setScene(new Scene(loader.load()));
//        stage.show();

//        pnl_scroll.getChildren().add(FXMLLoader.load(getClass().getResource("EditItem.fxml")));
    }

    public void reload(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);

        stage.setScene(scene);
        stage.show();

    }

    private void boxifyVBoxes() {
        // styles used for vboxes
        Background focusBackground = new Background(new BackgroundFill(Color.BLUEVIOLET, CornerRadii.EMPTY, Insets.EMPTY));
        Background unfocusBackground = new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY));
        Border border = new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, null));

        for (Node child : pnl_scroll.getChildren()) {
            VBox vb = (VBox) child;
            vb.setPadding(new Insets(10));
            vb.setBorder(border);

            // when vbox is clicked focus on it
            vb.setOnMouseClicked((e) -> {
                vb.requestFocus();
            });

            // use different backgrounds for focused and unfocused states
            vb.backgroundProperty().bind(Bindings
                    .when(vb.focusedProperty())
                    .then(focusBackground)
                    .otherwise(unfocusBackground));

        }
    }

    @FXML
    private void VolClicked(ActionEvent event) {
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/VolCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void transportClicked(ActionEvent event) {
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/TransportCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void locationClicked(ActionEvent event) {
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/LocationCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void hotelClicked(ActionEvent event) {  
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/HotelCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void reservationClicked(ActionEvent event) {
                pnl_scroll.getChildren().clear();

        try {
            // TODO
//        Scrollepane.gets
//        refreshNodes();
            pnl_scroll.getChildren().add((Node) FXMLLoader.load(getClass().getResource("/crud/ReservationCRUD.fxml")));
            
        } catch (IOException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void sendMailClicked(ActionEvent event) {
    }

    @FXML
    private void makeReservationClicked(ActionEvent event) {
    }

    @FXML
    private void commanderVolClicked(ActionEvent event) {
    }

    @FXML
    private void reserverChambreClicked(ActionEvent event) {
    }

}
