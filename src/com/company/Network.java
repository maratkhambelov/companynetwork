package com.company;


import java.io.*;

public class Network implements Serializable {
    private NodeComputers tail; //последний элемент списка
    private int size = 0; //количество элеметов
    private int memory;

    public void addElement(NodeComputers node){
        NodeComputers newNode = node;
        if(isEmpty()) {
            tail = newNode;
            tail.setNext(newNode);
            tail.setPrev(newNode);
            tail = newNode;
        }
        else {
            if(!isFound(newNode)){
                NodeComputers head = tail.getNext();
                NodeComputers current = head;
                boolean stop = false;
                if(tail.getId() < newNode.getId()){
                    newNode.setPrev(tail); // устанавливаем для нового значения Prev - Tail
                    head.setPrev(newNode);  // устанавливаем для первого элемента Prev - Новый Tail
                    newNode.setNext(head); // устанавливаем для нового значения
                                            // следующий элемент  - первый элемент списка
                    tail.setNext(newNode); // для tail следующий элемент - новый Tail
                    tail = newNode;
                    stop = true;
                }
                while(!stop) {
                    if(current.getId() > newNode.getId()) {
                        current.getPrev().setNext(newNode); // prev-prev -> newNode
                        newNode.setPrev(current.getPrev()); //  prev-prev<-newNode
                        newNode.setNext(current); // newNode-> last
                        current.setPrev(newNode); //newNode <- last
                        stop = true;
                    }
                    else{
                        current = current.getNext();
                    }
                }
            }
        }
        size++;
        setMemory(memory + node.getMemory());
    }

    public void removeElement(NodeComputers node){
        // проверка - находится ли элемент в списке
        if(isFound(node)){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            setMemory(memory - node.getMemory());
            size--;
        }
        else{
            throw new RuntimeException("item was not found");
        }
    }
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }

    // поиск элемента
    public boolean isFound(NodeComputers node){
        NodeComputers current = tail.getNext();
        boolean isFound = false;
        // продолжать поиск пока текущий элемент поиска не достигнет конца
        // т.е. пока последний элемент не начнет ссылаться на первый элемент
        while(current.getNext() !=  tail.getNext() && !isFound) {
            if(current.getId() == node.getId()) {
                isFound = true;
            }
            else{
                current = current.getNext();
            }
        }
        // сравнить последний элемент с необходимым элементом
        if(node == tail && current.getId() == node.getId()) {
            isFound = true;
        }
        return isFound;
    }
    public int getMemory(){
        return this.memory;
    }
    public void setMemory(int newValue){
        this.memory = newValue;
    }
    private String getStringNodes(){
        String allElements = " NodeComputers: {" + "\n" ;

        NodeComputers current = tail.getNext();
        allElements = allElements + current.toString();

        current = current.getNext();
        while(current !=  tail.getNext()) {
            allElements = allElements + current.toString();
            current = current.getNext();
        }
        allElements = allElements + " }";
        return allElements;
    }
    public void writeNetwork(String path) throws IOException {
        FileOutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this);
        objectOutputStream.close();
    }
    public void readNetwork(String path) throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        Network thisNetwork = (Network) objectInputStream.readObject();
        objectInputStream.close();
        System.out.println(thisNetwork);
    }
    @Override
    public String toString() {
        return "Network: {" +
                "memory:" + Integer.toString(memory) + "," +
                getStringNodes() +
                '}';
    }
}
