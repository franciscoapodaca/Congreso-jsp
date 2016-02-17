/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Ulrick
 */
public class Participante {
    
    private String clave;
    
    private String nombre;
    
    private String email;
    
    private String tipo;
    
    private String carrera;
    
    private String puesto;

    public Participante() {
    }

    
    public Participante(String clave, String nombre, String email, String tipo, String carrera, String puesto) {
        this.clave = clave;
        this.nombre = nombre;
        this.email = email;
        this.tipo = tipo;
        this.carrera = carrera;
        this.puesto = puesto;
    }
    

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }
    
    
    
    
}
