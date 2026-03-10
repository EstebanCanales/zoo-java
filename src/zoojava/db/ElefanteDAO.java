package zoojava.db;

import zoojava.elefante;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ElefanteDAO {

    public void insert(elefante e) throws SQLException {
        String sql = "INSERT INTO ELEFANTES (ID, NOMBRE, EDAD, HABITAT, ZONA_ORIGEN, PESO, TAMANO, ALTURA, GENERO, PERIODO_GESTACION, TIPO_PELAJE, LACTANCIA, TAM_OREJA_IZQ, TAM_OREJA_DER, TAM_COLMILLO_IZQ, TAM_COLMILLO_DER, TAM_TROMPA) "
                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setInt(3, e.getAge());
            ps.setString(4, e.getHabitat());
            ps.setString(5, e.getZonaOrigen());
            ps.setDouble(6, e.getWeight());
            ps.setDouble(7, e.getSize());
            ps.setDouble(8, e.getHeight());
            ps.setString(9, e.getGender());
            ps.setDouble(10, e.period());
            ps.setString(11, e.coatType());
            ps.setInt(12, e.lactation());
            ps.setDouble(13, e.tamanhoOrejaIzquierda());
            ps.setDouble(14, e.tamanhoOrejaDerecha());
            ps.setDouble(15, e.tamanhoColmilloIzquierda());
            ps.setDouble(16, e.tamanhoColmilloDerecha());
            ps.setDouble(17, e.tamanhoTrompa());
            
            ps.executeUpdate();
            System.out.println("Elefante insertado correctamente.");
        }
    }

    public void update(elefante e) throws SQLException {
        String sql = "UPDATE ELEFANTES SET NOMBRE=?, EDAD=?, HABITAT=?, ZONA_ORIGEN=?, PESO=?, TAMANO=?, ALTURA=?, GENERO=?, PERIODO_GESTACION=?, TIPO_PELAJE=?, LACTANCIA=?, TAM_OREJA_IZQ=?, TAM_OREJA_DER=?, TAM_COLMILLO_IZQ=?, TAM_COLMILLO_DER=?, TAM_TROMPA=? WHERE ID=?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, e.getName());
            ps.setInt(2, e.getAge());
            ps.setString(3, e.getHabitat());
            ps.setString(4, e.getZonaOrigen());
            ps.setDouble(5, e.getWeight());
            ps.setDouble(6, e.getSize());
            ps.setDouble(7, e.getHeight());
            ps.setString(8, e.getGender());
            ps.setDouble(9, e.period());
            ps.setString(10, e.coatType());
            ps.setInt(11, e.lactation());
            ps.setDouble(12, e.tamanhoOrejaIzquierda());
            ps.setDouble(13, e.tamanhoOrejaDerecha());
            ps.setDouble(14, e.tamanhoColmilloIzquierda());
            ps.setDouble(15, e.tamanhoColmilloDerecha());
            ps.setDouble(16, e.tamanhoTrompa());
            ps.setInt(17, e.getId());
            
            ps.executeUpdate();
            System.out.println("Elefante actualizado correctamente.");
        }
    }

    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM ELEFANTES WHERE ID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("Elefante eliminado correctamente.");
        }
    }

    public List<elefante> getAll() throws SQLException {
        List<elefante> list = new ArrayList<>();
        String sql = "SELECT * FROM ELEFANTES";
        
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            
            while (rs.next()) {
                elefante e = new elefante(
                    rs.getDouble("PERIODO_GESTACION"),
                    rs.getString("TIPO_PELAJE"),
                    rs.getInt("LACTANCIA"),
                    rs.getDouble("TAM_OREJA_IZQ"),
                    rs.getDouble("TAM_OREJA_DER"),
                    rs.getDouble("TAM_COLMILLO_IZQ"),
                    rs.getDouble("TAM_COLMILLO_DER"),
                    rs.getDouble("TAM_TROMPA")
                );
                e.setId(rs.getInt("ID"));
                e.setName(rs.getString("NOMBRE"));
                e.setAge(rs.getInt("EDAD"));
                e.setHabitat(rs.getString("HABITAT"));
                e.setZonaOrigen(rs.getString("ZONA_ORIGEN"));
                e.setWeight(rs.getDouble("PESO"));
                e.setSize(rs.getDouble("TAMANO"));
                e.setHeight(rs.getDouble("ALTURA"));
                e.setGender(rs.getString("GENERO"));
                list.add(e);
            }
        }
        return list;
    }

    public elefante getById(int id) throws SQLException {
        String sql = "SELECT * FROM ELEFANTES WHERE ID = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    elefante e = new elefante(
                        rs.getDouble("PERIODO_GESTACION"),
                        rs.getString("TIPO_PELAJE"),
                        rs.getInt("LACTANCIA"),
                        rs.getDouble("TAM_OREJA_IZQ"),
                        rs.getDouble("TAM_OREJA_DER"),
                        rs.getDouble("TAM_COLMILLO_IZQ"),
                        rs.getDouble("TAM_COLMILLO_DER"),
                        rs.getDouble("TAM_TROMPA")
                    );
                    e.setId(rs.getInt("ID"));
                    e.setName(rs.getString("NOMBRE"));
                    e.setAge(rs.getInt("EDAD"));
                    e.setHabitat(rs.getString("HABITAT"));
                    e.setZonaOrigen(rs.getString("ZONA_ORIGEN"));
                    e.setWeight(rs.getDouble("PESO"));
                    e.setSize(rs.getDouble("TAMANO"));
                    e.setHeight(rs.getDouble("ALTURA"));
                    e.setGender(rs.getString("GENERO"));
                    return e;
                }
            }
        }
        return null;
    }
}
