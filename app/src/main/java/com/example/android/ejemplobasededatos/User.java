package com.example.android.ejemplobasededatos;

public class User {
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    private String dni;
    private String nombre;
    private String ciudad;
    private String numero;

    @Override
    public String toString() {
        return "User{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", numero='" + numero + '\'' +
                '}';
    }

    public User(String dni, String nombre, String ciudad, String numero) {
        this.dni = dni;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.numero = numero;
    }
}
