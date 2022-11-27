/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import javafx.scene.image.Image;
import tdas.LinkedList;

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
    private LinkedList<String> Reseña;

    public Juego(String titulo, String descripcion, Image imagen, Image captura, LinkedList<Genero> genero, LinkedList<Desarrollador> desarrollador, LinkedList<String> Reseña) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.imagen = imagen;
        this.captura = captura;
        this.genero = genero;
        this.desarrollador = desarrollador;
        this.Reseña = Reseña;
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

    public LinkedList<String> getReseña() {
        return Reseña;
    }

    public void setReseña(LinkedList<String> Reseña) {
        this.Reseña = Reseña;
    }

    @Override
    public String toString() {
        return "Juego{" + "titulo=" + titulo + ", descripcion=" + descripcion + ", imagen=" + imagen + ", captura=" + captura + ", genero=" + genero + ", desarrollador=" + desarrollador + ", Rese\u00f1a=" + Reseña + '}';
    }
    
    
    
    
    
}
