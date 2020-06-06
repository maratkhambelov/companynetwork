package com.company;



public class Network {
    private NodeComputers head; //первый элемент списка
    private NodeComputers tail; //последний элемент списка
    private int size = 0; //количество элеметов
    private int memory;


    // добавить элемент
    public void addElement(int id, int initialSize){
        NodeComputers newNode = new NodeComputers(id, initialSize);
        if(isEmpty()) { // проверка на пустоту списка
            head = newNode; //если список пустой, то добавить первый элемент
        }
        //если список состоит из одного и более элемента
        else {
            tail.setNext(newNode); //последний элемент ссылается на новый
            newNode.setPrev(tail); //новый элемент ссылается на последний
        }
        tail = newNode; // новый элемент теперь становится элементом в списке
        size++; // увеличить счетчик количества элементов
        toCloseList(); // вызывать метод кольцевания списка
    }
    public void addElement(NodeComputers node){
        NodeComputers newNode = node;
        if(isEmpty()) {
            head = newNode;
        }
        else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
        }
        tail = newNode;
        size++;
        //
        head.setPrev(tail); // первый элемент ссылается на последний
        tail.setNext(head); // последний элемент ссылается на первый
        //
//        toCloseList();
    }
    // сделать замкнутым список
//    public void toCloseList(){
//        // проверка на пустота списка
//        if(isEmpty()){
//            return;
//        }
//        else{
//            head.setPrev(tail); // первый элемент ссылается на последний
//            tail.setNext(head); // последний элемент ссылается на первый
//        }
//    }
    public void removeElement(NodeComputers node){
        // проверка - находится ли элемент в списке
        if(findElement(node)){

        };
    }
    public boolean isEmpty(){
        if(size == 0) {
            return true;
        }
        return false;
    }

    // поиск элемента
    public boolean findElement(NodeComputers node){
        NodeComputers current = head;
        boolean isFound = false;
        // продолжать поиск пока текущий элемент поиска не достигнет конца
        // т.е. пока последний элемент не начнет ссылаться на первый элемент
        while(current.getNext() != head && !isFound) {
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
