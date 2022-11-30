/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.grupo02.TDAs;

/**
 *
 * @author robes
 */
public class NodeList<E> {
    private E content;
    private NodeList<E> next;
    private NodeList<E> previus;
    
    public NodeList(E e){
        this.content = e;
    }
    
    public void setNext(E e){
        this.next = new NodeList(e);
    }
    
    public NodeList<E> getNext(){
        return this.next;
    }
    
    public NodeList<E> getPrevius(){
        return this.previus;
    }
    
    public void setNext(NodeList<E> next){
        this.next = next;
    }
    
    public void setPrevius(E e){
        this.previus = new NodeList(e);
    }
    
    public void setPrevius(NodeList<E> next){
        this.previus = next;
    }
    
    public void setContent(E e){
        this.content = e;
    }
    
    public E getContent(){
        return this.content;
    }
    
    
    
    public NodeList<E> copyNode(){
        return new NodeList(this.getContent());
    }
}
