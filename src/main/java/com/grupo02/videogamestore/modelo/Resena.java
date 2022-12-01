/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.videogamestore.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author robes
 */
public class Resena implements Serializable{
    private int calificacion;
    private String critico;
    private String mensaje;
    private Date fecha;

    public Resena(String critico, int calificacion, String mensaje, Date fecha) {
        this.calificacion = calificacion;
        this.critico = critico;
        this.mensaje = mensaje;
        this.fecha = fecha;
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

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
