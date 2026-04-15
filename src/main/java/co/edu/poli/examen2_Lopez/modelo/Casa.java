package co.edu.poli.examen2_Lopez.modelo;

public class Casa extends Inmueble {

    private int cantidadPisos;

    public Casa(String numero, String fechaCompra, Propietario propietario, int cantidadPisos) {
        super(numero, fechaCompra, propietario);
        this.cantidadPisos = cantidadPisos;
    }

    public int getCantidadPisos() { return cantidadPisos; }
    public void setCantidadPisos(int cantidadPisos) { this.cantidadPisos = cantidadPisos; }
}
