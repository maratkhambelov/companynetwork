package com.company;



public class Network {
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
            if(findById(newNode.getId()) == null){
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
            else{
                throw new Error("network has already node with same id");
            }
        }
        size++;
        setMemory(memory + node.getMemory());
    }

    public void removeElement(NodeComputers node){
        NodeComputers found = findById(node.getId());
        if(node == tail) {
           tail = tail.getPrev();
        }
        if(found != null && node.getNext() == node ){
            this.tail = null;
            size--;
//            throw new NullPointerException("all nodes removed");
        }
        else if(isFound(node)){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            setMemory(memory - node.getMemory());
            if(getMemory() < 0 ){
                setMemory(0);
            }
            size--;
        }
        else{
            throw new Error("item was not found");
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
    public NodeComputers findById(int id){
        NodeComputers current = tail.getNext();
        // продолжать поиск пока текущий элемент поиска не достигнет конца
        // т.е. пока последний элемент не начнет ссылаться на первый элемент
        if(id == tail.getId()) {
            return tail;
        }
        while(current.getNext() !=  tail.getNext()) {
            if(current.getId() == id) {
                return current;
            }
            else{
                current = current.getNext();
            }
        }

        return null;
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
            allElements = allElements + " }" + "\n";
            return allElements;
    }
    public String getStringNodesShort(){
        int amountNodes = 0;
        String allElements = " NodeComputers: {" + "\n" ;
        NodeComputers current = tail.getNext();
        allElements = allElements + current.toStringShort();

        current = current.getNext();
        amountNodes++;
        while(current !=  tail.getNext()) {
            allElements = allElements + current.toStringShort();
            current = current.getNext();
            amountNodes++;
        }
        allElements = allElements  + "amountNodes: " + amountNodes + " }";
        return allElements;
    }
    public Integer getLength(){
        int amountNodes = 0;
        NodeComputers current = tail.getNext();

        current = current.getNext();
        amountNodes++;
        while(current !=  tail.getNext()) {
            current = current.getNext();
            amountNodes++;
        }
        return amountNodes;
    }
    public NodeComputers[] getNodes(){
        int length = this.getLength();
        NodeComputers current = tail.getNext();
        NodeComputers[] nodes = new NodeComputers[length];
        for (int j = 0; j <= length-1; j++) {
            nodes[j] = current;
            current = current.getNext();
        }
        return nodes;
    }
    public String[][] getMainInfo(){
        int length = this.getLength();
        int countRows = 3;
        System.out.println(this.getLength());
        String[][] nodesMainInfo = new String[length][countRows];
        NodeComputers current = tail.getNext();
        System.out.println(current.getId());
        for (int j = 0; j <= length-1; j++) {
            nodesMainInfo[j][0] = String.valueOf(current.getId());
            nodesMainInfo[j][1] = String.valueOf(current.getAmountComputers());
            nodesMainInfo[j][2] = String.valueOf(current.getMemory());
            current = current.getNext();
        }
        return nodesMainInfo;
    }

    @Override
    public String toString() {
        return "Network: {" +
                "memory:" + memory + "," +
                "tailId: " + tail.getId() + ", " +
                getStringNodes() +
                '}';
    }
    public String toStringShort(){
        return " Network: {" +
                getStringNodesShort() +
                "}," + "\n" ;
    }
}
