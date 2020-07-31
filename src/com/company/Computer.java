package com.company;

import java.io.Serializable;

public class Computer implements Serializable {
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
    @Override
    public String toString() {
        return "Computer: {" +
                "id:'" + Integer.toString(id)  + "', " +
                "memory: " + Integer.toString(memory) +
                '}';
    }

}
