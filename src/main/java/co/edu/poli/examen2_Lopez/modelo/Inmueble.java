package co.edu.poli.examen2_Lopez.modelo;

public abstract class Inmueble {

    private String numero;
    private String fechaCompra;
    private boolean estado;
    private Propietario propietario;

    public Inmueble(String numero, String fechaCompra, Propietario propietario) {
        this.numero = numero;
        this.fechaCompra = fechaCompra;
        this.estado = true;
        this.propietario = propietario;
    }

    public String vender() {
        estado = false;
        return "Inmueble vendido";
    }

    public String activar() {
        estado = true;
        return "Inmueble activo";
    }

    // GETTERS
    public String getNumero() { return numero; }
    public String getFechaCompra() { return fechaCompra; }
    public boolean isEstado() { return estado; }
    public Propietario getPropietario() { return propietario; }

    // SETTERS
    public void setNumero(String numero) { this.numero = numero; }
    public void setFechaCompra(String fechaCompra) { this.fechaCompra = fechaCompra; }
    public void setEstado(boolean estado) { this.estado = estado; }
    public void setPropietario(Propietario propietario) { this.propietario = propietario; }
}