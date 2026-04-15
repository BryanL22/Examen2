package co.edu.poli.examen2_Lopez.servicios;

import co.edu.poli.examen2_Lopez.modelo.Propietario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOPropietario implements CRUD<Propietario, String> {

    private Connection conexion;

    public DAOPropietario() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    // ➕ CREAR
    @Override
    public String create(Propietario p) {

        String sql = "INSERT INTO propietario (id, nombre) VALUES (?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, p.getId());
            ps.setString(2, p.getNombre());

            ps.executeUpdate();
            return "✅ Propietario guardado";

        } catch (SQLException e) {

            // ⚠️ Si ya existe, evitamos duplicarlo
            if (e.getErrorCode() == 1062) {
                return "⚠️ Propietario ya existe";
            }

            e.printStackTrace();
            return "❌ Error al guardar propietario";
        }
    }

    // 🔍 CONSULTAR UNO
    @Override
    public Propietario readOne(String id) {

        String sql = "SELECT * FROM propietario WHERE id = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Propietario(
                    rs.getString("id"),
                    rs.getString("nombre")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 📋 CONSULTAR TODOS
    @Override
    public List<Propietario> readAll() {

        List<Propietario> lista = new ArrayList<>();
        String sql = "SELECT * FROM propietario";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                lista.add(new Propietario(
                    rs.getString("id"),
                    rs.getString("nombre")
                ));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }
}