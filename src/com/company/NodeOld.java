//package com.company;
//
//public class NodeOld {
//    private int id;
//    private Computer[] queueComputers;
//    private Computer[] bufferQueue;
//    private int memory;
//    private int size;
//    private int tail;
//    private int next;
//    private int prev;
//
//    public NodeComputers(int id){
//        this.id = id;
//        this.memory = 0;
//        this.tail = 0;
//        this.size = 0;
//        this.next = 0;
//        this.prev = 0;
//    }
//    public void setNext(int next){
//        this.next = next;
//    }
//    public void setPrev(int prev){
//        this.prev = prev;
//    }
//
//    public void addElement(Computer computer) {
//        if(size!=0) {
//            size++;
//            bufferQueue = new Computer[size];
//            for(int i = 0; i < bufferQueue.length - 1; i++){
//                bufferQueue[i] =  queueComputers[i];
//            }
//            tail = bufferQueue.length-1;
//            bufferQueue[tail] = computer;
////            System.out.println("memory of tail " + bufferQueue[tail].getMemory());
//            bufferQueue[tail].setPrev(tail-1);
////            System.out.println("length of array " + bufferQueue.length);
////            System.out.println("prev of tail " + bufferQueue[tail].getPrev());
//            bufferQueue[tail].setNext(0);
////            System.out.println("next of tail " + bufferQueue[tail].getNext());
//            queueComputers[tail-1].setNext(tail);
//            queueComputers[0].setPrev(tail);
////            System.out.println("next of preTailEl " + bufferQueue[tail - 1].getNext() );
////            System.out.println(bufferQueue.length);
////            System.out.println("size " + size);
////            System.out.println("tail " + tail);
//            queueComputers = bufferQueue;
//        }
//        else {
//            size++;
//            queueComputers = new Computer[size];
//            queueComputers[0] = computer;
////              tail++;
//            tail = queueComputers.length - 1;
////              System.out.println("size " + size);
////              System.out.println("tail " + tail);
//        }
//    }
//    public void removeElement() {
//        if (size == 0) {
//            throw new RuntimeException("queue is empty");
//        }
//        size--;
//        bufferQueue = new Computer[size];
//        tail = bufferQueue.length - 1;
//        for(int i = 1; i <= queueComputers.length-1; i++) {
//            bufferQueue[i-1] = queueComputers[i];
////            System.out.println(bufferQueue[i-1].getId());
//        }
//        if(size == 0) {
//            queueComputers = bufferQueue;
//            return;
//        }
//        bufferQueue[0].setPrev(tail);
//        bufferQueue[0].setNext(1);
//        bufferQueue[tail].setNext(0);
//        queueComputers = bufferQueue;
//
//    }
//    public void showLength() {
//        System.out.println(queueComputers.length);
//    }
//    public void showLinks() {
//        int index = 0;
//        for(Computer item : queueComputers) {
//            System.out.println(index + " element has nextEl : " + item.getNext());
//            System.out.println(index + " element has prevEl : " + item.getPrev());
//            index++;
//        }
//    }
//    public int getMemory() {
//        memory = 0;
//        for(Computer item : queueComputers) {
//            memory += item.getMemory();
//        }
//        return memory;
//    }
//}
