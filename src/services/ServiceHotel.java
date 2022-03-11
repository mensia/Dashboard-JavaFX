package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.stream.Collectors;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// import javax.sql.DataSource;
import utils.DataSource;

import modeles.Hotel;
import modeles.Type;

public class ServiceHotel implements IService {
    Connection cnx = DataSource.getInstance().getCnx();

    public List<Hotel> Tri() {
        List<Hotel> list_chambre = this.getAll();
        return list_chambre.stream()
                .sorted(((o1, o2) -> o1.getNb_etoile() - o2.getNb_etoile()))
                .collect(Collectors.toList());

    }

    public List<Hotel> Chercher(String s) {
        List<Hotel> list_chambre = this.getAll();
        return list_chambre.stream()
                .filter(o -> o.getNom().contains(s))
                .collect(Collectors.toList());

    }

    @Override
    public void add(Object u) {
        Hotel h = (Hotel) u;
        try {
            String req = "INSERT INTO `hotel`(`id_responsable`, `nom`, `address`, `type`, `nb_etoile`, `phone`, `capacite`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_responsable());
            ps.setString(2, h.getNom());
            ps.setString(3, h.getAddress());
            ps.setString(4, h.getType());
            ps.setInt(5, h.getNb_etoile());
            ps.setInt(6, h.getPhone());
            ps.setInt(7, h.getCapacite());

            ps.executeUpdate();
            System.out.println("Hotel Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Hotel h = new Hotel(id);
        try {
            String req = "SELECT * FROM `hotel` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Hotel hot = new Hotel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                h = hot;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return h;
    }

    @Override
    public List getAll() {
        List<Hotel> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `hotel`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Hotel u = new Hotel(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6), rs.getInt(7), rs.getInt(8));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u) {
        Hotel h = (Hotel) u;
        System.out.println(u);
        String req = "update Hotel set id_responsable = ? , nom = ? , address =? , type = ? , nb_etoile = ? , phone = ? , capacite = ?  where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_responsable());
            ps.setString(2, h.getNom());
            ps.setString(3, h.getAddress());
            ps.setString(4, h.getType().toString());
            ps.setInt(5, h.getNb_etoile());
            ps.setInt(6, h.getPhone());
            ps.setInt(7, h.getCapacite());
            ps.setInt(8, h.getId());

            ps.executeUpdate();
            System.out.println("Hotel modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Hotel h = (Hotel) u;

        String req = "delete from Hotel where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId());
            ps.executeUpdate();
            System.out.println("Hotel supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
