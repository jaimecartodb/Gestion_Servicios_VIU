/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author jaime
 */
public class Gastos {
    private int importe;
    private String fecha_registro;
    private String fecha_pago;
    private String numero_telefono;
    private String email_prov;
    private String direccion_prov;
    private String nombre_prov;
    private int id_gasto;
    /**
     * constructor clase gastos
     * @param importe
     * @param fecha_registro
     * @param fecha_pago
     * @param numero_telefono
     * @param email_prov
     * @param direccion_prov
     * @param nombre_prov 
     */
    public Gastos(int importe, String fecha_registro, String fecha_pago, String numero_telefono, String email_prov, String direccion_prov, String nombre_prov) {
        this.id_gasto = -1;
        this.importe = importe;
        this.fecha_registro = fecha_registro;
        this.fecha_pago = fecha_pago;
        this.numero_telefono = numero_telefono;
        this.email_prov = email_prov;
        this.direccion_prov = direccion_prov;
        this.nombre_prov = nombre_prov;
    }
    /**
     * set id gasto
     * @param id_gasto 
     */
    public void setId_gasto(int id_gasto) {
        this.id_gasto = id_gasto;
    }
    /**
     * get id gasto
     * @return 
     */
    public int getId_gasto() {
        return id_gasto;
    }

    /**
     * set importe
     * @param importe 
     */
    public void setImporte(int importe) {
        this.importe = importe;
    }
    /**
     * set fecha registro
     * @param fecha_registro 
     */
    public void setFecha_registro(String fecha_registro) {
        this.fecha_registro = fecha_registro;
    }
    /**
     * set fecha pago
     * @param fecha_pago 
     */
    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    /**
     * set numero telefono
     * @param numero_telefono 
     */
    public void setNumero_telefono(String numero_telefono) {
        this.numero_telefono = numero_telefono;
    }
    /**
     * set email proveedor
     * @param email_prov 
     */
    public void setEmail_prov(String email_prov) {
        this.email_prov = email_prov;
    }
    /**
     * set direccion proveedor
     * @param direccion_prov 
     */
    public void setDireccion_prov(String direccion_prov) {
        this.direccion_prov = direccion_prov;
    }
    /**
     * set nombre proveedor
     * @param nombre_prov 
     */
    public void setNombre_prov(String nombre_prov) {
        this.nombre_prov = nombre_prov;
    }
    /** 
     * get importe
     * @return 
     */
    public int getImporte() {
        return importe;
    }
    /**
     * get fecha registro
     * @return 
     */
    public String getFecha_registro() {
        return fecha_registro;
    }
    /**
     * get fecha pago
     * @return 
     */
    public String getFecha_pago() {
        return fecha_pago;
    }
    /**
     * get numero telefono
     * @return 
     */
    public String getNumero_telefono() {
        return numero_telefono;
    }
    /**
     * get email proveedor
     * @return 
     */
    public String getEmail_prov() {
        return email_prov;
    }
    /**
     * get direccion proveedor
     * @return 
     */
    public String getDireccion_prov() {
        return direccion_prov;
    }
    /** 
     * get nombre proveedor
     * @return 
     */
    public String getNombre_prov() {
        return nombre_prov;
    }
    
}
