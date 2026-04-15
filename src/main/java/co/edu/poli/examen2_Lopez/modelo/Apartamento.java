package co.edu.poli.examen2_Lopez.modelo;

public class Apartamento extends Inmueble {

    private int numeroPiso;

    public Apartamento(String numero, String fechaCompra, Propietario propietario, int numeroPiso) {
        super(numero, fechaCompra, propietario);
        this.numeroPiso = numeroPiso;
    }

    public int getNumeroPiso() {
        return numeroPiso;
    }

    public void setNumeroPiso(int numeroPiso) {
        this.numeroPiso = numeroPiso;
    }
}