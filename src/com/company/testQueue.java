package com.company;
import java.util.ArrayDeque;

public class testQueue {
    private int id;
    private ArrayDeque<Computer> queueComputers = new ArrayDeque<>();
    private int memory;
    private int first;
    private int last;
    testQueue (int id){
        this.id = id;
        this.first = 0;
        this.last = 0;
    }
    public void addObject(Computer computer){
        if(this.queueComputers.size() != 0) {
            last++;
            this.queueComputers.addLast(computer);
        }
        else {
            first++;
            last++;
            this.queueComputers.addLast(computer);
        }
        System.out.println(last);
    }
    public void removeObject(Computer computer){
        if(this.queueComputers.size() != 0) {
            last++;
            this.queueComputers.removeFirst();
        }
        else {
            // TODO: throw exception
            System.out.println("queue is empty");
        }
    }

    public int getMemory(){
        memory = 0;
        for(Computer item : this.queueComputers){
            memory += item.getMemory();
        }
        System.out.println(memory);
        return memory;
    }
    public void goThroughArray() {

    }
}
