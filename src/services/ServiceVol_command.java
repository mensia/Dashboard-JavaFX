package services;

import java.util.List;

import modeles.Vol_command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DataSource;

public class ServiceVol_command implements IService {

    Connection cnx = DataSource.getInstance().getCnx();

    public void add(Object u) {
        Vol_command v = (Vol_command) u;
        try {
            String req = "INSERT into `vol_command`(`id_user`,`id_agence`,`id_vol`,`prix`)  VALUES (?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_user());
            ps.setInt(2, v.getId_agance());
            ps.setInt(3, v.getId_vol());
            ps.setInt(4, v.getPrix());

            ps.executeUpdate();
            System.out.println("Vol_command Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Vol_command v = new Vol_command(id);
        try {
            String req = "SELECT * FROM `Vol_command` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Vol_command vc = new Vol_command(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
                v = vc;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return v;
    }

    public List<Vol_command> getById_vol(int id) {
        Vol_command v = new Vol_command(id);
        List<Vol_command> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Vol_command` where id_vol = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Vol_command vc = new Vol_command(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
                list.add(vc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List getAll() {
        List<Vol_command> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Vol_command`";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Vol_command vc = new Vol_command(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5));
                list.add(vc);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u) {
        Vol_command v = (Vol_command) u;
        System.out.println(u);
        String req = "update Vol_command set id_user = ? , id_agance= ? , id_vol = ? prix = ? where id = ? ";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_user());
            ps.setInt(2, v.getId_agance());
            ps.setInt(3, v.getId_vol());
            ps.setInt(4, v.getPrix());
            ps.setInt(5, v.getId());

            ps.executeUpdate();
            System.out.println("Vol_command modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Vol_command v = (Vol_command) u;

        String req = "delete from Vol_command where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId());
            ps.executeUpdate();
            System.out.println("Vol_command supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
