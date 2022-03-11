/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metier;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;
import modeles.Chambre;
import modeles.Hotel;
import services.ServiceHotel;

/**
 * FXML Controller class
 *
 * @author hanam
 */
public class ReservationMController implements Initializable {

    @FXML
    private TableView<?> table;
    @FXML
    private Text hotelLabel;
    @FXML
    private Text chambreLabel;
    @FXML
    private Text prix_totaleLabel;
    @FXML
    private DatePicker entreeDate;
    @FXML
    private DatePicker sortieDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        ServiceHotel sH = new ServiceHotel();

    void assas(){
        List<Hotel> list_hotel = sH.getAll();
        list_hotel.forEach(h -> System.out.println(h));
        System.out.println("id= ");
        int id = Integer.valueOf(in.nextLine());

        Hotel h = (Hotel) sH.getById(id);
        h.setChambres();
        //**disponibilite */
        if (h.isDispo()) {
            h.getChambreDispo().forEach(c -> System.out.println(c));
            System.out.println("id_chambre= ");
            int id_chambre = Integer.valueOf(in.nextLine());
            Chambre c = (Chambre) sC.getById(id_chambre);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
            System.out.println("Date sous form 31 12 2000");
            System.out.println("entree= ");
            LocalDate entree = LocalDate.parse(in.nextLine(), dtf);
            System.out.println("Sortie= ");
            LocalDate sortie = LocalDate.parse(in.nextLine(), dtf);

            int id_user = 0;
            Period daysBetween = Period.between(entree, sortie);

            Reservation res = new Reservation(id_user, h.getId(), daysBetween.getDays() * c.getPrix(), entree, sortie,
                    c.getNumber(), c.getDescription());

            sR.add(res);
            c.reserve();
            sC.update(c);
        } else {
            System.out.println("Hotel complet");
        }
    }
    void mohemayaser(){
        
        initHotel();


        Hotel h = (Hotel) sH.getById(id);
        h.setChambres();
        //**disponibilite */
        if (h.isDispo()) {
            h.getChambreDispo().forEach(c -> System.out.println(c));
            System.out.println("id_chambre= ");
            int id_chambre = Integer.valueOf(in.nextLine());
            Chambre c = (Chambre) sC.getById(id_chambre);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd MM yyyy");
            System.out.println("Date sous form 31 12 2000");
            System.out.println("entree= ");
            LocalDate entree = LocalDate.parse(in.nextLine(), dtf);
            System.out.println("Sortie= ");
            LocalDate sortie = LocalDate.parse(in.nextLine(), dtf);

            int id_user = 0;
            Period daysBetween = Period.between(entree, sortie);

            Reservation res = new Reservation(id_user, h.getId(), daysBetween.getDays() * c.getPrix(), entree, sortie,
                    c.getNumber(), c.getDescription());

            sR.add(res);
            c.reserve();
            sC.update(c);
        } else {
            System.out.println("Hotel complet");
        }
    }

    @FXML
    private void chooseClicked(ActionEvent event) {
    }

    @FXML
    private void confirmClicked(ActionEvent event) {
    }
    
    void initHotel() {

        TableColumn id_userColReservation = new TableColumn("id_user");
        id_userColReservation.setMinWidth(100);
        id_userColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_user"));

        TableColumn id_hotelColReservation = new TableColumn("id_hotel");
        id_hotelColReservation.setMinWidth(100);
        id_hotelColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("id_hotel"));

        TableColumn prixColReservation = new TableColumn("prix");
        prixColReservation.setMinWidth(100);
        prixColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("prix"));

        TableColumn entreeColReservation = new TableColumn("entree");
        entreeColReservation.setMinWidth(100);
        entreeColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("entree"));

        TableColumn sortieColReservation = new TableColumn("sortie");
        sortieColReservation.setMinWidth(100);
        sortieColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("sortie"));

        TableColumn num_chambreColReservation = new TableColumn("num_chambre");
        num_chambreColReservation.setMinWidth(100);
        num_chambreColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("num_chambre"));

        TableColumn descriptionColReservation = new TableColumn("description");
        descriptionColReservation.setMinWidth(100);
        descriptionColReservation.setCellValueFactory(
                new PropertyValueFactory<Reservation, String>("description"));

        tableReservation.getColumns().addAll(id_userColReservation, id_hotelColReservation, prixColReservation, entreeColReservation, sortieColReservation, num_chambreColReservation, descriptionColReservation);
        updateList();
    }

    public void updateReservation() {
        ServiceReservation sR = new ServiceReservation();
        List list = sR.getAll();
        ObservableList<Reservation> dataRes = FXCollections.observableArrayList(sR.getAll());

        table.setItems(dataRes);
    }
    public void updateHotel() {
        ServiceHotel sh = new ServiceHotel();
        List list = sh.getAll();
        System.out.println(list);
        ObservableList<Hotel> listO = FXCollections.observableArrayList(list);

        table.setItems(listO);

    }
}
