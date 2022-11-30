/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.tdas2.Readers;

import com.grupo02.TDAs.LinkedList;
import java.io.BufferedReader;
import java.io.FileReader;

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
    // id|name|date|developer|positiveRatings|price|header_image|screenshots|short_description
    private static void leerJuegos(String archivo){
        LinkedList<String> lineas = leerDatos(archivo);
        for (String l: lineas){
            
        }
    }
}
