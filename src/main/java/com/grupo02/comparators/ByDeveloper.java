/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.comparators;

import com.grupo02.TDAs.LinkedList;
import com.grupo02.videogamestore.modelo.Juego;
import java.util.Comparator;

/**
 *
 * @author robes
 */
public class ByDeveloper implements Comparator<Juego>{
    @Override
    public int compare(Juego o1, Juego o2) {
        if (LinkedList.containsString(o1.getDesarrollador().getFirst().getContent(), o2.getDesarrollador())){
            return 0;
        }
        return 1;
    }
}
