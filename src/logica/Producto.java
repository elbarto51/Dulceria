/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Date;

/**
 *
 * @author thebar70
 */
public class Producto {
    private String nombre;
    private float precio;
    private int stock;
    private String empaque;
    private boolean detallable;
    private int unidadesPorPaquete;
    private float precioUnidad;
    private Date fecha_ingreso;
    private boolean estado;

    public Producto(String nombre, float precio, int stock, String empaque, boolean detallable, int unidadesPorPaquete, float precioUnidad,
            Date fecha_ingreso, boolean estado) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.empaque = empaque;
        this.detallable = detallable;
        this.unidadesPorPaquete = unidadesPorPaquete;
        this.precioUnidad = precioUnidad;
        this.fecha_ingreso = fecha_ingreso;
        this.estado = estado;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getEmpaque() {
        return empaque;
    }

    public void setEmpaque(String empaque) {
        this.empaque = empaque;
    }

    public boolean isDetallable() {
        return detallable;
    }

    public void setDetallable(boolean detallable) {
        this.detallable = detallable;
    }

    public int getUnidadesPorPaquete() {
        return unidadesPorPaquete;
    }

    public void setUnidadesPorPaquete(int unidadesPorPaquete) {
        this.unidadesPorPaquete = unidadesPorPaquete;
    }

    public float getPrecioUnidad() {
        return precioUnidad;
    }

    public void setPrecioUnidad(float precioUnidad) {
        this.precioUnidad = precioUnidad;
    }
    
    
}
