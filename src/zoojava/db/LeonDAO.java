package zoojava.db;

import zoojava.leon;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LeonDAO {

    public void insert(leon l) throws SQLException {
        String sql = "INSERT INTO LEONES (ID, NOMBRE, EDAD, HABITAT, ZONA_ORIGEN, PESO, TAMANO, ALTURA, GENERO, PERIODO_GESTACION, TIPO_PELAJE, LACTANCIA, TAM_MELENA, DECIBELES_RUGIDO, ES_ALFA) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, l.getId());
            ps.setString(2, l.getName());
            ps.setInt(3, l.getAge());
            ps.setString(4, l.getHabitat());
            ps.setString(5, l.getZonaOrigen());
            ps.setDouble(6, l.getWeight());
            ps.setDouble(7, l.getSize());
            ps.setDouble(8, l.getHeight());
            ps.setString(9, l.getGender());
            ps.setDouble(10, l.period());
            ps.setString(11, l.coatType());
            ps.setInt(12, l.lactation());
            ps.setDouble(13, l.getTamMelena());
            ps.setDouble(14, l.getDecibelesRugido());
            ps.setString(15, l.isEsAlfa() ? "S" : "N");
            
            ps.executeUpdate();
        }
    }

    public void update(leon l) throws SQLException {
        String sql = "UPDATE LEONES SET NOMBRE=?, EDAD=?, HABITAT=?, ZONA_ORIGEN=?, PESO=?, TAMANO=?, ALTURA=?, GENERO=?, PERIODO_GESTACION=?, TIPO_PELAJE=?, LACTANCIA=?, TAM_MELENA=?, DECIBELES_RUGIDO=?, ES_ALFA=? WHERE ID=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, l.getName());
            ps.setInt(2, l.getAge());
            ps.setString(3, l.getHabitat());
            ps.setString(4, l.getZonaOrigen());
            ps.setDouble(5, l.getWeight());
            ps.setDouble(6, l.getSize());
            ps.setDouble(7, l.getHeight());
            ps.setString(8, l.getGender());
            ps.setDouble(9, l.period());
            ps.setString(10, l.coatType());
            ps.setInt(11, l.lactation());
            ps.setDouble(12, l.getTamMelena());
            ps.setDouble(13, l.getDecibelesRugido());
            ps.setString(14, l.isEsAlfa() ? "S" : "N");
            ps.setInt(15, l.getId());
            
            ps.executeUpdate();
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM LEONES WHERE ID = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public List<leon> getAll() throws SQLException {
        List<leon> list = new ArrayList<>();
        String sql = "SELECT * FROM LEONES";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                leon l = new leon(
                    rs.getDouble("PERIODO_GESTACION"),
                    rs.getString("TIPO_PELAJE"),
                    rs.getInt("LACTANCIA"),
                    rs.getDouble("TAM_MELENA"),
                    rs.getDouble("DECIBELES_RUGIDO"),
                    rs.getString("ES_ALFA").equals("S")
                );
                l.setId(rs.getInt("ID"));
                l.setName(rs.getString("NOMBRE"));
                l.setAge(rs.getInt("EDAD"));
                l.setHabitat(rs.getString("HABITAT"));
                l.setZonaOrigen(rs.getString("ZONA_ORIGEN"));
                l.setWeight(rs.getDouble("PESO"));
                l.setSize(rs.getDouble("TAMANO"));
                l.setHeight(rs.getDouble("ALTURA"));
                l.setGender(rs.getString("GENERO"));
                list.add(l);
            }
        }
        return list;
    }
}
