/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.grupo02.TDAs;

import java.io.Serializable;
import java.util.Comparator;

/**
 *
 * @author robes
 */
public interface List<E> extends Iterable<E>, Serializable{
    /**
     * Este método retorna la longitud de una lista
     * @return Retorna el tamaño de la lista
     */
    int size();
    /**
     * Este metodo comprueba si una lista está vacía
     * @return Retorna true si la lista no contiene elementos
     */
    boolean isEmpty();
    
    /**
     * 
     * @param element Elemento a agregar al final de la lista
     * @return Retorna true si agregó con éxito
     */    
    boolean addFirst(E element);
    
    
    
    boolean addLast(E element);
    /**
     * 
     * Limpia la lista
     */
    void clear();
    
    
    List<E> findAll(E element, Comparator<E> cmp);

    List<E> findLower(E element, Comparator<E> cmp);

    List<E> findGreater(E element, Comparator<E> cmp);

    List<E> findBetween(E elementOne, E elementTwo, Comparator<E> cmp);
}
