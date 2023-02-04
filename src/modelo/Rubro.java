/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Rubro {
    private int identificador;
    private String nombre;
    /**
     * constructor rubro
     * @param identificador
     * @param nombre 
     */
    public Rubro(int identificador, String nombre) {
        this.identificador = identificador;
        this.nombre = nombre;
    }
    /**
     * set identificador
     * @param identificador 
     */
    public void setIdentificador(int identificador) {
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
    public int getIdentificador() {
        return identificador;
    }
    /**
     * get nombre
     * @return 
     */
    public String getNombre() {
        return nombre;
    }
    
}
