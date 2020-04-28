package com.company;


public class Main {

    public static void main(String[] args) {
        Computer myComputer = new Computer(1, 256);
        Computer myComputer2 = new Computer(2, 500);
        Computer myComputer3 = new Computer(3, 600);
        Computer myComputer4 = new Computer(4, 900);
        NodeComputers myNode = new NodeComputers(1);
        myNode.addElement(myComputer2);
        myNode.addElement(myComputer3);
        myNode.addElement(myComputer4);
        NodeComputers myNode1 = new NodeComputers(2);
        NodeComputers myNode2 = new NodeComputers(3);
        NodeComputers myNode3 = new NodeComputers(4);
        Network myNetwork = new Network();
        myNetwork.addElement(myNode);
        myNetwork.addElement(myNode1);
        myNetwork.addElement(myNode2);
    }
}
