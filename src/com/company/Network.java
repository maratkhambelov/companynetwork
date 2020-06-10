package com.company;



public class Network {
    private NodeComputers tail; //последний элемент списка
    private int size = 0; //количество элеметов
    private int memory;

    public void addElement(int id, int initialSize){
        NodeComputers newNode = new NodeComputers(id, initialSize);
        if(isEmpty()) {
//            tail = newNode;
            tail.setNext(newNode);
            tail.setPrev(newNode);
        }
        else {
            NodeComputers head = tail.getNext();

            newNode.setPrev(tail); // устанавливаем для нового значения Prev - Tail
            head.setPrev(newNode);  // устанавливаем для первого элемента Prev - Новый Tail
            newNode.setNext(head); // устанавливаем для нового значения
                                    // следующий элемент  - первый элемент списка
            tail.setNext(newNode); // для tail следующий элемент - новый Tail
        }
        tail = newNode;
        size++;
    }
    public void addElement(NodeComputers node){
        NodeComputers newNode = node;
        if(isEmpty()) {
            tail = newNode;
            tail.setNext(newNode);
            tail.setPrev(newNode);
        }
        else {
            NodeComputers head = tail.getNext();

            newNode.setPrev(tail); // устанавливаем для нового значения Prev - Tail
            head.setPrev(newNode);  // устанавливаем для первого элемента Prev - Новый Tail
            newNode.setNext(head); // устанавливаем для нового значения
                                    // следующий элемент  - первый элемент списка
            tail.setNext(newNode); // для tail следующий элемент - новый Tail

        }
        tail = newNode;
        size++;
        System.out.println("ADD ELEMENT:");
        System.out.println(tail.getId());

    }
    public void removeElement(NodeComputers node){
        // проверка - находится ли элемент в списке
        if(isFound(node)){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
        }
        else{
            throw new RuntimeException("item was not found");
        }
        System.out.println("REMOVE ELEMENT: ");

        System.out.println(node.getId());
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
    public void writeStructure(){

    }
    public void readStructure(){

    }
}
