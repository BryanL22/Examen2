package co.edu.poli.examen2_Lopez.test.integracion;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_Lopez.modelo.Propietario;
import co.edu.poli.examen2_Lopez.servicios.DAOPropietario;

public class DAOPropietarioTest {

    @Test
    public void testCreatePropietario() {

        DAOPropietario dao = new DAOPropietario();
        Propietario p = new Propietario("3", "Ana");

        String resultado = dao.create(p);

        assertEquals("⚠️ Propietario ya existe", resultado);
    }
}
