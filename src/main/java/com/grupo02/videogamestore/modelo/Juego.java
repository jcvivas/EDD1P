/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.videogamestore.modelo;

import javafx.scene.image.Image;
import com.grupo02.TDAs.LinkedList;

/**
 *
 * @author DELL
 */
public class Juego {
    private String titulo;
    private String descripcion;
    private Image imagen;
    private Image captura;
    private LinkedList<Genero> genero;
    private LinkedList<Desarrollador> desarrollador;
    private LinkedList<Resena> resenas;

    public Juego(String titulo, String descripcion, Image imagen, Image captura, LinkedList<Genero> genero, LinkedList<Desarrollador> desarrollador, LinkedList<Resena> resenas) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.captura = captura;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.resenas = resenas;
    }

    public Juego(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Image getImagen() {
        return imagen;
    }

    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }

    public Image getCaptura() {
        return captura;
    }

    public void setCaptura(Image captura) {
        this.captura = captura;
    }

    public LinkedList<Genero> getGenero() {
        return genero;
    }

    public void setGenero(LinkedList<Genero> genero) {
        this.genero = genero;
    }

    public LinkedList<Desarrollador> getDesarrollador() {
        return desarrollador;
    }

    public void setDesarrollador(LinkedList<Desarrollador> desarrollador) {
        this.desarrollador = desarrollador;
    }

    public LinkedList<Resena> getReseña() {
        return resenas;
    }

    public void setReseña(LinkedList<Resena> resenas) {
        this.resenas = resenas;
    }

    @Override
    public String toString() {
        return "Juego{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", imagen=" + imagen + ", captura=" + captura + ", genero=" + genero + ", desarrollador=" + desarrollador + ", Rese\u00f1a=" + resenas + '}';
    }
    
    
    
    
    
}
