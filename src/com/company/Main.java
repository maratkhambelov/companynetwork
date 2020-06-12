package com.company;


import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Computer myComp = new Computer(1, 256);
        Computer myComp2 = new Computer(2, 256);
        Computer myComp3 = new Computer(3, 512);
        Computer myComp4 = new Computer(4, 256);

        NodeComputers myNode = new NodeComputers(1, 0);
        NodeComputers myNode2 = new NodeComputers(20, 0);
        NodeComputers myNode3 = new NodeComputers(3, 0);

        Network myNet = new Network();

        myNode.addElement(myComp);
        myNode.addElement(myComp2);
        myNode.addElement(myComp3);
        myNode.addElement(myComp4);

        myNet.addElement(myNode);
        myNet.addElement(myNode2);
//        myNet.addElement(myNode2);
        myNet.addElement(myNode3);
        myNet.writeNetwork("C:\\Users\\Ralina\\Desktop\\save.ser");
        myNet.readNetwork("C:\\Users\\Ralina\\Desktop\\save.ser");






//        NodeComputers node = new NodeComputers(1, 0);
//        NodeComputers node2 = new NodeComputers(2, 0);
//        NodeComputers node3 = new NodeComputers(3, 0);
//        NodeComputers node4 = new NodeComputers(4, 0);
//
//        Computer computer1 = new Computer(1, 256);
//        Computer computer2 = new Computer(2, 256);
//        Computer computer3 = new Computer(3, 256);
//        Computer computer4 = new Computer(4, 256);
//        node.addElement(computer1);
//        node.addElement(computer2);
//        node.addElement(computer3);
//
//        node.removeElement();
//        node.showElements();
//        System.out.println("");
//        node.addElement(computer4);
//        node.showElements();
//        System.out.println("AFTER ADDED COMP 4 ");
//        node.removeElement();
//        node.showElements();
//        Network newNet = new Network();
//        newNet.addElement(node);
//        newNet.addElement(node2);
//        newNet.addElement(node3);
//        newNet.addElement(node4);
//        newNet.removeElement(node2);
    }
}
