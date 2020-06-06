package com.company;

public class Computer {
    private int id;
    private int memory;


    Computer(int id, int memory) {
        this.id = id;
        this.memory = memory;
    }

    public int getMemory() {
        return memory;
    }
    public int getId(){
        return id;
    }
}
