/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;


public class Usuario {
    private String identificador;
    private String clave;
    private String tipo_usuario;
    private String telefono;
    private String email;
    private boolean baja;
    
    public Usuario(){};
    /**
     * constructor usuario
     * @param identificador
     * @param clave
     * @param tipo_usuario
     * @param telefono
     * @param email
     * @param baja 
     */
    public Usuario(String identificador, String clave, String tipo_usuario, String telefono, String email, boolean baja) {
        this.identificador = identificador;
        this.clave = clave;
        this.tipo_usuario = tipo_usuario;
        this.telefono = telefono;
        this.email = email;
        this.baja = baja;
    }
    /**
     * set baja
     * @param baja 
     */
    public void setBaja(boolean baja) {
        this.baja = baja;
    }
    /**
     * get baja
     * @return 
     */
    public boolean isBaja() {
        return baja;
    }
    /**
     * set identificador
     * @param identificador 
     */
    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }
    /**
     * set clave
     * @param clave 
     */
    public void setClave(String clave) {
        this.clave = clave;
    }
    /**
     * set tipo usuario
     * @param tipo_usuario 
     */
    public void setTipo_usuario(String tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    }
    /**
     * set telefono
     * @param telefono 
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    /**
     * set email
     * @param email 
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * get identificador
     * @return 
     */
    public String getIdentificador() {
        return identificador;
    }
    /**
     * get clave
     * @return 
     */
    public String getClave() {
        return clave;
    }
    /**
     * get tipo usuario
     * @return 
     */
    public String getTipo_usuario() {
        return tipo_usuario;
    }
    /**
     * get telefono
     * @return 
     */
    public String getTelefono() {
        return telefono;
    }
    /**
     * get email
     * @return 
     */
    public String getEmail() {
        return email;
    }
    
}
