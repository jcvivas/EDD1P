/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.comparators;

import com.grupo02.videogamestore.modelo.Juego;
import java.util.Comparator;

/**
 *
 * @author robes
 */
public class ByName implements Comparator<Juego>{

    @Override
    public int compare(Juego o1, Juego o2) {
        if (o2.getTitulo().toLowerCase().contains(o1.getTitulo().toLowerCase())){
            return 0;
        }
        else{
            return 1;
        }
    }
    
}
