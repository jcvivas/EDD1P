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
public class ByDate implements Comparator<Resena> {

    @Override
    public int compare(Resena o1, Resena o2) {
        if (o1.getFecha().getYear() - o2.getFecha().getYear() != 0) {
            return o1.getFecha().getYear();
        }
        if (o1.getFecha().getMonth() - o2.getFecha().getMonth() != 0) {
            return o1.getFecha().getMonth() - o2.getFecha().getMonth();
        }
        return o1.getFecha().getDay() - o2.getFecha().getDay();

    }

}
