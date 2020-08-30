package com.company;

public class NodeComputers{
    private int id;
    private Computer[] queueComputers; //кольцевая очередь на основе массива
    private int memory;
    private int amount; // количество элементов
    private int first;
    private int last;
    private NodeComputers next; //следующий узел в списке
    private NodeComputers prev;//предыдущий узел в списке
    public NodeComputers(int id, int initialSize){
        this.id = id;
        this.queueComputers = new Computer[initialSize];
        this.amount = 0;
        this.first = 0;
        this.last = 0;
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
    public int getId(){
        return this.id;
    }
    public int getAmountComputers(){
        return this.amount;
    }
    public int getMemory() {
        return this.memory;
    }
    public void setMemory(int newValue){
        this.memory = newValue;
    }

    //задавать явно количество компьютеров - для сериализации
    public void setAmountComputers(int newAmount){
        this.amount = newAmount;
    }
    //задавать явно индексы первого и последнего - для сериализации
    public void setFirstLast(int first, int last) {
        this.first = first;
        this.last = last;
    }
    // вставлять в массив в определенном месте компьютер - для сериализации
    public void setDirectlyComp(int idx, Computer computer) {
        this.queueComputers[idx] = computer;
    }

    public void addElement(Computer computer) {
        if(isFull()) {
            throw new ArrayIndexOutOfBoundsException("queue is full");
        }
        else if(isFound(computer.getId())){
            throw new Error("node has already computer with same id");
        }
        else{
            this.queueComputers[last] = computer;
            this.last++;
            if(last > queueComputers.length-1){
                last = 0;
            }
            amount++;
        }
        setMemory(memory + computer.getMemory());
    }
    public void removeElement() {
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("queue is empty");
        }
        setMemory(memory - this.queueComputers[first].getMemory());
        this.queueComputers[first] = null;
        first++;
        if(first > queueComputers.length-1){
            first = 0;
        }
        amount--;
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

    @Override
    public String toString() {
        return " Node: {" +
                "id: " + id  + ", "+
                "memory: " +  memory + ", " +
                "prevElemId: " + getPrev().getId() + ", " +
                "nextElemId: " + getNext().getId() + ", " +
                "\n" +
                "queue: " + toStringCircle() + ", " +
                "\n" +
                "first: " + first  + ", "+
                "last: " + last  + ", "+
                "amountComputers: " + amount  + ", " +
                "size: " + queueComputers.length + ", " +
                "}," + "\n" ;
    }
    //для вывода в консоли в рамках структуры кольцевая очередь
    public String toStringCircle(){
        String circle = "[ ";
        if(last == 0) {
            for(int i = first; i <= queueComputers.length-1 ; i++){
                if (queueComputers[i] != null) {
                    circle += queueComputers[i].toString() + ", ";
                }
            }
        }
        else if(first == queueComputers.length-1 && last == queueComputers.length-1) {
            if(queueComputers[first] != null && queueComputers[last] != null) {
                circle += queueComputers[first].toString() + ", ";
            }
            for(int i = 0; i <= last-1 ; i++){
                if (queueComputers[i] != null) {
                    circle += queueComputers[i].toString() + ", ";
                }
            }
        }
        else if(first < last ) {
            for(int i = first; i <= last ; i++){
                if (queueComputers[i] != null) {
                    circle += queueComputers[i].toString() + ", ";
                }
            }
        }
        else if(first > last){
            for(int i = first; i >= last-1 ; i--){
                if (queueComputers[i] != null) {
                    circle += queueComputers[i].toString() + ", ";
                }
            }
        }

        circle += " ]";
        return circle;
    }

    //для вывода в jtable в рамках структуры кольцевая очередь
    public String[][] toStringCircleAtTable(){
        int length = this.queueComputers.length;
        int countRows = 2;
        String[][] computersMainInfo = new String[length][countRows];
        if(last == 0) {

            int j = 0;
            for(int i = first; i <= queueComputers.length-1 ; i++){
                if (queueComputers[i] == null) {
                    continue;
                }
                computersMainInfo[j][0] = String.valueOf(this.queueComputers[i].getId());
                computersMainInfo[j][1] = String.valueOf(this.queueComputers[i].getMemory());

                j++;
            }
        }

        else if((first == last) || (first > last)){
            int j = 0;
            for(int i = first; i <= queueComputers.length-1; i++){
                if (queueComputers[i] == null) {
                    continue;
                }
                computersMainInfo[j][0] = String.valueOf(this.queueComputers[i].getId());
                computersMainInfo[j][1] = String.valueOf(this.queueComputers[i].getMemory());
                j++;
            }
            for(int t = 0; t < last; t++){
                if (queueComputers[t] == null) {
                    continue;
                }
                computersMainInfo[j][0] = String.valueOf(this.queueComputers[t].getId());
                computersMainInfo[j][1] = String.valueOf(this.queueComputers[t].getMemory());
                j++;
            }
        }
        else if(first < last ) {
            int j = 0;
            for(int i = first; i <= last ; i++){
                if (queueComputers[i] == null) {
                    continue;
                }
                computersMainInfo[j][0] = String.valueOf(this.queueComputers[i].getId());
                computersMainInfo[j][1] = String.valueOf(this.queueComputers[i].getMemory());
                j++;
            }
        }


        return computersMainInfo;
    }

    //для сохранения структуры в файле
    public String toSaveString(){

        // проходимся по компьютерам
        String computers = "";
        for(int i = 0; i <= this.queueComputers.length-1 ; i++){
            if(this.queueComputers[i] != null) {
                computers += "\n" + this.queueComputers[i].toSaveString() + " " + i;
            }
            else{
                computers += "\n" + "null";
            }
        }
        return "\nNode "  +
                this.id + " " +
                this.queueComputers.length + " " +
                this.first + " " +
                this.last  + " " +
                this.amount + " " +
                this.memory +
                computers;
    }
}





