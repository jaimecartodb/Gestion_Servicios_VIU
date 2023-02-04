/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Servicio {
    private String identificador;
    private String actividades;
    private int obligatorio;
    private int costo;
    /**
     * constructor servicio
     * @param identificador
     * @param actividades
     * @param obligatorio
     * @param costo 
     */
    public Servicio(String identificador, String actividades, int obligatorio, int costo) {
        this.identificador = identificador;
        this.actividades = actividades;
        this.obligatorio = obligatorio;
        this.costo = costo;
    }
    /**
     * set identificador servicio
     * @param identificador 
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /**
     * set actividades servicio
     * @param actividades 
     */
    public void setActividades(String actividades) {
        this.actividades = actividades;
    }
    /**
     * set obligatorio
     * @param obligatorio 
     */
    public void setObligatorio(int obligatorio) {
        this.obligatorio = obligatorio;
    }
    /**
     * set costo
     * @param costo 
     */
    public void setCosto(int costo) {
        this.costo = costo;
    }
    /**
     * get identificador
     * @return 
     */
    public String getIdentificador() {
        return identificador;
    }
    /**
     * get actividades
     * @return 
     */
    public String getActividades() {
        return actividades;
    }
    /**
     * get obligatorio
     * @return 
     */
    public int getObligatorio() {
        return obligatorio;
    }
    /**
     * get costo
     * @return 
     */
    public int getCosto() {
        return costo;
    }
    
}
