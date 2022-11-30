/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.tdas2.Readers;

import com.grupo02.TDAs.DoublyCircularLinkedList;
import com.grupo02.TDAs.LinkedList;
import com.grupo02.videogamestore.App;
import com.grupo02.videogamestore.modelo.Juego;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;

/**
 *
 * @author robes
 */
public class Reader {

    /**
     * Este método es un lector genérico de archivos.
     *
     * @param archivo
     * @return Retorna todas un ArrayList con todas las lineas del archivo dado
     * como parámetro.
     */
    private static LinkedList<String> leerDatos(String archivo) {
        LinkedList<String> lineas = new LinkedList();
        try ( BufferedReader bf = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = bf.readLine()) != null) {
                lineas.addLast(linea);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Captura de error incompleto");
        }
        return lineas;
    }
    private static DoublyCircularLinkedList<Juego> cargarJuegos(String archivo){
        DoublyCircularLinkedList<Juego> juego = null;
        try ( ObjectInputStream oos = new ObjectInputStream(new FileInputStream(App.filePath+archivo))) {
            juego = (DoublyCircularLinkedList<Juego>) oos.readObject();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return juego;
    }
}
