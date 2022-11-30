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
public class DoublyCircularLinkedList<E> implements List<E> {

    private NodeList<E> head;
    
    
    @Override
    public int size() {
        int cont = 0;
        if (!this.isEmpty()) {
            cont++;
            for (NodeList<E> n = head.getNext(); n != head; n.getNext()) {
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
                return cursor != head && i++ < size;
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
