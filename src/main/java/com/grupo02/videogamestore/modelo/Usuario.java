/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.videogamestore.modelo;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.LinkedList;
import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author IMPORTSOLUTION
 */
public class Usuario implements Serializable{

    private String usuario;
    private String contraseña;
    private char tipo;
    private DoublyCircularLinkedList<Juego> wishlist = new DoublyCircularLinkedList();
    private DoublyCircularLinkedList<Juego> misJuegos = new DoublyCircularLinkedList();


    public Usuario(String usuario, String contraseña, char tipo) {
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.tipo = tipo;
    }

    public DoublyCircularLinkedList<Juego> getWishlist() {
        return wishlist;
    }

    public DoublyCircularLinkedList<Juego> getMisJuegos() {
        return misJuegos;
    }
    
    

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return usuario + ";" + contraseña + ";" + tipo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.usuario, other.usuario)) {
            return false;
        }
        return Objects.equals(this.contraseña, other.contraseña);
    }

    
    
}
