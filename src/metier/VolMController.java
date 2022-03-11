/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import TTS.TextToSpeech;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import modeles.Agence;
import modeles.Hotel;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class VolMController implements Initializable {

    @FXML
    private TableView<Agence> table;
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
        TextToSpeech t = new TextToSpeech();
        t.speak("CONFIRMED");
    }
    void initHotel() {

        TableColumn id_responsableColHotel = new TableColumn("id_responsable");
        id_responsableColHotel.setMinWidth(100);
        id_responsableColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("id_responsable"));

        TableColumn nomColHotel = new TableColumn("nom");
        nomColHotel.setMinWidth(100);
        nomColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("nom"));

        TableColumn addressColHotel = new TableColumn("address");
        addressColHotel.setMinWidth(100);
        addressColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("address"));

        TableColumn nb_etoileColHotel = new TableColumn("nb_etoile");
        nb_etoileColHotel.setMinWidth(100);
        nb_etoileColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("nb_etoile"));

        TableColumn phoneColHotel = new TableColumn("phone");
        phoneColHotel.setMinWidth(100);
        phoneColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("phone"));

        TableColumn capaciteColHotel = new TableColumn("capacite");
        capaciteColHotel.setMinWidth(100);
        capaciteColHotel.setCellValueFactory(
                new PropertyValueFactory<Hotel, String>("capacite"));

        tableHotel.getColumns().addAll(id_responsableColHotel, nomColHotel, addressColHotel, nb_etoileColHotel, phoneColHotel, capaciteColHotel);
        updateList();

        ObservableList value = FXCollections.observableArrayList("Hotel", "Maison D'hut", "Appartement", "Lounge");
        type.setItems(value);
    }
}
