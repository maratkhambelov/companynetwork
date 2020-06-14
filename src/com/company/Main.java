package com.company;


import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        Computer myComp = new Computer(1, 256);
        Computer myComp2 = new Computer(2, 256);
        Computer myComp3 = new Computer(3, 512);
        Computer myComp4 = new Computer(4, 256);
        Computer myComp5 = new Computer(5, 128);

        NodeComputers myNode = new NodeComputers(1, 0);
        NodeComputers myNode2 = new NodeComputers(2, 0);
        NodeComputers myNode3 = new NodeComputers(3, 0);

        myNode.addElement(myComp);
        myNode.addElement(myComp2);
        myNode.addElement(myComp3);

        myNode3.addElement(myComp4);
        myNode3.addElement(myComp5);

        Network myNet = new Network();
        myNet.addElement(myNode);
        myNet.addElement(myNode2);
        myNet.addElement(myNode3);
//
//        myNode.removeElement();
//        myNode.removeElement();
//
//        myNode2.removeElement();
//        NodeComputers nodeNotAdded = new NodeComputers(99, 0);
//        myNet.removeElement(myNode);
        System.out.println(myNet.toString());
//        myNet.removeElement(nodeNotAdded);
        myNet.writeNetwork("C:\\Users\\Ralina\\Desktop\\structureNet.ser");
        myNet.readNetwork("C:\\Users\\Ralina\\Desktop\\structureNet.ser");

    }
}
