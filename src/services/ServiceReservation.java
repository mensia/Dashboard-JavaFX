package services;

import java.util.List;

import modeles.Reservation;
import modeles.Type;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.ArrayList;
import java.sql.Date;

import utils.DataSource;

public class ServiceReservation implements IService {
    Connection cnx = DataSource.getInstance().getCnx();
    ZoneId defaultZoneId = ZoneId.systemDefault();

    @Override
    public void add(Object u) {
        Reservation h = (Reservation) u;
        try {
            String req = "INSERT INTO `reservation`(`id_user`, `id_hotel`, `prix`, `entree`, `sortie`, `num_chambre`, `description`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_user());
            ps.setInt(2, h.getId_hotel());
            ps.setInt(3, h.getPrix());
            ps.setDate(4, Date.valueOf(h.getEntree()));
            ps.setDate(5, Date.valueOf(h.getSortie()));
            ps.setInt(6, h.getNum_chambre());
            ps.setString(7, h.getDescription());

            ps.executeUpdate();
            System.out.println("Reservation Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Reservation h = new Reservation(id);
        try {
            String req = "SELECT * FROM `Reservation` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Reservation hot = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getDate(5).toLocalDate(),
                        rs.getDate(6).toLocalDate(),
                        rs.getInt(7), rs.getString(8));
                h = hot;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return h;
    }

    @Override
    public List getAll() {
        List<Reservation> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `reservation`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Reservation u = new Reservation(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4),
                        rs.getDate(5).toLocalDate(), rs.getDate(6).toLocalDate(), rs.getInt(7), rs.getString(8));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u) {
        Reservation h = (Reservation) u;
        System.out.println(u);
        String req = "update Reservation set id_user = ? , id_hotel = ? , prix =? , entree = ? , sortie = ? , num_chambre = ? , description = ?  where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_user());
            ps.setInt(2, h.getId_hotel());
            ps.setInt(3, h.getPrix());
            ps.setDate(4, Date.valueOf(h.getEntree()));
            ps.setDate(5, Date.valueOf(h.getSortie()));
            ps.setInt(6, h.getNum_chambre());
            ps.setString(7, h.getDescription());

            ps.setInt(8, h.getId());

            ps.executeUpdate();
            System.out.println("Reservation modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Reservation h = (Reservation) u;

        String req = "delete from Reservation where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId());
            ps.executeUpdate();
            System.out.println("Reservation supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
