/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.videogamestore.modelo;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author robes
 */
public class Resena implements Serializable{
    private int calificacion;
    private String critico;
    private String mensaje;
    private LocalDate fecha;

    public Resena(String critico, int calificacion, LocalDate fecha, String texto) {
        this.critico = critico;
        this.calificacion = calificacion;
        this.fecha = fecha;
        this.mensaje = texto;
    }
    
    

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }

    public String getCritico() {
        return critico;
    }

    public void setCritico(String critico) {
        this.critico = critico;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
    
}
