package com.company;

import java.util.ArrayDeque;

public class NodeComputers {
    private int id;
    private Computer[] queueComputers;
    private Computer[] bufferQueue;
    private int memory;
//    private int first;
//    private int last;
    private int size;
//    private int amountEls;
    private int tail;
    public NodeComputers(int id){
        this.id = id;
        this.memory = 0;
        this.tail = 0;
        this.size = 0;
//              this.first = 0;
//        this.last = 0;
//        this.amountEls = 0;

    }


    public void addElement(Computer computer) {
        if(size!=0) {
            size++;
            bufferQueue = new Computer[size];
            for(int i = 0; i < bufferQueue.length - 1; i++){
                bufferQueue[i] =  queueComputers[i];
            }
            tail = bufferQueue.length-1;
            bufferQueue[tail] = computer;
//            System.out.println("memory of tail " + bufferQueue[tail].getMemory());
            bufferQueue[tail].setPrev(tail-1);
//            System.out.println("length of array " + bufferQueue.length);
//            System.out.println("prev of tail " + bufferQueue[tail].showPrev());
            bufferQueue[tail].setNext(0);
//            System.out.println("next of tail " + bufferQueue[tail].showNext());
            queueComputers[tail-1].setNext(tail);
//            System.out.println("next of preTailEl " + bufferQueue[tail - 1].showNext() );
//            System.out.println(bufferQueue.length);
//            System.out.println("size " + size);
//            System.out.println("tail " + tail);
            queueComputers = bufferQueue;
        }
        else {
              size++;
              queueComputers = new Computer[size];
              queueComputers[0] = computer;
//              tail++;
              tail = queueComputers.length - 1;
//              System.out.println("size " + size);
//              System.out.println("tail " + tail);
        }
    }
    public void removeElement() {
        if(size == 0 ) {
            throw new RuntimeException("queue is empty");
        }
        if(size == 10) {
            size--;
            bufferQueue = new Computer[size];
            tail = 0;
            queueComputers = bufferQueue;
        }
        else {
            size--;
            bufferQueue = new Computer[size];
            tail = bufferQueue.length - 1;

            for(int i = 1; i <= queueComputers.length-1; i++) {
                bufferQueue[i-1] = queueComputers[i];
                System.out.println(bufferQueue[i-1].getMemory());
            }
            queueComputers = bufferQueue;

        }
    }
    public void showLength() {
        System.out.println(queueComputers.length);
    }
}
