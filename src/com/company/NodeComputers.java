package com.company;

import java.util.ArrayDeque;

public class NodeComputers {
    private int id;
    private Computer[] queueComputers;
    private Computer[] bufferQueue;
    private int memory;
    private int first;
    private int last;
    private int size;
    private int amountEls;
    private int tail;
    public NodeComputers(int id){
        this.id = id;
        this.first = 0;
        this.last = 0;
        this.size = 0;
        this.amountEls = 0;
        this.memory = 0;
        this.tail = 0;
    }


    public void addElement(Computer computer) {
        if(tail != 0) {
            bufferQueue = new Computer[size+1];
            tail = bufferQueue.length-1;
            System.out.println("tail: " + tail);
            for(int i = 0; i < bufferQueue.length - 1; i++){
                bufferQueue[i] =  queueComputers[i];
            }
            bufferQueue[tail] = computer;
//            System.out.println("memory of tail " + bufferQueue[tail].getMemory());
            bufferQueue[tail].setPrev(tail-1);
            System.out.println("length of array " + bufferQueue.length);
//            System.out.println("prev of tail " + bufferQueue[tail].showPrev());
            bufferQueue[tail].setNext(0);
//            System.out.println("next of tail " + bufferQueue[tail].showNext());
            queueComputers[tail-1].setNext(tail);
//            System.out.println("next of preTailEl " + bufferQueue[tail - 1].showNext() );
//            System.out.println(bufferQueue.length);
            size++;
            queueComputers = bufferQueue;
//            System.out.println(bufferQueue[1].showPrev());
//            System.out.println(bufferQueue[2].showPrev());

        }
        else {
              size++;
              queueComputers = new Computer[size];
              queueComputers[0] = computer;
              tail++;
        }
    }
    public void showLength() {
        System.out.println(queueComputers.length);
    }
}
