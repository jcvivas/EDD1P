/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.TDAs;

import java.util.Comparator;
import java.util.Iterator;

/**
 *
 * @author robes
 */
public class LinkedList<E> implements List<E> {

    NodeList<E> head, tail;

    @Override
    public int size() {
        int cont = 0;
        if (this.isEmpty()) {
            return cont;
        }
        for (NodeList<E> n = head; n != null; n.getNext()) {
            cont += 1;
        }
        return cont;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    @Override
    public boolean contains(E element){
        for (E eCompare: this){
            if (element.equals(eCompare)){
                return true;
            }
        }
        return false;
    }
    
    public static boolean containsString(String s, LinkedList<String> lista){
        for (String e: lista){
            if (e.toLowerCase().contains(s.toLowerCase())) {
                return true;
            }
        }
        
        return false;
    }

    
    public NodeList<E> getNode(E element) {
        NodeList<E> nodeBuscar = new NodeList<E>(element);
        if (this.isEmpty()) {
            return null;
        }
        if (element==null) {
            return null;
        }
        if (nodeBuscar.equals(head)) {
            return head;
        }
        
        if (nodeBuscar.equals(tail));
        
        for (NodeList<E> encontrado = head.getNext(); encontrado != null; encontrado = encontrado.getNext()) {
            if (encontrado.equals(nodeBuscar)) {
                return encontrado;
            }
        }
        return null;
    }
    
    @Override
    public boolean addFirst(E e) {
        if (this.isEmpty()) {
            head = tail = new NodeList<>(e);
            return true;
        }

        NodeList<E> node = new NodeList<>(e);
        node.setNext(head);
        head = node;
        return true;
    }

    @Override
    public boolean addLast(E e) {
        if (this.isEmpty()) {
            head = tail = new NodeList<>(e);
            return true;
        }

        NodeList<E> node = new NodeList<>(e);
        tail.setNext(node);
        tail = node;
        return true;
    }

    @Override
    public void clear() {
        head = null;
    }

    public NodeList<E> getFirst() {
        return head;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {
            private NodeList<E> cursor = head;

            @Override
            public boolean hasNext() {
                return cursor != null;
            }

            @Override
            public E next() {
                E tmp = cursor.getContent();
                cursor = cursor.getNext();
                return tmp;
            }
        };

        return it;
    }
    
    @Override
    public LinkedList<E> findAll(E element, Comparator<E> cmp) {
        LinkedList<E> result = new LinkedList();
        for (E eCompare : this) {
            if (cmp.compare(element, eCompare) == 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }

    @Override
    public LinkedList<E> findLower(E element, Comparator<E> cmp) {

        LinkedList<E> result = new LinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, element) < 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }

    @Override
    public LinkedList<E> findGreater(E element, Comparator<E> cmp) {
        LinkedList<E> result = new LinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, element) > 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }

    @Override
    public LinkedList<E> findBetween(E elementOne, E elementTwo, Comparator<E> cmp) {
        LinkedList<E> result = new LinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, elementOne) > 0 && cmp.compare(eCompare, elementTwo) < 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }
    
    @Override
    public String toString(){
        String content = "";
        if (!this.isEmpty()) {
            content+=this.getFirst().getContent();
        }
        
        for (NodeList<E> temp = this.getFirst().getNext(); temp!=null; temp=temp.getNext()){
            content+= "-" + temp.getContent();
        }
        return content;
    }

}
