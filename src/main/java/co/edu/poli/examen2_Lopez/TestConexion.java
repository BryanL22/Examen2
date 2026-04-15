package co.edu.poli.examen2_Lopez;

import co.edu.poli.examen2_Lopez.modelo.Propietario;
import co.edu.poli.examen2_Lopez.servicios.DAOPropietario;

public class TestConexion {
    public static void main(String[] args) {

        DAOPropietario dao = new DAOPropietario();

        Propietario p = new Propietario("1", "Brayan");
        System.out.println(dao.create(p));
    }
}