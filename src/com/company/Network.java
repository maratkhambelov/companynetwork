package com.company;


import java.util.Arrays;

public class Network {
    private int memory;
    private int size;
    private NodeComputers nodes[];
    private NodeComputers bufferNodes[];
    private static final int DEFAULT_CAPACITY = 10;
    Network(){
        this.memory = 0;
        this.size = 0;
        nodes = new NodeComputers[DEFAULT_CAPACITY];
    }

    public void addElement(NodeComputers node){
        if(size == nodes.length){
            ensureCapacity();
        }
        if(size !=0) {
            nodes[size] = node;
            nodes[size].setNext(0);
            nodes[size].setPrev(size-1);
            nodes[size-1].setNext(size);
            nodes[0].setPrev(size);
            size++;
        }
        else {
            nodes[size] = node;
            size++;
        }
//        System.out.println("nodes length " + nodes.length);
//        System.out.println("nodes size " + size);
    }
    public void removeElement(int idx){

    }
    public void getMemory(){

    }
    private void ensureCapacity() {
        int newSize = nodes.length * 2;
        bufferNodes = Arrays.copyOf(nodes, newSize);
//        System.out.println("length buffernodes " + bufferNodes.length);
        nodes = bufferNodes;
    }
//    public String toString() {
//
//    }
}
