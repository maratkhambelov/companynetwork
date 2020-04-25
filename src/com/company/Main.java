package com.company;

import org.w3c.dom.Node;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Computer myComputer = new Computer(1, 256);
        Computer myComputer2 = new Computer(2, 500);
        Computer myComputer3 = new Computer(3, 600);
        Computer myComputer4 = new Computer(4, 900);

        NodeComputers myNode = new NodeComputers(1);
        myNode.addElement(myComputer);
        myNode.removeElement();

        myNode.addElement(myComputer2);
        myNode.addElement(myComputer3);
        myNode.addElement(myComputer4);

//        myNode.showLength();

    }
}
