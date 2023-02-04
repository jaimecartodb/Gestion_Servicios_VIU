/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Inmueble {
    private String identificador;
    private String nombre;
    private String usuario;
    /**
     * constructor inmueble
     * @param identificador
     * @param nombre 
     */
    public Inmueble(String identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.usuario = "";
    }
    /**
     * set usuario
     * @param usuario 
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * set identificador
     * @param identificador 
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /** 
     * set nombre
     * @param nombre 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * get identificador
     * @return 
     */
    public String getIdentificador() {
        return identificador;
    }
    /**
     * get nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * get usuario
     * @return 
     */
    public String getUsuario() {
        return usuario;
    }
    
}
