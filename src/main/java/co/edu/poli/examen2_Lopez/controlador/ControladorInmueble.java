package co.edu.poli.examen2_Lopez.controlador;

import co.edu.poli.examen2_Lopez.modelo.*;
import co.edu.poli.examen2_Lopez.servicios.*;

public class ControladorInmueble {

    private DAOInmueble daoInmueble;
    private DAOPropietario daoPropietario;

    public ControladorInmueble() {
        daoInmueble = new DAOInmueble();
        daoPropietario = new DAOPropietario();
    }

    // 🔍 CONSULTAR
    public String consultar(String numero) {

        Inmueble i = daoInmueble.readOne(numero);

        if (i != null) {

            String tipo = "";
            String extra = "";

            if (i instanceof Casa) {
                Casa c = (Casa) i;
                tipo = "Casa";
                extra = "Pisos: " + c.getCantidadPisos();
            } else {
                Apartamento a = (Apartamento) i;
                tipo = "Apartamento";
                extra = "Piso: " + a.getNumeroPiso();
            }

            return "Número: " + i.getNumero() +
                   "\nTipo: " + tipo +
                   "\nFecha: " + i.getFechaCompra() +
                   "\nEstado: " + i.isEstado() +
                   "\nPropietario: " + i.getPropietario().getId() +
                   " - " + i.getPropietario().getNombre() +
                   "\n" + extra;
        }

        return "No encontrado";
    }

    // ➕ CREAR
    public String crear(String tipo, String numero, String fecha, String idProp, String nombreProp, String extra) {

        Propietario p = new Propietario(idProp, nombreProp);

        if (daoPropietario.readOne(idProp) == null) {
            daoPropietario.create(p);
        }

        if (tipo.equalsIgnoreCase("Casa")) {
            int pisos = Integer.parseInt(extra);
            Casa c = new Casa(numero, fecha, p, pisos);
            return daoInmueble.create(c);
        } else {
            int piso = Integer.parseInt(extra);
            Apartamento a = new Apartamento(numero, fecha, p, piso);
            return daoInmueble.create(a);
        }
    }

}