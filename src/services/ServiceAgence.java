package services;
import java.util.List;

import modeles.Agence;
import modeles.Vol_command;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import utils.DataSource;
public class ServiceAgence implements IService {
    Connection cnx = DataSource.getInstance().getCnx();


    public ServiceAgence() {
    }

    public void add(Object u) {
        Agence v = (Agence) u;
        try {
            String req = "INSERT INTO `Agence`(`id_prop`, `nom`, `numero`, `nb_etoile`, `address`) VALUES (?,?,?,?,?)";
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_prop());
            ps.setString(2, v.getNom());
            ps.setInt(3, v.getNumero());
            ps.setInt(4, v.getNb_etoile());
            ps.setString(5, v.getAddress());

            ps.executeUpdate();
            System.out.println("Agence Ajoutée");
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

    }

    @Override
    public Object getById(int id) {
        Agence v = new Agence(id);
        try {
            String req = "SELECT * FROM `Agence` where id = " + id;
            // Statement st = cnx.createStatement();
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);

            while (rs.next()) {
                Agence hot = new Agence(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                v = hot;
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return v;
    }

    @Override
    public List getAll() {
        List<Agence> list = new ArrayList<>();
        try {
            String req = "SELECT * FROM `Agence` ";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                Agence u = new Agence(rs.getInt(1),rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
                list.add(u);
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Object u  ) {
        Agence v = (Agence) u;
        System.out.println(u);
       // v.setId(1);
        String req = "update Agence set id_prop = ? , nom = ? , numero =? , nb_etoile = ? , address = ?  where id = ?"  ;
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId_prop());
            ps.setString(2, v.getNom());
            ps.setInt(3, v.getNumero());
            ps.setInt(4, v.getNb_etoile());
            ps.setString(5, v.getAddress());
            ps.setInt(6, v.getId());

            ps.executeUpdate();
            System.out.println("Agence modifier");
            ps.close();

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Object u) {
        Agence v = (Agence) u;

        String req = "delete from Agence where id = ?";
        try {
            PreparedStatement ps = cnx.prepareStatement(req);
            ps.setInt(1, v.getId());
            ps.executeUpdate();
            System.out.println("Agence supprimer");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }
}
