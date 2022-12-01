/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.TDAs;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author robes
 */
public class DoublyCircularLinkedList<E> implements List<E> {

    private NodeList<E> head;
    
    
    @Override
    public int size() {
        int cont = 0;
        if (!this.isEmpty()) {
            cont++;
            for (NodeList<E> n = head.getNext(); n != head; n = n.getNext()) {
                cont++;
            }
        }
        return cont;
    }

    public boolean addFirst(E e) {
        if (this.isEmpty()) {
            head = new NodeList(e);
            head.setNext(head);
            head.setPrevius(head);
            return true;
        }

        NodeList<E> tempP = head.getPrevius();
        NodeList<E> tempN = head;

        NodeList<E> nodeA = new NodeList(e);

        nodeA.setNext(tempN);
        head.setPrevius(nodeA);
        nodeA.setPrevius(tempP);
        tempP.setNext(nodeA);
        head = nodeA;

        return true;
    }

    public NodeList<E> getFirst() {
        return head;
    }
    
    @Override
    public boolean isEmpty() {
        return this.head == null;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public boolean addLast(E e) {
        if (this.isEmpty()) {
            head = new NodeList(e);
            head.setNext(head);
            head.setPrevius(head);
            return true;
        }

        NodeList<E> tempL = head.getPrevius();

        NodeList<E> nodeA = new NodeList(e);

        tempL.setNext(nodeA);
        nodeA.setPrevius(tempL);
        nodeA.setNext(head);
        head.setPrevius(nodeA);

        return true;
    }

    
    
    public NodeList<E> getLast(){
        return head.getPrevius();
    }
    
    @Override
    public Iterator<E> iterator() {
        int size = this.size();
        Iterator<E> it = new Iterator<E>() {
            int i = 0;
            private NodeList<E> cursor = head;;
            @Override
            public boolean hasNext() {
                return i++ < size;
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
    
    public E removeLast(){
        NodeList<E> temp = null;
        if (this.isEmpty()) {
            return null;
        }
        temp = head.getPrevius();
        NodeList<E> tempL = head;
        NodeList<E> tempP = temp.getPrevius();
        tempL.setPrevius(tempP);
        tempP.setNext(tempL);
        return temp.getContent();
        
    }
    
    public NodeList<E> getNode(E element){
        NodeList<E> nodeBuscar = new NodeList<E>(element);
        if (nodeBuscar.equals(head)) {
            return head;
        }
        for (NodeList<E> encontrado = head.getNext(); encontrado != head; encontrado = encontrado.getNext()) {
            if (encontrado.equals(nodeBuscar)) {
                return encontrado;
            }
        }
        return null;
    }
    
    
    
    public DoublyCircularLinkedList<E> subList(int pos){
        DoublyCircularLinkedList<E> nueva = new DoublyCircularLinkedList();
        NodeList<E> temp = this.getFirst();
        for (int i = 0; i < pos; i++) {
            nueva.addLast(temp.getContent());
            temp = temp.getNext();
        }
        return nueva;
    }
    
    public E removeFirst(){
        NodeList<E> temp = null;
        if (this.isEmpty()) {
            return null;
        }
        temp = head;
        NodeList<E> tempL = head.getNext();
        NodeList<E> tempP = head.getPrevius();
        tempL.setPrevius(tempP);
        tempP.setNext(tempL);
        this.head = tempL;
        return temp.getContent();
    }
    
    
    @Override
    public DoublyCircularLinkedList<E> findAll(E element, Comparator<E> cmp) {
        DoublyCircularLinkedList<E> result = new DoublyCircularLinkedList();
        for (E eCompare : this) {
            if (cmp.compare(element, eCompare) == 0) {
                result.addLast(eCompare);
            }
        }
        return result;
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
        
    public Set<E> findAllSet(E element, Comparator<E> cmp) {
        Set<E> result = new HashSet();
        for (E eCompare : this) {
            if (cmp.compare(element, eCompare) == 0) {
                result.add(eCompare);
            }
        }
        return result;
    }
    
    @Override
    public DoublyCircularLinkedList<E> findLower(E element, Comparator<E> cmp) {

        DoublyCircularLinkedList<E> result = new DoublyCircularLinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, element) < 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }

    @Override
    public DoublyCircularLinkedList<E> findGreater(E element, Comparator<E> cmp) {
        DoublyCircularLinkedList<E> result = new DoublyCircularLinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, element) > 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }

    @Override
    public DoublyCircularLinkedList<E> findBetween(E elementOne, E elementTwo, Comparator<E> cmp) {
        DoublyCircularLinkedList<E> result = new DoublyCircularLinkedList();
        for (E eCompare : this) {
            if (cmp.compare(eCompare, elementOne) > 0 && cmp.compare(eCompare, elementTwo) < 0) {
                result.addLast(eCompare);
            }
        }
        return result;
    }
}
