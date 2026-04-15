package co.edu.poli.examen2_Lopez.servicios;

import co.edu.poli.examen2_Lopez.modelo.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOInmueble implements CRUD<Inmueble, String> {

    private Connection conexion;

    public DAOInmueble() {
        conexion = ConexionBD.getInstancia().getConexion();
    }

    @Override
    public String create(Inmueble i) {

        String sql = "INSERT INTO inmueble (numero, fecha_compra, estado, propietario_id, tipo, pisos, piso) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, i.getNumero());
            ps.setString(2, i.getFechaCompra());
            ps.setBoolean(3, i.isEstado());
            ps.setString(4, i.getPropietario().getId());

            // Tipo
            ps.setString(5, i instanceof Casa ? "CASA" : "APARTAMENTO");

            if (i instanceof Casa) {
                Casa c = (Casa) i;
                ps.setInt(6, c.getCantidadPisos());
                ps.setNull(7, Types.INTEGER);
            } else {
                Apartamento a = (Apartamento) i;
                ps.setNull(6, Types.INTEGER);
                ps.setInt(7, a.getNumeroPiso());
            }

            ps.executeUpdate();
            return "✅ Inmueble guardado";

        } catch (Exception e) {
            e.printStackTrace();
            return "❌ Error";
        }
    }

    @Override
    public Inmueble readOne(String numero) {

        String sql = "SELECT * FROM inmueble WHERE numero = ?";

        try (PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, numero);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String tipo = rs.getString("tipo");

                DAOPropietario daoProp = new DAOPropietario();
                Propietario p = daoProp.readOne(rs.getString("propietario_id"));

                int pisos = rs.getInt("pisos");
                int piso = rs.getInt("piso");

                if ("CASA".equalsIgnoreCase(tipo)) {
                    return new Casa(
                        rs.getString("numero"),
                        rs.getString("fecha_compra"),
                        p,
                        pisos
                    );
                } else {
                    return new Apartamento(
                        rs.getString("numero"),
                        rs.getString("fecha_compra"),
                        p,
                        piso
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Inmueble> readAll() {
        return new ArrayList<>();
    }
}