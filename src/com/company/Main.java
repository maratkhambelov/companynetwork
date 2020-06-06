package com.company;


public class Main {

    public static void main(String[] args) {
        NodeComputers node = new NodeComputers(1, 0);
        Computer computer1 = new Computer(1, 256);
        Computer computer2 = new Computer(2, 256);
        Computer computer3 = new Computer(3, 256);
        node.addElement(computer1);
        node.addElement(computer2);
        node.addElement(computer3);
        node.removeElement();
        node.removeElement();
        node.removeElement();
        node.removeElement();
    }
}
