package com.company;

import sun.nio.ch.Net;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextUtil {

    public void toWrite(Network network, String path) {
        try(FileWriter writer = new FileWriter(path, false)) {
            String text = network.toSaveString();
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public Network toRead(File file, Network network) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        //TODO: node should to change
        NodeComputers node = new NodeComputers(0,0);
        while(scanner.hasNext()){

            String[] tokens = scanner.nextLine().split(" ");

            String instance = tokens[0].toString();

            if(instance.equals("Network")){
                System.out.println("NETWORK: ");
                continue;
            }
            else if(instance.equals("Node")){
                System.out.println("NODE: ");
                int id = Integer.parseInt(tokens[1]);
                int size = Integer.parseInt(tokens[2]);
                int first = Integer.parseInt(tokens[3]);
                int last = Integer.parseInt(tokens[4]);
                int amountComps = Integer.parseInt(tokens[5]);
                int memory = Integer.parseInt(tokens[6]);

                node = new NodeComputers(id, size);
                node.setFirstLast(first, last);
                node.setAmountComputers(amountComps);
                node.setMemory(memory);
                network.addElement(node);
            }
            else if(instance.equals("Computer")) {
                System.out.println("COMPUTER: ");
                int id = Integer.parseInt(tokens[1]);
                int memory = Integer.parseInt(tokens[2]);
                int idx = Integer.parseInt(tokens[3]);
                Computer computer = new Computer(id, memory);
                //TODO: node might not be created before, but unlikely
                node.setDirectlyComp(idx, computer);
            }
            else if(instance.equals("null")){
                System.out.println("NULL: ");
                continue;
            }
        }

        System.out.println(network.getStringNodes());
        return network;
    }

}
