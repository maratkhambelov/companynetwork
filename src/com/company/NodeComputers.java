package com.company;


import java.io.Serializable;
import java.util.Arrays;

public class NodeComputers implements Serializable {
    private int id;
    private Computer[] queueComputers; //кольцевая очередь на основе массива
    private int memory;
    private int amount; // количество элементов

    private NodeComputers next; //следующий узел в списке
    private NodeComputers prev;//предыдущий узел в списке
    public NodeComputers(int id, int initialSize){
        this.id = id;
        this.queueComputers = new Computer[initialSize];
        this.amount = 0;
    }
    public int getId(){
        return this.id;
    }
    public NodeComputers getNext() {
        return this.next;
    }
    public NodeComputers getPrev() {
        return this.prev;
    }
    public void setNext(NodeComputers next){
        this.next = next;
    }
    public void setPrev(NodeComputers prev){
        this.prev = prev;
    }

    public void addElement(Computer computer) {
        if(isFull()) {
            throw new Error("queue is full");
        }
        else if(isFound(computer.getId())){
            throw new Error("node has already computer with same id");
        }
        else{
            this.queueComputers[amount] = computer;
            amount++;
        }
        setMemory(memory + computer.getMemory());
    }
    public boolean isFull(){
        if(amount == this.queueComputers.length){
            return true;
        }
        return false;
    }
    public boolean isEmpty(){
        if(amount == 0) {
            return true;
        }
        return false;
    }
    public void removeElement() {
        if (isEmpty()) {
            throw new Error("queue is empty");
        }
        Computer [] bufferQueue = new Computer[queueComputers.length];
        for(int i = 1; i <= queueComputers.length-1; i++) {
            bufferQueue[i-1] = queueComputers[i];
        }
        bufferQueue[amount-1] = queueComputers[0]; // первый элемент в очереди помещается в конец очереди

        queueComputers = bufferQueue;
    }
    public boolean isFound(int id){
        if(!isEmpty()) {
            for(int i = 0; i <= queueComputers.length-1; i++) {
                if(queueComputers[i] != null && queueComputers[i].getId() == id){
                    return true;
                }
            }
        }
        return false;

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
                "id: " + Integer.toString(id)  + ", "+
                "memory: " + Integer.toString(memory) + ", " +
                "prevElemId: " + getPrev().getId() + ", " +
                "nextElemId: " + getNext().getId() + ", " +
                "queue: " + Arrays.toString(queueComputers) +
                "}," + "\n" ;
    }
}
