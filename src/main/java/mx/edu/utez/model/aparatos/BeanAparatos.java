package mx.edu.utez.model.aparatos;

import mx.edu.utez.model.direccion.BeanDireccion;

public class BeanAparatos {
    private int id;
    private String nombre;
    private BeanDireccion direccion;
    private String fechaDeRegistro;
    private int estado;

    public BeanAparatos() {
    }

    public BeanAparatos(int id, String nombre, BeanDireccion direccion, String fechaDeRegistro, int estado) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.fechaDeRegistro = fechaDeRegistro;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BeanDireccion getDireccion() {
        return direccion;
    }

    public void setDireccion(BeanDireccion direccion) {
        this.direccion = direccion;
    }

    public String getFechaDeRegistro() {
        return fechaDeRegistro;
    }

    public void setFechaDeRegistro(String fechaDeRegistro) {
        this.fechaDeRegistro = fechaDeRegistro;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
