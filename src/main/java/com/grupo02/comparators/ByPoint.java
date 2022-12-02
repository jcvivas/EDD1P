/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.comparators;

import com.grupo02.videogamestore.modelo.Resena;
import java.util.Comparator;

/**
 *
 * @author robes
 */
public class ByPoint implements Comparator<Resena>{

    @Override
    public int compare(Resena o1, Resena o2) {
        return o1.getCalificacion()-o2.getCalificacion();
    }
    
}
