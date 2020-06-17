package com.company;


import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

//        Computer myComp = new Computer(1, 256);
//        Computer myComp2 = new Computer(2, 256);
//        Computer myComp3 = new Computer(3, 512);
//        Computer myComp4 = new Computer(4, 256);
//        Computer myComp5 = new Computer(5, 128);
        NodeComputers myNode0 = new NodeComputers(1, 0);
        NodeComputers myNode1 = new NodeComputers(5, 0);
        NodeComputers myNode2 = new NodeComputers(2, 0);
        NodeComputers myNode3 = new NodeComputers(3, 0);
        NodeComputers myNode4 = new NodeComputers(2, 0);
        NodeComputers myNode5 = new NodeComputers(7, 0);
        NodeComputers myNode6 = new NodeComputers(4, 0);

        NodeComputers myNode99 = new NodeComputers(2, 0);

//        myNode.addElement(myComp);
//        myNode.addElement(myComp2);
//        myNode.addElement(myComp3);
//
//        myNode3.addElement(myComp4);
//        myNode3.addElement(myComp5);

        Network myNet = new Network();
        myNet.addElement(myNode0);
        myNet.addElement(myNode1);
        myNet.addElement(myNode2);
        myNet.addElement(myNode3);
        myNet.removeElement(myNode3);
        myNet.addElement(myNode3);
        myNet.addElement(myNode4);
        myNet.addElement(myNode5);
        myNet.addElement(myNode6);

//        System.out.println(myNet.toString());

        myNet.addElement(myNode99);


//        System.out.println(myNet.toString());

//        myNode.removeElement();
//        myNode.removeElement();
//
//        myNode2.removeElement();
//        NodeComputers nodeNotAdded = new NodeComputers(99, 0);
//        myNet.removeElement(myNode);
        System.out.println(myNet.toString());
//        myNet.removeElement(nodeNotAdded);
//        myNet.writeNetwork("C:\\Users\\Ralina\\Desktop\\structureNet.ser");
//        myNet.readNetwork("C:\\Users\\Ralina\\Desktop\\structureNet.ser");

    }
}
