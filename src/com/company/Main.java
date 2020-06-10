package com.company;


public class Main {

    public static void main(String[] args) {
        NodeComputers node = new NodeComputers(1, 0);
        NodeComputers node2 = new NodeComputers(2, 0);
        NodeComputers node3 = new NodeComputers(3, 0);
        NodeComputers node4 = new NodeComputers(4, 0);

        Computer computer1 = new Computer(1, 256);
        Computer computer2 = new Computer(2, 256);
        Computer computer3 = new Computer(3, 256);
        Computer computer4 = new Computer(4, 256);
        node.addElement(computer1);
        node.addElement(computer2);
        node.addElement(computer3);

        node.removeElement();
        node.showElements();
        System.out.println("");
        node.addElement(computer4);
        node.showElements();
        System.out.println("AFTER ADDED COMP 4 ");
        node.removeElement();
        node.showElements();
//        Network newNet = new Network();
//        newNet.addElement(node);
//        newNet.addElement(node2);
//        newNet.addElement(node3);
//        newNet.addElement(node4);
//        newNet.removeElement(node2);
    }
}
