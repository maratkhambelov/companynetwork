package com.company;


import java.io.Serializable;
import java.util.Arrays;

public class NodeComputers implements Serializable {
    private int id;
    private Computer[] queueComputers; //кольцевая очередь на основе массива
    private Computer[] bufferQueue;
    private int memory;
    private int size; // размер массива

    private int tail; //последний элемент массива
    private NodeComputers next; //следующий узел в списке
    private NodeComputers prev;//предыдущий узел в списке
    public NodeComputers(int id, int initialSize){
        this.id = id;
        this.size = initialSize;
    }

    public NodeComputers getNext() {
        return this.next;
    }
    public NodeComputers getPrev() {
        return this.prev;
    }
    public int getId(){
        return this.id;
    }
    public void setNext(NodeComputers next){
        this.next = next;
    }
    public void setPrev(NodeComputers prev){
        this.prev = prev;
    }
    public void addElement(Computer computer) {
        if(isEmpty()) {
            size++;
            queueComputers = new Computer[size];
            queueComputers[0] = computer;
            tail = queueComputers.length - 1;
        }
        else{
            size++;
            bufferQueue = new Computer[size];
            for(int i = 0; i < bufferQueue.length - 1; i++){
                bufferQueue[i] =  queueComputers[i];
            }
            tail = bufferQueue.length-1;
            bufferQueue[tail] = computer;
            queueComputers = bufferQueue;
//            System.out.println("size: " + size);
//            for(int i = 0; i <= queueComputers.length - 1; i++){
//                System.out.println(queueComputers[i].getId());
//            }
        }
        setMemory(memory + computer.getMemory());
    }
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }
    public void removeElement() {
        if (isEmpty()) {
            throw new RuntimeException("queue is empty");
        }
        bufferQueue = new Computer[size];
        for(int i = 1; i <= queueComputers.length-1; i++) {
            bufferQueue[i-1] = queueComputers[i];
        }
        bufferQueue[tail] = queueComputers[0]; // первый элемент в очереди помещается в конец очереди
        queueComputers = bufferQueue;
    }
    public void showElements(){
        for(int i = 0; i <= queueComputers.length-1; i++) {
            System.out.println(queueComputers[i].getId());
        }
    }
    public int getMemory() {
        return this.memory;
    }
    public void setMemory(int newValue){
        this.memory = newValue;
    }
    @Override
    public String toString() {
        return " Node: {" +
                "id:'" + Integer.toString(id)  + "'" +
                "memory:" + Integer.toString(memory) + "," +
                "queue: " + Arrays.toString(queueComputers) +
                "},";
    }
}
