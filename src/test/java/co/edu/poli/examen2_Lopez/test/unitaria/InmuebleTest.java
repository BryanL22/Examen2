package co.edu.poli.examen2_Lopez.test.unitaria;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import co.edu.poli.examen2_Lopez.modelo.Propietario;
import co.edu.poli.examen2_Lopez.modelo.Casa;

public class InmuebleTest {

    @Test
    public void testVender() {

        Propietario p = new Propietario("1", "Brayan");
        Casa c = new Casa("101", "2024-01-01", p, 2);

        c.vender();

        assertFalse(c.isEstado());
    }
}
