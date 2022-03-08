package services;

import java.util.List;

import modeles.Vol;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DataSource;

public class ServiceVol implements IService {

    Connection cnx = DataSource.getInstance().getCnx();

    public void add(Object u) {
        Vol v = (Vol) u;
        System.out.println(v);
        try {
            String req = "INSERT INTO `vol` (`id_agence`,`capacity`,`prix` ,`company`, `depart`, `destination`, `date`) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_agence());
            ps.setInt(2, v.getCapacity());
            ps.setInt(3, v.getPrix());
            ps.setString(4, v.getCompany());
            ps.setString(5, v.getDepart());
            ps.setString(6, v.getDestination());
            ps.setString(7, v.getDate().toString());

            ps.executeUpdate();
            System.out.println("Vol Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Vol v = new Vol(id);
        try {
            String req = "SELECT * FROM `Vol` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Vol vv = new Vol(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8));
                v = vv;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return v;
    }

    @Override
    public List getAll() {
        List<Vol> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Vol`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vol vv = new Vol(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8));
                list.add(vv);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    public List getByIdAgence(int id_agence) {
        List<Vol> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Vol` where id_agence = "+ id_agence;
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vol vv = new Vol(
                        rs.getInt(1),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(2),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getDate(8));
                list.add(vv);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u) {
        Vol v = (Vol) u;
        System.out.println(u);
        String req = "update Vol set id_agance= ? ,capacity = ?,prix = ?, company = ? , depart =? , destination = ? , date = ? where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_agence());
            ps.setInt(2, v.getCapacity());
            ps.setInt(3, v.getPrix());
            ps.setString(4, v.getCompany());
            ps.setString(5, v.getDepart());
            ps.setString(6, v.getDestination());
            ps.setString(7, v.getDate().toString());
            ps.setInt(8, v.getId());

            ps.executeUpdate();
            System.out.println("Vol modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Vol v = (Vol) u;

        String req = "delete from Vol where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId());
            ps.executeUpdate();
            System.out.println("Vol supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
