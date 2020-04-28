package com.company;

public class Computer {
    private int id;
    private int memory;
    private int next;
    private int prev;

    Computer(int id, int memory) {
        this.id = id;
        this.memory = memory;
        this.next = 0;
        this.prev = 0;
    }
    public void setNext(int idx){
        this.next = idx;
    }
    public void setPrev(int idx){
        this.prev = idx;
    }
    public int getPrev(){
        return this.prev;
    }
    public int getNext(){
        return this.next;
    }
    public int getMemory() {
        return memory;
    }
    public int getId() {
        return this.id;
    }
}
