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
//        System.out.println("next: " + next);
    }
    public void setPrev(int idx){
        this.prev = idx;
//        System.out.println("prev: " + prev);

    }
    public int showPrev(){
        return this.prev;
    }
    public int showNext(){
        return this.next;
    }
    public int getMemory() {
        return memory;
    }

}
