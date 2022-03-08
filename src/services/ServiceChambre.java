package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

// import javax.sql.DataSource;
import utils.DataSource;

import modeles.Chambre;
import modeles.Hotel;

public class ServiceChambre implements IService {
    Connection cnx = DataSource.getInstance().getCnx();

    public ServiceChambre() {
        Connection cnx = DataSource.getInstance().getCnx();
    }

    @Override
    public void add(Object u) {
        Chambre h = (Chambre) u;
        try {
            String req = "INSERT INTO `chambre`(`id_hotel`, `number`, `prix`, `image`, `description`, `disp`) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_hotel());
            ps.setInt(2, h.getNumber());
            ps.setInt(3, h.getPrix());
            ps.setString(4, h.getImage());
            ps.setString(5, h.getDescription());
            ps.setBoolean(6, h.getDisp());

            ps.executeUpdate();
            System.out.println("chambre Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Chambre h = new Chambre(id);
        try {
            String req = "SELECT * FROM `chambre` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Chambre hot = new Chambre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getBoolean(7));
                h = hot;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return h;
    }

    @Override
    public List getAll() {
        List<Chambre> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `chambre`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Chambre u = new Chambre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getBoolean(7));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    public List getHotel(Hotel h) {
        List<Chambre> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `chambre` Where id_hotel = "+h.getId();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Chambre u = new Chambre(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
                        rs.getString(6), rs.getBoolean(7));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u) {
        Chambre h = (Chambre) u;
        System.out.println(u);
        String req = "update chambre set id_hotel = ? , number = ? , prix =? , image = ? , description = ? , disp = ?  where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId_hotel());
            ps.setInt(2, h.getNumber());
            ps.setInt(3, h.getPrix());
            ps.setString(4, h.getImage());
            ps.setString(5, h.getDescription());
            ps.setBoolean(6, h.getDisp());
            ps.setInt(7, h.getId());

            ps.executeUpdate();
            System.out.println("chambre modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Chambre h = (Chambre) u;

        String req = "delete from chambre where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, h.getId());
            ps.executeUpdate();
            System.out.println("Chambre supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

}
